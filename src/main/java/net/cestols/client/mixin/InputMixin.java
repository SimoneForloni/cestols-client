package net.cestols.client.mixin;

import net.cestols.client.CestolsClient;
import net.cestols.client.mods.HudEditorScreen;
import net.cestols.client.mods.ModMenuScreen;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class InputMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if(CestolsClient.INSTANCE.keyBindingMenu.wasPressed()) {
            MinecraftClient mc = MinecraftClient.getInstance();

            if(mc.currentScreen == null) {
                mc.setScreen(new HudEditorScreen());
            }
        }
    }
}
