package sleepless.sleepless_additions;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

public class ItemRegistry {
	private int itemID(String blockName) {
		return SleeplessConfig.cfg.getInt("Item IDs." + blockName);
	}

	public static Item ruby;

	public void initializeItems() {
		// Items

		ruby = new ItemBuilder(SleeplessAdditionsMod.MOD_ID)
			.setIcon("sleepless_additions:item/ruby")
			.build(new Item("ruby", itemID("ruby")));
	}
}
