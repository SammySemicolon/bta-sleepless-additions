package sleepless.sleepless_additions;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SleeplessConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	public static final Toml properties = new Toml("Sleepless TOML Config");
	public static TomlConfigHandler cfg;

	public static int blockIndex = 1011;
	public static int itemIndex = 634;


	static {
		properties.addCategory("Sleepless Additions")
			.addEntry("cfgVersion", 5);
		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", blockIndex);

		List<Field> blockFields = Arrays.stream(BlockRegistry.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIndex++);
		}

		properties.addCategory("Item IDs");
		properties.addEntry("Item IDs.startingID", itemIndex);

		List<Field> itemFields = Arrays.stream(ItemRegistry.class.getDeclaredFields()).filter((F)-> Item.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field itemField : itemFields) {
			properties.addEntry("Item IDs." + itemField.getName(), itemIndex++);
		}

		cfg = new TomlConfigHandler(updater, SleeplessAdditionsMod.MOD_ID, properties);

	}
}
