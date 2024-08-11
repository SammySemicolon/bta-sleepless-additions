package sleepless.sleepless_additions;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.WeightedRandomLootObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class SleeplessAdditionsMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "sleepless_additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final BlockRegistry blockRegistry = new BlockRegistry();
	public static final ItemRegistry itemRegistry = new ItemRegistry();

    @Override
    public void onInitialize() {
        LOGGER.info("Sleepless Additions initialized.");
		itemRegistry.initializeItems();
		blockRegistry.initializeBlocks();
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {
		itemRegistry.initializeItemDetails();
		blockRegistry.initializeBlockDetails();
	}

	@Override
	public void onRecipesReady() {
		RecipeBuilder.ModifyTrommel("minecraft", "rich_dirt")
			.addEntry(new WeightedRandomLootObject(ItemRegistry.ruby.getDefaultStack(), 1, 2), 3);
	}

	@Override
	public void initNamespaces() {

	}
}
