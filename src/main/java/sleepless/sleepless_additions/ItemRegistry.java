package sleepless.sleepless_additions;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

public class ItemRegistry {

	private int itemID(String itemName) {
		return SleeplessConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static final ToolMaterial RUBY_TOOL = (new ToolMaterial()).setDurability(1024).setEfficiency(12.0F, 24.0F).setMiningLevel(3).setSilkTouch(true);
	public static final ArmorMaterial RUBY_ARMOR = ArmorMaterial.register(
		new ArmorMaterial(new NamespaceID("minecraft", "gold"), ArmorMaterial.getArmorMaterials().size()-1, 400))
		.withProtectionPercentage(DamageType.COMBAT, 70.0F)
		.withProtectionPercentage(DamageType.BLAST, 70.0F)
		.withProtectionPercentage(DamageType.FIRE, 70.0F)
		.withProtectionPercentage(DamageType.FALL, 70.0F);

	public static Item ruby;

	public static Item toolSwordRuby;
	public static Item toolShovelRuby;
	public static Item toolPickaxeRuby;
	public static Item toolAxeRuby;
	public static Item toolHoeRuby;

	public static Item armorHelmetRuby;
	public static Item armorChestplateRuby;
	public static Item armorLeggingsRuby;
	public static Item armorBootsRuby;

	public void initializeItems() {
		// Items

		ruby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/ruby")
			.build(new Item("ruby", itemID("ruby")));

		toolSwordRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_sword_rosarian")
			.build(new ItemToolSword("tool.sword.rosarian", itemID("toolSwordRuby"), RUBY_TOOL));

		toolShovelRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_shovel_rosarian")
			.build(new ItemToolShovel("tool.shovel.rosarian", itemID("toolShovelRuby"), RUBY_TOOL));

		toolPickaxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_pickaxe_rosarian")
			.build(new ItemToolPickaxe("tool.pickaxe.rosarian", itemID("toolPickaxeRuby"), RUBY_TOOL));

		toolAxeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_axe_rosarian")
			.build(new ItemToolAxe("tool.axe.rosarian", itemID("toolAxeRuby"), RUBY_TOOL));

		toolHoeRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_hoe_rosarian")
			.build(new ItemToolHoe("tool.hoe.rosarian", itemID("toolHoeRuby"), RUBY_TOOL));

		armorHelmetRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_helmet_rosarian")
			.build(new ItemArmor("armor.helmet.rosarian", itemID("armorHelmetRuby"), RUBY_ARMOR, 0));

		armorChestplateRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_chestplate_rosarian")
			.build(new ItemArmor("armor.chestplate.rosarian", itemID("armorChestplateRuby"), RUBY_ARMOR, 1));

		armorLeggingsRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_leggings_rosarian")
			.build(new ItemArmor("armor.leggings.rosarian", itemID("armorLeggingsRuby"), RUBY_ARMOR, 2));

		armorBootsRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_boots_rosarian")
			.build(new ItemArmor("armor.boots.rosarian", itemID("armorBootsRuby"), RUBY_ARMOR, 3));
	}

	public void initializeItemDetails() {
		CreativeHelper.setParent(ruby, Item.diamond);

		CreativeHelper.setParent(toolSwordRuby, Item.toolAxeGold);
		CreativeHelper.setParent(toolShovelRuby, toolSwordRuby);
		CreativeHelper.setParent(toolPickaxeRuby, toolShovelRuby);
		CreativeHelper.setParent(toolAxeRuby, toolPickaxeRuby);
		CreativeHelper.setParent(toolHoeRuby, Item.toolHoeGold);

		CreativeHelper.setParent(armorHelmetRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorChestplateRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorLeggingsRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorBootsRuby, Item.armorBootsGold);

		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_tools", Registries.stackListOf(toolSwordRuby, toolShovelRuby, toolPickaxeRuby, toolAxeRuby, toolHoeRuby));
		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_armor", Registries.stackListOf(armorHelmetRuby, armorChestplateRuby, armorLeggingsRuby, armorBootsRuby));

	}
}
