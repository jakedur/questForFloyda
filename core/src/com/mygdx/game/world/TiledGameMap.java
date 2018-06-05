package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap {

	OrthographicCamera cam;
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tiledMapRenderer;
	
	public TiledGameMap() {
		cam = new OrthographicCamera();
		tiledMap = new TmxMapLoader().load("Town Mapu 2.0.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}

	public OrthogonalTiledMapRenderer getTiledGMapRender() {
		return tiledMapRenderer;
	}
	
	public TiledMap getMap() {
		return tiledMap;
	}
}
