package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.CsdyTinker;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

public class CsdyTinkerModifiers  {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MOD_ID);
    public static final StaticModifier<TrinityModifier> TRINITY_MODIFIER_STATIC_MODIFIER = MODIFIERS.register("trinity",TrinityModifier::new);
    public static final StaticModifier<MakeConcertedEfforts> MAKE_CONCERTED_EFFORTS_STATIC_MODIFIER = MODIFIERS.register("makeconcertedefforts",MakeConcertedEfforts::new);
    public static final StaticModifier<TriplingBless> TRIPLING_BLESS_STATIC_MODIFIER = MODIFIERS.register("triplingbless",TriplingBless::new);

    public static final StaticModifier<TriplingCurse> TRIPLING_CURSE_STATIC_MODIFIER = MODIFIERS.register("triplingcurse",TriplingCurse::new);
    public static final StaticModifier<Mutation> MUTATION_STATIC_MODIFIER = MODIFIERS.register("mutation",Mutation::new);

}
