package com.bizunt.creaturesmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import com.bizunt.creaturesmod.CreaturesMod;
import com.bizunt.creaturesmod.entity.custom.BasiliskEntity;
import com.bizunt.creaturesmod.client.model.BasiliskModel;

public class BasiliskRenderer extends MobRenderer<BasiliskEntity, BasiliskModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CreaturesMod.MOD_ID, "textures/entity/basilisk.png");

    public BasiliskRenderer(EntityRendererProvider.Context context) {
        super(context, new BasiliskModel(context.bakeLayer(BasiliskModel.LAYER_LOCATION)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(BasiliskEntity entity) {
        return TEXTURE;
    }
}
