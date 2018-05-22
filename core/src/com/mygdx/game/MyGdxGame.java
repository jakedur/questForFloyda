package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TiledGameMap;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	GameMap gameMap;
	OrthographicCamera cam;
	
	public String randomImg() {
		return "/memes/" + ( (int) (Math.random() * 10) + 1) + ".jpg";
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture(randomImg());
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());;
		cam.update();
		
		gameMap = new TiledGameMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (Gdx.input.isTouched()) {
			cam.translate(Gdx.input.getDeltaX(), Gdx.input.getDeltaY()); //switch this to match character loc
		}
		
		gameMap.render(cam);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
