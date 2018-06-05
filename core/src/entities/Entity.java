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
	
	private float SPEED;
	private float srcX, srcY;
	private float destX, destY;
	private float animTimer;
	private float ANIM_TIME = 0.5f;
	
	private ACTOR_STATE state;
	
	public Entity(float x, float y, EntityType type, CommonMapFunctions map2) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map2;
		this.worldX = x;
		this.worldY = y;
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
			worldX = Interpolation.linear.apply(srcX, destX, animTimer/ANIM_TIME);
			worldY = Interpolation.linear.apply(srcY, destY, animTimer/ANIM_TIME);		
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

	public void moveOnX(float amount) {
		
		float newX = pos.x + amount;
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()) ) {
			//initializeMove(pos.x, pos.y, newX, pos.y);
			this.pos.x = newX;
			//finishMove();
		}
	}
	public void moveOnY(float amount) {
		float newY = pos.y + amount;
		if (!map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight())) {
			this.pos.y = newY;
		}
	}
	
	public void initializeMove(float x, float y, float newX, float y2) {
		this.srcX = x;
		this.srcY = y;
		this.destX = x + newX;
		this.destY = y + y2;
		this.worldX = x;
		this.worldY = y;
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
		return type.getHeight()-2;
	}

	public float getSPEED() {
		return SPEED;
	}

	public void setSPEED(float sPEED) {
		SPEED = sPEED;
	}
	
}
