package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Quest;

import controller.TitleController;

public class TitleScreen extends AbstractScreen{
	TitleController titleController;
	Image image;
	Texture img;
	Sprite backgroundSprite;
	private SpriteBatch spriteBatch;
	public TitleScreen(Quest app) {
		super(app);
		titleController = new TitleController();
		img = new Texture("Screens/Title Screen.png");
        backgroundSprite = new Sprite(img);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(titleController);
	}

	public void renderBackground() {
		backgroundSprite.draw(spriteBatch);
	}

	@Override
	public void render(float delta) {
		spriteBatch.begin();
		renderBackground(); //In first place!!!!
		spriteBatch.end();
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
