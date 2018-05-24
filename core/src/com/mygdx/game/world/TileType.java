package com.mygdx.game.world;

import java.util.HashMap;

public enum TileType {
	
	GRASS(1, false, "Grass"),
	GRASSCORNER(16, false, "Grass"),
	GRASSSIDE(31, false, "Grass"),
	PATHWAY(2, false, "Pathway"),
	PATHWAYRIGHTCORNER(17, false, "Pathway"),
	PATHWAYLEFTCORNER(32, false, "Pathway"),
	STONEWALLDOUBLE(3, true, "Stone Wall"),
	STONEWALLLEFTCORNER(18, true, "Stone Wall"),
	STONEWALLRIGHTWALL(33, true, "Stone Wall"),
	STONEWALLLEFTWALL(48, true, "Stone Wall"),
	STONEWALL(63, true, "Stone Wall"),
	FENCE(4, true, "Fence"),
	TREE(5, true, "Tree"),
	DOUBLETREE(20, true, "Tree"),
	WATER(6, true, "Water"),
	WATERLEFT(21, true, "Water"),
	WATERCORNER(36, true, "Water"),
	TOMBSTONE(7, true, "Tombstone"),
	BRIDGEUP(8, false, "Bridge"),
	BRIDGESIDE(23, false, "Bridge"),
	DOOR(9, false, "Door"),
	FLOWERS(10, false, "Flowers"),
	WINDOW(11, true, "Window"),
	DOUBLEWINDOW(22, true, "Window"),
	ROOFTILE(12, true, "Rooftile"),
	ROOFTILEEDGE(27, true, "Rooftile"),
	SHOPIDARMOR(13, true, "Shop Id"),
	SHOPIDCHURCH(28, true, "Shop Id"),
	SHOPIDBLACKMAGIC(43, true, "Shop Id"),
	SHOPIDWHITEMAGIC(58, true, "Shop Id"),
	SHOPIDMATERIALS(73, true, "Shop Id"),
	SHOPIDINN(88, true, "Shop Id"),
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
