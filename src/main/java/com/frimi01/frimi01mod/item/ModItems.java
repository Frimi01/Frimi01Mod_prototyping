package com.frimi01.frimi01mod.item;

import com.frimi01.frimi01mod.Frimi01Mod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Frimi01Mod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Frimi01Mod.LOGGER.info("Registering Mod Items for " + Frimi01Mod.MOD_ID);
    }
}
