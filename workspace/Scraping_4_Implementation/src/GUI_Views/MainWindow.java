package GUI_Views;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		mainPanel.setLayout(new BorderLayout());
		if(!actionsSet){			
			openFileButton.addActionListener(windowListener);
			scrapingButton.addActionListener(windowListener);
			helpButton.addActionListener(windowListener);
			exitButton.addActionListener(windowListener);
			actionsSet = true;
		}
		buttonPanel.add(openFileButton);
		buttonPanel.add(scrapingButton);
		buttonPanel.add(helpButton);
		buttonPanel.add(exitButton);
		centerPanel.add(filePathLabel);
		centerPanel.add(filePathField);
		greetingLabel.setFont(new Font(greetingLabel.getFont().getFontName(), Font.PLAIN, 20));
		mainPanel.add(greetingLabel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		this.add(mainPanel);
	}
	
	public void showWindow(){
		init();
		this.setVisible(true);
	}
	
	public void hideWindow(){
		this.removeAll();
		mainPanel.removeAll();
		centerPanel.removeAll();
		buttonPanel.removeAll();
		//this.setVisible(false);
	}

	public void updateWindow(){
		init();
	}
	public static void main(String[] args) {
		mainWindow.showWindow();
	}
}