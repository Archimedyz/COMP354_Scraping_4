package GUI_Views;
import static Common.SharedVariables.windowListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Common.SharedVariables;

/*
 * Main window to be show on start up.
 * Can lead to scraping load window and allows user to open a file from directory.
 */

public class MainWindow extends JFrame implements SharedVariables{
	
	boolean actionsSet;
	
	public MainWindow(){
		super(APP_TITLE + ": Main Window");
		actionsSet = false;
	}
	
	private void init(){
		this.setSize(600, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		errorMessage.setForeground(Color.RED);
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		if(openFileButton.getActionListeners().length == 0){			
			openFileButton.addActionListener(windowListener);
		}
		if(scrapingButton.getActionListeners().length == 0){	
			scrapingButton.addActionListener(windowListener);
		}
		if(helpButton.getActionListeners().length == 0){	
			helpButton.addActionListener(windowListener);
		}
		if(exitButton.getActionListeners().length == 0){	
			exitButton.addActionListener(windowListener);
		}
		buttonPanel.add(openFileButton);
		buttonPanel.add(scrapingButton);
		buttonPanel.add(helpButton);
		buttonPanel.add(exitButton);
		JPanel errorPanel = new JPanel();
		errorPanel.add(errorMessage);
		centerPanel.add(errorPanel, BorderLayout.CENTER);
		JPanel tempPanel = new JPanel();
		tempPanel.add(filePathLabel, BorderLayout.SOUTH);
		tempPanel.add(filePathField, BorderLayout.SOUTH);
		centerPanel.add(tempPanel, BorderLayout.SOUTH);
		windowLabel.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		windowLabel.setText(GREETING_STRING);
		mainPanel.add(windowLabel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		this.add(mainPanel);
		//System.out.println("MAIN");
	}
	
	public void showWindow(){
		init();
		this.setVisible(true);
	}
	
	public void hideWindow(){
		errorMessage.setText("");
		mainPanel.removeAll();
		centerPanel.removeAll();
		buttonPanel.removeAll();
		this.setVisible(false);
	}
	public static void main(String[] args) {
		mainWindow.showWindow();
	}
}