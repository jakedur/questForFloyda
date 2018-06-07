package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

public class BattleScreen extends AbstractScreen{

	private Texture img;
	private SpriteBatch batch;
	private Quest apps;
	
	public BattleScreen(Quest app) {
		super(app);
		apps = app;
		img = new Texture("Screens/Battle Screen.png");
		batch = app.batch;
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		batch.end();
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
		
	}

	@Override
	public void dispose() {
		
	}

}
