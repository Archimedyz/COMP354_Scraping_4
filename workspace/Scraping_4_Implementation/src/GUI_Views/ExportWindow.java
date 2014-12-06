package GUI_Views;

import static Common.SharedVariables.windowListener;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import Common.SharedVariables;

public class ExportWindow extends JFrame implements SharedVariables{
	
	public ExportWindow(){
		super(APP_TITLE + ": Export Window");
	}
	
	private void init(){
		
	}
	
	public void showWindow(){
		init();
		this.setVisible(true);
	}
	
	public void hideWindow(){
		this.setVisible(false);
	}
}
