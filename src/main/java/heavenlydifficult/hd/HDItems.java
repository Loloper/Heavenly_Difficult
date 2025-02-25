package heavenlydifficult.hd;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HDItems {
    public static final Item DECREPIT_BRICK = register("decrepit_brick", new Item(new Item.Settings()
            .maxCount(16).maxDamage(1)));

    /**
     * @param name name of item
     * @param item Item object to register
     * @return Registered Item
     * */
    public static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(HD.MOD_ID, name), item);
    }

    public static void register()
    {
        /*Decripit Brick Drops from DECREPIT_BRICK_BLOCK. It's pretty useless*/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries ->
                entries.add(DECREPIT_BRICK));
    }
}
