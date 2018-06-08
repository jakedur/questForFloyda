package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Quest;
import com.mygdx.game.world.CommonMapFunctions;
import com.mygdx.game.world.TiledShopMap;

import controller.OptionBoxController;
import controller.PlayerController;
import entities.Entity;
import entities.Player;
import entities.ShopKeeperNPC;
import items.ArmorItem;
import items.WeaponItem;
import ui.DialogueBox;
import ui.OptionBox;

public class ShopScreen extends AbstractScreen{
	private ArrayList<Entity>entities;

	private PlayerController controller;
	private Player player;

	private ShopKeeperNPC NPC;

	private SpriteBatch batch;
	private TiledShopMap TiledSMap;

	private Quest apps;

	private float X, Y;

	private Viewport gameViewport;

	private Table root;
	private Table dialogTable;
	private Stage uiStage;
	private int uiScale = 2;

	private OptionBox WeaponoptionBox;
	private OptionBoxController WeaponoptionController;

	private OptionBox WeaponoptionBox2;
	private OptionBoxController WeaponoptionController2;

	private OptionBox WeaponoptionBox3;
	private OptionBoxController WeaponoptionController3;

	private DialogueBox WeapondialogueBox;
	private DialogueBox WeapondialogueBox2;
	private DialogueBox WeapondialogueBox3;
	private DialogueBox WeaponNotEnoughdialogueBox;

	//inn stuff
	private DialogueBox InnDialogueBox1;
	private DialogueBox InnDialogueBox2;

	private OptionBox InnOptionBox1;
	private OptionBox InnOptionBox2;

	private OptionBoxController InnOptionController1;
	private OptionBoxController InnOptionController2;


	//armor shop
	private DialogueBox ArmorDialogueBox1;
	private DialogueBox ArmorDialogueBox2;
	private DialogueBox ArmorDialogueBox3;
	private DialogueBox ArmorDialogueBox4;
	private DialogueBox ArmorDialogueBox5;
	private DialogueBox ArmorDialogueBox6;

	private OptionBox ArmorOptionBox1;
	private OptionBox ArmorOptionBox2;
	private OptionBox ArmorOptionBox3;
	private OptionBox ArmorOptionBox4;
	private OptionBox ArmorOptionBox5;
	private OptionBox ArmorOptionBox6;

	private OptionBoxController ArmorOptionController1;
	private OptionBoxController ArmorOptionController2;
	private OptionBoxController ArmorOptionController3;
	private OptionBoxController ArmorOptionController4;
	private OptionBoxController ArmorOptionController5;
	private OptionBoxController ArmorOptionController6;

	//not enough mula cost
	private DialogueBox NotEnoughdialogueBox;

	OrthographicCamera cam;

	private WeaponItem Sword;
	private WeaponItem Staff;
	
	private ArmorItem Shield;
	private ArmorItem Hat;
	private ArmorItem Boots;
	private ArmorItem Chest;
	private ArmorItem Amulet;
<<<<<<< HEAD
	
	private Music mus;
=======
	private Music music;
>>>>>>> 4edf1d47ccfb84d3da96d0ca78637b24c193a5f8

	public ShopScreen(Quest app, float x , float y) {
		super(app);
		gameViewport = new ScreenViewport();
		apps = app;
		X = x;
		Y = y;
		TiledSMap = new TiledShopMap();
		batch = app.batch;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		CommonMapFunctions mapFunctions = new CommonMapFunctions(TiledSMap.getMap());

		initUI();

		entities = new ArrayList<Entity>();
		NPC = new ShopKeeperNPC(112, 128 , mapFunctions, apps.ClassSelect);
		player = new Player(112, 16, mapFunctions, apps.ClassSelect);
		entities.add(player);
		entities.add(NPC);
		controller = new PlayerController(player);
		
		AssetManager assetload = new AssetManager();
		assetload.load("music/Simplistic Wonderland.wav", Music.class);
		assetload.finishLoading();
<<<<<<< HEAD
		mus = assetload.get("music/Simplistic Wonderland.wav", Music.class);
		mus.play();
=======
		music = assetload.get("music/Simplistic Wonderland.wav", Music.class);
		music.play();
>>>>>>> 4edf1d47ccfb84d3da96d0ca78637b24c193a5f8
		
		Sword = new WeaponItem("Sword", 200, 3);
		Staff = new WeaponItem("Staff", 200, 2);
		
		Shield = new ArmorItem("Shiled", 400, 4);
		Hat = new ArmorItem("Hat", 200, 2);
		Chest = new ArmorItem("Chest", 300, 3);
		Boots = new ArmorItem("Boots", 200, 3);
		Amulet = new ArmorItem("Amulet", 200, 2);
	}

