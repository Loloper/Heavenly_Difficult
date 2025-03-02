package heavenlydifficult.hd;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HD implements ModInitializer {
	//This is the MOD_ID for this project
	public static final String MOD_ID = "hd";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//Register Events, items, blocks and anything else really
		RaidEvent.register();
		HDItems.register();
	}

}
