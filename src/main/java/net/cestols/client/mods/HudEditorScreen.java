package net.cestols.client.mods;

import net.cestols.client.CestolsClient;
import net.minecraft.client.gui.screen.Screen;

public class HudEditorScreen extends Screen {
    private boolean dragging = false;

    public HudEditorScreen() {
        super();
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
// 1. Sfondo scuro per far capire che siamo in edit mode
        this.renderBackground();

        // 2. Disegna un rettangolo tratteggiato o colorato attorno all'HUD per far capire che è spostabile
        int hudWidth = this.textRenderer.getStringWidth("Cestols Client 1.8.9");
        fill(CestolsClient.INSTANCE.hudX - 2, CestolsClient.INSTANCE.hudY - 2,
                CestolsClient.INSTANCE.hudX + hudWidth + 2, CestolsClient.INSTANCE.hudY + 11, 0x55FFFFFF);

        // 3. Bottone al centro per aprire il Mod Menu vero e proprio
        int btnWidth = 100;
        int btnHeight = 20;
        int btnX = this.width / 2 - btnWidth / 2;
        int btnY = this.height / 2 - btnHeight / 2;

        boolean hovered = mouseX >= btnX && mouseX <= btnX + btnWidth && mouseY >= btnY && mouseY <= btnY + btnHeight;
        fill(btnX, btnY, btnX + btnWidth, btnY + btnHeight, hovered ? 0xAA5555FF : 0xAA000000);
        this.textRenderer.drawWithShadow("MOD SETTINGS", btnX + 10, btnY + 6, 0xFFFFFF);

        // 4. Gestione trascinamento (Drag)
        if (dragging) {
            CestolsClient.INSTANCE.hudX = mouseX - (hudWidth / 2);
            CestolsClient.INSTANCE.hudY = mouseY - 5;
        }

        super.render(mouseX, mouseY, delta);
    }
}
