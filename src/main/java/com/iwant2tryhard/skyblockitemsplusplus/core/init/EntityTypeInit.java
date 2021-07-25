package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.DragonCrystalEntity;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer.SlayerDealerEntity;
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
    public static final RegistryObject<EntityType<DragonCrystalEntity>> DRAGON_CRYSTAL = ENTITY_TYPES.register("dragon_crystal",
            () -> EntityType.Builder.<DragonCrystalEntity>of(DragonCrystalEntity::new, EntityClassification.MISC)
                    .sized(2f, 2f)
                    .build(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "dragon_crystal_entity").toString()));
    public static final RegistryObject<EntityType<SlayerDealerEntity>> SLAYER_DEALER = ENTITY_TYPES.register("slayer_dealer",
            () -> EntityType.Builder.<SlayerDealerEntity>of(SlayerDealerEntity::new, EntityClassification.MISC)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "slayer_dealer_entity").toString()));
}
