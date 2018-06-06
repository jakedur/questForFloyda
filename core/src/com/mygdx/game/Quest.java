package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import screens.ShopScreen;
import screens.TitleScreen;
import screens.inGameScreen;
import util.SkinGenerator;

public class Quest extends Game {
	private Quest game;
	
	public SpriteBatch batch;
	Texture img;

	public int tracker = 0;
	
	private AssetManager assetManager;
	
	private Skin skin;
	
	public inGameScreen gameStart;
	public TitleScreen titleScreen;
	public Screen currentScreen;
	
	public static final AssetDescriptor<TextureAtlas> ATLAS = 
		new AssetDescriptor<TextureAtlas>("assets/ui/neon/skin/neon-ui.atlas", TextureAtlas.class);

	//A skin does require additional parameters.
	public static final AssetDescriptor<Skin> SKIN = 
		new AssetDescriptor<Skin>("assets/ui/neon/skin/neon-ui.json", Skin.class, 
		new SkinLoader.SkinParameter("assets/ui/neon/skin/neon-ui.atlas"));
	
	public Quest() {
		game = this;
	}
	
	public String randomImg() {
		return "memes/" + ((int) (Math.random() * 10) + 1) + ".jpg";
	}

	@Override
	public void create() {
		//img = new Texture(randomImg());
		batch = new SpriteBatch();
		
		assetManager = new AssetManager();
		skin = new Skin();
		
		assetManager.load("assets/ui/neon/skin/neon-ui.json", Skin.class, new SkinLoader.SkinParameter("assets/ui/neon/skin/neon-ui.atlas"));

		//skin.addRegions(this.assests.get("assets/ui/neon/skin/neon-ui.atlas", TextureAtlas.class));
		
		game.setScreen(new TitleScreen(game));
		super.render();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//System.out.println(getTracker());
		
		super.render();
	}
	
	public void setCurrentScreen(String whatScreen , float x , float y) {
		if (whatScreen.equals("Title Screen")) {
			this.setScreen(new TitleScreen(game));
			super.render();
			tracker = 1;
		}
		if(whatScreen.equals("Game Start")) {
			this.setScreen(new inGameScreen(game, x, y));
			super.render();
			tracker = 2;
		}
		if(whatScreen.equals("Shop Screen")) {
			this.setScreen(new ShopScreen(game, x , y));
			super.render();
			tracker = 3;
		}
	}
	
	public int getTracker() {
		return tracker;
	}
	
	public Screen getGameStart() {
		return gameStart;
	}
	public Skin getSkin() {
		return skin;
	}
}
