package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

import controller.TitleController;

public class TitleScreen extends AbstractScreen{
	private TitleController titleController;
	private Texture img;
	private SpriteBatch batch;
	Quest Quest = new Quest();
	public TitleScreen(Quest app) {
		super(app);
		titleController = new TitleController();
		img = new Texture("Screens/Title Screen.png");
		batch = new SpriteBatch();
        //backgroundSprite = new Sprite(img);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(titleController);
	}

	//public void renderBackground() {
		//backgroundSprite.draw(spriteBatch);
	//}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(img, 0, 0); 
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
