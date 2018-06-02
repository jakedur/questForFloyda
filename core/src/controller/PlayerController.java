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
			player.moveOnY(player.getSPEED());
		}
		if (keycode == Keys.S) {
			player.moveOnY(-player.getSPEED());
		}
		if (keycode == Keys.D) {
			player.moveOnX(player.getSPEED());
		}
		if (keycode == Keys.A) {
			player.moveOnX(-player.getSPEED());
		}
		return false;
	}
	
}
