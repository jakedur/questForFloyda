package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import entities.Player;

public class PlayerController extends InputAdapter {
	
	private Player player;
	private boolean moveRight, moveLeft, moveUp, moveDown, SpaceBar;
	
	public PlayerController (Player p) {
		this.player = p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.W) {
			moveUp = true;
		}
		if (keycode == Keys.S) {
			moveDown = true;
		}
		if (keycode == Keys.D) {
			moveRight = true;
		}
		if (keycode == Keys.A) {
			moveLeft = true;
		}
		if (keycode == Keys.SPACE) {
			SpaceBar = true;
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
	
	public boolean getSpaceBar() {
		return SpaceBar;
	}
	public void setSpaceBar(boolean spacebar) {
		SpaceBar = spacebar;
	}
	
	public void update(float delta) {
		if (moveUp == true) {
			player.moveOnY(16);
		}
		if (moveDown == true) {
			player.moveOnY(-16);
		}
		if (moveRight == true) {
			player.moveOnX(16);
		}
		if (moveLeft == true) {
			player.moveOnX(-16);
		}
	}
	
}
