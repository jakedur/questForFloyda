package controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import ui.OptionBox;

public class OptionBoxController extends InputAdapter {
	
	private OptionBox optionBox;
	
	public boolean closeOptionBox;
	
	public boolean enter;
	
	public OptionBoxController(OptionBox options) {
		optionBox = options;
		closeOptionBox = false;
		enter = false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.W) {
			optionBox.moveUp();
		}
		if (keycode == Keys.S) {
			optionBox.moveDown();
		}
		if (keycode == Keys.ESCAPE) {
			closeOptionBox = true;
		}
		if(keycode == Keys.ENTER) {
			enter = true;
		}
		return false;
	}
	
	public boolean CloseOptionBox() {
		return closeOptionBox;
	}
	
	public void setCloseOPtionBox(boolean set) {
		closeOptionBox = set;
	}
	
	public boolean getEnterStatus() {
		return enter;
	}
}
