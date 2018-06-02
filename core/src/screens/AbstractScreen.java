package screens;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Quest;

public abstract class AbstractScreen implements Screen {

	private Quest app;
	
	public AbstractScreen(Quest app) {
		this.app = app;
	}
	
	@Override
	public abstract void show();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public abstract void pause();

	@Override
	public abstract void resume();

	@Override
	public abstract void hide();

	@Override
	public abstract void dispose();

	public Quest getApp() {
		return app;
	}
}
