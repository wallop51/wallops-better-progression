package net.wallop.betterprogression.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.wallop.betterprogression.effect.ModEffects;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class BronzeSpearEntity extends PersistentProjectileEntity {
    private boolean dealtDamage;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(BronzeSpearEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public BronzeSpearEntity(EntityType<? extends BronzeSpearEntity> entityType, World world) {
        super(entityType, world);
    }

    public BronzeSpearEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.BRONZE_SPEAR, owner, world, stack, null);
        int variant = owner.isPlayer() ? 1 : 0;
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant);
    }

    @Nullable
    @Override
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        super.tick();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        DamageSource damageSource = this.getDamageSources().thrown(this, owner);
        float damage = owner == null ? 10f : (owner.isPlayer() ? 6f : 10f);
        this.dealtDamage = true;
        if (entity.damage(damageSource, damage)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                this.knockback(livingEntity, damageSource);
                this.onHit(livingEntity);
            }

        }

        if (owner instanceof PlayerEntity player && entity instanceof LivingEntity && entity != owner) {
            float f = player.distanceTo(entity);
            player.addStatusEffect(new StatusEffectInstance(ModEffects.SEISMIC, MathHelper.ceil(MathHelper.clamp(f*10,50,220)), 0, false, false, true));
        }

        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1,-0.01));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1F,1F);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }
    }

    @Override
    protected float getDragInWater() {
        return 0.99F;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return ModItems.BRONZE_SPEAR.getDefaultStack();
    }

    public boolean isEnchanted() {
        return false;
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dealtDamage = nbt.getBoolean("DealtDamage");
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("DealtDamage", this.dealtDamage);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    /* VARIANT */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    public BronzeSpearVariant getVariant() {
        return BronzeSpearVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(BronzeSpearVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }



}
