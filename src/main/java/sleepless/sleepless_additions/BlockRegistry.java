package sleepless.sleepless_additions;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import sleepless.sleepless_additions.content.BlockOreRuby;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static sleepless.sleepless_additions.SleeplessAdditionsMod.MOD_ID;

public class BlockRegistry {
	public int blockID(String blockName) {
		return SleeplessConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block oreRubyStone;
	public static Block oreRubyBasalt;
	public static Block oreRubyLimestone;
	public static Block oreRubyGranite;

	public void initializeBlockDetails() {
		ItemToolPickaxe.miningLevels.put(oreRubyStone, 1);
		ItemToolPickaxe.miningLevels.put(oreRubyBasalt, 1);
		ItemToolPickaxe.miningLevels.put(oreRubyLimestone, 1);
		ItemToolPickaxe.miningLevels.put(oreRubyGranite, 1);

		CreativeHelper.setParent(oreRubyStone, Block.oreDiamondGranite);
		CreativeHelper.setParent(oreRubyBasalt, Block.oreDiamondGranite);
		CreativeHelper.setParent(oreRubyLimestone, Block.oreDiamondGranite);
		CreativeHelper.setParent(oreRubyGranite, Block.oreDiamondGranite);

		Registries.ITEM_GROUPS.register("sleepless_additions:ruby_ore", Registries.stackListOf(oreRubyStone, oreRubyBasalt, oreRubyLimestone, oreRubyGranite));

	}

	public void initializeBlocks() {

		BlockBuilder ore = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(3.0f)
			.setResistance(5.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		// Randomite Ores
		oreRubyStone = ore
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("sleepless_additions:block/randomitestone"))
			.build(new BlockOreRuby("ore.rubyore.stone", blockID("oreRubyStone"), Material.stone));
		oreRubyBasalt = ore
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("sleepless_additions:block/randomitebasalt"))
			.build(new BlockOreRuby("ore.rubyore.basalt", blockID("oreRubyBasalt"), Material.stone));
		oreRubyLimestone = ore
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("sleepless_additions:block/randomitelimestone"))
			.build(new BlockOreRuby("ore.rubyore.limestone", blockID("oreRubyLimestone"), Material.stone));
		oreRubyGranite = ore
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("sleepless_additions:block/randomitegranite"))
			.build(new BlockOreRuby("ore.rubyore.granite", blockID("oreRubyGranite"), Material.stone));
	}
}
