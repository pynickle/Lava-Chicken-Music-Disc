package com.euphony.lava_chicken_music_disc;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LavaChickenMusicDisc.MOD_ID);

    public static final DeferredItem<Item> MUSIC_DISC_LAVA_CHICKEN = ITEMS.registerItem(
            "music_disc_lava_chicken",
            Item::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ModSongs.LAVA_CHICKEN)
    );
}
