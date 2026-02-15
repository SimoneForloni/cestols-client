package net.cestols.client.mods;

import net.cestols.client.CestolsClient;
import net.minecraft.client.gui.screen.Screen;

public class ModMenuScreen extends Screen {

    public ModMenuScreen() {
        super();
    }

    public void render(int mouseX, int mouseY, float delta) {
        // 1. Sfondo scuro sfumato
        this.renderBackground();

        // Coordinate del pannello centrale
        int x = this.width / 2 - 150;
        int y = this.height / 2 - 100;
        int w = 300;
        int h = 200;

        // 2. Ombra/Bordo esterno (leggero)
        fill(x - 1, y - 1, x + w + 1, y + h + 1, 0xFF000000);

        // 3. Sfondo principale (Grigio molto scuro, quasi nero)
        fill(x, y, x + w, y + h, 0xFF181818);

        // 4. Sidebar sinistra (più scura del corpo)
        fill(x, y, x + 60, y + h, 0xFF111111);

        // 5. Titolo sopra la sidebar
        this.textRenderer.drawWithShadow("MODS", x + 15, y + 10, 0xFFFFFFFF);

        // 6. Esempio di Bottone Mod (Stile Moderno)
        drawModButton("Toggle Sprint", x + 70, y + 30, mouseX, mouseY, false);
        drawModButton("FPS Boost", x + 70, y + 65, mouseX, mouseY, true); // Esempio sempre attivo

        super.render(mouseX, mouseY, delta);
    }

    private void drawModButton(String buttonName, int x, int y, int mouseX, int mouseY, boolean enabled) {
        int btnWidth = 210;
        int btnHeight = 30;

        // Verifica se il mouse è sopra il bottone
        boolean hovered = mouseX >= x && mouseX <= x + btnWidth && mouseY >= y && mouseY <= y + btnHeight;

        // Colore di sfondo: cambia se hovered
        int bgColor = hovered ? 0xFF252525 : 0xFF202020;
        fill(x, y, x + btnWidth, y + btnHeight, bgColor);

        // Testo della Mod
        this.textRenderer.drawWithShadow(buttonName, x + 10, y + 10, 0xFFDDDDDD);

        // Switch ON/OFF stile Lunar
        int statusColor = enabled ? 0xFF55FF55 : 0xFFFF5555; // Verde o Rosso
        fill(x + btnWidth - 30, y + 10, x + btnWidth - 10, y + 20, statusColor);
    }
}
