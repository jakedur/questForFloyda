
package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledShopMap{

	OrthographicCamera cam;
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tiledMapRenderer;
	
	public TiledShopMap() {
		cam = new OrthographicCamera();
		tiledMap = new TmxMapLoader().load("Shop Insides.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	public OrthogonalTiledMapRenderer getTiledGMapRender() {
		return tiledMapRenderer;
	}
	public TiledMap getMap() {
		return tiledMap;
	}
}
