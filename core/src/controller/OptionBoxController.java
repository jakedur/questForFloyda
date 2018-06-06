package controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import ui.OptionBox;

public class OptionBoxController extends InputAdapter {
	
	private OptionBox optionBox;
	
	public OptionBoxController(OptionBox options) {
		optionBox = options;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.W) {
			optionBox.moveUp();
		}
		if (keycode == Keys.S) {
			optionBox.moveDown();
		}
		return false;
	}
}
