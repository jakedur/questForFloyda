package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

public class BattleScreen extends AbstractScreen{

	private Texture img;
	private SpriteBatch batch;
	private Quest apps;
	private OrthographicCamera cam;

	private Texture Knight;
	private Texture Wizard;

	private double RNG;
	
	private Music mus;
	
	private float returnX, returnY;
	
	private Texture Bat;
	private Texture Goblin;

	public BattleScreen(Quest app, float x, float y) {
		super(app);
		apps = app;
		this.returnX = x;
		this.returnY = y;
		
		img = new Texture("Screens/Battle Screen.png");
		batch = app.batch;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		
		AssetManager assetload = new AssetManager();
		assetload.load("music/Chiptune Battle.wav", Music.class);
		assetload.load("music/Battlecry.wav", Music.class);
		assetload.finishLoading();
		if (Math.random() > .5) {
			mus = assetload.get("music/Chiptune Battle.wav", Music.class);
		}
		else {
			mus = assetload.get("music/Battlecry.wav", Music.class);
		}
		mus.setLooping(true);
		mus.play();
		
		Knight = new Texture("Knight.png");
		Wizard = new Texture("Wizard.png");

		RNG = Math.random();
		
		Bat = new Texture("Bat.png");
		Goblin = new Texture("Goblin.png");
		
		//WHEN YOU END THE BATTLE AND SWITCH SCREENS, RIGHT BEFORE ADD mus.dispose();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		batch.setProjectionMatrix(cam.combined);
		cam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		cam.update();
		
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
