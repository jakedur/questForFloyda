package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.AbstractScreen;
import screens.TitleScreen;
import screens.inGameScreen;

public class Quest extends Game {
	SpriteBatch batch;
	Texture img;

	
<<<<<<< HEAD
	public inGameScreen gameStart;
	public TitleScreen titleScreen;
	public AbstractScreen currentScreen;
=======
	private inGameScreen gameStart;
>>>>>>> 8f8552c0cc27bca6265732d54c891ca694ca2479

	public String randomImg() {
		return "memes/" + ((int) (Math.random() * 10) + 1) + ".jpg";
	}

	@Override
	public void create() {
		gameStart = new inGameScreen(this);
<<<<<<< HEAD
		titleScreen = new TitleScreen(this);
		
		img = new Texture(randomImg());

		this.setScreen(currentScreen);
=======
		
		img = new Texture(randomImg());

		this.setScreen(gameStart);
>>>>>>> 8f8552c0cc27bca6265732d54c891ca694ca2479
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
	public void setScreen(AbstractScreen screen) {
		currentScreen = screen;
	}
	
	public AbstractScreen getScreen(String whatScreen) {
		if (whatScreen.equals("Title Screen")) 
			return titleScreen;
		if(whatScreen.equals("Game Start"))
			return gameScreen;
		return currentScreen;
	}
}
