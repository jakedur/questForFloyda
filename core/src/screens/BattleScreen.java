package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Quest;

import classes.Classes;
import controller.OptionBoxController;
import enemy.Enemy;
import ui.DialogueBox;
import ui.OptionBox;

public class BattleScreen extends AbstractScreen{

	private Texture img;
	private SpriteBatch batch;
	private Quest apps;
	private OrthographicCamera cam;

	private Stage uiStage;
	private Viewport gameViewport;
	private int uiScale = 2;


	private Table root;
	private Table optionBox;
	private DialogueBox afterText;
	private DialogueBox display;
	private DialogueBox damageText;
	private OptionBox choice;
	private OptionBoxController controller;


	private Texture Knight;
	private Texture Wizard;

	private double RNG;


	private float returnX, returnY;

	private enemy.Bat bat;
	private enemy.Goblin goblin;

	private boolean BAT;
	private boolean GOBLIN;

	private Texture Bat;
	private Texture Goblin;

	//	.animateText("Gold: " + gold +"\nHP: " + curHp + "\\" + maxHp);

	public BattleScreen(Quest app, float x, float y) {
		super(app);
		apps = app;
		this.returnX = x;
		this.returnY = y;

		gameViewport = new ScreenViewport();

		img = new Texture("Screens/Battle Screen.png");
		batch = app.batch;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();



		Knight = new Texture("Knight.png");
		Wizard = new Texture("Wizard.png");

		RNG = Math.random();

		Bat = new Texture("Bat.png");
		Goblin = new Texture("Goblin.png");

		bat = new enemy.Bat();
		goblin = new enemy.Goblin();

		intUI();

	}

	public void intUI() {
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale, true);
		//uiStage.setDebugAll(true);

		root = new Table();
		optionBox = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);

		display = new DialogueBox(getApp().getSkin());
		display.animateText("Display Stuff");

		damageText = new DialogueBox(getApp().getSkin());
		damageText.animateText("Take/Deal Damage");

		choice = new OptionBox(getApp().getSkin());
		choice.addOption("Fight");
		choice.addOption("Flee");

		optionBox.add(choice).expand().align(Align.right).space(8f);

		controller = new OptionBoxController(choice);

		root.add(display).expand().align(Align.bottom).space(8f);
		root.add(optionBox).expand().align(Align.bottom).space(8f);
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

		if(checkDeath() == true) {
			DeathStuff();
		}else {
			choices();
		}
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			MapTransition();
		}
		display.act(delta);
	}
	
	public boolean checkDeath() {
		boolean bool = false;
		 if(apps.wizardPlayer.isAlive() == false){
			bool = true; 
		 }
		 else if(apps.knightPlayer.isAlive() == false) {
			 bool = true;
		 }
		 else if(bat.getAlive() == false) {
			 bool = true;
		 }
		 else if(goblin.getAlive() == false) {
			 bool = true;
		 }
		return bool;
	}
	
	public void DeathStuff() {
		if(apps.ClassSelect == 0) {
			if(goblin.getAlive() == false) {
				apps.wizardPlayer.addMoney(goblin.getGoldGiven());
				apps.wizardPlayer.gainExp(goblin.getExp());
			}
			if(bat.getAlive() == false) {
				apps.wizardPlayer.addMoney(bat.getGoldGiven());
				apps.wizardPlayer.gainExp(bat.getExp());
			}
		}
		if(apps.ClassSelect == 1) {
			if(goblin.getAlive() == false) {
				apps.knightPlayer.addMoney(goblin.getGoldGiven());
				apps.knightPlayer.gainExp(goblin.getExp());
			}
			if(bat.getAlive() == false) {
				apps.knightPlayer.addMoney(bat.getGoldGiven());
				apps.knightPlayer.gainExp(bat.getExp());
			}
		}
		MapTransition();
	}

	public void choices() {
		if(controller.getEnterStatus() == true) {
			if(choice.getSelected() == 0) {
				Fight();
				choice.setSelected(0);
				controller.enter = false;
			}else if(choice.getSelected() == 1) {
				double random = Math.random();
				if(random < .5){
					MapTransition();
					choice.setSelected(0);
					controller.enter = false;
				}
			}
		}
	}

	public void MapTransition() {
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
		if(killed == false){
			defender.loseHP(damage);
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
		if(killed == false){
			defender.loseHP(damage);
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
		if(killed == false){
			defender.loseHP(damage);
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
		if(killed == false){
			defender.loseHP(damage);
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
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		uiStage.getViewport().update(width/uiScale, height/uiScale, true);
		gameViewport.update(width, height);
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
