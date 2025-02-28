package net.wallop.betterprogression.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class BronzeShootGoal extends ProjectileAttackGoal {
    private final BronzeEntity entity;
    private LivingEntity target;
    private int attackDelay = 15;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountUntilNextAttack = false;
    private final float maxShootRange;
    private final RangedAttackMob owner;
    private final double mobSpeed;
    private int seenTicks = 0;
    private final float squaredMaxShootRange;

    public BronzeShootGoal(RangedAttackMob mob, double mobSpeed, int intervalTicks, float maxShootRange) {
        super(mob, mobSpeed, intervalTicks, maxShootRange);
        this.mobSpeed = mobSpeed;
        owner = mob;
        entity = ((BronzeEntity) mob);
        this.maxShootRange = maxShootRange;
        this.squaredMaxShootRange = maxShootRange * maxShootRange;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 15;
        ticksUntilNextAttack = 15;
        seenTicks = 0;
    }

    protected void shoot() {
        if (isEnemyInRangeAndSeen()) {
            shouldCountUntilNextAttack = true;

            entity.getNavigation().stop();

            if (isTimeToStartShootAnimation()) {
                entity.setShooting(true);
            }

            entity.getLookControl().lookAt(this.target, 30f, 30f);

            if (isTimeToShoot()) {
                this.entity.getLookControl().lookAt(target, 30f, 30f);
                performAttack(target);
            }
        } else {
            this.entity.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            this.entity.getNavigation().startMovingTo(this.target, this.mobSpeed);
            entity.getNavigation().startMovingTo(target, mobSpeed);
            resetAttackCooldown();
            shouldCountUntilNextAttack = false;
            entity.setShooting(false);
            entity.shootAnimationTimeout = 0;
        }

    }

    private void performAttack(LivingEntity enemy) {
        this.resetAttackCooldown();
        BetterProgression.LOGGER.info("Shot ------------------");

        float f = (float) Math.sqrt(entity.distanceTo(target)) / this.maxShootRange;
        float pullProgress = MathHelper.clamp(f, 0.1f, 1f);

        owner.shootAt(enemy, pullProgress);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    private boolean isEnemyInRangeAndSeen() {
        double squaredDistanceToTarget = this.entity.squaredDistanceTo(this.target.getX(), this.target.getY(), this.target.getZ());
        return squaredDistanceToTarget < this.squaredMaxShootRange - 5 && this.seenTicks >=5;
    }

    protected boolean isTimeToStartShootAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToShoot() {
        return this.ticksUntilNextAttack <= 0 && entity.isShooting();
    }

    @Override
    public void tick() {
        if(shouldCountUntilNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
        target = this.entity.getTarget();

        boolean canSeeTarget = target != null && this.entity.getVisibilityCache().canSee(this.target);

        if (canSeeTarget) {
            this.seenTicks++;
        } else {
            this.seenTicks = 0;
        }

        if (target != null) {
            this.shoot();
        }
    }
}
