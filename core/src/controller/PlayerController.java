package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import entities.Player;

public class PlayerController extends InputAdapter {
	
	private Player player;
	private boolean moveRight, moveLeft, moveUp, moveDown;
	
	public PlayerController (Player p) {
		this.player = p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.W) {
			moveUp = true;
			player.moveOnY(2);
		}
		if (keycode == Keys.S) {
			moveDown = true;
			player.moveOnY(-2);
		}
		if (keycode == Keys.D) {
			moveRight = true;
			player.moveOnX(2);
		}
		if (keycode == Keys.A) {
			moveLeft = true;
			player.moveOnX(-2);
		}
		return false;
	}
	
	public boolean keyUp(int keycode) {
		if (keycode == Keys.W) {
			moveUp = false;
		}
		if (keycode == Keys.S) {
			moveDown = false;
		}
		if (keycode == Keys.D) {
			moveRight = false;
		}
		if (keycode == Keys.A) {
			moveLeft = false;
		}
		return false;
	}
	
	public void update(float delta) {
		if (moveUp == true) {
			player.moveOnY(2);
		}
		if (moveDown == true) {
			player.moveOnY(-2);
		}
		if (moveRight == true) {
			player.moveOnX(2);
		}
		if (moveLeft == true) {
			player.moveOnX(-2);
		}
	}
	
}
