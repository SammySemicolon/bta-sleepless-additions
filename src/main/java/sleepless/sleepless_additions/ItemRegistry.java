package sleepless.sleepless_additions;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import sleepless.sleepless_additions.content.ItemSlingshot;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

public class ItemRegistry {

	private int itemID(String itemName) {
		return SleeplessConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static final ToolMaterial RUBY_TOOL = (new ToolMaterial()).setDurability(1024).setEfficiency(16.0F, 32.0F).setMiningLevel(2).setSilkTouch(true);
	public static final ArmorMaterial RUBY_ARMOR = ArmorMaterial.register(
		new ArmorMaterial(new NamespaceID(SleeplessAdditionsMod.MOD_ID, "ruby"), ArmorMaterial.getArmorMaterials().size()-1, 400))
		.withProtectionPercentage(DamageType.COMBAT, 70.0F)
		.withProtectionPercentage(DamageType.BLAST, 50.0F)
		.withProtectionPercentage(DamageType.FIRE, 50.0F)
		.withProtectionPercentage(DamageType.FALL, 70.0F);

	public static Item ruby;

	public static Item toolRubySword;
	public static Item toolRubyShovel;
	public static Item toolRubyPickaxe;
	public static Item toolRubyAxe;
	public static Item toolRubyHoe;

	public static Item armorHelmetRuby;
	public static Item armorChestplateRuby;
	public static Item armorLeggingsRuby;
	public static Item armorBootsRuby;

	public static Item itemWoodenSlingshot;
	public static Item itemSteelSlingshot;

	public void initializeItems() {
		ruby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/ruby")
			.build(new Item("ruby", itemID("ruby")));

		toolRubySword = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_sword_ruby")
			.build(new ItemToolSword("tool.sword.ruby", itemID("toolRubySword"), RUBY_TOOL));

		toolRubyShovel = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_shovel_ruby")
			.build(new ItemToolShovel("tool.shovel.ruby", itemID("toolRubyShovel"), RUBY_TOOL));

		toolRubyPickaxe = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_pickaxe_ruby")
			.build(new ItemToolPickaxe("tool.pickaxe.ruby", itemID("toolRubyPickaxe"), RUBY_TOOL));

		toolRubyAxe = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_axe_ruby")
			.build(new ItemToolAxe("tool.axe.ruby", itemID("toolRubyAxe"), RUBY_TOOL));

		toolRubyHoe = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/tool_hoe_ruby")
			.build(new ItemToolHoe("tool.hoe.ruby", itemID("toolRubyHoe"), RUBY_TOOL));

		armorHelmetRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_helmet_ruby")
			.build(new ItemArmor("armor.helmet.ruby", itemID("armorHelmetRuby"), RUBY_ARMOR, 0));

		armorChestplateRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_chestplate_ruby")
			.build(new ItemArmor("armor.chestplate.ruby", itemID("armorChestplateRuby"), RUBY_ARMOR, 1));

		armorLeggingsRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_leggings_ruby")
			.build(new ItemArmor("armor.leggings.ruby", itemID("armorLeggingsRuby"), RUBY_ARMOR, 2));

		armorBootsRuby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/armor_boots_ruby")
			.build(new ItemArmor("armor.boots.ruby", itemID("armorBootsRuby"), RUBY_ARMOR, 3));

		itemWoodenSlingshot = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/wooden_slingshot")
			.build(new ItemSlingshot("wooden_slingshot", itemID("itemWoodenSlingshot"), 384));

		itemSteelSlingshot = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/steel_slingshot")
			.build(new ItemSlingshot("steel_slingshot", itemID("itemSteelSlingshot"), 2304));
	}

	public void initializeItemDetails() {
		CreativeHelper.setParent(ruby, Item.diamond);

		CreativeHelper.setParent(toolRubySword, Item.toolAxeGold);
		CreativeHelper.setParent(toolRubyShovel, Item.toolAxeGold);
		CreativeHelper.setParent(toolRubyPickaxe, Item.toolAxeGold);
		CreativeHelper.setParent(toolRubyAxe, Item.toolAxeGold);
		CreativeHelper.setParent(toolRubyHoe, Item.toolHoeGold);

		CreativeHelper.setParent(armorHelmetRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorChestplateRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorLeggingsRuby, Item.armorBootsGold);
		CreativeHelper.setParent(armorBootsRuby, Item.armorBootsGold);

		CreativeHelper.setParent(itemWoodenSlingshot, Item.olivine);
		CreativeHelper.setParent(itemSteelSlingshot, Item.toolHoeSteel);

		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_tools", Registries.stackListOf(toolRubySword, toolRubyShovel, toolRubyPickaxe, toolRubyAxe, toolRubyHoe));
		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_armor", Registries.stackListOf(armorHelmetRuby, armorChestplateRuby, armorLeggingsRuby, armorBootsRuby));
	}
}
