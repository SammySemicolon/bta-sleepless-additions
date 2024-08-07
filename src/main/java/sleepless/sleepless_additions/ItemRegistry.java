package sleepless.sleepless_additions;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

public class ItemRegistry {

	private int itemID(String itemName) {
		return SleeplessConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static final ToolMaterial rubyMaterial = (new ToolMaterial()).setDurability(1024).setEfficiency(12.0F, 24.0F).setMiningLevel(3).setSilkTouch(true);

	public static Item ruby;

	public static Item toolSwordRuby;
	public static Item toolShovelRuby;
	public static Item toolPickaxeRuby;
	public static Item toolAxeRuby;
	public static Item toolHoeRuby;

	public void initializeItems() {
		// Items

		ruby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/ruby")
			.build(new Item("ruby", itemID("ruby")));

		toolSwordRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_sword_rosarian")
			.build(new ItemToolSword("tool.sword.rosarian", itemID("toolSwordRuby"), rubyMaterial));

		toolShovelRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_shovel_rosarian")
			.build(new ItemToolShovel("tool.shovel.rosarian", itemID("toolShovelRuby"), rubyMaterial));

		toolPickaxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_pickaxe_rosarian")
			.build(new ItemToolPickaxe("tool.pickaxe.rosarian", itemID("toolPickaxeRuby"), rubyMaterial));

		toolAxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_axe_rosarian")
			.build(new ItemToolAxe("tool.axe.rosarian", itemID("toolAxeRuby"), rubyMaterial));

		toolHoeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_hoe_rosarian")
			.build(new ItemToolHoe("tool.hoe.rosarian", itemID("toolHoeRuby"), rubyMaterial));
	}

	public void initializeItemDetails() {
		CreativeHelper.setParent(ruby, Item.diamond);

		CreativeHelper.setParent(toolSwordRuby, Item.toolAxeGold);
		CreativeHelper.setParent(toolShovelRuby, toolSwordRuby);
		CreativeHelper.setParent(toolPickaxeRuby, toolShovelRuby);
		CreativeHelper.setParent(toolAxeRuby, toolPickaxeRuby);
		CreativeHelper.setParent(toolHoeRuby, Item.toolHoeGold);

		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_tools", Registries.stackListOf(toolSwordRuby, toolShovelRuby, toolPickaxeRuby, toolAxeRuby, toolHoeRuby));

	}
}
