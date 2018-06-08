package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.game.Quest;

import controller.TitleController;

public class TitleScreen extends AbstractScreen{
	private TitleController titleController;
	private Texture img;
	private Texture overlay;
	private SpriteBatch batch;
	private Quest apps;
	private static final float FADE_IN_TIME = 1f;
	private float fadeElapsed = 0;
	private float fade;
	private BitmapFont enter;
	private boolean fadeBool = false;
	
	public TitleScreen(Quest app) {
		super(app);
		apps = app;
		titleController = new TitleController();
		img = new Texture("Screens/Title Screen.png");
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/calidone.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 36;
		parameter.color = new Color(0f, 0f, 0f, 1f);
		enter = generator.generateFont(parameter);
		generator.dispose();

		batch = app.batch;
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(titleController);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		textureAnimate(delta);
		batch.end();
		if (Gdx.input.isKeyJustPressed(Keys.ENTER))
			apps.setCurrentScreen("Class Select Screen", 304, 16);
	}
	
	private void textureAnimate(float delta) {
		if (fadeBool == true) {
			fadeElapsed -= delta;
			fade = Interpolation.fade.apply(fadeElapsed / FADE_IN_TIME);
			if (fade <= 0)
				fadeBool = false;
		}
		if (fade < 1 && fadeBool == false) {
			fadeElapsed += delta;
			fade = Interpolation.fade.apply(fadeElapsed / FADE_IN_TIME);
			if (fade >= 1)
				fadeBool = true;
		}
		enter.setColor(1, 1, 1, fade);
		enter.draw(batch, "Press Enter To Start Your Quest", -15, 100, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
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
