package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Quest;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Quest quest = new Quest();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 500;
		config.height = 400;
		config.title = "( ͡° ͜ʖ ͡°)       ¯\\_(ツ)_/¯";
		config.vSyncEnabled = true;
		new LwjglApplication(quest, config);
	}
}
