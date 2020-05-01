package com.ransack3r.ruby.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class WildBoarEntity extends PigEntity {

    public static final String WILD_BOAR_NAME = "sewer";

    public WildBoarEntity(final EntityType<? extends WildBoarEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();

        final double baseSpeed = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();
        final double baseHealth = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
        // Multiply base health and base speed by one and a half
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * 1.5D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(baseHealth * 1.5D);
    }

    @Override
    public WildBoarEntity createChild(final AgeableEntity parent) {
        // Use getType to support overrides in subclasses
        return (WildBoarEntity) getType().create(this.world);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
