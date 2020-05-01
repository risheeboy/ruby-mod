package com.ransack3r.ruby.client;

import com.ransack3r.ruby.Rubymod;
import com.ransack3r.ruby.client.render.entity.WildBoarRenderer;
import com.ransack3r.ruby.util.Registryhandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Rubymod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber {
	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(Registryhandler.WILD_BOAR.get(), WildBoarRenderer::new);
	}
}
