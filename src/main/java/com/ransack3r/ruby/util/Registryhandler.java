package com.ransack3r.ruby.util;

import com.ransack3r.ruby.blocks.BlockItemBase;
import com.ransack3r.ruby.blocks.RubyBlock;
import com.ransack3r.ruby.entities.WildBoarEntity;
import com.ransack3r.ruby.items.ItemBase;
import com.ransack3r.ruby.Rubymod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject; //Forge Mod Loader Registry
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registryhandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Rubymod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Rubymod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Rubymod.MOD_ID);

    public static void init() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
    }

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));

    //Entity Types
    public static final RegistryObject<EntityType<WildBoarEntity>> WILD_BOAR = ENTITY_TYPES.register(WildBoarEntity.WILD_BOAR_NAME, () ->
                    EntityType.Builder.<WildBoarEntity>create(WildBoarEntity::new, EntityClassification.CREATURE)
                            .size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight()*29)
                            .build(new ResourceLocation(Rubymod.MOD_ID, WildBoarEntity.WILD_BOAR_NAME).toString()));
}
