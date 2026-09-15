package net.bikash.miningmod.item;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.phys.Vec3;

import java.util.List;
public class SapphireExtremeItem extends Item
{ public SapphireExtremeItem(Item.Properties properties) {
    super(properties.component(DataComponents.TOOL, new Tool
                    (List.of(Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, 50.0F),
                            Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, 50.0F),
                            Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, 50.0F)),
                            50.0F, 1))
            .attributes(ItemAttributeModifiers.builder()
                    .add(Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(ResourceLocation.fromNamespaceAndPath
                                    ("miningmod", "sapphire_extreme_damage"),
                                    1000.0, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND).build()));


}
    @Override
    public InteractionResultHolder<ItemStack> use( Level level, Player player, InteractionHand hand)
    { ItemStack stack = player.getItemInHand(hand);
        if (player.isInWaterOrRain()) {
            Vec3 look = player.getLookAngle();

            player.setDeltaMovement(
                    look.x * 5.0,
                    look.y * 5.0,
                    look.z * 5.0
            );

            player.hurtMarked = true;
        }
        if (!level.isClientSide)
        { ThrownTrident trident = new ThrownTrident( level, player, new ItemStack(Items.TRIDENT));

            trident.shootFromRotation( player, player.getXRot(), player.getYRot(),
                    0.0F, 3.0F, 1.0F );
            level.addFreshEntity(trident);
        } return InteractionResultHolder.sidedSuccess( stack, level.isClientSide() ); }
}