package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.CommonMapFunctions;

public class Player extends Entity {
	
	Texture image;
	
	public Player(float x, float y, CommonMapFunctions mapFunctions) {
		super(x, y, EntityType.PLAYER, mapFunctions);
		image = new Texture("wizard.png");
		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

}
