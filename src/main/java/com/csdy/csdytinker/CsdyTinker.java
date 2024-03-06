package com.csdy.csdytinker;
 import com.csdy.csdytinker.modifiers.ModifiersRegister;
 import net.minecraft.data.DataGenerator;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.common.data.ExistingFileHelper;
 import net.minecraftforge.eventbus.api.IEventBus;
 import net.minecraftforge.fml.common.Mod;
 import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
 import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
 import com.csdy.csdytinker.Effect.EffectsRegister;
 import com.csdy.csdytinker.Effect.Event.ELivingEvent;

@Mod(CsdyTinker.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CsdyTinker {
    public static final String MOD_ID = "csdytinker";



    public CsdyTinker() {
        IEventBus Bus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.ITEMS.register(Bus);
        ModifiersRegister.MODIFIERS.register(Bus);
        EffectsRegister.EFFECT.register(Bus);
        MinecraftForge.EVENT_BUS.register(new ELivingEvent());
    }

    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeClient()) {
        }
        if (event.includeServer()) {
        }
    }
}
