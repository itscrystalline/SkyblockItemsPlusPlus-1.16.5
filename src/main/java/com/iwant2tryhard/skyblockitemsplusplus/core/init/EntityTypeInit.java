package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SkyblockItemsPlusPlus.MOD_ID);

    public static final RegistryObject<EntityType<ZealotEntity>> ZEALOT = ENTITY_TYPES.register("zealot",
            () -> EntityType.Builder.<ZealotEntity>of(ZealotEntity::new, EntityClassification.MONSTER)
                    .sized(.75f, 2.8125f)
                    .build(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "zealot_entity").toString()));
}