	private void initUI() {
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale, true);
		//uiStage.setDebugAll(true);

		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);

		dialogTable = new Table();

		//weapon shop stuff
		WeapondialogueBox = new DialogueBox(getApp().getSkin());
		WeapondialogueBox.setVisible(false);

		WeapondialogueBox2 = new DialogueBox(getApp().getSkin());
		WeapondialogueBox2.setVisible(false);

		WeapondialogueBox3 = new DialogueBox(getApp().getSkin());
		WeapondialogueBox3.setVisible(false);

		WeaponoptionBox = new OptionBox(getApp().getSkin());
		WeaponoptionBox.setVisible(false);

		WeaponoptionController = new OptionBoxController(WeaponoptionBox);

		WeaponoptionBox2 = new OptionBox(getApp().getSkin());
		WeaponoptionBox2.setVisible(false);

		WeaponoptionController2 = new OptionBoxController(WeaponoptionBox2);

		WeaponoptionBox3 = new OptionBox(getApp().getSkin());
		WeaponoptionBox3.setVisible(false);

		WeaponoptionController3 = new OptionBoxController(WeaponoptionBox3);

		WeaponNotEnoughdialogueBox = new DialogueBox(getApp().getSkin());
		WeaponNotEnoughdialogueBox.setVisible(false);

		WeapondialogueBox.animateText("What would you like to \nbuy from me?");
		WeaponoptionBox.addOption("Sword");
		WeaponoptionBox.addOption("Staff");
		WeaponoptionBox.addOption("Back");

		WeapondialogueBox2.animateText("Buy sword for 200?\n");
		WeaponoptionBox2.addOption("Yes");
		WeaponoptionBox2.addOption("No");
		
		WeapondialogueBox3.animateText("Buy staff for 200?\n");
		WeaponoptionBox3.addOption("Yes");
		WeaponoptionBox3.addOption("No");

		if(X == 176 && Y == 256) {	
			//add the weapon box option 1 to the table
			dialogTable.add(WeaponoptionBox).expand().align(Align.right).space(8f).row();

			//add to the root table
			root.add(WeapondialogueBox).expand().align(Align.bottom);
			root.add(dialogTable).expand().align(Align.bottom);
		}
		
		//Inn stuff

		InnDialogueBox1 = new DialogueBox(getApp().getSkin());
		InnDialogueBox1.animateText("Would you like to rest here?");
		InnDialogueBox1.setVisible(false);

		InnOptionBox1 = new OptionBox(getApp().getSkin());
		InnOptionBox1.addOption("Yes");
		InnOptionBox1.addOption("No");
		InnOptionBox1.setVisible(false);

		InnOptionController1 = new OptionBoxController(InnOptionBox1);

		InnDialogueBox2 = new DialogueBox(getApp().getSkin());
		InnDialogueBox2.animateText("Sleep here for 100?");
		InnDialogueBox2.setVisible(false);

		InnOptionBox2 = new OptionBox(getApp().getSkin());
		InnOptionBox2.addOption("Yes");
		InnOptionBox2.addOption("No");
		InnOptionBox2.setVisible(false);

		InnOptionController2 = new OptionBoxController(InnOptionBox2);

		if(X == 192 && Y+16 == 96) {
			dialogTable.add(InnOptionBox1).expand().align(Align.right).space(8f).row();

			root.add(InnDialogueBox1).expand().align(Align.bottom);
			root.add(dialogTable).expand().align(Align.bottom);
		}

		//armor shop stuff
		ArmorDialogueBox1 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox1.animateText("What would you like to \nbuy from me?");
		ArmorDialogueBox1.setVisible(false);

		ArmorOptionBox1 = new OptionBox(getApp().getSkin());
		ArmorOptionBox1.setVisible(false);
		ArmorOptionBox1.addOption("Shield");
		ArmorOptionBox1.addOption("Hat");
		ArmorOptionBox1.addOption("Chest");
		ArmorOptionBox1.addOption("Boots");
		ArmorOptionBox1.addOption("Amulet");
		ArmorOptionBox1.addOption("Back");

		ArmorOptionController1 = new OptionBoxController(ArmorOptionBox1);

		ArmorDialogueBox2 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox2.animateText("Would you like to buy a \nshield for 400?");
		ArmorDialogueBox2.setVisible(false);

		ArmorOptionBox2 = new OptionBox(getApp().getSkin());
		ArmorOptionBox2.addOption("Yes");
		ArmorOptionBox2.addOption("No");
		ArmorOptionBox2.setVisible(false);

		ArmorOptionController2 = new OptionBoxController(ArmorOptionBox2);

		ArmorDialogueBox3 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox3.animateText("Would you like to buy a \nhat for 200?");
		ArmorDialogueBox3.setVisible(false);

		ArmorOptionBox3 = new OptionBox(getApp().getSkin());
		ArmorOptionBox3.addOption("Yes");
		ArmorOptionBox3.addOption("No");
		ArmorOptionBox3.setVisible(false);

		ArmorOptionController3 = new OptionBoxController(ArmorOptionBox3);

		ArmorDialogueBox4 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox4.animateText("Would you like to buy a \nchest for 300?");
		ArmorDialogueBox4.setVisible(false);

		ArmorOptionBox4 = new OptionBox(getApp().getSkin());
		ArmorOptionBox4.addOption("Yes");
		ArmorOptionBox4.addOption("No");
		ArmorOptionBox4.setVisible(false);

		ArmorOptionController4 = new OptionBoxController(ArmorOptionBox4);

		ArmorDialogueBox5 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox5.animateText("Would you like to buy a \nboots for 200?");
		ArmorDialogueBox5.setVisible(false);

		ArmorOptionBox5 = new OptionBox(getApp().getSkin());
		ArmorOptionBox5.addOption("Yes");
		ArmorOptionBox5.addOption("No");
		ArmorOptionBox5.setVisible(false);

		ArmorOptionController5 = new OptionBoxController(ArmorOptionBox5);

		ArmorDialogueBox6 = new DialogueBox(getApp().getSkin());
		ArmorDialogueBox6.animateText("Would you like to buy a \namulet for 200?");
		ArmorDialogueBox6.setVisible(false);

		ArmorOptionBox6 = new OptionBox(getApp().getSkin());
		ArmorOptionBox6.addOption("Yes");
		ArmorOptionBox6.addOption("No");
		ArmorOptionBox6.setVisible(false);

		ArmorOptionController6 = new OptionBoxController(ArmorOptionBox6);

		if(X == 96 && Y+16 == 384) {
			dialogTable.add(ArmorOptionBox1).expand().align(Align.right).space(8f).row();

			root.add(ArmorDialogueBox1).expand().align(Align.bottom);
			root.add(dialogTable).expand().align(Align.bottom);
		}

		//not enough mula 
		NotEnoughdialogueBox = new DialogueBox(getApp().getSkin());
		NotEnoughdialogueBox.setVisible(false);
		NotEnoughdialogueBox.animateText("You do not have\n enough mula");
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		controller.update(delta);

		talkShopkeeper(delta);
		MapTansition();

		TiledSMap.getTiledGMapRender().render();
		TiledSMap.getTiledGMapRender().setView(cam);

		cam.position.set(player.getX(), player.getY(), 0);
		cam.update();
		TiledSMap.getTiledGMapRender().setView(cam);
		TiledSMap.getTiledGMapRender().render();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		for(Entity entity : entities) {
			entity.update(delta);
			entity.render(batch);
		}

		batch.end();

		uiStage.draw();
		WeapondialogueBox.act(delta);
		WeapondialogueBox2.act(delta);
		WeapondialogueBox3.act(delta);
		//Inn
		InnDialogueBox1.act(delta);
		InnDialogueBox2.act(delta);
		//Armor shop
		ArmorDialogueBox1.act(delta);
		ArmorDialogueBox2.act(delta);
		ArmorDialogueBox3.act(delta);
		ArmorDialogueBox4.act(delta);
		ArmorDialogueBox5.act(delta);
		ArmorDialogueBox6.act(delta);
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
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {

	}
	public void talkShopkeeper(float delta) {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			if(player.getX() == 112 && player.getY() == 96) {	
				//for every different shop
				//Weapon Shop
				if(X == 176 && Y == 256) {
					//first box set
					WeaponOptions();
				}
				//Potion Shop
				else if(X == 448 && Y == 256) {
					//					PotionShopOptions();
				}
				//Inn
				else if(X == 192 && Y+16 == 96) {
					InnOptions1();
				}
				//Armor Shop
				else if(X == 96 && Y+16 == 384) {
					ArmorOptions1();
				}

			}
		}
	}

	public void InnOptions1() {
		Gdx.input.setInputProcessor(InnOptionController1);

		InnDialogueBox1.setVisible(true);
		InnOptionBox1.setVisible(true);

		if(InnOptionController1.getEnterStatus() == true) {
			if(InnOptionBox1.getSelected() == 0) {
				InnDialogueBox1.setVisible(false);
				InnOptionBox1.setVisible(false);

				dialogTable.removeActor(InnOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(InnDialogueBox1);

				dialogTable.add(InnOptionBox2).expand().align(Align.right).space(8f).row();

				root.add(InnDialogueBox2).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);


				Gdx.input.setInputProcessor(InnOptionController2);

				InnOptions2();
			}
			else if(InnOptionBox1.getSelected() == 1) {
				InnDialogueBox1.setVisible(false);
				InnOptionBox1.setVisible(false);

				dialogTable.removeActor(InnOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(InnDialogueBox1);

				InnOptionController1.enter = false;

				Gdx.input.setInputProcessor(controller);
			}
		}

	}
	public void InnOptions2() {
		InnDialogueBox2.setVisible(true);
		InnOptionBox2.setVisible(true);

		if(InnOptionController2.getEnterStatus() == true) {
			if(InnOptionBox2.getSelected() == 0) {
				InnDialogueBox2.setVisible(false);
				InnOptionBox2.setVisible(false);

				dialogTable.removeActor(InnOptionBox2);

				root.removeActor(dialogTable);
				root.removeActor(InnDialogueBox2);

				InnOptionController1.enter = false;
				InnOptionController2.enter = false;

				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(100)) {
						apps.wizardPlayer.subtractMoeny(100);
						apps.wizardPlayer.FullHP();
						apps.wizardPlayer.FullMP();

						InnDialogueBox2.setVisible(false);
						InnOptionBox2.setVisible(false);

						dialogTable.removeActor(InnOptionBox2);

						root.removeActor(dialogTable);
						root.removeActor(InnDialogueBox2);

						InnOptionController1.enter = false;
						InnOptionController2.enter = false;

						Gdx.input.setInputProcessor(controller);
					}else {
						InnDialogueBox2.setVisible(false);
						InnOptionBox2.setVisible(false);

						dialogTable.removeActor(InnOptionBox2);

						root.removeActor(dialogTable);
						root.removeActor(InnDialogueBox2);

						InnOptionController1.enter = false;
						InnOptionController2.enter = false;

						Gdx.input.setInputProcessor(controller);
					}
				}
				if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(100)) {
						apps.knightPlayer.subtractMoeny(100);
						apps.knightPlayer.FullHP();
						apps.knightPlayer.FullMP();

						InnDialogueBox2.setVisible(false);
						InnOptionBox2.setVisible(false);

						dialogTable.removeActor(InnOptionBox2);

						root.removeActor(dialogTable);
						root.removeActor(InnDialogueBox2);

						InnOptionController1.enter = false;
						InnOptionController2.enter = false;

						Gdx.input.setInputProcessor(controller);
					}else {
						InnDialogueBox2.setVisible(false);
						InnOptionBox2.setVisible(false);

						dialogTable.removeActor(InnOptionBox2);

						root.removeActor(dialogTable);
						root.removeActor(InnDialogueBox2);

						InnOptionController1.enter = false;
						InnOptionController2.enter = false;

						Gdx.input.setInputProcessor(controller);
					}
				}


				Gdx.input.setInputProcessor(controller);
			}
			if(InnOptionBox2.getSelected() == 1) {
				InnDialogueBox2.setVisible(false);
				InnOptionBox2.setVisible(false);

				dialogTable.removeActor(InnOptionBox2);

				root.removeActor(dialogTable);
				root.removeActor(InnDialogueBox2);

				InnOptionController1.enter = false;
				InnOptionController2.enter = false;

				Gdx.input.setInputProcessor(controller);
			}
		}
	}

	public void WeaponOptions() {
		//set input to the first weapon controller
		Gdx.input.setInputProcessor(WeaponoptionController);

		//set the boxes to visible
		WeapondialogueBox.setVisible(true);
		WeaponoptionBox.setVisible(true);

		//if you press enter
		if(WeaponoptionController.getEnterStatus() == true) {

			//picked sword
			if(WeaponoptionBox.getSelected() == 0) {

				//remove the table and dialogue box from the root table
				//remove the weapon option box form the table
				root.removeActor(WeapondialogueBox);
				dialogTable.removeActor(WeaponoptionBox);
				root.removeActor(dialogTable);



				//set first set of boxes to not visible
				WeapondialogueBox.setVisible(false);
				WeaponoptionBox.setVisible(false);

				//add the second option box to table
				dialogTable.add(WeaponoptionBox2).expand().align(Align.right).space(8f).row();

				//add in the table and the second dialogue to the root table
				root.add(WeapondialogueBox2).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);

				//set the new boxes to visible
				WeapondialogueBox2.setVisible(true);
				WeaponoptionBox2.setVisible(true);

				//set the input to the second weapon controller
				Gdx.input.setInputProcessor(WeaponoptionController2);
				//sword box set
				WeaponOptionsSword();
			}
			//if the chose the staff
			else if(WeaponoptionBox.getSelected() == 1) {
				//remove the table and dialogue box from the root table
				//remove the weapon option box form the table
				root.removeActor(WeapondialogueBox);
				dialogTable.removeActor(WeaponoptionBox);
				root.removeActor(dialogTable);

				//set first set of boxes to not visible
				WeapondialogueBox.setVisible(false);
				WeaponoptionBox.setVisible(false);

				//add the third option box to table
				dialogTable.add(WeaponoptionBox3).expand().align(Align.right).space(8f).row();

				//add in the table and the third dialogue to the root table
				root.add(WeapondialogueBox3).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);

				//set the new boxes to visible
				WeapondialogueBox3.setVisible(true);
				WeaponoptionBox3.setVisible(true);

				//set the input to the third weapon controller
				Gdx.input.setInputProcessor(WeaponoptionController3);
				WeaponOptionsStaff();
			}
			//if you selected back
			else if(WeaponoptionBox.getSelected() == 2) {
				//remove the table and dialogue box from the root table
				root.removeActor(dialogTable);
				root.removeActor(WeapondialogueBox);

				//remove the weapon option box form the table
				dialogTable.removeActor(WeaponoptionBox);
				WeaponoptionController.enter = false;
				//set controller to the player
				Gdx.input.setInputProcessor(controller);
			}
		}
	}
	//sword selection
	public void WeaponOptionsSword() {

		//if enter in pressed on the second boxes
		if(WeaponoptionController2.getEnterStatus() == true) {

			//picked yes
			if(WeaponoptionBox2.getSelected() == 0) {

				//if you are a wizard
				if(apps.ClassSelect == 0) {

					//check if wizard has enough
					if(apps.wizardPlayer.checkEnough(200)) {

						//subtract the cost of the money
						apps.wizardPlayer.subtractMoeny(200);

						//add the sword to the inventory
						apps.wizardPlayer.addItem(Sword);
						System.out.println("Wizard Bought the Sword");
						System.out.println(apps.wizardPlayer.getPlayerMoney());

						//set the second set of boxes to not visible
						WeapondialogueBox2.setVisible(false);
						WeaponoptionBox2.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox2);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox2);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;

						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
					// if not enough money
					else {
						notEnoughMula();
						//set the second set of boxes to not visible
						WeapondialogueBox2.setVisible(false);
						WeaponoptionBox2.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox2);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox2);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;

						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
				}
				//if you are a knight
				else if(apps.ClassSelect == 1) {

					//check if enough money
					if(apps.knightPlayer.checkEnough(200)) {

						//if enough take cost from the player
						apps.knightPlayer.subtractMoeny(200);

						//add the sword to the knight inventory
						apps.knightPlayer.addItem(Sword);
						System.out.println("Knight Bought the Sword");
						System.out.println(apps.knightPlayer.getPlayerMoney());

						//set the second set of boxes to not visible
						WeapondialogueBox2.setVisible(false);
						WeaponoptionBox2.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox2);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox2);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;

						//set controller to the player
						Gdx.input.setInputProcessor(controller);
					}
					//if not enough mula
					else {
						notEnoughMula();
						//set the second set of boxes to not visible
						WeapondialogueBox2.setVisible(false);
						WeaponoptionBox2.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox2);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox2);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;

						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
				}
			}
			//picked no
			else if(WeaponoptionBox2.getSelected() == 1) {
				root.removeActor(dialogTable);
				root.removeActor(WeapondialogueBox2);

				//remove the weapon option box form the table
				dialogTable.removeActor(WeaponoptionBox2);
				WeaponoptionController.enter = false;
				WeaponoptionController2.enter = false;
				WeaponoptionController3.enter = false;
				//set controller to the player
				Gdx.input.setInputProcessor(controller);
			}
		}

	}

	public void WeaponOptionsStaff() {
		//if enter in pressed on the second boxes
		if(WeaponoptionController3.getEnterStatus() == true) {

			//picked yes
			if(WeaponoptionBox3.getSelected() == 0) {

				//if you are a wizard
				if(apps.ClassSelect == 0) {

					//check if wizard has enough
					if(apps.wizardPlayer.checkEnough(200)) {

						//subtract the cost of the money
						apps.wizardPlayer.subtractMoeny(200);

						//add the sword to the inventory
						apps.wizardPlayer.addItem(Staff);
						System.out.println("Wizard Bought the Staff");
						System.out.println(apps.wizardPlayer.getPlayerMoney());

						//set the second set of boxes to not visible
						WeapondialogueBox3.setVisible(false);
						WeaponoptionBox3.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox3);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox3);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;
						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
					// if not enough mula
					else {
						notEnoughMula();
						//set the second set of boxes to not visible
						WeapondialogueBox3.setVisible(false);
						WeaponoptionBox3.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox3);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox3);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;
						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
				}
				//if you are a knight
				else if(apps.ClassSelect == 1) {

					//check if enough money
					if(apps.knightPlayer.checkEnough(200)) {

						//if enough take cost from the player
						apps.knightPlayer.subtractMoeny(200);

						//add the sword to the knight inventory
						apps.knightPlayer.addItem(Staff);
						System.out.println("Knight Bought the Staff");
						System.out.println(apps.knightPlayer.getPlayerMoney());

						//set the second set of boxes to not visible
						WeapondialogueBox3.setVisible(false);
						WeaponoptionBox3.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox3);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox3);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;

						//set controller to the player
						Gdx.input.setInputProcessor(controller);
					}
					// if not enough mula
					else {
						notEnoughMula();
						//set the second set of boxes to not visible
						WeapondialogueBox3.setVisible(false);
						WeaponoptionBox3.setVisible(false);

						//remove the second option box from table
						dialogTable.removeActor(WeaponoptionBox3);

						//remove the second box and table from the  root table
						root.removeActor(dialogTable);
						root.removeActor(WeapondialogueBox3);

						//set all the other controller's enter to false;
						WeaponoptionController.enter = false;
						WeaponoptionController2.enter = false;
						WeaponoptionController3.enter = false;
						//set to player controller
						Gdx.input.setInputProcessor(controller);
					}
				}
			}else if(WeaponoptionBox3.getSelected() == 1) {
				root.removeActor(dialogTable);
				root.removeActor(WeapondialogueBox3);

				//remove the weapon option box form the table
				dialogTable.removeActor(WeaponoptionBox3);
				WeaponoptionController.enter = false;
				WeaponoptionController2.enter = false;
				WeaponoptionController3.enter = false;
				//set controller to the player
				Gdx.input.setInputProcessor(controller);
			}
		}
	}


	public void notEnoughMula() {

	}

	public void ArmorOptions1() {
		Gdx.input.setInputProcessor(ArmorOptionController1);

		ArmorDialogueBox1.setVisible(true);
		ArmorOptionBox1.setVisible(true);

		if(ArmorOptionController1.getEnterStatus() == true) {
			if(ArmorOptionBox1.getSelected() == 0) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				dialogTable.add(ArmorOptionBox2).expand().align(Align.right).space(8f).row();

				root.add(ArmorDialogueBox2).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);


				Gdx.input.setInputProcessor(ArmorOptionController2);
				ArmorOption2();  
			}else if(ArmorOptionBox1.getSelected() == 1) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				dialogTable.add(ArmorOptionBox3).expand().align(Align.right).space(8f).row();

				root.add(ArmorDialogueBox3).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);


				Gdx.input.setInputProcessor(ArmorOptionController3);
				ArmorOption3();
			}else if(ArmorOptionBox1.getSelected() == 2) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				dialogTable.add(ArmorOptionBox4).expand().align(Align.right).space(8f).row();

				root.add(ArmorDialogueBox4).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);

				Gdx.input.setInputProcessor(ArmorOptionController4);
				ArmorOption4();
			}else if(ArmorOptionBox1.getSelected() == 3) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				dialogTable.add(ArmorOptionBox5).expand().align(Align.right).space(8f).row();

				root.add(ArmorDialogueBox5).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);


				Gdx.input.setInputProcessor(ArmorOptionController5);
				ArmorOption5();
			}else if(ArmorOptionBox1.getSelected() == 4) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				dialogTable.add(ArmorOptionBox6).expand().align(Align.right).space(8f).row();

				root.add(ArmorDialogueBox6).expand().align(Align.bottom);
				root.add(dialogTable).expand().align(Align.bottom);


				Gdx.input.setInputProcessor(ArmorOptionController6);
				ArmorOption6();
			}else if(ArmorOptionBox1.getSelected() == 5) {
				ArmorDialogueBox1.setVisible(false);
				ArmorOptionBox1.setVisible(false);

				dialogTable.removeActor(ArmorOptionBox1);

				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox1);

				ArmorOptionController1.enter = false;

				Gdx.input.setInputProcessor(controller);
			}
		}
	}

	public void ArmorOption2() {
		ArmorDialogueBox2.setVisible(true);
		ArmorOptionBox2.setVisible(true);
		if(ArmorOptionController2.getEnterStatus() == true) {
			if(ArmorOptionBox2.getSelected() == 0) {
				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(400)) {
						apps.wizardPlayer.subtractMoeny(400);
						apps.wizardPlayer.addItem(Shield);

						ArmorDialogueBox2.setVisible(false);
						ArmorOptionBox2.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox2);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox2);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox2.setVisible(false);
						ArmorOptionBox2.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox2);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox2);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
				else if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(400)) {
						apps.knightPlayer.subtractMoeny(400);
						apps.knightPlayer.addItem(Shield);

						ArmorDialogueBox2.setVisible(false);
						ArmorOptionBox2.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox2);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox2);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox2.setVisible(false);
						ArmorOptionBox2.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox2);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox2);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
			}else if (ArmorOptionBox2.getSelected() == 1) {
				ArmorDialogueBox2.setVisible(false);
				ArmorOptionBox2.setVisible(false);
				dialogTable.removeActor(ArmorOptionBox2);
				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox2);

				ArmorOptionController1.enter = false;
				ArmorOptionController2.enter = false;
				ArmorOptionController3.enter = false;
				ArmorOptionController4.enter = false;
				ArmorOptionController5.enter = false;
				ArmorOptionController6.enter = false;
				Gdx.input.setInputProcessor(controller);
			}
		}
	}
	public void ArmorOption3() {
		ArmorDialogueBox3.setVisible(true);
		ArmorOptionBox3.setVisible(true);
		if(ArmorOptionController3.getEnterStatus() == true) {
			if(ArmorOptionBox3.getSelected() == 0) {
				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(200)) {
						apps.wizardPlayer.subtractMoeny(200);
						apps.wizardPlayer.addItem(Hat);

						ArmorDialogueBox3.setVisible(false);
						ArmorOptionBox3.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox3);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox3);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox3.setVisible(false);
						ArmorOptionBox3.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox3);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox3);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
				else if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(200)) {
						apps.knightPlayer.subtractMoeny(200);
						apps.knightPlayer.addItem(Hat);

						ArmorDialogueBox3.setVisible(false);
						ArmorOptionBox3.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox3);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox3);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox3.setVisible(false);
						ArmorOptionBox3.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox3);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox3);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
			}else if (ArmorOptionBox3.getSelected() == 1) {
				ArmorDialogueBox3.setVisible(false);
				ArmorOptionBox3.setVisible(false);
				dialogTable.removeActor(ArmorOptionBox3);
				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox3);

				ArmorOptionController1.enter = false;
				ArmorOptionController2.enter = false;
				ArmorOptionController3.enter = false;
				ArmorOptionController4.enter = false;
				ArmorOptionController5.enter = false;
				ArmorOptionController6.enter = false;
				Gdx.input.setInputProcessor(controller);
			}
		}
	}
	
	public void ArmorOption4() {
		ArmorDialogueBox4.setVisible(true);
		ArmorOptionBox4.setVisible(true);
		if(ArmorOptionController4.getEnterStatus() == true) {
			if(ArmorOptionBox4.getSelected() == 0) {
				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(300)) {
						apps.wizardPlayer.subtractMoeny(300);
						apps.wizardPlayer.addItem(Chest);

						ArmorDialogueBox4.setVisible(false);
						ArmorOptionBox4.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox4);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox4);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox4.setVisible(false);
						ArmorOptionBox4.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox4);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox4);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
				else if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(300)) {
						apps.knightPlayer.subtractMoeny(300);
						apps.knightPlayer.addItem(Chest);

						ArmorDialogueBox4.setVisible(false);
						ArmorOptionBox4.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox4);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox4);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox4.setVisible(false);
						ArmorOptionBox4.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox4);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox4);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
			}else if (ArmorOptionBox4.getSelected() == 1) {
				ArmorDialogueBox4.setVisible(false);
				ArmorOptionBox4.setVisible(false);
				dialogTable.removeActor(ArmorOptionBox4);
				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox4);

				ArmorOptionController1.enter = false;
				ArmorOptionController2.enter = false;
				ArmorOptionController3.enter = false;
				ArmorOptionController4.enter = false;
				ArmorOptionController5.enter = false;
				ArmorOptionController6.enter = false;
				Gdx.input.setInputProcessor(controller);
			}
		}
	}
	public void ArmorOption5() {
		ArmorDialogueBox5.setVisible(true);
		ArmorOptionBox5.setVisible(true);
		if(ArmorOptionController5.getEnterStatus() == true) {
			if(ArmorOptionBox5.getSelected() == 0) {
				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(200)) {
						apps.wizardPlayer.subtractMoeny(200);
						apps.wizardPlayer.addItem(Boots);

						ArmorDialogueBox5.setVisible(false);
						ArmorOptionBox5.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox5);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox5);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox5.setVisible(false);
						ArmorOptionBox5.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox5);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox5);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
				else if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(200)) {
						apps.knightPlayer.subtractMoeny(200);
						apps.knightPlayer.addItem(Boots);

						ArmorDialogueBox5.setVisible(false);
						ArmorOptionBox5.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox5);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox5);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox5.setVisible(false);
						ArmorOptionBox5.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox5);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox5);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
			}else if (ArmorOptionBox5.getSelected() == 1) {
				ArmorDialogueBox5.setVisible(false);
				ArmorOptionBox5.setVisible(false);
				dialogTable.removeActor(ArmorOptionBox5);
				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox5);

				ArmorOptionController1.enter = false;
				ArmorOptionController2.enter = false;
				ArmorOptionController3.enter = false;
				ArmorOptionController4.enter = false;
				ArmorOptionController5.enter = false;
				ArmorOptionController6.enter = false;
				Gdx.input.setInputProcessor(controller);
			}
		}
	}
	
	public void ArmorOption6() {
		ArmorDialogueBox6.setVisible(true);
		ArmorOptionBox6.setVisible(true);
		if(ArmorOptionController6.getEnterStatus() == true) {
			if(ArmorOptionBox6.getSelected() == 0) {
				if(apps.ClassSelect == 0) {
					if(apps.wizardPlayer.checkEnough(200)) {
						apps.wizardPlayer.subtractMoeny(200);
						apps.wizardPlayer.addItem(Amulet);

						ArmorDialogueBox6.setVisible(false);
						ArmorOptionBox6.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox6);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox6);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox6.setVisible(false);
						ArmorOptionBox6.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox6);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox6);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
				else if(apps.ClassSelect == 1) {
					if(apps.knightPlayer.checkEnough(200)) {
						apps.knightPlayer.subtractMoeny(200);
						apps.knightPlayer.addItem(Amulet);

						ArmorDialogueBox6.setVisible(false);
						ArmorOptionBox6.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox6);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox6);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;
						Gdx.input.setInputProcessor(controller);
					}
					else {
						ArmorDialogueBox6.setVisible(false);
						ArmorOptionBox6.setVisible(false);
						dialogTable.removeActor(ArmorOptionBox6);
						root.removeActor(dialogTable);
						root.removeActor(ArmorDialogueBox6);

						ArmorOptionController1.enter = false;
						ArmorOptionController2.enter = false;
						ArmorOptionController3.enter = false;
						ArmorOptionController4.enter = false;
						ArmorOptionController5.enter = false;
						ArmorOptionController6.enter = false;

						notEnoughMula();
					}
				}
			}else if (ArmorOptionBox6.getSelected() == 1) {
				ArmorDialogueBox6.setVisible(false);
				ArmorOptionBox6.setVisible(false);
				dialogTable.removeActor(ArmorOptionBox6);
				root.removeActor(dialogTable);
				root.removeActor(ArmorDialogueBox6);

				ArmorOptionController1.enter = false;
				ArmorOptionController2.enter = false;
				ArmorOptionController3.enter = false;
				ArmorOptionController4.enter = false;
				ArmorOptionController5.enter = false;
				ArmorOptionController6.enter = false;
				Gdx.input.setInputProcessor(controller);
			}
		}
	}

	//
	//	public void PotionShopOptions() {
	//		dialogueBox.animateText("What would you like to \nbuy from me?");
	//		optionBox.addOption("HP Potion");
	//		optionBox.addOption("MP Potion");
	//		optionBox.addOption("Back");
	//
	//	}
	//
	public void MapTansition() {
		if(player.getX() == 112 && player.getY() == 0) {
<<<<<<< HEAD
			mus.stop();
			mus.dispose();
=======
			music.stop();
			music.dispose();
>>>>>>> 4edf1d47ccfb84d3da96d0ca78637b24c193a5f8
			apps.setCurrentScreen("Game Start", X , Y);
		}
	}
	public void checkInputProcessor() {
		if(WeaponoptionController.CloseOptionBox() == true) {
			WeapondialogueBox.setVisible(false);
			WeaponoptionBox.setVisible(false);
			WeapondialogueBox2.setVisible(false);
			WeaponoptionBox2.setVisible(false);
			Gdx.input.setInputProcessor(controller);
			WeaponoptionController.setCloseOPtionBox(false);
		}
	}
}