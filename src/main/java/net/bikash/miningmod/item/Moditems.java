package net.bikash.miningmod.item;

import net.bikash.miningmod.MiningMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, MiningMod.MOD_ID);

//registering ruby and sapphire here:-
public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
        ()-> new Item (new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item (new Item.Properties()));



    //registerning ruby tools here:-
    //pickaxe
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            ()-> new PickaxeItem(ModToolTiers.RUBY,new Item.Properties()));
    //axe
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            ()-> new AxeItem(ModToolTiers.RUBY,new Item.Properties()));
    //shword
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            ()-> new SwordItem(ModToolTiers.RUBY,new Item.Properties()));
//hoe
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            ()-> new HoeItem(ModToolTiers.RUBY,new Item.Properties()));
    //showel
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            ()-> new ShovelItem(ModToolTiers.RUBY,new Item.Properties()));

public static void register(IEventBus eventBus){
    ITEMS.register(eventBus);
}

}
