package GUI_Views;

import static Common.SharedVariables.windowListener;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.SharedVariables;

public class ScrapingProgressWindow extends JFrame implements SharedVariables{
	
	public ScrapingProgressWindow(){
		super(APP_TITLE + ": Scraping Progress Window");
	}
	
	private void init(){
		this.setSize(600, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		scrapingProgressBar.setLocation(10, 10);
		scrapingProgressBar.setSize(20, 100);
		scrapingProgressBar.setStringPainted(true);
		mainPanel.setLayout(new BorderLayout());
		centerPanel.add(scrapingProgressBar);
		windowLabel.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		windowLabel.setText(PROGRESS_STRING);
		mainPanel.add(windowLabel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		this.add(mainPanel);
	}
	
	public void showWindow(){
		scrapingProgressBar.setValue(0);
		init();
		this.setVisible(true);
	}
	
	public void hideWindow(){
		//this.removeAll();
		mainPanel.removeAll();
		centerPanel.removeAll();
		buttonPanel.removeAll();
		this.setVisible(false);
	}
}
