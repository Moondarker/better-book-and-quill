package me.moondark.betterbaq;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "betterbaq", name = "BetterBookAndQuill", version = BetterBookAndQuill.VERSION)
public final class BetterBookAndQuill {
	public static final String VERSION = "1.01";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Better Book and Quill ready");
    }
}
