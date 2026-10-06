package com.bizunt.creaturesmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import com.bizunt.creaturesmod.CreaturesMod;
import com.bizunt.creaturesmod.entity.custom.IceSpiderEntity;
import com.bizunt.creaturesmod.client.model.IceSpiderModel;

public class IceSpiderRenderer extends MobRenderer<IceSpiderEntity, IceSpiderModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CreaturesMod.MOD_ID, "textures/entity/ice_spider.png");

    public IceSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new IceSpiderModel(context.bakeLayer(IceSpiderModel.LAYER_LOCATION)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(IceSpiderEntity entity) {
        return TEXTURE;
    }
}
