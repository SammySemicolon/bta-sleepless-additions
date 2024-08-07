package sleepless.sleepless_additions;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
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
			.setIcon("sleepless_additions:item/rosarian_sword")
			.build(new ItemToolSword("tool.sword.rosarian", itemID("tool.sword.rosarian"), rubyMaterial));

		toolShovelRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/rosarian_shovel")
			.build(new ItemToolShovel("tool.shovel.rosarian", itemID("tool.shovel.rosarian"), rubyMaterial));

		toolPickaxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/rosarian_pickaxe")
			.build(new ItemToolPickaxe("tool.pickaxe.rosarian", itemID("tool.pickaxe.rosarian"), rubyMaterial));

		toolAxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/rosarian_axe")
			.build(new ItemToolAxe("tool.axe.rosarian", itemID("tool.axe.rosarian"), rubyMaterial));

		toolHoeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/rosarian_hoe")
			.build(new ItemToolHoe("tool.hoe.rosarian", itemID("tool.hoe.rosarian"), rubyMaterial));
	}
}
