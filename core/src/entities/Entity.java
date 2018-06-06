package entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.world.CommonMapFunctions;

public abstract class Entity {
	
	protected Vector2 pos;
	protected EntityType type;
	protected CommonMapFunctions map;
	
	private float worldX, worldY;
	private int srcX, srcY;
	private int destX, destY;
	private float animTimer;
	private float ANIM_TIME = 0.5f;
	
	private ACTOR_STATE state;
	
	public Entity(float x, float y, EntityType type, CommonMapFunctions map2) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map2;
		this.state = ACTOR_STATE.STANDING;
	}
	
	public enum ACTOR_STATE {
		WALKING,
		RUNNING,
		STANDING;
	}

	public void update(float deltaTime) {
		if (state == ACTOR_STATE.WALKING) {
			animTimer += deltaTime;
			pos.x = Interpolation.linear.apply(srcX, destX, animTimer/ANIM_TIME);
			pos.y = Interpolation.linear.apply(srcY, destY, animTimer/ANIM_TIME);
			if (animTimer > ANIM_TIME)
				finishMove();
		}
	}

	public float getWorldX() {
		return worldX;
	}

	public float getWorldY() {
		return worldY;
	}

	public abstract void render(SpriteBatch batch);
	
	public void moveOnX(int amount) {
		float newX = pos.x + amount;
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()) && state == ACTOR_STATE.STANDING) {
			initializeMove((int) pos.x, (int) pos.y, amount, 0);
		}
	}
	public void moveOnY(int amount) {
		float newY = pos.y + amount;
		if (!map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight()) && state == ACTOR_STATE.STANDING) {
			initializeMove((int) pos.x, (int) pos.y, 0, amount);
		}
	}
	
	public void initializeMove(int oldX, int oldY, int newX, int newY) {
		this.srcX = oldX;
		this.srcY = oldY;
		this.destX = oldX + newX;
		this.destY = oldY + newY;
		this.worldX = oldX;
		this.worldY = oldY;
		animTimer = 0f;
		state = ACTOR_STATE.WALKING;
	}
	
	public void finishMove() {
		state = ACTOR_STATE.STANDING;
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
		return type.getWidth()-1;
	}
	
	public int getHeight() {
		return type.getHeight()-1;
	}
}
