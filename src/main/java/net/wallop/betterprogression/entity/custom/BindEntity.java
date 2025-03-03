package net.wallop.betterprogression.entity.custom;

import com.mojang.datafixers.kinds.IdF;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.entity.ai.BronzeBindGoal;
import org.jetbrains.annotations.Nullable;

public class BindEntity extends Entity implements Attackable {
    public final AnimationState bindAnimationState = new AnimationState();
    public final AnimationState deathAnimationState = new AnimationState();
    private final BindEntity entity;
    private boolean animationBegun = false;
    public float health;
    private int ticksUntilDeath = 200;
    private LivingEntity lastAttacker;
    private LivingEntity target;

    private static final TrackedData<Boolean> SHOULD_PLAY_DEATH_ANIMATION =
            DataTracker.registerData(BindEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DEATH_ANIMATION_TIMEOUT =
            DataTracker.registerData(BindEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public BindEntity(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
        this.entity = this;
        this.health = getDefaultHealth(world);
    }

    public BindEntity(EntityType<? extends Entity> entityType, World world, LivingEntity target) {
        this(entityType, world);
        this.target = target;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        this.lastAttacker = source.getAttacker() instanceof LivingEntity ? (LivingEntity)source.getAttacker() : lastAttacker;



        if (this.target != null && source.getAttacker() != null) {
            if (source.getAttacker().getType() == ModEntities.BRONZE) {
                this.target.damage(source, amount);
                return true;
            }
        }

        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (this.getWorld().isClient) {
            return true;
        } else {
            this.scheduleVelocityUpdate();
            this.health = (this.health - amount);
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
            return true;
        }
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();

        } else {

            //BetterProgression.LOGGER.info("[Server] Bind Health = {}", (int)this.health);

            if (this.target != null) {
                this.target.teleport(this.entity.getX(), this.entity.getY(), this.entity.getZ(), false);
                if (this.target.getPose() == EntityPose.DYING) {
                    this.health = 0;
                    this.target = null;
                }
            }

            //BetterProgression.LOGGER.info("DeathAnimationTimeout={}", this.getDeathAnimationTimeout());
            if (this.ticksUntilDeath == 1 || this.health <= 0) {
                this.setShouldPlayDeathAnimation(true);

                if (this.getDeathAnimationTimeout() >= -1) {
                    this.setDeathAnimationTimeout(this.getDeathAnimationTimeout() - 1);
                } else {
                    //BetterProgression.LOGGER.info("[Server] Discarding BindEntity");
                    this.discard();
                    return;
                }
                //BetterProgression.LOGGER.info("[Server] ticksUntilDeath={}, setting shouldPlayDeathAnimation=true, health={}, deathAnimationTimeout={}",
                //        this.ticksUntilDeath, this.health, this.getDeathAnimationTimeout());
            } else {
                //BetterProgression.LOGGER.info("[Server] ticksUntilDeath={}", this.ticksUntilDeath);
                --this.ticksUntilDeath;
            }
        }
    }

    private void setupAnimationStates() {
        //boolean shouldPlayDeathAnimation = this.shouldPlayDeathAnimation();
        //int deathAnimationTimeout = this.getDeathAnimationTimeout();
        //BetterProgression.LOGGER.info("[Client] shouldPlayDeathAnimation={}, deathAnimationTimeout={}", shouldPlayDeathAnimation, deathAnimationTimeout);

        if (!this.animationBegun) {
            this.bindAnimationState.start(this.age);
            this.animationBegun = true;
        }

        if (this.shouldPlayDeathAnimation()) {
            //BetterProgression.LOGGER.info("[Client] shouldPlayDeathAnimation detected! Starting death animation. deathAnimationTimeout={}",
            //        this.getDeathAnimationTimeout());

            if (this.getDeathAnimationTimeout() == 4) {
                this.bindAnimationState.stop();
                this.deathAnimationState.start(this.age);
            }
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.getTypeRegistryEntry() == DamageTypes.IN_WALL ||
                damageSource.getTypeRegistryEntry() == DamageTypes.CACTUS ||
                damageSource.getTypeRegistryEntry() == DamageTypes.CAMPFIRE ||
                damageSource.getTypeRegistryEntry() == DamageTypes.DROWN ||
                damageSource.getTypeRegistryEntry() == DamageTypes.HOT_FLOOR ||
                damageSource.getTypeRegistryEntry() == DamageTypes.THORNS
        ) {
            return true;
        }
        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public void setVelocity(Vec3d velocity) {

    }

    @Override
    public void setVelocity(double x, double y, double z) {

    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(SHOULD_PLAY_DEATH_ANIMATION, false);
        builder.add(DEATH_ANIMATION_TIMEOUT, 5);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.dataTracker.set(SHOULD_PLAY_DEATH_ANIMATION, nbt.getBoolean("ShouldPlayDeathAnimation"));
        this.animationBegun = nbt.getBoolean("AnimationBegun");

        if (nbt.contains("DeathAnimationTimeout")) {
            this.dataTracker.set(DEATH_ANIMATION_TIMEOUT, nbt.getInt("DeathAnimationTimeout"));
        } else {
            this.dataTracker.set(DEATH_ANIMATION_TIMEOUT, 5); // Reset to default if not found
        }

        if (nbt.contains("TicksUntilDeath")) {
            this.ticksUntilDeath = nbt.getInt("TicksUntilDeath");
        } else {
            this.ticksUntilDeath = 200;
        }
        if (nbt.contains("Health")) {
            this.health = nbt.getFloat("Health");
        } else {
            this.health = getDefaultHealth(this.getWorld());
        }
    }

    private float getDefaultHealth(World world) {
        return 8 * ((float) world.getDifficulty().getId() / 2 + 1); // easy -> 12, normal -> 16, hard -> 20;
    }


    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putBoolean("AnimationBegun", this.animationBegun);
        nbt.putFloat("Health", this.health);
        nbt.putInt("TicksUntilDeath", this.ticksUntilDeath);
        nbt.putBoolean("ShouldPlayDeathAnimation", this.dataTracker.get(SHOULD_PLAY_DEATH_ANIMATION));
        nbt.putInt("DeathAnimationTimeout", this.dataTracker.get(DEATH_ANIMATION_TIMEOUT));
    }

    public void setDeathAnimationTimeout(int deathAnimationTimeout) {
        this.dataTracker.set(DEATH_ANIMATION_TIMEOUT, deathAnimationTimeout);
    }

    public int getDeathAnimationTimeout() {
        return this.dataTracker.get(DEATH_ANIMATION_TIMEOUT);
    }

    public void setShouldPlayDeathAnimation(boolean shouldPlayDeathAnimation) {
        if (!this.getWorld().isClient()) {
            this.dataTracker.set(SHOULD_PLAY_DEATH_ANIMATION, shouldPlayDeathAnimation);
            //BetterProgression.LOGGER.info("[Server] shouldPlayDeathAnimation set to {}", shouldPlayDeathAnimation);
        }
    }

    public boolean shouldPlayDeathAnimation() {
        return this.dataTracker.get(SHOULD_PLAY_DEATH_ANIMATION);
    }


//    @Override
//    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
//
//    }

    @Nullable
    @Override
    public LivingEntity getLastAttacker() {
        return this.lastAttacker;
    }
}
