package net.wallop.betterprogression.entity.custom;

import net.minecraft.block.PumpkinBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.item.custom.BronzeSpearItem;

public class BronzeSpearEntity extends PersistentProjectileEntity {
    public BronzeSpearEntity(EntityType<? extends BronzeSpearEntity> entityType, World world) {
        super(entityType, world);
    }

    public BronzeSpearEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.BRONZE_SPEAR, owner, world, stack, null);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        DamageSource damageSource = this.getDamageSources().arrow(this, owner);
        float damage = 6f;
        if (entity.damage(damageSource, damage)) {
            if (entity.getType() == EntityType.ENDERMAN || entity.getType() == ModEntities.BRONZE) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                this.knockback(livingEntity, damageSource);
                this.onHit(livingEntity);
            }

        }

        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1,-0.01));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1F,1F);
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
        return 0.8F;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return ModItems.BRONZE_SPEAR.getDefaultStack();
    }

    public boolean isEnchanted() {
        return false;
    }
}
