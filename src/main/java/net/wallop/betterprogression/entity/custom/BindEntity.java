package net.wallop.betterprogression.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Arm;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class BindEntity extends LivingEntity {
    public final AnimationState bindAnimationState = new AnimationState();
    private boolean animationBegun = false;

    public BindEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 18);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (!this.animationBegun) {
            this.bindAnimationState.start(this.age);
            this.animationBegun = true;
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return super.damage(source, amount);
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
    public Iterable<ItemStack> getArmorItems() {
        return DefaultedList.ofSize(4, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void pushAway(Entity entity) {

    }

    @Override
    public void kill() {
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {

    }

    @Override
    public boolean isAffectedBySplashPotions() {
        return false;
    }

    @Override
    public boolean isMobOrPlayer() {
        return false;
    }
}
