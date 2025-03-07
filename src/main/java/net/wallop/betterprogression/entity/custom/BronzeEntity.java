package net.wallop.betterprogression.entity.custom;


import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.ai.BronzeBindGoal;
import net.wallop.betterprogression.entity.ai.BronzeShootGoal;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.item.custom.BronzeSpearItem;
import net.wallop.betterprogression.particle.ModParticles;
import net.wallop.betterprogression.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class BronzeEntity extends HostileEntity implements RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState shootAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int shootAnimationTimeout = 0;
    private static final int BIND_COOLDOWN_SECONDS = 20;

    private static final TrackedData<Boolean> SHOOTING =
            DataTracker.registerData(BronzeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> BIND_COOLDOWN =
            DataTracker.registerData(BronzeEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final TrackedData<Boolean> SHOULD_BIND =
            DataTracker.registerData(BronzeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public BronzeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ItemStack getProjectileType(ItemStack stack) {
        return ModItems.BRONZE_SPEAR.getDefaultStack();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new BronzeShootGoal(this, 1, 30,10));
        this.goalSelector.add(1, new BronzeBindGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 10F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(0, new RevengeGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, PigEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 29;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isShooting()) {
            if (this.shootAnimationTimeout <= 0) {
                this.shootAnimationTimeout = 29;
                this.shootAnimationState.start(this.age);
            } else --this.shootAnimationTimeout;
        } else {
            shootAnimationState.stop();
            shootAnimationTimeout = -1;
        }
    }

    public void setShooting(boolean attacking) {
        this.dataTracker.set(SHOOTING, attacking);
    }

    public boolean isShooting() {
        return this.dataTracker.get(SHOOTING);
    }

    public void decrementBindCooldown() {
        this.setBindCooldown(this.getBindCooldown() - 1);
    }

    public void setBindCooldown(int cooldown) {
        this.dataTracker.set(BIND_COOLDOWN, cooldown);
        this.setShouldBind(cooldown <= 0);
    }

    public void resetBindCooldown() {
        this.dataTracker.set(BIND_COOLDOWN, BIND_COOLDOWN_SECONDS * 20);
        this.setShouldBind(false);
    }

    public int getBindCooldown() {
        return this.dataTracker.get(BIND_COOLDOWN);
    }

    public void setShouldBind(boolean bool) {
        this.dataTracker.set(SHOULD_BIND, bool);
    }

    public boolean shouldBind() {
        return this.dataTracker.get(SHOULD_BIND);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SHOOTING, false);
        builder.add(BIND_COOLDOWN, 0);
        builder.add(SHOULD_BIND, false);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();

            //TODO: add particles here maybe?

        } else if (this.getBindCooldown() > 0) {
            this.decrementBindCooldown();
        }

        //if (!this.getWorld().isClient()) {
            //BetterProgression.LOGGER.info("Shooting = {}", isShooting());
        //}
    }

    @Override
    public void slowMovement(BlockState state, Vec3d multiplier) {
        if (!state.isOf(Blocks.COBWEB)) {
            super.slowMovement(state, multiplier);
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
            ItemStack itemStack2 = ModItems.BRONZE_SPEAR.getDefaultStack();
            PersistentProjectileEntity persistentProjectileEntity = this.createSpearProjectile(itemStack2, pullProgress, this);
            double d = target.getX() - this.getX();
            double e = target.getBodyY(0.3333333333333333) - persistentProjectileEntity.getY();
            double f = target.getZ() - this.getZ();
            double g = Math.sqrt(d * d + f * f);
            persistentProjectileEntity.setVelocity(d, e + g * 0.2F, f, 1.6F, (float)(12 - this.getWorld().getDifficulty().getId() * 4));
            this.playSound(SoundEvents.ENTITY_LLAMA_SPIT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.getWorld().spawnEntity(persistentProjectileEntity);

    }

    protected PersistentProjectileEntity createSpearProjectile(ItemStack spear, float damageModifier, LivingEntity entity) {
        PersistentProjectileEntity persistentProjectileEntity = BronzeSpearItem.createBronzeSpear(entity.getWorld(), spear, entity);
        persistentProjectileEntity.applyDamageModifier(damageModifier);
        return persistentProjectileEntity;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BRONZE_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BRONZE_ENTITY_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BRONZE_DEATH;
    }

}
