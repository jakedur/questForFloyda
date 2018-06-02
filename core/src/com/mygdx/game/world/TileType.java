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
	DOUBLEWINDOW(26, true, "Window"),
	ROOFTILE(12, true, "Rooftile"),
	ROOFTILEEDGE(27, true, "Rooftile"),
	SHOPIDARMOR(13, true, "Shop Id"),
	SHOPIDCHURCH(28, true, "Shop Id"),
	SHOPIDBLACKMAGIC(43, true, "Shop Id"),
	SHOPIDWHITEMAGIC(58, true, "Shop Id"),
	SHOPIDMATERIALS(73, true, "Shop Id"),
	SHOPIDINN(88, true, "Shop Id"),
	ROOFWEDGE(14, true, "Roof Wedge"),
	FLOOR1(19 , false, "Floor 1"),
	FLOOR2(22, false, "Floor 2"),
	FLOOR3(24, false, "Floor 3"),
	FLOOR4(25, false, "Floor 4"),
	COUNTERTOPRIGHT(29, true, "Counter Top Right"),
	WALLCOUNTERTOPRIGHT(30, true, "Wall COunter Top Right"),
	BOTLEFTCORNERSHOP(39, true , "Bottom Left Corner of Shop"),
	WEIRDCORNER(40, true , "Werid Corner Thing"),
	WALLCOUNTERLEFT(41, true, "Wall Counter Top Left"),
	COUNTERTOPLEFT(42, true, "Counter Top Left"),
	COUNTERBOTTOMRIGHT(44, true, "Counter Bottom Right"),
	WALLCOUNTERBOTTOMRIGHT(45, true, "Wall Counter Bottom Right"),
	WALLCOUNTERBOTTOMLEFT(56, true, "Wall Counter Bottom Left"),
	COUNTERBOTTOMLEFT(57, true, "Counter Bottom Left"),
	SHOPFLOOR1(59, false, "Shop Floor 1"),
	SHOPWALLRIGHT(60, true,"Shop Wall Right"),
	SHOPWALLLEFT(71, true, "Shop Wall Left"),
	SHOPFLOORWALLBOTTOMRIGHT(74, false, "Shop Floor Wall Bottom Right"),
	SHOPFLOORWALLCORNERRIGHT(75, true, "Shop Floor Wall Corner Bottom Right"),
	SHOPFLOORWALLCORNERLEFT(86, true, "Shop Floor Wall Corner Bottom Left"),
	SHOPFLLORWALLBOTTOMLEFT(87, false, "Shop Floor Wall Bottom Left"),
	WALLBOTTOMRIGHT(89, true, "Wall Bottom Right"),
	WALLBOTTOMCORNERRIGHT(90, true, "Wall Bottom Corner Right"),
	WALLBOTTOMCORNERLEFT(101, true, "Wall Bottom Corner Left"),
	WALLBOTTOMLEFT(102, true, "Wall Bottom Left");
	
	
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
