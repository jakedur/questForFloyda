package ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class OptionBox extends Table{

	private int selectedIndex = 0;
	
	private List<Image> arrows = new ArrayList<Image>();
	private List<Label> options = new ArrayList<Label>();
	
	private Table uiContainer;
	
	public OptionBox(Skin skin) {
		super(skin);
		this.setBackground("optionbox");
		uiContainer = new Table();
		this.add(uiContainer).pad(5f);
	}
	
	public void addOption(String option) {
		Label optionLabel = new Label(option, this.getSkin());
		options.add(optionLabel);
		Image arrow = new Image(this.getSkin(), "arrow");
		arrow.setVisible(false);
		arrows.add(arrow);
		
		uiContainer.add(arrow).expand().align(Align.left).space(8f);
		uiContainer.add(optionLabel).expand().align(Align.left).space(8f);
		uiContainer.row();
		
		calcArrowVisiblity();
	}
	
	public void moveUp() {
		selectedIndex--;
		if(selectedIndex < 0) {
			selectedIndex = 0;
		}
		calcArrowVisiblity();
	}
	
	public void moveDown() {
		selectedIndex++;
		if(selectedIndex >= options.size()) {
			selectedIndex = options.size()-1;
		}
		calcArrowVisiblity();
	}
	
	public int getSelected() {
		return selectedIndex;
	}
	
	public void clearChoices() {
		uiContainer.clearChildren();
		arrows.clear();
		options.clear();
		selectedIndex = 0;
	}
	
	public void calcArrowVisiblity() {
		for(int i = 0; i < arrows.size(); i++) {
			if(i == selectedIndex) {
				arrows.get(i).setVisible(true);
			} else {
				arrows.get(i).setVisible(false);
			}
		}
	}
}
