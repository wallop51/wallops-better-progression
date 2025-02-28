package net.wallop.betterprogression.entity.ai;

import com.mojang.datafixers.kinds.IdF;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class BronzeSpearAttackGoal extends Goal{
    private final BronzeEntity mob;
    private final RangedAttackMob owner;
    @Nullable
    private LivingEntity target;
    private int updateCountdownTicks = -1;
    private final double mobSpeed;
    private int seenTargetTicks;
    private final int minIntervalTicks;
    private final int maxIntervalTicks;
    private final float maxShootRange;
    private final float squaredMaxShootRange;
    private int attackDelay = 15;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountUntilNextAttack = false;

    public BronzeSpearAttackGoal(RangedAttackMob mob, double mobSpeed, int intervalTicks, float maxShootRange) {
        this(mob, mobSpeed, intervalTicks, intervalTicks, maxShootRange);
    }

    public BronzeSpearAttackGoal(RangedAttackMob mob, double mobSpeed, int minIntervalTicks, int maxIntervalTicks, float maxShootRange) {
        if (!(mob instanceof LivingEntity)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        } else {
            this.owner = mob;
            this.mob = (BronzeEntity)mob;
            this.mobSpeed = mobSpeed;
            this.minIntervalTicks = minIntervalTicks;
            this.maxIntervalTicks = maxIntervalTicks;
            this.maxShootRange = maxShootRange;
            this.squaredMaxShootRange = maxShootRange * maxShootRange;
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 15;
        ticksUntilNextAttack = 15;
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity != null && livingEntity.isAlive()) {
            this.target = livingEntity;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean shouldContinue() {
        return this.canStart() || this.target.isAlive() && !this.mob.getNavigation().isIdle();
    }



    @Override
    public void stop() {
        this.target = null;
        this.seenTargetTicks = 0;
        this.updateCountdownTicks = -1;
        this.mob.setShooting(false);
        super.stop();
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    protected boolean isTimeToStartAttackAnimation() {
        BetterProgression.LOGGER.info("Starting attack animation at ticksUntilNextAttack = " + ticksUntilNextAttack);
        return  ticksUntilNextAttack <= attackDelay;
    }

    @Override
    public void tick() {

        if (shouldCountUntilNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0);
        }

        BetterProgression.LOGGER.info("ticksUntilNextAttack = " + ticksUntilNextAttack + " updateCountdownTicks = " + (updateCountdownTicks - 1));

        double d = this.mob.squaredDistanceTo(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean bl = this.mob.getVisibilityCache().canSee(this.target);
        if (bl) {
            this.seenTargetTicks++;
        } else {
            this.seenTargetTicks = 0;
        }

        if (!(d > (double)this.squaredMaxShootRange - 5) && this.seenTargetTicks >= 5) {
            //if within attack range
            this.mob.getNavigation().stop();
            shouldCountUntilNextAttack = true;
            if (isTimeToStartAttackAnimation()) {
                mob.setShooting(true);
            }
        } else {
            //not within attack range
            this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            this.mob.getNavigation().startMovingTo(this.target, this.mobSpeed);
            if (ticksUntilNextAttack == 39) {
                resetAttackCooldown();
                shouldCountUntilNextAttack = false;
                mob.setShooting(false);
                mob.shootAnimationTimeout = 0;
                return;
            }
        }

        this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);
        if (--this.updateCountdownTicks == 0) {
            if (ticksUntilNextAttack != 0) {
                ++this.updateCountdownTicks;
                return;
            }

            this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);

            float f = (float)Math.sqrt(d) / this.maxShootRange;
            float g = MathHelper.clamp(f, 0.1F, 1.0F);
            this.owner.shootAt(this.target, g);
            BetterProgression.LOGGER.info("Shot! -------------------");
            this.resetAttackCooldown();
            this.updateCountdownTicks = MathHelper.floor(f * (float)(this.maxIntervalTicks - this.minIntervalTicks) + (float)this.minIntervalTicks);
        } else if (this.updateCountdownTicks < 0) {
            this.updateCountdownTicks = MathHelper.floor(
                    MathHelper.lerp(Math.sqrt(d) / (double)this.maxShootRange, (double)this.minIntervalTicks, (double)this.maxIntervalTicks)
            );
        }
    }

    private void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }
}
