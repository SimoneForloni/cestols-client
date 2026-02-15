package net.cestols.client;

import net.fabricmc.api.ClientModInitializer;

public class ClientInitializer implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Avviamo il cuore del nostro client
		CestolsClient.INSTANCE.onInitialize();
	}
}