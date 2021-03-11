package me.moondark.betterbaq.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen
{
    @Shadow
    protected List<GuiButton> buttonList;

    @Shadow
    public int width;

    @Shadow
    public int height;
}
