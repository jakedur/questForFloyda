package screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Quest;

import controller.OptionBoxController;
import items.Item;
import ui.DialogueBox;
import ui.OptionBox;

public class ItemManegementScreen extends AbstractScreen{
	private Quest apps;
	private Viewport gameViewport;

	private Stage uiStage;
	private Table root;
	private Table rightDialogTable;
	private Table leftDialogTable;
	private int uiScale = 2;

	private OptionBox rightSide;
	private OptionBox leftSideBag;
	private OptionBox leftSideEquip;

	private OptionBoxController rightSideController;
	private OptionBoxController leftSideBagController;
	private OptionBoxController leftSideEquipController;

	private DialogueBox stats;

	private float X,Y;

	private List<Item> Bag;
	private Item[] Equip;

	public ItemManegementScreen(Quest app, float x, float y) {
		super(app);
		apps = app;
		gameViewport = new ScreenViewport();
		X = x;
		Y = x;

		initUI();
	}

	public void initUI() {
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale, true);
		//uiStage.setDebugAll(true);

		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);

		rightDialogTable = new Table();
		leftDialogTable = new Table();

		rightSide = new OptionBox(getApp().getSkin());
		leftSideBag = new OptionBox(getApp().getSkin());
		leftSideEquip = new OptionBox(getApp().getSkin());

		rightSideController = new OptionBoxController(rightSide);
		leftSideBagController = new OptionBoxController(leftSideBag);
		leftSideEquipController = new OptionBoxController(leftSideEquip);

		stats = new DialogueBox(getApp().getSkin());

		rightSide.addOption("Bag");
		rightSide.addOption("Equipment");
		rightSide.addOption("Stats");
		rightSide.addOption("Back");

		if(apps.ClassSelect == 0) {
			Bag = apps.wizardPlayer.getBag();
			if(Bag != null) {
				for(Item item: Bag) {
					if(item != null)
						leftSideBag.addOption(item.getItemName());
				}
			}
			Equip = apps.wizardPlayer.getEqupiment();
			if(Equip != null) {
				for(Item item: Equip) {
					if(item != null)
						leftSideEquip.addOption(item.getItemName());
				}
			}
			int gold = apps.wizardPlayer.getPlayerMoney();
			int curHp = apps.wizardPlayer.getHP();
			int maxHp = apps.wizardPlayer.getMaxHP();
			stats.animateText("Gold: " + gold +"\nHP: " + curHp + "\\" + maxHp);
		}
		if(apps.ClassSelect == 1) {
			Bag = apps.knightPlayer.getBag();
			if(Bag != null) {
				for(Item item: Bag) {
					if(item != null)
						leftSideBag.addOption(item.getItemName());
				}
			}
			Equip = apps.knightPlayer.getEqupiment();
			if(Equip != null) {
				for(Item item: Equip) {
					if(item != null)
						leftSideEquip.addOption(item.getItemName());
				}
			}
			int gold = apps.knightPlayer.getPlayerMoney();
			stats.animateText("Gold: " + gold);
		}
		rightDialogTable.add(rightSide).expand();
		root.add(rightDialogTable).expand().align(Align.right).space(8f);

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(rightSideController);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 252f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		uiStage.draw();
		stats.act(delta);
		rightSide();
		escapeInventory();
	}

	public void rightSide() {
		if(rightSideController.getEnterStatus() == true) {
			if(rightSide.getSelected() == 0) {
				root.add(leftDialogTable).expand().align(Align.left).space(8f);
				leftDialogTable.add(leftSideBag).expand().align(Align.left).space(8f);
				Gdx.input.setInputProcessor(leftSideBagController);
				leftSideBag();
			}
			if(rightSide.getSelected() == 1) {
				root.add(leftDialogTable).expand().align(Align.left).space(8f);
				leftDialogTable.add(leftSideEquip).expand().align(Align.left).space(8f);
				Gdx.input.setInputProcessor(leftSideEquipController);
				leftSideEquip();
			}
			if(rightSide.getSelected() == 2) {
				root.add(leftDialogTable).expand().align(Align.left).space(8f);
				leftDialogTable.add(stats).expand().align(Align.left).space(8f);
				Gdx.input.setInputProcessor(null);
				Stats();
			}
			if(rightSide.getSelected() == 3) {
				apps.setCurrentScreen("Game Start", X, Y);
			}
		}
	}

	public void leftSideBag() {
		if(leftSideBagController.getEnterStatus() == true) {
			if(apps.ClassSelect == 0) {
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Sword")|| 
						Bag.get(leftSideBag.getSelected()).getItemName().equals("Staff")) {
					apps.wizardPlayer.EquipWeapon(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Shield")){
					apps.wizardPlayer.EquipShield(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Hat")){
					apps.wizardPlayer.EquipHat(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Chest")){
					apps.wizardPlayer.EquipChest(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Boots")){
					apps.wizardPlayer.EquipBoots(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Amulet")){
					apps.wizardPlayer.EquipAmulet(Bag.get(leftSideBag.getSelected()));
				}
			}
			if(apps.ClassSelect == 1) {
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Sword")|| 
						Bag.get(leftSideBag.getSelected()).getItemName().equals("Staff")) {
					apps.knightPlayer.EquipWeapon(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Shield")){
					apps.knightPlayer.EquipShield(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Hat")){
					apps.knightPlayer.EquipHat(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Chest")){
					apps.knightPlayer.EquipChest(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Boots")){
					apps.knightPlayer.EquipBoots(Bag.get(leftSideBag.getSelected()));
				}
				if(Bag.get(leftSideBag.getSelected()).getItemName().equals("Amulet")){
					apps.knightPlayer.EquipAmulet(Bag.get(leftSideBag.getSelected()));
				}
			}

			leftDialogTable.removeActor(leftSideBag);
			root.removeActor(leftDialogTable);
			Gdx.input.setInputProcessor(rightSideController);
			rightSideController.enter = false;
			leftSideBagController.enter = false;
		}
		if(leftSideBagController.CloseOptionBox() == true) {
			leftDialogTable.removeActor(leftSideBag);
			root.removeActor(leftDialogTable);
			Gdx.input.setInputProcessor(rightSideController);
			rightSideController.enter = false;
			leftSideBagController.setCloseOPtionBox(false);
		}
	}
	
	public void leftSideEquip() {
		if(leftSideEquipController.CloseOptionBox() == true) {
			leftDialogTable.removeActor(leftSideEquip);
			root.removeActor(leftDialogTable);
			Gdx.input.setInputProcessor(rightSideController);
			rightSideController.enter = false;
			leftSideEquipController.setCloseOPtionBox(false);
		}
	}
	
	public void Stats() {
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			leftDialogTable.removeActor(stats);
			root.removeActor(leftDialogTable);
			Gdx.input.setInputProcessor(rightSideController);
		}
	}
	
	public void escapeInventory() {
		if(rightSideController.CloseOptionBox() == true) {
			apps.setCurrentScreen("Game Start", X, Y);
		}
	}

	@Override
	public void resize(int width, int height) {
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
