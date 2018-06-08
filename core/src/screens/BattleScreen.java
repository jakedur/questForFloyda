package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Quest;

import classes.Classes;
import enemy.Enemy;

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

	private enemy.Bat bat;
	private enemy.Goblin goblin;

	private boolean BAT;
	private boolean GOBLIN;

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

		bat = new enemy.Bat();
		goblin = new enemy.Goblin();
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

	public void MapTransition() {
		mus.stop();
		mus.dispose();
		apps.setCurrentScreen("Outside Map", returnX , returnY);
	}

	public String getInitiative() {
		double random = Math.random();
		if(random < .5){
			return "Enemy";
		}
		else {
			return "Player";
		}
	}

	public enemy.Bat attackBat(Classes attacker, enemy.Bat defender){
		int attack = attacker.getAttack();
		int defense = defender.getDefense();
		int damage = attack - defense;
		boolean killed = defender.death(damage);
		String name = defender.getName();
		if(killed == false){
			defender.loseHP(damage);
			int hp = defender.getHP();
		}else if(killed == true){
			defender.setAlive(false);
		}
		return defender;
	}
	
	public enemy.Goblin attackGoblin(Classes attacker, enemy.Goblin defender){
		int attack = attacker.getAttack();
		int defense = defender.getDefense();
		int damage = attack - defense;
		boolean killed = defender.death(damage);
		String name = defender.getName();
		if(killed == false){
			defender.loseHP(damage);
			int hp = defender.getHP();
		}else if(killed == true){
			defender.setAlive(false);
		}
		return defender;
	}

	public classes.Wizard attackWizard(Enemy attacker, classes.Wizard defender){
		int attack = attacker.getAttack();
		int defense = defender.getDefense();
		int damage = attack - defense;
		boolean killed = defender.death(damage);
		String name = defender.getPlayerName();
		if(killed == false){
			defender.loseHP(damage);
			int hp = defender.getHP();
		}else if(killed == true){
			defender.setAlive(false);
		}
		return defender;
	}

	public classes.Knight attackKnight(Enemy attacker, classes.Knight defender){
		int attack = attacker.getAttack();
		int defense = defender.getDefense();
		int damage = attack - defense;
		boolean killed = defender.death(damage);
		String name = defender.getPlayerName();
		if(killed == false){
			defender.loseHP(damage);
			int hp = defender.getHP();
		}else if(killed == true){
			defender.setAlive(false);
		}
		return defender;
	}
	public void Fight() {
		String Initiative = getInitiative();
		if(Initiative.equals("Enemy")){
			if(apps.ClassSelect == 0) {
				if(BAT == true) {
					apps.wizardPlayer = attackWizard(bat,apps.wizardPlayer);
					bat = attackBat(apps.wizardPlayer, bat);
				}
				if(GOBLIN == true) {
					apps.wizardPlayer = attackWizard(goblin,apps.wizardPlayer);
					goblin = attackGoblin(apps.wizardPlayer, goblin);
				}
			}
			if(apps.ClassSelect == 1) {
				if(BAT == true) {
					apps.knightPlayer = attackKnight(bat,apps.knightPlayer);
					bat = attackBat(apps.knightPlayer, bat);
				}
				if(GOBLIN == true) {
					apps.knightPlayer = attackKnight(goblin,apps.knightPlayer);
					goblin = attackGoblin(apps.knightPlayer, goblin);
				}
			}
		}
		if(Initiative.equals("Player")){
			if(apps.ClassSelect == 0) {
				if(BAT == true) {
					bat = attackBat(apps.wizardPlayer, bat);
					apps.wizardPlayer = attackWizard(bat,apps.wizardPlayer);
				}
				if(GOBLIN == true) {
					goblin = attackGoblin(apps.wizardPlayer, goblin);
					apps.wizardPlayer = attackWizard(goblin,apps.wizardPlayer);
				}
			}
			if(apps.ClassSelect == 1) {
				if(BAT == true) {
					bat = attackBat(apps.knightPlayer, bat);
					apps.knightPlayer = attackKnight(bat,apps.knightPlayer);
				}
				if(GOBLIN == true) {
					goblin = attackGoblin(apps.knightPlayer, goblin);
					apps.knightPlayer = attackKnight(goblin,apps.knightPlayer);
				}
			}
		}
	}
	public void drawEnemy() {
		if(RNG < 0.5) {
			batch.draw(Bat, 100, 150, 75, 75);
			BAT = true;
		}
		else if(RNG <= 1.0) {
			batch.draw(Goblin, 100, 150, 75, 75);
			GOBLIN = true;
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
