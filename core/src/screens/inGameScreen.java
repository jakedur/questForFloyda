package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;
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
		System.out.println("used");
		TiledGMap = new TiledGameMap();
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		
		image = new Texture("wizard.png");
		
		entities = new ArrayList<Entity>();
		player = new Player(304, 16, this);
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
	
	public TileType getTileTypeByCoordinate (int layer, int col, int row) {
		return TiledGMap.getTileTypeByCoordinate(layer, col, row);
	}
	
	public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
		if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight())
			return true;
		
		for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
			for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
				for (int layer = 0; layer < getLayers(); layer++) {
					TileType type = getTileTypeByCoordinate(layer, col, row);
					if (type != null && type.isCollidable())
						return true;
				}
			}
		}
		return false;
	}

	public int getWidth() {
		return TiledGMap.getWidth();
	}
	public int getHeight() {
		return TiledGMap.getHeight();
	}
	public int getLayers() {
		return TiledGMap.getLayers();
	}

	public int getPixelWidth() {
		return TiledGMap.getWidth() * TileType.TILE_SIZE;
	}

	public int getPixelHeight() {
		return TiledGMap.getHeight() * TileType.TILE_SIZE;
	}
}
