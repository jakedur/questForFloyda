package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;
import com.mygdx.game.world.CommonMapFunctions;
import com.mygdx.game.world.TileType;
import com.mygdx.game.world.TiledGameMap;
import com.mygdx.game.world.TiledShopMap;

import controller.PlayerController;
import entities.Entity;
import entities.Player;
import entities.ShopKeeperNPC;

public class ShopScreen extends AbstractScreen{
	private ArrayList<Entity>entities;
	private PlayerController controller;
	private Player player;
	private ShopKeeperNPC NPC;
	private SpriteBatch batch;
	private TiledShopMap TiledSMap;
	private Quest apps;
	
	OrthographicCamera cam;
	
	public ShopScreen(Quest app) {
		super(app);
		apps = app;
		TiledSMap = new TiledShopMap();
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledSMap.getMap());
		
		entities = new ArrayList<Entity>();
		NPC = new ShopKeeperNPC(112, 128 , mapFunctions);
		player = new Player(112, 16, mapFunctions );
		entities.add(player);
		entities.add(NPC);
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		if(player.getX() == 112 && player.getY() == 0) {
			apps.setCurrentScreen("Game Start");
		}
		TiledSMap.getTiledGMapRender().render();
		TiledSMap.getTiledGMapRender().setView(cam);
		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for(Entity entity : entities) {
			entity.update(delta);
			entity.render(batch);
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
		
	}

}
