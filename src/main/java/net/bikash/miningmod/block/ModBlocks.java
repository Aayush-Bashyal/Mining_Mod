package net.bikash.miningmod.block;

import net.bikash.miningmod.MiningMod;
import net.bikash.miningmod.item.Moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;S
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block>  BLOCKS =
             DeferredRegister.create(ForgeRegistries.BLOCKS , MiningMod.MOD_ID);



    public static  final  RegistryObject<Block> RUBY_BLOCK = registerBlock( "ruby_block" ,
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST) ));


    public static  final  RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock( "sapphire_block" ,
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST) ));


    private static<T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }



    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        Moditems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));

    }


    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
