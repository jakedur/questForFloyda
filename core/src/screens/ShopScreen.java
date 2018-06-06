package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Quest;
import com.mygdx.game.world.CommonMapFunctions;
import com.mygdx.game.world.TileType;
import com.mygdx.game.world.TiledGameMap;
import com.mygdx.game.world.TiledShopMap;

import controller.PlayerController;
import entities.Entity;
import entities.Player;
import entities.ShopKeeperNPC;
import ui.OptionBox;

public class ShopScreen extends AbstractScreen{
	private ArrayList<Entity>entities;
	private PlayerController controller;
	private Player player;
	private ShopKeeperNPC NPC;
	private SpriteBatch batch;
	private TiledShopMap TiledSMap;
	private Quest apps;
	private float X;
	private float Y;
	
	private Viewport gameViewport;
	
	private Table root;
	private Stage uiStage;
	private OptionBox optionBox;
	private int uiScale = 2;

	
	OrthographicCamera cam;
	
	public ShopScreen(Quest app, float x , float y) {
		super(app);
		gameViewport = new ScreenViewport();
		apps = app;
		X = x;
		Y = y;
		TiledSMap = new TiledShopMap();
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledSMap.getMap());
		
		initUI();
		
		entities = new ArrayList<Entity>();
		NPC = new ShopKeeperNPC(112, 128 , mapFunctions);
		player = new Player(112, 16, mapFunctions );
		entities.add(player);
		entities.add(NPC);
		controller = new PlayerController(player);
	}

	private void initUI() {
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale, true);
		//uiStage.setDebugAll(true);
		
		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);
		
		optionBox = new OptionBox(getApp().getSkin());
		optionBox.setVisible(false);
		optionBox.addOption("Item 1");
		optionBox.addOption("Item 2");
		optionBox.addOption("Item 3");
		
		Table dialogTable = new Table();
		dialogTable.add(optionBox).expand().align(Align.right).space(8f).row();
		
		root.add(dialogTable).expand().align(Align.bottom);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		if(player.getX() == 112 && player.getY() == 0) {
			apps.setCurrentScreen("Game Start", X , Y);
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			if(player.getX() == 112 && player.getY() == 96) {
				//add option box to render here
				System.out.println("Option Box Please Pop up");
				optionBox.setVisible(true);
			}
		}
		TiledSMap.getTiledGMapRender().render();
		TiledSMap.getTiledGMapRender().setView(cam);
		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		TiledSMap.getTiledGMapRender().setView(cam);
		TiledSMap.getTiledGMapRender().render();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for(Entity entity : entities) {
			entity.update(delta);
			entity.render(batch);
		}
		batch.end();
		uiStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		uiStage.getViewport().update(width/uiScale, height/uiScale, true);
		gameViewport.update(width, height);
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
