package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import entities.Player;

public class PlayerController extends InputAdapter {
	
	private Player player;
	
	public PlayerController (Player p) {
		this.player = p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.W) {
			player.moveOnY(16);
		}
		if (keycode == Keys.S) {
			player.moveOnY(-16);
		}
		if (keycode == Keys.D) {
			player.moveOnX(16);
		}
		if (keycode == Keys.A) {
			player.moveOnX(-16);
		}
		return false;
	}
	
}
