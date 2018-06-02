package controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class TitleController extends InputAdapter{
	com.mygdx.game.Quest Quest = new com.mygdx.game.Quest();
	public boolean keyDown(int keycode) {
		if (keycode == Keys.ENTER) {
			Quest.setScreen(Quest.getScreen("Game Start"));
		}
		return false;
	}
}
