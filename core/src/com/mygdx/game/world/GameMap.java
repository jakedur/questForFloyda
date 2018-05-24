package com.mygdx.game.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entities.Entity;
import entities.Player;

public abstract class GameMap {

	protected ArrayList<Entity>entities;
	
	public GameMap() {
		entities = new ArrayList<Entity>();
		entities.add(new Player(200, 30, this));
	}


	public void render(OrthographicCamera camera, SpriteBatch batch) {
		for(Entity entity : entities) {
			entity.render(batch);
			batch.setProjectionMatrix(camera.combined);
		}
	}

	public void update(float delta) {
		System.out.println("used");
		for(Entity entity : entities ) {

			entity.update(delta);
		}
	}
	public abstract void dispose();

	/**
	 *Gets a tile by pixel position within the world
	 */
	public TileType getTileTypeByLocation(int layer, float x, float y) {
		return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
	}

	/**
	 * Gets a tile at its coordinate within the map
	 */
	public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

	public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
		if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight())
			return true;
		
		for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
			for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
				for (int layer = 0; layer < getLayers(); layer++) {
					TileType type = getTileTypeByCoordinate(layer, col, row);
					if (type != null && type.isCollidable())
						return true;
				}
			}
		}
		return false;
	}

	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getLayers();

	public int getPixelWidth() {
		return this.getWidth() * TileType.TILE_SIZE;
	}

	public int getPixelHeight() {
		return this.getHeight() * TileType.TILE_SIZE;
	}
}
