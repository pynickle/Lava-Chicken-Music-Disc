package com.euphony.lava_chicken_music_disc;

import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@Mod(LavaChickenMusicDisc.MOD_ID)
@EventBusSubscriber(modid = LavaChickenMusicDisc.MOD_ID)
public class LavaChickenMusicDisc {
    public static final String MOD_ID = "lava_chicken_music_disc";

    public LavaChickenMusicDisc(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);
    }

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getTable().getLootTableId().equals(ResourceLocation.withDefaultNamespace("entities/zombie"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer())
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                            new EntityPredicate.Builder()
                                    .flags(new EntityFlagsPredicate.Builder().setIsBaby(true))
                                    .vehicle(new EntityPredicate.Builder()
                                            .entityType(new EntityTypePredicate(HolderSet.direct(EntityType.CHICKEN.builtInRegistryHolder())))
                                    )
                    ))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                    .add(LootItem.lootTableItem(ModItems.MUSIC_DISC_LAVA_CHICKEN));
            event.getTable().addPool(poolBuilder.build());
        }
    }

    @SubscribeEvent
    public static void itemGroupModification(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().equals(ResourceLocation.withDefaultNamespace("tools_and_utilities"))) {
            event.accept(ModItems.MUSIC_DISC_LAVA_CHICKEN);
        }
    }
}
