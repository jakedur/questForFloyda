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
	private Quest apps;

	OrthographicCamera cam;
	Texture image;

	public inGameScreen(Quest app, float x, float y) {
		super(app);
		apps = app;
	
		TiledGMap = new TiledGameMap();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledGMap.getMap());
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		image = new Texture("wizard.png");

		entities = new ArrayList<Entity>();
		player = new Player(x, y, mapFunctions);
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
		//black heart
		if(player.getX() == 176 && player.getY() == 272) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//potion
		else if(player.getX() == 448 && player.getY() == 272) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//black magic
		else if(player.getX() == 368 && player.getY() == 400) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//white magic
		else if(player.getX() == 464 && player.getY() == 400) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//inn
		else if(player.getX() == 192 && player.getY() == 96) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//shield one
		else if(player.getX() == 96 && player.getY() == 384) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		//no label
		else if(player.getX() == 208 && player.getY() == 384) {
			apps.setCurrentScreen("Shop Screen", player.getX(), player.getY()- 16);
		}
		TiledGMap.getTiledGMapRender().render();
		TiledGMap.getTiledGMapRender().setView(cam);
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
}
