package com.csdy.csdytinker.modifiers;

import org.lwjgl.system.CallbackI;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

public class ModifiersRegister {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MOD_ID);
    public static final StaticModifier<TrinityModifier> TRINITY_MODIFIER_STATIC_MODIFIER = MODIFIERS.register("trinity", TrinityModifier::new);
    public static final StaticModifier<MakeConcertedEfforts> MAKE_CONCERTED_EFFORTS_STATIC_MODIFIER = MODIFIERS.register("makeconcertedefforts", MakeConcertedEfforts::new);
    public static final StaticModifier<TriplingBless> TRIPLING_BLESS_STATIC_MODIFIER = MODIFIERS.register("triplingbless", TriplingBless::new);
    public static final StaticModifier<TriplingCurse> TRIPLING_CURSE_STATIC_MODIFIER = MODIFIERS.register("triplingcurse", TriplingCurse::new);
    public static final StaticModifier<Mutation> MUTATION_STATIC_MODIFIER = MODIFIERS.register("mutation", Mutation::new);
    public static final StaticModifier<Void> VOID_STATIC_MODIFIER = MODIFIERS.register("void", Void::new);
    public static final StaticModifier<Erase> ERASE_STATIC_MODIFIER = MODIFIERS.register("erase", Erase::new);
    public static final StaticModifier<OverNatural> OVER_NATURAL_STATIC_MODIFIER = MODIFIERS.register("overnatural", OverNatural::new);
    public static final StaticModifier<Gamble> GAMBLE_STATIC_MODIFIER = MODIFIERS.register("gamble", Gamble::new);
    public static final StaticModifier<Forging> FORGING_STATIC_MODIFIER = MODIFIERS.register("forging", Forging::new);
    public static final StaticModifier<Quenching> QUENCHING_STATIC_MODIFIER = MODIFIERS.register("quenching", Quenching::new);
    public static final StaticModifier<Agent> AGENT_STATIC_MODIFIER = MODIFIERS.register("agent", Agent::new);
    public static final StaticModifier<NoLevelsModifier> AGENT_D1_STATIC_MODIFIER = MODIFIERS.register("agent.d1", NoLevelsModifier::new);
    public static final StaticModifier<NoLevelsModifier> AGENT_D2_STATIC_MODIFIER = MODIFIERS.register("agent.d2", NoLevelsModifier::new);
    public static final StaticModifier<Kagutsuchi> KAGUTSUCHI_STATIC_MODIFIER = MODIFIERS.register("kagutsuchi", Kagutsuchi::new);
    public static final StaticModifier<ShatteredDreams> SHATTERED_DREAMS_STATIC_MODIFIER = MODIFIERS.register("shattered_dreams",ShatteredDreams::new);
    public static final StaticModifier<Exothermic> EXOTHERMIC_STATIC_MODIFIER = MODIFIERS.register("exothermic",Exothermic::new);
    public static final StaticModifier<Electrified> ELECTRIFIED_STATIC_MODIFIER = MODIFIERS.register("electrified",Electrified::new);
    public static final StaticModifier<Eyesight> EYESIGHT_STATIC_MODIFIER = MODIFIERS.register("eyesight",Eyesight::new);
    public static final StaticModifier<Conductive> CONDUCTIVE_STATIC_MODIFIER = MODIFIERS.register("conductive",Conductive::new);
    public static final StaticModifier<Fickle> FICKLE_STATIC_MODIFIER = MODIFIERS.register("fickle",Fickle::new);
    public static final StaticModifier<Test> TEST_STATIC_MODIFIER = MODIFIERS.register("test",Test::new);
    public static final StaticModifier<Banishment> BANISHMENT_STATIC_MODIFIER = MODIFIERS.register("banishment",Banishment::new);
    public static final StaticModifier<Arthur> ARTHUR_STATIC_MODIFIER = MODIFIERS.register("arthur",Arthur::new);
}
