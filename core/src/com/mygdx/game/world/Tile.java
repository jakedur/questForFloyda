package com.mygdx.game.world;

import entities.Entity;

public class Tile {

	private TileType tiles;
	
	private Entity entity;
	
	public Tile(TileType tiles) {
		this.tiles = tiles;
	}
	
	public TileType getTerrain() {
		return tiles;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
}
