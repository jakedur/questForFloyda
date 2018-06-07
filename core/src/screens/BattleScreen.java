package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

public class BattleScreen extends AbstractScreen{

	private Texture img;
	private SpriteBatch batch;
	private Quest apps;

	private Texture Knight;
	private Texture Wizard;

	private double RNG;
	
	private Texture Bat;
	private Texture Goblin;

	public BattleScreen(Quest app) {
		super(app);
		apps = app;
		img = new Texture("Screens/Battle Screen.png");
		batch = app.batch;

		Knight = new Texture("Knight.png");
		Wizard = new Texture("Wizard.png");

		RNG = Math.random();
		
		Bat = new Texture("Bat.png");
		Goblin = new Texture("Goblin.png");
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		
		drawPlayer();
		drawEnemy();
		
		batch.end();
	}

	public void drawEnemy() {
		if(RNG < 0.5) {
			batch.draw(Bat, 100, 150, 75, 75);
		}
		else if(RNG <= 1.0) {
			batch.draw(Goblin, 100, 150, 75, 75);
		}
	}
	
	public void drawPlayer() {
		if(apps.ClassSelect == 0) {
			batch.draw(Wizard, 350, 150, 75, 75);
		}
		if(apps.ClassSelect == 1) {
			batch.draw(Knight, 350, 150, 75, 75);
		}
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
