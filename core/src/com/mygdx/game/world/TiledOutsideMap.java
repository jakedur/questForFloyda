package com.mygdx.game.world;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class TiledOutsideMap {

	OrthographicCamera cam;
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tiledMapRenderer;
	
	public TiledOutsideMap() {
		cam = new OrthographicCamera();
		tiledMap = new TmxMapLoader().load("Outside Map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	public OrthogonalTiledMapRenderer getTiledGMapRender() {
		return tiledMapRenderer;
	}
	public TiledMap getMap() {
		return tiledMap;
	}
}
