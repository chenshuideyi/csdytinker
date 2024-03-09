package com.csdy.csdytinker;


import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class MaterialsRegister {

    public MaterialId register(String name) {
        return new MaterialId(new ResourceLocation(CsdyTinker.MOD_ID, name));
    }

    public final MaterialId INARONS = register("inarons");
    public final MaterialId AGENT = register("agent");
}
