package entities;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {
	
	private static final int SPEED = 100;
	int time;
	Texture image;
	
	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("wizard.png");
		
	}
	
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			time = 100;
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			moveXLeft(-SPEED * deltaTime);
			sleep();
		}
		if(Gdx.input.isKeyPressed(Keys.D)) {
			moveXRight(SPEED * deltaTime);
			sleep();
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			moveYDown(-SPEED * deltaTime);
			sleep();
		}
		if(Gdx.input.isKeyPressed(Keys.W)) {
			moveYUp(SPEED * deltaTime);
			sleep();
		}
		time = 200;
	}
	
	public void sleep() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x , pos.y, getWidth(), getHeight());
	}

}
