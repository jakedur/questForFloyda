package com.mygdx.game.world;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

public class CommonMapFunctions {
	
	private TiledMap tiledMap;
	
	public CommonMapFunctions(TiledMap tiledMap) {
		this.tiledMap = tiledMap;
	}
	
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
	
	public TileType getTileTypeByCoordinate (int layer, int col, int row) {
		Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(col, row);
		if (cell != null) {
			TiledMapTile tile = cell.getTile();
			if (tile != null) {
				int id = tile.getId();
				return TileType.getTileTypeById(id);
			}
		}
		return null;
	}

	public int getWidth() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
	}

	public int getHeight() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
	}

	public int getLayers() {
		return tiledMap.getLayers().getCount();
	}

	public int getPixelWidth() {
		return getWidth() * TileType.TILE_SIZE;
	}

	public int getPixelHeight() {
		return getHeight() * TileType.TILE_SIZE;
	}
	
}
