package com.frimi01.frimi01mod.item;

import com.frimi01.frimi01mod.Frimi01Mod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item DARK_GEM = register("dark_gem", Item::new, new Item.Settings());
    public static final Item DARK_MINERAL = register("dark_mineral", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Frimi01Mod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }


    public static void registerModItems(){
        Frimi01Mod.LOGGER.info("Registering Mod Items for " + Frimi01Mod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(groupEntries -> {
            groupEntries.add(DARK_GEM);
            groupEntries.add(DARK_MINERAL);
        });

        // 20 ticks = 1 second.
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.DARK_MINERAL, 30 * 20);
        });
    }
}