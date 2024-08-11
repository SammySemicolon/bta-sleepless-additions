package sleepless.sleepless_additions;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

public class TerrainAPIContainer implements TerrainAPI {

	@Override
	public String getModID() {
		return SleeplessAdditionsMod.MOD_ID;
	}

	@Override
	public void onInitialize() {
		ChunkDecoratorOverworldAPI.oreFeatures.addFeature(
			new WorldFeatureOre(BlockRegistry.oreRubyStone.id, 5, true), 8, 0.3f);
	}
}
