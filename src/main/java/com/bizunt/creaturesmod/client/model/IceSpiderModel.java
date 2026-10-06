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
import com.bizunt.creaturesmod.entity.custom.IceSpiderEntity;

public class IceSpiderModel extends EntityModel<IceSpiderEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new ResourceLocation(CreaturesMod.MOD_ID, "ice_spider"), "main");

    private ModelPart body;
    private ModelPart abdomen;
    private ModelPart leg1;
    private ModelPart leg2;
    private ModelPart leg3;
    private ModelPart leg4;
    private ModelPart leg5;
    private ModelPart leg6;
    private ModelPart leg7;
    private ModelPart leg8;

    public IceSpiderModel(ModelPart root) {
        this.body = root.getChild("body");
        this.abdomen = root.getChild("abdomen");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
        this.leg5 = root.getChild("leg5");
        this.leg6 = root.getChild("leg6");
        this.leg7 = root.getChild("leg7");
        this.leg8 = root.getChild("leg8");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
            .texCoords(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 6.0F),
            PartPose.offset(0.0F, 15.0F, -1.0F));

        partdefinition.addOrReplaceChild("abdomen", CubeListBuilder.create()
            .texCoords(0, 12).addBox(-5.0F, -5.0F, 1.0F, 10.0F, 10.0F, 8.0F),
            PartPose.offset(0.0F, 15.0F, 0.0F));

        partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create()
            .texCoords(0, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(-4.0F, 14.0F, -3.0F));

        partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create()
            .texCoords(8, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(4.0F, 14.0F, -3.0F));

        partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create()
            .texCoords(16, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(-5.0F, 14.0F, 1.0F));

        partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create()
            .texCoords(24, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(5.0F, 14.0F, 1.0F));

        partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create()
            .texCoords(32, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(-5.0F, 14.0F, 5.0F));

        partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create()
            .texCoords(40, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(5.0F, 14.0F, 5.0F));

        partdefinition.addOrReplaceChild("leg7", CubeListBuilder.create()
            .texCoords(0, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(-4.0F, 14.0F, 7.0F));

        partdefinition.addOrReplaceChild("leg8", CubeListBuilder.create()
            .texCoords(8, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F),
            PartPose.offset(4.0F, 14.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(IceSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leg1.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg5.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg6.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg7.xRot = (float) Math.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg8.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
