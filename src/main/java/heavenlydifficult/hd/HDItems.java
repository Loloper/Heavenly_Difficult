package heavenlydifficult.hd;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HDItems {
    /**
     * @param name name of item
     * @param item Item object to register
     * @return Registered Item
     * */
    public static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(HD.MOD_ID, name), item);
    }

    /*Decripit Brick Drops from DECREPIT_BRICK_BLOCK. It's pretty useless*/
    public static final Item DECREPIT_BRICK = register("Decrepit_Brick", new Item(new Item.Settings()
            .maxCount(16).maxDamage(1)));


}
