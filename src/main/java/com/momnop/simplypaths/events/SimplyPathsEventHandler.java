package com.momnop.simplypaths.events;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.momnop.simplypaths.config.ConfigHandler;
import com.momnop.simplypaths.items.SimplyPathsItems;
import com.momnop.simplypaths.blocks.SimplyPathsBlocks;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimplyPathsEventHandler {

	EntityPlayer player;

	public Block findBlockUnderEntity(World parWorld, Entity parEntity) {
		return parWorld.getBlock(
				MathHelper.floor_double(parEntity.posX),
				MathHelper.floor_double(parEntity.posY - 0.20000000298023224D
						- (double) parEntity.yOffset),
				MathHelper.floor_double(parEntity.posZ));
	}

	@SubscribeEvent
	public void onPlayerInteractWool(PlayerInteractEvent event) {
		ItemStack getHeldItem = event.entityPlayer.getCurrentEquippedItem();

		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (getHeldItem != null
					&& getHeldItem.getItem() == SimplyPathsItems.pathChisel) {
				if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.wool) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockWoolPath,
							event.world.getBlockMetadata(event.x, event.y,
									event.z), 2);
				} else {

				}

			} else {

			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteractShovel(PlayerInteractEvent event) {
		ItemStack getHeldItem = event.entityPlayer.getCurrentEquippedItem();

		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (getHeldItem != null
					&& getHeldItem.getItem() instanceof ItemSpade
					|| getHeldItem != null && ConfigHandler.pathChisel == true
					&& getHeldItem.getItem() == SimplyPathsItems.pathChisel) {
				if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.grass) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.dirt
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 0) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockDirtPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.dirt
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 2) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockPodzolPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.gravel) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockGravelPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.clay) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockClayPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.soul_sand) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockSoulSandPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.sand
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 0) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockSandPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.sand
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 1) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockRedSandPath);
				} else {

				}

			} else {

			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteractPickaxe(PlayerInteractEvent event) {
		ItemStack getHeldItem = event.entityPlayer.getCurrentEquippedItem();

		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (getHeldItem != null
					&& getHeldItem.getItem() instanceof ItemPickaxe
					|| getHeldItem != null && ConfigHandler.pathChisel == true
					&& getHeldItem.getItem() == SimplyPathsItems.pathChisel) {
				if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.stone) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockStonePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.stonebrick) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockStoneBrickPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == SimplyPathsBlocks.asphaultBlock) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockAsphaultPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == SimplyPathsBlocks.whiteLineBlock) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockWhiteLinePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == SimplyPathsBlocks.yellowLineBlock) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockYellowLinePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.cobblestone) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockCobblestonePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.quartz_block
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 0) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockQuartzPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.quartz_block
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 1) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockChiselledQuartzPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.quartz_block
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 2) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockPillarQuartzPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.sandstone) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockSandstonePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.glowstone) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockGlowstonePath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.netherrack) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockNetherrackPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.brick_block) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockBricksPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == SimplyPathsBlocks.yellowBricksBlock) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockYellowBricksPath);
				} else {

				}
			} else {

			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteractAxe(PlayerInteractEvent event) {
		ItemStack getHeldItem = event.entityPlayer.getCurrentEquippedItem();

		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (getHeldItem != null && getHeldItem.getItem() instanceof ItemAxe
					|| getHeldItem != null && ConfigHandler.pathChisel == true
					&& getHeldItem.getItem() == SimplyPathsItems.pathChisel) {
				if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockOakPlankPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 1
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockSprucePlankPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 2
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockBirchPlankPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 3
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockJunglePlankPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 4
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockAcaciaPlankPath);
				} else if (event.world.blockExists(event.x, event.y, event.z)
						&& event.world.getBlockMetadata(event.x, event.y,
								event.z) == 5
						&& event.world.getBlock(event.x, event.y, event.z) == Blocks.planks) {
					getHeldItem.damageItem(1, event.entityPlayer);
					event.world.setBlock(event.x, event.y, event.z,
							SimplyPathsBlocks.blockDarkOakPlankPath);
				} else {

				}

			} else {

			}
		}
	}
	
	@SubscribeEvent
	public void setTooltips(ItemTooltipEvent event) {
		if (event.itemStack.getItem() == Item.getItemFromBlock(SimplyPathsBlocks.blockAsphaultFullWhitePath)) {
			event.toolTip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("item.tooltip.variant") + EnumChatFormatting.GRAY + " " + StatCollector.translateToLocal("item.tooltip.whiteFullVariant"));
		} else if (event.itemStack.getItem() == Item.getItemFromBlock(SimplyPathsBlocks.blockAsphaultFullYellowPath)) {
			event.toolTip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("item.tooltip.variant") + EnumChatFormatting.GRAY + " " + StatCollector.translateToLocal("item.tooltip.yellowFullVariant"));
		} else if (event.itemStack.getItem() == Item.getItemFromBlock(SimplyPathsBlocks.blockAsphaultBrokenWhitePath)) {
			event.toolTip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("item.tooltip.variant") + EnumChatFormatting.GRAY + " " + StatCollector.translateToLocal("item.tooltip.whiteBrokenVariant"));
		} else if (event.itemStack.getItem() == Item.getItemFromBlock(SimplyPathsBlocks.blockAsphaultBrokenYellowPath)) {
			event.toolTip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("item.tooltip.variant") + EnumChatFormatting.GRAY + " " + StatCollector.translateToLocal("item.tooltip.yellowBrokenVariant"));
		} else if (event.itemStack.getItem() == Item.getItemFromBlock(SimplyPathsBlocks.blockAsphaultWhiteIntersectionPath)) {
			event.toolTip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("item.tooltip.variant") + EnumChatFormatting.GRAY + " " + StatCollector.translateToLocal("item.tooltip.whiteIntersectionVariant"));
		}
	}
}