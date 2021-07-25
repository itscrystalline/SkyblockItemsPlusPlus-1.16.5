package com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class SlayerDealerEntity extends MobEntity {
    public SlayerDealerEntity(EntityType<SlayerDealerEntity> entityType, World world) {
        super(entityType, world);
    }

    /*protected void defineSynchedData() {

    }*/
                                                                    
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10000000000.0D)
                .add(Attributes.MOVEMENT_SPEED, 0D)
                .add(Attributes.ATTACK_DAMAGE, 0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0D)
                .add(Attributes.FOLLOW_RANGE, 0D);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return damageSource != DamageSource.OUT_OF_WORLD;
    }

    @Override
    public void tick() {
        /*PlayerEntity closest = (PlayerEntity) this.level.players().toArray()[0];
        List<PlayerEntity> all = (List<PlayerEntity>) this.level.players();
        double dist = Double.MAX_VALUE;
        double thx = this.position().x;
        double thy = this.position().y;
        for (int i = 0; i < all.size(); i++)
        {
            double px = all.get(i).position().x;
            double py = all.get(i).position().y;
            double newdist = Math.sqrt(Math.pow(px - thx, 2) + Math.pow(py - thy, 2));
            if (newdist < dist)
            {
                closest = all.get(i);
                dist = newdist;
            }
        }

        this.lookAt(closest, 100, 0);
        super.tick();*/
    }

    /*@Override
    public boolean attackable() {
        return false;
    }*/
}
