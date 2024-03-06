package com.csdy.csdytinker.entities;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class MasterSpark<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "master_spark"), "main");
    private final ModelPart PreShot;
    private final ModelPart Shot;
    private final ModelPart Rings;
    private final ModelPart Falling;

    public MasterSpark(ModelPart root) {
        this.PreShot = root.getChild("PreShot");
        this.Shot = root.getChild("Shot");
        this.Rings = root.getChild("Rings");
        this.Falling = root.getChild("Falling");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition PreShot = partdefinition.addOrReplaceChild("PreShot", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Shot = partdefinition.addOrReplaceChild("Shot", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition in = Shot.addOrReplaceChild("in", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition in_down = in.addOrReplaceChild("in_down", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = in_down.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition in_up = in.addOrReplaceChild("in_up", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition cube_r2 = in_up.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition out = Shot.addOrReplaceChild("out", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition out_down = out.addOrReplaceChild("out_down", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition out_r1 = out_down.addOrReplaceChild("out_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition out_up = out.addOrReplaceChild("out_up", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition cube_r3 = out_up.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition Rings = partdefinition.addOrReplaceChild("Rings", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Ring1 = Rings.addOrReplaceChild("Ring1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition zn = Ring1.addOrReplaceChild("zn", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition xn = Ring1.addOrReplaceChild("xn", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition zp = Ring1.addOrReplaceChild("zp", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition xp = Ring1.addOrReplaceChild("xp", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Ring2 = Rings.addOrReplaceChild("Ring2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition zn2 = Ring2.addOrReplaceChild("zn2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition xn2 = Ring2.addOrReplaceChild("xn2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition zp2 = Ring2.addOrReplaceChild("zp2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition xp2 = Ring2.addOrReplaceChild("xp2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Ring3 = Rings.addOrReplaceChild("Ring3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition zn3 = Ring3.addOrReplaceChild("zn3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition xn3 = Ring3.addOrReplaceChild("xn3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition zp3 = Ring3.addOrReplaceChild("zp3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition xp3 = Ring3.addOrReplaceChild("xp3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Ring4 = Rings.addOrReplaceChild("Ring4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition zn4 = Ring4.addOrReplaceChild("zn4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition xn4 = Ring4.addOrReplaceChild("xn4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition zp4 = Ring4.addOrReplaceChild("zp4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition xp4 = Ring4.addOrReplaceChild("xp4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Falling = partdefinition.addOrReplaceChild("Falling", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition fall1 = Falling.addOrReplaceChild("fall1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f11 = fall1.addOrReplaceChild("f11", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f12 = fall1.addOrReplaceChild("f12", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fall2 = Falling.addOrReplaceChild("fall2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f21 = fall2.addOrReplaceChild("f21", CubeListBuilder.create().texOffs(4, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f22 = fall2.addOrReplaceChild("f22", CubeListBuilder.create().texOffs(4, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f23 = fall2.addOrReplaceChild("f23", CubeListBuilder.create().texOffs(4, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fall3 = Falling.addOrReplaceChild("fall3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f31 = fall3.addOrReplaceChild("f31", CubeListBuilder.create().texOffs(4, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f32 = fall3.addOrReplaceChild("f32", CubeListBuilder.create().texOffs(4, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f33 = fall3.addOrReplaceChild("f33", CubeListBuilder.create().texOffs(4, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f34 = fall3.addOrReplaceChild("f34", CubeListBuilder.create().texOffs(4, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fall4 = Falling.addOrReplaceChild("fall4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f41 = fall4.addOrReplaceChild("f41", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f42 = fall4.addOrReplaceChild("f42", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f43 = fall4.addOrReplaceChild("f43", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f44 = fall4.addOrReplaceChild("f44", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition f45 = fall4.addOrReplaceChild("f45", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        PreShot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Shot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Rings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Falling.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}