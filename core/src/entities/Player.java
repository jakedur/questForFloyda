package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {

	private static final int SPEED = 60;
	
	Texture image;
	
	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texure("");
	}

	public void update(float deltaTime) {
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			moveX(-SPEED * deltaTime);
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
			moveX(SPEED * deltaTime);
		if(Gdx.input.isKeyPressed(Keys.DOWN))
			moveY(-SPEED * deltaTime);
		if(Gdx.input.isKeyPressed(Keys.UP))
			moveY(SPEED * deltaTime);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		

	}

}
