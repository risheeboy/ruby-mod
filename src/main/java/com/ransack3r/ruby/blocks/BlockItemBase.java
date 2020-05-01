package com.ransack3r.ruby.blocks;

import com.ransack3r.ruby.Rubymod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(Rubymod.TAB));
    }
}
