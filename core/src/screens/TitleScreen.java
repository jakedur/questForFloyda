package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

import controller.TitleController;

public class TitleScreen extends AbstractScreen{
	private TitleController titleController;
	private Texture img;
	private SpriteBatch batch;
	private Quest apps;
	
	public TitleScreen(Quest app) {
		super(app);
		apps = app;
		titleController = new TitleController();
		img = new Texture("Screens/Title Screen.png");
		batch = app.batch;
        //backgroundSprite = new Sprite(img);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(titleController);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		batch.end();
		if (Gdx.input.isKeyJustPressed(Keys.ENTER))
			apps.setCurrentScreen("Class Select Screen", 304, 16);
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
