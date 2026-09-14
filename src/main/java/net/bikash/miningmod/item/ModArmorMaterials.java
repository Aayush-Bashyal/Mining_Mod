package net.bikash.miningmod.item;


import net.bikash.miningmod.MiningMod;

import net.minecraft.core.registries.Registries;

import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;


public class ModArmorMaterials {


    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, MiningMod.MOD_ID);

    public static final RegistryObject<ArmorMaterial> RUBY =
            ARMOR_MATERIALS.register("ruby", () -> new ArmorMaterial(
                    Map.of(
                            ArmorItem.Type.HELMET, 3,
                            ArmorItem.Type.CHESTPLATE, 8,
                            ArmorItem.Type.LEGGINGS, 6,
                            ArmorItem.Type.BOOTS, 3,
                            ArmorItem.Type.BODY, 8
                    ),
                    30,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(Moditems.RUBY.get()),
                    List.of(),
                    0.0F,
                    0.0F
            ));
}