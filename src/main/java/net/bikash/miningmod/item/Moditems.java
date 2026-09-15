package net.bikash.miningmod.item;

import net.bikash.miningmod.MiningMod;
import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.Properties;
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
            ()-> new PickaxeItem(ModToolTiers.RUBY,new Item.Properties().stacksTo(1)));
    //axe
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            ()-> new AxeItem(ModToolTiers.RUBY,new Item.Properties().stacksTo(1)));
    //sword
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            ()-> new SwordItem(ModToolTiers.RUBY,new Item.Properties().stacksTo(1)));
//hoe
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            ()-> new HoeItem(ModToolTiers.RUBY,new Item.Properties().stacksTo(1)));
    //shoVel
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            ()-> new ShovelItem(ModToolTiers.RUBY,new Item.Properties().stacksTo(1)));

    //registering ruby armors
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY.getHolder().get(), ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY.getHolder().get(), ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY.getHolder().get(), ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY.getHolder().get(), ArmorItem.Type.BOOTS , new Item.Properties().stacksTo(1)));




    //sapphire extereme item registration
    public static final RegistryObject<Item> SAPPHIRE_EXTREME = ITEMS.register( "sapphire_extreme",
            () -> new SapphireExtremeItem(new Item.Properties().stacksTo(1)
                    .durability(10000)) );





    //registering sapphire armors
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE.getHolder().get(), ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE.getHolder().get(), ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE.getHolder().get(), ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE.getHolder().get(), ArmorItem.Type.BOOTS , new Item.Properties().stacksTo(1)));

public static void register(IEventBus eventBus){
    ITEMS.register(eventBus);
}

}
