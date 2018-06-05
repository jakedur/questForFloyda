package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.CommonMapFunctions;

public class ShopKeeperNPC extends Entity {
	int time;
	Texture image;
	public ShopKeeperNPC(float x, float y, CommonMapFunctions mapFunctions) {
		super(x, y, EntityType.NPC, mapFunctions);
		image = new Texture("Shop keeper.png");
		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x , pos.y, getWidth(), getHeight());
	}

}