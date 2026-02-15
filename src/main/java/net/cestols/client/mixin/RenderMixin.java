package net.cestols.client.mixin;

import net.cestols.client.CestolsClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class RenderMixin {

	@Inject(method = "render", at = @At("TAIL"))
	private void onRender(float tickDelta, CallbackInfo ci) {
		MinecraftClient mc = MinecraftClient.getInstance();
		if (mc.textRenderer != null) {
			// Usiamo hudX e hudY invece di 4, 4
			mc.textRenderer.drawWithShadow("Cestols Client 1.8.9",
					CestolsClient.INSTANCE.hudX,
					CestolsClient.INSTANCE.hudY,
					0xFFFFFF);
		}
	}
}