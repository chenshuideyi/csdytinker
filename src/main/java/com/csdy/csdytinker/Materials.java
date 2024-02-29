package com.csdy.csdytinker;


import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class Materials {

    public MaterialId register(String name){
        return new MaterialId(new ResourceLocation(CsdyTinker.MOD_ID,name));
    }
    public MaterialId inarons = register("inarons");
}
