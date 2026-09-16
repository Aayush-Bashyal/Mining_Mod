```java
// TODO: clean up imports later, some of these might not even be needed anymore lol
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;

// Helper class for custom armor materials. 
// Copied mostly from diamond material structure back in 1.20.4, hope it doesn't crash xD
public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = 
            DeferredRegister.create(Registries.ARMOR_MATERIAL, MiningMod.MOD_ID);

    // ruby armor stats - felt like making it slightly better than diamond or at least equal
    public static final RegistryObject<ArmorMaterial> RUBY = ARMOR_MATERIALS.register("ruby", () -> new ArmorMaterial(
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.BODY, 8 // wait is BODY even used for players? whatever, keeping it just in case
            ),
            30, // enchantability, pretty high cuz magic gem logic lol
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(Moditems.RUBY.get()),
            List.of(new ArmorMaterial.Layer(
                    ResourceLocation.fromNamespaceAndPath(MiningMod.MOD_ID, "ruby")
            )),
            5.0F,  // toughness
            0.8F   // knockback resistance - OP? nah it's fine
    ));

    // sapphire stuff - basically copy pasted from ruby because im lazy, just changed the item reference
    public static final RegistryObject<ArmorMaterial> SAPPHIRE = ARMOR_MATERIALS.register("sapphire", () -> new ArmorMaterial(
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.BODY, 8
            ),
            30,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(Moditems.SAPPHIRE.get()), // TODO: make sure Moditems has SAPPHIRE defined properly or game throws null pointer
            List.of(new ArmorMaterial.Layer(
                    ResourceLocation.fromNamespaceAndPath(MiningMod.MOD_ID, "sapphire")
            )),
            5.0F,
            0.8F
    ));
    
  
}

