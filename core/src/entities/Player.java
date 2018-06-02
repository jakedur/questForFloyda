package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.inGameScreen;

public class Player extends Entity {
	
	int time;
	Texture image;
	
	public Player(float x, float y, inGameScreen map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("wizard.png");
		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x , pos.y, getWidth(), getHeight());
	}

}
