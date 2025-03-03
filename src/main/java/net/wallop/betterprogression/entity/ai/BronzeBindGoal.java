package net.wallop.betterprogression.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.entity.custom.BindEntity;
import net.wallop.betterprogression.entity.custom.BronzeEntity;

public class BronzeBindGoal extends Goal {
    BronzeEntity mob;
    LivingEntity target;
    World world;
    BindEntity bindEntity;

    public BronzeBindGoal(BronzeEntity mob) {
        this.mob = mob;
        this.world = mob.getWorld();
        this.bindEntity = new BindEntity(mob.getType(), world, target);
    }



    @Override
    public void tick() {
        super.tick();
        this.target = this.mob.getTarget();
    }

    @Override
    public void start() {
        super.start();
        this.attack();
    }

    private void attack() {
        this.target = this.mob.getTarget();
        this.bindEntity = new BindEntity(ModEntities.BIND, this.world, this.target);
        this.bindEntity.setPosition(target.getX(), target.getY(), target.getZ());
        this.world.spawnEntity(this.bindEntity);
        this.target.damage(this.mob.getDamageSources().mobProjectile(this.bindEntity, this.mob), 4);
        this.stop();
    }

    @Override
    public void stop() {
        super.stop();
        this.mob.resetBindCooldown();
    }

    @Override
    public boolean canStart() {
        this.target = this.mob.getTarget();
        if (this.target == null) {
            return false;
        } else return target.isOnGround() && mob.shouldBind();
    }
}
