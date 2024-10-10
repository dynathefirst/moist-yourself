package net.epiccool.moistyourself;

import net.epiccool.moistyourself.effect.ModEffects;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoistYourself implements ModInitializer {
	public static final String MOD_ID = "moistyourself";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Began initializing " + MOD_ID);
		ModEffects.registerEffects();
		LOGGER.info("Finished initializing " + MOD_ID);
	}
}