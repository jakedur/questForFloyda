package com.mygdx.game.world;

import java.util.HashMap;

public enum TileType {
	
	GRASS(1, false, "Grass"),
	PATHWAY(2, false, "Pathway"),
	STONEWALL(3, true, "Stone Wall"),
	FENCE(4, true, "Fence"),
	TREE(5, true, "Tree"),
	WATER(6, true, "Water"),
	TOMBSTONE(7, true, "Tombstone"),
	BRIDGE(8, false, "Bridge"),
	DOOR(9, false, "Door"),
	FLOWERS(10, false, "Flowers"),
	WINDOW(11, true, "Window"),
	ROOFTILE(12, true, "Rooftile"),
	SHOPID(13, true, "Shop Id"),
	ROOFWEDGE(14, true, "Roof Wedge");
	
	
	public static final int TILE_SIZE = 16;
	
	private int id;
	private boolean collidable;
	private String name;
	private float damage;
	
	private TileType(int id, boolean collidable, String name) {
		this(id, collidable, name, 0);
	}
	
	private TileType(int id, boolean collidable, String name, float damage) {
		this.id = id;
		this.collidable = collidable;
		this.name= name;
		this.damage = damage;
	}

	public int getId() {
		return id;
	}

	public boolean isCollidable() {
		return collidable;
	}

	public String getName() {
		return name;
	}

	public float getDamage() {
		return damage;
	}
	
	private static HashMap<Integer, TileType> tileMap;
	
	static {
		tileMap = new HashMap<Integer, TileType>();
		for (TileType tileType : TileType.values()) {
			tileMap.put(tileType.getId(), tileType);
		}
	}
	
	public static TileType getTileTypeById(int id) {
		return tileMap.get(id);
	}
}
