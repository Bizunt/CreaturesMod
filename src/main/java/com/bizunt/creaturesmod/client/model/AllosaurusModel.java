package com.bizunt.creaturesmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;

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
import com.bizunt.creaturesmod.entity.custom.AllosaurusEntity;

public class AllosaurusModel extends EntityModel<AllosaurusEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new ResourceLocation(CreaturesMod.MOD_ID, "allosaurus"), "main");

    private ModelPart body;
    private ModelPart head;
    private ModelPart tail;
    private ModelPart leg1;
    private ModelPart leg2;
    private ModelPart leg3;
    private ModelPart leg4;
    private ModelPart arm1;
    private ModelPart arm2;

    public AllosaurusModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.tail = root.getChild("tail");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
        this.arm1 = root.getChild("arm1");
        this.arm2 = root.getChild("arm2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
            .texCoords(0, 0).addBox(-8.0F, -8.0F, -16.0F, 16.0F, 16.0F, 24.0F),
            PartPose.offset(0.0F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
            .texCoords(0, 40).addBox(-6.0F, -8.0F, -12.0F, 12.0F, 12.0F, 12.0F),
            PartPose.offset(0.0F, -8.0F, -16.0F));

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create()
            .texCoords(48, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 20.0F),
            PartPose.offset(0.0F, -4.0F, 8.0F));

        partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create()
            .texCoords(0, 64).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
            PartPose.offset(-6.0F, 8.0F, -8.0F));

        partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create()
            .texCoords(0, 64).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
            PartPose.offset(6.0F, 8.0F, -8.0F));

        partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create()
            .texCoords(32, 64).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
            PartPose.offset(-6.0F, 8.0F, 4.0F));

        partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create()
            .texCoords(32, 64).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
            PartPose.offset(6.0F, 8.0F, 4.0F));

        partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create()
            .texCoords(48, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F),
            PartPose.offset(-8.0F, 0.0F, -8.0F));

        partdefinition.addOrReplaceChild("arm2", CubeListBuilder.create()
            .texCoords(48, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F),
            PartPose.offset(8.0F, 0.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(AllosaurusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        
        this.leg1.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        
        this.tail.yRot = (float) Math.sin(ageInTicks * 0.1F) * 0.3F;
    }
}
