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

import controller.PlayerController;
import entities.Entity;
import entities.Player;

public class inGameScreen extends AbstractScreen {

	private ArrayList<Entity>entities;
	private PlayerController controller;
	private Player player;
	private SpriteBatch batch;
	private TiledGameMap TiledGMap;
	
	OrthographicCamera cam;
	Texture image;
	
	public inGameScreen(Quest app) {
		super(app);
		TiledGMap = new TiledGameMap();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledGMap.getMap());
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		
		image = new Texture("wizard.png");
		
		entities = new ArrayList<Entity>();
		player = new Player(304, 16, mapFunctions);
		entities.add(player);
		controller = new PlayerController(player);
	}

	public void dispose() {
		
	}


	
	public void show() {
		Gdx.input.setInputProcessor(controller);
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
	public void render(float delta) {
		TiledGMap.getTiledGMapRender().render();
		TiledGMap.getTiledGMapRender().setView(cam);;
		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		for(Entity entity : entities) {
			entity.setSPEED(200 * delta);
			entity.render(batch);
		}
		batch.end();
	}


}
