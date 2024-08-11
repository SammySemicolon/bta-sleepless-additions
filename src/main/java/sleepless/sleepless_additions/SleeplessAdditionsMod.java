package sleepless.sleepless_additions;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
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

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("##", "##")
			.addInput('#', ItemRegistry.ruby)
			.create("ruby_bricks", BlockRegistry.blockRubyBricks.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("###", "###", "###")
			.addInput('#', ItemRegistry.ruby)
			.create("ruby_block", BlockRegistry.blockRuby.getDefaultStack());

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(BlockRegistry.blockRuby)
			.create("ruby_block_to_ruby", new ItemStack(ItemRegistry.ruby, 9));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("X", "X", "Y")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.stick)
			.create("ruby_sword", ItemRegistry.toolRubySword.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("X", "Y", "Y")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.stick)
			.create("ruby_shovel", ItemRegistry.toolRubyShovel.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("XXX", " Y ", " Y ")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.stick)
			.create("ruby_pickaxe", ItemRegistry.toolRubyPickaxe.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("XX ", "XY ", " Y ")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.stick)
			.create("ruby_axe", ItemRegistry.toolRubyAxe.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("XX ", " Y ", " Y ")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.stick)
			.create("ruby_hoe", ItemRegistry.toolRubyHoe.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("YXY", "X X")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.ingotGold)
			.create("ruby_helmet", ItemRegistry.armorHelmetRuby.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("Y Y", "XXX", "XXX")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.ingotGold)
			.create("ruby_chestplate", ItemRegistry.armorChestplateRuby.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("YXY", "X X", "X X")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.ingotGold)
			.create("ruby_leggings", ItemRegistry.armorLeggingsRuby.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("X X", "Y Y")
			.addInput('X', ItemRegistry.ruby)
			.addInput('Y', Item.ingotGold)
			.create("ruby_boots", ItemRegistry.armorBootsRuby.getDefaultStack());
	}

	@Override
	public void initNamespaces() {

	}
}
