package screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;
import com.mygdx.game.world.CommonMapFunctions;
import com.mygdx.game.world.TiledOutsideMap;

import controller.PlayerController;
import entities.Entity;
import entities.Player;
import util.Coordinate;

public class OutsideMapScreen extends AbstractScreen{

	private ArrayList<Entity>entities;
	private PlayerController controller;
	private Player player;
	private SpriteBatch batch;
	private TiledOutsideMap TiledOutsideMap;
	private Quest apps;
	private double RNG;
	OrthographicCamera cam;
	private List<Coordinate> townBox; 
	
	public OutsideMapScreen(Quest app, float x, float y) {
		super(app);
		apps = app;
		
		TiledOutsideMap = new TiledOutsideMap();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledOutsideMap.getMap());
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		entities = new ArrayList<Entity>();
		player = new Player(x, y, mapFunctions, apps.ClassSelect);
		entities.add(player);
		
		controller = new PlayerController(player);
		townBox = new ArrayList<Coordinate>();
		
		for (int i = 752; i < 976; i += 16)
			townBox.add(new Coordinate(i, 1056));
		for (int i = 752; i < 976; i += 16)
			townBox.add(new Coordinate(i, 1264));
		for (int i = 1056; i < 1264; i += 16)
			townBox.add(new Coordinate(752, i));
		for (int i = 1056; i < 1264; i += 16)
			townBox.add(new Coordinate(976, i));
		System.out.println(townBox.get(0).getX());
		System.out.println(townBox.get(0).getY());
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
		
		MapTransition();
		
		RNG = (int) (Math.random() * 100) + 1;
		if (player.firedMove()) {
			enmeyEncounter(RNG);
		}
	}
	
	public void MapTransition() {
		for(Coordinate cord : townBox)
			if (cord.getX() == (int) player.getX())
				if (cord.getY() == (int) player.getY())
					apps.setCurrentScreen("Game Start", 304, 16);
	}

	public void enmeyEncounter(double RNG) {
		if(RNG <= 5) {
			apps.setCurrentScreen("Battle Screen", player.getX(), player.getY());
		}
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
