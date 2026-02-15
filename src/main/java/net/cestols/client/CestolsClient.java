package net.cestols.client;

import net.legacyfabric.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.input.Keyboard;

public class CestolsClient {
    public static final CestolsClient INSTANCE = new CestolsClient();
    private String name = "Cestols Client";
    private String version = "1.0.0";

    public int hudX = 4;
    public int hudY = 4;

    public KeyBinding keyBindingMenu;

    public void onInitialize() {
        System.out.println("[" + name + "] Inizializzazione in corso...");

        keyBindingMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open Mod Menu",
                Keyboard.KEY_RSHIFT,
                this.name
        ));
    }

    public String getName() { return name; }
}
