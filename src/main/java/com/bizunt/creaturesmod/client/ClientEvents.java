package com.bizunt.creaturesmod.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.bizunt.creaturesmod.CreaturesMod;
import com.bizunt.creaturesmod.client.model.AllosaurusModel;
import com.bizunt.creaturesmod.client.model.BasiliskModel;
import com.bizunt.creaturesmod.client.model.IceSpiderModel;
import com.bizunt.creaturesmod.client.renderer.AllosaurusRenderer;
import com.bizunt.creaturesmod.client.renderer.BasiliskRenderer;
import com.bizunt.creaturesmod.client.renderer.IceSpiderRenderer;
import com.bizunt.creaturesmod.entity.ModEntities;

@Mod.EventBusSubscriber(modid = CreaturesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ALLOSAURUS.get(), AllosaurusRenderer::new);
        event.registerEntityRenderer(ModEntities.BASILISK.get(), BasiliskRenderer::new);
        event.registerEntityRenderer(ModEntities.ICE_SPIDER.get(), IceSpiderRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AllosaurusModel.LAYER_LOCATION, AllosaurusModel::createBodyLayer);
        event.registerLayerDefinition(BasiliskModel.LAYER_LOCATION, BasiliskModel::createBodyLayer);
        event.registerLayerDefinition(IceSpiderModel.LAYER_LOCATION, IceSpiderModel::createBodyLayer);
    }
}
