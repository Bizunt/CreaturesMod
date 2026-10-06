package com.bizunt.creaturesmod.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import com.bizunt.creaturesmod.CreaturesMod;
import com.bizunt.creaturesmod.entity.custom.BasiliskEntity;

public class BasiliskModel extends EntityModel<BasiliskEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new ResourceLocation(CreaturesMod.MOD_ID, "basilisk"), "main");

    private ModelPart body;
    private ModelPart head;
    private ModelPart hood;
    private ModelPart tail;
    private ModelPart leg1;
    private ModelPart leg2;
    private ModelPart leg3;
    private ModelPart leg4;

    public BasiliskModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.hood = root.getChild("hood");
        this.tail = root.getChild("tail");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
            .texCoords(0, 0).addBox(-6.0F, -8.0F, -12.0F, 12.0F, 12.0F, 20.0F),
            PartPose.offset(0.0F, 4.0F, 0.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
            .texCoords(0, 32).addBox(-5.0F, -10.0F, -8.0F, 10.0F, 10.0F, 8.0F),
            PartPose.offset(0.0F, -4.0F, -12.0F));

        partdefinition.addOrReplaceChild("hood", CubeListBuilder.create()
            .texCoords(44, 0).addBox(-8.0F, -12.0F, -6.0F, 16.0F, 6.0F, 10.0F),
            PartPose.offset(0.0F, -8.0F, -12.0F));

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create()
            .texCoords(44, 16).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 8.0F, 16.0F),
            PartPose.offset(0.0F, -2.0F, 8.0F));

        partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create()
            .texCoords(0, 50).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
            PartPose.offset(-5.0F, 8.0F, -6.0F));

        partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create()
            .texCoords(0, 50).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
            PartPose.offset(5.0F, 8.0F, -6.0F));

        partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create()
            .texCoords(24, 50).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
            PartPose.offset(-5.0F, 8.0F, 4.0F));

        partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create()
            .texCoords(24, 50).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
            PartPose.offset(5.0F, 8.0F, 4.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(BasiliskEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        
        this.hood.yRot = (float) Math.sin(ageInTicks * 0.08F) * 0.2F;
        
        this.leg1.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
