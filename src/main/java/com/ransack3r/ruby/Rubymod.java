package com.ransack3r.ruby;

import com.ransack3r.ruby.util.Registryhandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("rubymod")
public class Rubymod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rubymod";

    public Rubymod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Registryhandler.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.debug("setup event: " + event.description());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.debug("doClientStuff event: " + event.description());
    }

    public  static final ItemGroup TAB = new ItemGroup("rubyTab") {

        @Override
        public ItemStack createIcon(){
            return new ItemStack(Registryhandler.RUBY.get());
        }
    };
}
