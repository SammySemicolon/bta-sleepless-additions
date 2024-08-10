package sleepless.sleepless_additions.content;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityPebble;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemSlingshot extends Item {
    public ItemSlingshot(String name, int id, int damage) {
        super(name, id);
        this.maxStackSize = 1;
		this.setMaxDamage(damage);
    }

    public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.inventory.consumeInventoryItem(Item.ammoPebble.id)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isClientSide) {
				EntityPebble pebble = new EntityPebble(world, entityplayer);
				pebble.damage++;
				pebble.setHeading(pebble.xd, pebble.yd, pebble.zd, 2f, 1.0F);
				world.entityJoinedWorld(pebble);
            }
        }
        return itemstack;
    }
}
