package com.csdy.csdytinker;
 import com.csdy.csdytinker.entities.EntitiesRegister;
 import com.csdy.csdytinker.modifiers.Register.ModifiersRegister;
 import net.minecraft.data.DataGenerator;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.common.data.ExistingFileHelper;
 import net.minecraftforge.eventbus.api.IEventBus;
 import net.minecraftforge.eventbus.api.SubscribeEvent;
 import net.minecraftforge.fml.common.Mod;
 import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
 import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
 import com.csdy.csdytinker.effects.EffectsRegister;
 import com.csdy.csdytinker.effects.Event.ELivingEvent;
 import software.bernie.geckolib3.GeckoLib;

@Mod(CsdyTinker.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CsdyTinker {
    public static final String MOD_ID = "csdytinker";



    public CsdyTinker() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //注册表
        Items.ITEMS.register(bus);
        ModifiersRegister.MODIFIERS.register(bus);
        EffectsRegister.EFFECT.register(bus);
        EntitiesRegister.ENTITY_TYPES.register(bus);

        //初始化GeckoLib
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(new ELivingEvent());
    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeClient()) {
        }
        if (event.includeServer()) {
        }
    }
}
