package com.momnop.simplypaths;

import java.util.List;

import com.momnop.simplypaths.blocks.SimplyPathsBlocks;
import com.momnop.simplypaths.info.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class SimplyPathsCreativeTab extends CreativeTabs {
	
	List list;
	public static SimplyPathsCreativeTab INSTANCE = new SimplyPathsCreativeTab();
	
	public SimplyPathsCreativeTab() {
		super(ModInfo.MODID);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(SimplyPathsBlocks.blockPath);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}

	@Override
	public void displayAllReleventItems(List list) {
		this.list = list;
		
		addBlock(SimplyPathsBlocks.asphaultBlock);
		addBlock(SimplyPathsBlocks.whiteLineBlock);
		addBlock(SimplyPathsBlocks.yellowLineBlock);
		addBlock(SimplyPathsBlocks.blockPath);
		addBlock(SimplyPathsBlocks.blockDirtPath);
		addBlock(SimplyPathsBlocks.blockPodzolPath);
		addBlock(SimplyPathsBlocks.blockClayPath);
		addBlock(SimplyPathsBlocks.blockGravelPath);
		addBlock(SimplyPathsBlocks.blockSandPath);
		addBlock(SimplyPathsBlocks.blockSandstonePath);
		addBlock(SimplyPathsBlocks.blockCobblestonePath);
		addBlock(SimplyPathsBlocks.blockStonePath);
		addBlock(SimplyPathsBlocks.blockStoneBrickPath);
		addBlock(SimplyPathsBlocks.blockAsphaultPath);
		addBlock(SimplyPathsBlocks.blockWhiteLinePath);
		addBlock(SimplyPathsBlocks.blockYellowLinePath);
		addBlock(SimplyPathsBlocks.blockQuartzPath);
		addBlock(SimplyPathsBlocks.blockChiselledQuartzPath);
		addBlock(SimplyPathsBlocks.blockPillarQuartzPath);
		addBlock(SimplyPathsBlocks.blockNetherrackPath);
		addBlock(SimplyPathsBlocks.blockSoulSandPath);
		addBlock(SimplyPathsBlocks.blockGlowstonePath);
		addBlock(SimplyPathsBlocks.blockOakPlankPath);
		addBlock(SimplyPathsBlocks.blockSprucePlankPath);
		addBlock(SimplyPathsBlocks.blockBirchPlankPath);
		addBlock(SimplyPathsBlocks.blockJunglePlankPath);
		addBlock(SimplyPathsBlocks.blockAcaciaPlankPath);
		addBlock(SimplyPathsBlocks.blockDarkOakPlankPath);
	}

	private void addItem(Item item) {
		item.getSubItems(item, this, list);
	}

	private void addBlock(Block block) {
		ItemStack stack = new ItemStack(block);
		block.getSubBlocks(stack.getItem(), this, list);
	}

}