package com.ransack3r.ruby.client.render.entity;

import com.ransack3r.ruby.Rubymod;
import com.ransack3r.ruby.client.render.entity.layer.WildBoarSaddleLayer;
import com.ransack3r.ruby.entities.WildBoarEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.util.ResourceLocation;

public class WildBoarRenderer extends MobRenderer<WildBoarEntity, PigModel<WildBoarEntity>> {

	private static final ResourceLocation WILD_BOAR_TEXTURE = new ResourceLocation(Rubymod.MOD_ID, "textures/entity/wild_boar/wild_boar.png");

	public WildBoarRenderer(final EntityRendererManager manager) {
		super(manager, new PigModel<>(), 0.7F);
		this.addLayer(new WildBoarSaddleLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(final WildBoarEntity entity) {
		return WILD_BOAR_TEXTURE;
	}

}
