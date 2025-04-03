package com.frimi01.frimi01mod;

import com.frimi01.frimi01mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frimi01Mod implements ModInitializer {
	public static final String MOD_ID = "frimi01mod";

	// It is considered best practice to use your mod id as the logger's name.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		LOGGER.info(Frimi01Mod.MOD_ID + " Initialize Complete!");
	}
}