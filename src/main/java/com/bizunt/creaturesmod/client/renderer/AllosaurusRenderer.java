package com.bizunt.creaturesmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;

import com.bizunt.creaturesmod.CreaturesMod;
import com.bizunt.creaturesmod.entity.custom.AllosaurusEntity;
import com.bizunt.creaturesmod.client.model.AllosaurusModel;

public class AllosaurusRenderer extends MobRenderer<AllosaurusEntity, AllosaurusModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CreaturesMod.MOD_ID, "textures/entity/allosaurus.png");

    public AllosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new AllosaurusModel(context.bakeLayer(AllosaurusModel.LAYER_LOCATION)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(AllosaurusEntity entity) {
        return TEXTURE;
    }
}
