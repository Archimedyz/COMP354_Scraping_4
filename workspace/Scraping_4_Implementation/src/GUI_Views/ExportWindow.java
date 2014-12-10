package GUI_Views;

import static Common.SharedVariables.windowListener;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Common.SharedVariables;

public class ExportWindow extends JFrame implements SharedVariables{
		
	public ExportWindow(){
		super(APP_TITLE + ": Export Window");
	}
	
	private void init(){
		this.setSize(600, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		if(saveFileButton.getActionListeners().length == 0){			
			saveFileButton.addActionListener(windowListener);
		}
		if(newScrapButton.getActionListeners().length == 0){	
			newScrapButton.addActionListener(windowListener);
		}
		if(helpButton.getActionListeners().length == 0){	
			helpButton.addActionListener(windowListener);
		}
		if(exitButton.getActionListeners().length == 0){	
			exitButton.addActionListener(windowListener);
		}
		if(xmlFormat.getChangeListeners().length == 1){
			xmlFormat.addChangeListener(windowListener);
			//System.out.println("CHECK ME");
		}
		if(rdfFormat.getChangeListeners().length == 1){
			rdfFormat.addChangeListener(windowListener);
		}
		buttonPanel.add(saveFileButton);
		buttonPanel.add(newScrapButton);
		buttonPanel.add(helpButton);
		buttonPanel.add(exitButton);
		windowLabel.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		saveFileName.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		saveFilePath.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		centerPanel.add(new JLabel("Save Format"));
		centerPanel.add(xmlFormat);
		centerPanel.add(rdfFormat);
		centerPanel.add(saveFileName);
		centerPanel.add(saveFilePath);
		windowLabel.setFont(new Font(windowLabel.getFont().getFontName(), Font.PLAIN, 20));
		windowLabel.setText(EXPORT_STRING);
		mainPanel.add(windowLabel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		this.add(mainPanel);
	}
	
	public void showWindow(){
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
