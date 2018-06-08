package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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

	//weapon stuff
	private OptionBox WeaponoptionBox;
	private OptionBoxController WeaponoptionController;

	private OptionBox WeaponoptionBox2;
	private OptionBoxController WeaponoptionController2;

	private OptionBox WeaponoptionBox3;
	private OptionBoxController WeaponoptionController3;

	private DialogueBox WeapondialogueBox;
	private DialogueBox WeapondialogueBox2;
	private DialogueBox WeapondialogueBox3;

	//inn stuff
	private DialogueBox InnDialogueBox1;
	private DialogueBox InnDialogueBox2;

	private OptionBox InnOptionBox1;
	private OptionBox InnOptionBox2;

	private OptionBoxController InnOptionController1;
	private OptionBoxController InnOptionController2;

	//not enough mula cost
	private DialogueBox NotEnoughdialogueBox;

	OrthographicCamera cam;

	private WeaponItem Sword;
	private WeaponItem Staff;

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

		Sword = new WeaponItem("Sword", 200, 3);
		Staff = new WeaponItem("Staff", 200, 2);
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
		//Weapon Shop
		WeapondialogueBox.act(delta);
		WeapondialogueBox2.act(delta);
		WeapondialogueBox3.act(delta);
		//Inn
		InnDialogueBox1.act(delta);
		InnDialogueBox2.act(delta);
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
				else if(X == 96 && Y == 384) {
					//					ArmorOptions();
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
			if(InnOptionBox1.getSelected() == 1) {
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

						notEnoughMula();
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

						notEnoughMula();
					}
				}
			}
			//picked no
			else if(WeaponoptionBox2.getSelected() == 1) {
				WeaponoptionController.enter = false;
				WeaponoptionController2.enter = false;
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

						notEnoughMula();
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

						notEnoughMula();

					}
				}
			}
		}
	}

	public void notEnoughMula() {
		root.add(NotEnoughdialogueBox).expand().align(Align.bottom);
		NotEnoughdialogueBox.setVisible(true);
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			root.removeActor(NotEnoughdialogueBox);
			NotEnoughdialogueBox.setVisible(false );
			//set controller to the player
			Gdx.input.setInputProcessor(controller);
		}
	}

	//	public void ArmorOptions() {
	//		dialogueBox.animateText("What would you like to \nbuy from me?");
	//		optionBox.addOption("Shield");
	//		optionBox.addOption("Hat");
	//		optionBox.addOption("Chest");
	//		optionBox.addOption("Boots");
	//		optionBox.addOption("Amulet");
	//		optionBox.addOption("Back");
	//	}
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







