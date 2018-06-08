package entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.world.CommonMapFunctions;

public abstract class Entity {
	
	protected Vector2 pos;
	protected EntityType type;
	protected CommonMapFunctions map;
	
	private int srcX, srcY;
	private int destX, destY;
	@SuppressWarnings("unused")
	private int ClassNum;
	private float animTimer;
	private float ANIM_TIME = 0.3f;
	private boolean inMove;
	
	private ACTOR_STATE state;
	
	public Entity(float x, float y, EntityType type, CommonMapFunctions map2, int classNum) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map2;
		this.state = ACTOR_STATE.STANDING;
		this.ClassNum = classNum;
	}
	
	public enum ACTOR_STATE {
		WALKING,
		RUNNING,
		STANDING;
	}

	public void update(float deltaTime) {
		if (state == ACTOR_STATE.WALKING) {
			animTimer += deltaTime;
			if (animTimer > 1)
				animTimer = 1;
			if (animTimer < 0) 
				animTimer = 0;
			pos.x = Interpolation.linear.apply(srcX, destX, animTimer/ANIM_TIME);
			pos.y = Interpolation.linear.apply(srcY, destY, animTimer/ANIM_TIME);
			if (animTimer > ANIM_TIME) {
				finishMove();
				System.out.println(pos.x);
				System.out.println(pos.y);
			}
		}
	}

	public abstract void render(SpriteBatch batch);
	
	public void moveOnX(int amount) {
		float newX =(pos.x + amount);
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()) && state == ACTOR_STATE.STANDING) {
			initializeMove((int) pos.x, (int) pos.y, amount, 0);
			//pos.x = newX;
		}
	}
	public void moveOnY(int amount) {
		float newY = (pos.y + amount); 
		if (!map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight()) && state == ACTOR_STATE.STANDING) {
			initializeMove((int) pos.x, (int) pos.y, 0, amount);
			//pos.y = newY;
		}
	}
	
	public void initializeMove(int oldX, int oldY, int newX, int newY) {
		this.srcX = oldX;
		this.srcY = oldY;
		this.destX = oldX + newX;
		this.destY = oldY + newY;
		animTimer = 0f;
		state = ACTOR_STATE.WALKING;
		
	}
	
	public void finishMove() {
		state = ACTOR_STATE.STANDING;
		animTimer = 0;
		pos.x = destX;
		pos.y = destY;
		inMove = true;
	}
	
	public boolean firedMove() {
		if (inMove == true) {
			inMove = false;
			return true;
		}
		return false;
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
