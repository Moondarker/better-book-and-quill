package me.moondark.betterbaq.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Module and mixin code by Moon_dark, 11.03.2021
@Mixin(GuiScreenBook.class)
public abstract class MixinGuiScreenBook extends MixinGuiScreen
{
    @Shadow
    private String bookTitle;

    @Shadow
    private boolean bookIsModified;

    @Shadow
    private boolean bookIsUnsigned;

    @Shadow
    private boolean bookGettingSigned;

    @Shadow
    private void pageInsertIntoCurrent(String p_146459_1_) {}

    @Inject(method = "initGui", at = @At("RETURN"))
    public void initGui(CallbackInfo info)
    {
        if (this.bookIsUnsigned) {
            this.buttonList.add(new GuiButton(6906, this.width / 2 - 116, 10, 20, 20, "\u00A7"+"cRed"));
            this.buttonList.add(new GuiButton(6907, this.width / 2 - 96, 10, 20, 20, "\u00A7"+"4DRd"));
            this.buttonList.add(new GuiButton(6908, this.width / 2 - 116, 30, 20, 20, "\u00A7"+"eYlw"));
            this.buttonList.add(new GuiButton(6909, this.width / 2 - 96, 30, 20, 20, "\u00A7"+"6Gld"));
            this.buttonList.add(new GuiButton(6910, this.width / 2 - 116, 50, 20, 20, "\u00A7"+"aGrn"));
            this.buttonList.add(new GuiButton(6911, this.width / 2 - 96, 50, 20, 20, "\u00A7"+"2DGr"));
            this.buttonList.add(new GuiButton(6912, this.width / 2 - 116, 70, 20, 20, "\u00A7"+"bAq"));
            this.buttonList.add(new GuiButton(6913, this.width / 2 - 96, 70, 20, 20, "\u00A7"+"3DAq"));
            this.buttonList.add(new GuiButton(6914, this.width / 2 - 116, 90, 20, 20, "\u00A7"+"9Blu"));
            this.buttonList.add(new GuiButton(6915, this.width / 2 - 96, 90, 20, 20, "\u00A7"+"1DBl"));
            this.buttonList.add(new GuiButton(6916, this.width / 2 - 116, 110, 20, 20, "\u00A7"+"dLPu"));
            this.buttonList.add(new GuiButton(6917, this.width / 2 - 96, 110, 20, 20, "\u00A7"+"5DPu"));
            this.buttonList.add(new GuiButton(6918, this.width / 2 - 116, 130, 20, 20, "\u00A7"+"7LGr"));
            this.buttonList.add(new GuiButton(6919, this.width / 2 - 96, 130, 20, 20, "\u00A7"+"8DGr"));
            this.buttonList.add(new GuiButton(6920, this.width / 2 - 116, 150, 20, 20, "\u00A7"+"fWht"));
            this.buttonList.add(new GuiButton(6921, this.width / 2 - 96, 150, 20, 20, "\u00A7"+"0Blk"));

            this.buttonList.add(new GuiButton(6922, this.width / 2 + 70, 50, 40, 20, "\u00A7lBold"));
            this.buttonList.add(new GuiButton(6923, this.width / 2 + 70, 70, 40, 20, "\u00A7oItalic"));
            this.buttonList.add(new GuiButton(6924, this.width / 2 + 70, 90, 40, 20, "\u00A7nUnder"));
            this.buttonList.add(new GuiButton(6925, this.width / 2 + 70, 110, 40, 20, "\u00A7mStrike"));
            this.buttonList.add(new GuiButton(6926, this.width / 2 + 70, 130, 40, 20, "Random"));
            this.buttonList.add(new GuiButton(6927, this.width / 2 + 70, 150, 40, 20, "Reset"));
        }
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    protected void actionPerformed(GuiButton button, CallbackInfo info)
    {
        if (this.bookIsUnsigned && button.enabled && button.id >= 6906 && button.id <= 6927)
        {
            String[] lookupTable = {"c","4","e","6","a","2","b","3","9","1","d","5","7","8","f","0","l","o","n","m","k","r"};

            if (this.bookGettingSigned) {
                if (this.bookTitle.length() < 15) {
                    this.bookTitle = this.bookTitle + "\u00A7" + lookupTable[button.id-6906];
                    this.bookIsModified = true;
                }
            }
            else
            {
                this.pageInsertIntoCurrent("\u00A7" + lookupTable[button.id-6906]);
            }
        }
    }
}
