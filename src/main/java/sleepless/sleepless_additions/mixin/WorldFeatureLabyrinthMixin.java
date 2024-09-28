package sleepless.sleepless_additions.mixin;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sleepless.sleepless_additions.ItemRegistry;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class WorldFeatureLabyrinthMixin {

	@Inject(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/WeightedRandomBag;addEntry(Ljava/lang/Object;D)V", ordinal = 1), remap = false)
	private void sleeplessAdditions$generate(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		WorldFeatureLabyrinth labyrinth = ((WorldFeatureLabyrinth)((Object)this));
		labyrinth.chestLoot.addEntry(new WeightedRandomLootObject(ItemRegistry.itemWoodenSlingshot.getDefaultStack(), 1), 6.0);
		labyrinth.chestLoot.addEntry(new WeightedRandomLootObject(ItemRegistry.itemSteelSlingshot.getDefaultStack(), 1), 0.5f);
	}
}
