package entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TileType;

public abstract class Entity {
	
	protected Vector2 pos;
	protected EntityType type;
	protected GameMap map;
	
	public Entity(float x, float y, EntityType type, GameMap map) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map;
	}

	public void update(float deltaTime) {
	}
	
	public abstract void render(SpriteBatch batch);

	protected void moveXLeft(float amount) {
		float newX = pos.x - 16;
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()))
			this.pos.x = newX;
	}
	protected void moveXRight(float amount) {
		float newX = pos.x + 16;
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()))
			this.pos.x = newX;
	}
	protected void moveYUp(float amount) {
		float newY = pos.y + 16;
		if (!map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight()))
			this.pos.y = newY;
	}
	protected void moveYDown(float amount) {
		float newY = pos.y - 16;
		if (!map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight()))
			this.pos.y = newY;
	}
	
	public Vector2 getPos() {
		return pos;
	}

	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public EntityType getType() {
		return type;
	}
	
	public int getWidth() {
		return type.getWidth()-3;
	}
	
	public int getHeight() {
		return type.getHeight()-3;
	}
	
}
