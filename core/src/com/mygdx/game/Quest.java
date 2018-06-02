package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.AbstractScreen;
import screens.TitleScreen;
import screens.inGameScreen;

public class Quest extends Game {
	SpriteBatch batch;
	Texture img;

	public int tracker = 0;
	
	public inGameScreen gameStart;


	public TitleScreen titleScreen;
	public Screen currentScreen;
	public String randomImg() {
		return "memes/" + ((int) (Math.random() * 10) + 1) + ".jpg";
	}

	@Override
	public void create() {
		gameStart = new inGameScreen(this);
		titleScreen = new TitleScreen(this);
		img = new Texture(randomImg());
		setCurrentScreen("Title Screen");
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//System.out.println(getTracker());
		
		super.render();
	}
	
	public void setCurrentScreen(String whatScreen) {
		
		if (whatScreen.equals("Title Screen")) {
			this.setScreen(titleScreen);
			tracker = 1;
		}
		if(whatScreen.equals("Game Start")) {
			this.setScreen(gameStart);
			tracker = 2;
		}
	}
	
	public int getTracker() {
		return tracker;
	}
	
	public inGameScreen getGameStart() {
		return gameStart;
	}
}
