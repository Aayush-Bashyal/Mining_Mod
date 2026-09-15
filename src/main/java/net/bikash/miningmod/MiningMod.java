package net.bikash.miningmod;

import com.mojang.logging.LogUtils;
import net.bikash.miningmod.block.ModBlocks;
import net.bikash.miningmod.item.ModArmorMaterials;
import net.bikash.miningmod.item.ModToolTiers;
import net.bikash.miningmod.item.Moditems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(MiningMod.MOD_ID)
public class MiningMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "miningmod";
    // Directly reference a slf4j logger
  public static final Logger LOGGER = LogUtils.getLogger();



    public MiningMod()
    {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in

        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(MiningMod.class);



        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
{
    event.accept(Moditems.RUBY);
    event.accept(Moditems.SAPPHIRE);
}

if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
    event.accept(ModBlocks.RUBY_BLOCK);
    event.accept(ModBlocks.SAPPHIRE_BLOCK);

}
if(event.getTabKey()== CreativeModeTabs.NATURAL_BLOCKS){
    event.accept(ModBlocks.RUBY_ORE);
    event.accept(ModBlocks.SAPPHIRE_ORE);
}
if(event.getTabKey()==CreativeModeTabs.COMBAT){
    event.accept(Moditems.RUBY_AXE);
    event.accept(Moditems.RUBY_PICKAXE);
    event.accept(Moditems.RUBY_HOE);
    event.accept(Moditems.RUBY_SHOVEL);
    event.accept(Moditems.RUBY_SWORD);
    event.accept(Moditems.SAPPHIRE_EXTREME);
    }
        if(event.getTabKey()==CreativeModeTabs.COMBAT) {
            event.accept(Moditems.RUBY_HELMET);
            event.accept(Moditems.RUBY_CHESTPLATE);
            event.accept(Moditems.RUBY_LEGGINGS);
            event.accept(Moditems.RUBY_BOOTS);
        }

    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if (event.phase != TickEvent.Phase.END){
            return;
        }
        if(event.player.level().isClientSide()){
            return;
        }
        if(event.player.getItemBySlot(EquipmentSlot.HEAD).is(Moditems.RUBY_HELMET.get())){
            event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,
                    400,
                    0,
                    false,
                    false));

        }
    }


    @SubscribeEvent
    public static void onPlayertick(TickEvent.PlayerTickEvent event){
        if (event.phase != TickEvent.Phase.END){
            return;
        }
        if(event.player.level().isClientSide()){
            return;
        }
        if(event.player.getItemBySlot(EquipmentSlot.HEAD).is(Moditems.  SAPPHIRE_HELMET.get())){
            event.player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
                    400,
                    0,
                    false,
                    false));

        }
    }
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event){
        if(event.getEntity() instanceof Player player){
            if(player.getItemBySlot(EquipmentSlot.FEET).is(Moditems.RUBY_BOOTS.get())){
              event.setDamageMultiplier(0.50F);
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
