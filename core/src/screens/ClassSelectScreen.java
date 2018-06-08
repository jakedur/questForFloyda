package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Quest;

import controller.OptionBoxController;
import ui.DialogueBox;
import ui.OptionBox;

public class ClassSelectScreen extends AbstractScreen{

	private Table root;
	private Stage uiStage;
	private int uiScale = 2;
	
	private Viewport gameViewport;
	
	private OptionBox optionBox1;
	private OptionBox optionBox2;
	private OptionBoxController optionController1;
	private OptionBoxController optionController2;
	
	private DialogueBox dialogueBox;
	private DialogueBox dialogueBox2;
	
	private Texture Knight;
	private Texture Wizard;
	private SpriteBatch batch;
	public Quest apps;
	
	public int select;
	
	public boolean wizard;
	public boolean knight;
	
	public Table dialogTable;
	
	public ClassSelectScreen(Quest app) {
		super(app);
		apps = app;
		batch = app.batch;
		
		gameViewport = new ScreenViewport();
		
		Knight = new Texture("Knight.png");
		Wizard = new Texture("Wizard.png");
		
		wizard = true;
		knight = false;
		
		initUI();
	}
	public Quest getQuest() {
		return apps;
	}
	
	private void initUI() {
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale, true);
		//uiStage.setDebugAll(true);

		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);
		
		dialogueBox = new DialogueBox(getApp().getSkin());
		dialogueBox.animateText("What Class would you \nlike to play as?");
		
		dialogueBox2 = new DialogueBox(getApp().getSkin());
		dialogueBox2.animateText("Are you sure you want \nto play this class?");
		dialogueBox2.setVisible(false);
		
		optionBox1 = new OptionBox(getApp().getSkin());
		optionBox1.setVisible(false);
		optionBox1.addOption("Wizard");
		optionBox1.addOption("Knight");
		optionController1 = new OptionBoxController(optionBox1);
		
		optionBox2 = new OptionBox(getApp().getSkin());
		optionBox2.setVisible(false);
		optionBox2.addOption("Yes");
		optionBox2.addOption("No");
		optionController2 = new OptionBoxController(optionBox2);
		
		
		dialogTable = new Table();
		dialogTable.add(optionBox1).expand().align(Align.right).space(8f).row();
		
		root.add(dialogueBox).expand().align(Align.bottom);
		root.add(dialogTable).expand().align(Align.bottom);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(optionController1);
	}  

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 128f, 128f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		checkOptionBox1();
		checkOptionBox2();
		batch.begin();
		if(wizard == true) {
			//Gdx.graphics.getWidth()
			// Gdx.graphics.getHeight()
			batch.draw(Wizard, 100,100,300,300);
		}else if(knight == true) {
			batch.draw(Knight, 100,100,300,300);
		}
		batch.end();
		
		uiStage.draw();
		dialogueBox.act(delta);
		if(dialogueBox.isFinished() == true) {
			optionBox1.setVisible(true);
		}
		dialogueBox2.act(delta);
		if(dialogueBox2.isFinished() == true) {
			optionBox2.setVisible(true);
		}
		
	}
	
	public void checkOptionBox1() {
		apps.ClassSelect = optionBox1.getSelected();
		if(apps.ClassSelect == 0) {
			wizard = true;
			knight = false;
		}
		if(apps.ClassSelect == 1) {
			wizard = false;
			knight = true;
		}
		if(optionController1.getEnterStatus() == true) {
			dialogueBox.setVisible(false);
			optionBox1.setVisible(false);
			
			root.removeActor(dialogueBox);
			dialogTable.removeActor(optionBox1);
			
			root.removeActor(dialogTable);
			root.add(dialogueBox2).expand().align(Align.bottom);
			dialogTable.add(optionBox2).expand().align(Align.right).space(8f).row();
			root.add(dialogTable).expand().align(Align.bottom);
			
			dialogueBox2.setVisible(true);
			
			optionController1.enter = false;
			Gdx.input.setInputProcessor(optionController2);
		}
	}
	
	public void checkOptionBox2() {
		select = optionBox2.getSelected();
		if(optionController2.CloseOptionBox() == true || optionController2.getEnterStatus() == true && select == 1) {
			dialogueBox2.setVisible(false);
			optionBox2.setVisible(false);
			
			root.removeActor(dialogueBox2);
			dialogTable.removeActor(optionBox2);
			
			root.removeActor(dialogTable);
			root.add(dialogueBox).expand().align(Align.bottom);
			dialogTable.add(optionBox1).expand().align(Align.right).space(8f).row();
			root.add(dialogTable).expand().align(Align.bottom);
			
			dialogueBox.setVisible(true);
			
			optionController2.setCloseOPtionBox(false);
			optionController2.enter = false;
			Gdx.input.setInputProcessor(optionController1);
		}
		if(optionController2.getEnterStatus() == true && select == 0) {
			apps.setCurrentScreen("Game Start", 304, 16);
		}
	}
	
	public int getSelected() {
		return optionBox1.getSelected();
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
