package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;
import com.mygdx.game.world.CommonMapFunctions;
import com.mygdx.game.world.TiledOutsideMap;

import controller.PlayerController;
import entities.Entity;
import entities.Player;

public class OutsideMapScreen extends AbstractScreen{

	private ArrayList<Entity>entities;
	private PlayerController controller;
	private Player player;
	private SpriteBatch batch;
	private TiledOutsideMap TiledOutsideMap;
	private Quest apps;
	private double RNG;
	OrthographicCamera cam;
	
	public OutsideMapScreen(Quest app) {
		super(app);
		apps = app;
		
		TiledOutsideMap = new TiledOutsideMap();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledOutsideMap.getMap());
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		entities = new ArrayList<Entity>();
		player = new Player(144, 144, mapFunctions, apps.ClassSelect);
		entities.add(player);
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		controller.update(delta);
		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		TiledOutsideMap.getTiledGMapRender().setView(cam);
		TiledOutsideMap.getTiledGMapRender().render();
		batch.setProjectionMatrix(cam.combined);

		batch.begin();
		for(Entity entity : entities) {
			entity.update(delta);
			entity.render(batch);
		}
		batch.end();
	}

	public void enmeyEncounter() {
//		if()
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
