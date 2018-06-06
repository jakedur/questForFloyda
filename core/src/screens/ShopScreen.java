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

import controller.OptionBoxController;
import controller.PlayerController;
import entities.Entity;
import entities.Player;
import entities.ShopKeeperNPC;
import ui.DialogueBox;
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
	private int uiScale = 2;
	
	private OptionBox optionBox;
	private OptionBoxController optionController;

	private DialogueBox dialogueBox;

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
		player = new Player(112, 30, mapFunctions );
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
		
		dialogueBox = new DialogueBox(getApp().getSkin());
		dialogueBox.setVisible(false);
		
		optionBox = new OptionBox(getApp().getSkin());
		optionBox.setVisible(false);
		optionBox.addOption("Item 1");
		optionBox.addOption("Item 2");
		optionBox.addOption("Item 3");
		
		optionController = new OptionBoxController(optionBox);
		
		Table dialogTable = new Table();
		dialogTable.add(optionBox).expand().align(Align.right).space(8f).row();
		
		root.add(dialogueBox).expand().align(Align.bottom);
		root.add(dialogTable).expand().align(Align.bottom);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		talkShopkeeper(delta);
		MapTansition();
		
		TiledSMap.getTiledGMapRender().render();
		TiledSMap.getTiledGMapRender().setView(cam);
		
		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		checkInputProcessor();
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
		dialogueBox.act(delta);
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
	public void talkShopkeeper(float delta) {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			if(player.getX() == 112 && player.getY() == 96) {	
				dialogueBox.animateText("What would you like to \nbuy from me?");
				dialogueBox.setVisible(true);
				
				optionBox.setVisible(true);
				Gdx.input.setInputProcessor(optionController);
			}
		}
	}
	public void MapTansition() {
		if(player.getX() == 112 && player.getY() == 0) {
			apps.setCurrentScreen("Game Start", X , Y);
		}
	}
	public void checkInputProcessor() {
		if(optionController.CloseOptionBox() == true) {
			dialogueBox.setVisible(false);
			optionBox.setVisible(false);
			Gdx.input.setInputProcessor(controller);
			optionController.setCloseOPtionBox(false);
		}
	}

}
