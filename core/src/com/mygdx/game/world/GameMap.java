package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMap {

		public abstract void render(OrthographicCamera camera);
		public abstract void update(float delta);
		public abstract void dispose();
		
		/**
		 *Gets a tile by pixel position within the world
		 */
		public TileType getTileByLocation(int layer, float x, float y) {
			return this.getTileByLocation(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
		}
		
		/**
		 * Gets a tile at its coordinate within the map
		 */
		public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);
		
		public abstract int getWidth();
		public abstract int getHeight();
		public abstract int getLayers();
}
