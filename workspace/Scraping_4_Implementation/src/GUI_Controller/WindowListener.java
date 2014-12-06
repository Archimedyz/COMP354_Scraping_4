package GUI_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import Common.SharedVariables;

/*
 * This class behaves as a GUI Controller in the sense that 
 * it will receive all input from the user (button clicks) and
 * send them to the appropriate sub routine in the Model Classes.
 * I've left some spaces empty (Not my responsibility).
 *  I also don't know what exactly you will be doing but I 
 *  have left some comments in various sections to indicate what
 *  ought to go where.
 *  
 *  Enjoy
 *  - Awais Ali
 */

public class WindowListener implements ActionListener, SharedVariables {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			System.exit(0);
		} else if (e.getSource() == helpButton) {
			System.out.println("Help");
		} else if (e.getSource() == scrapingButton) {
			System.out.println("Scraping start");
			/*
			 * Scraping should start here. show a "loading" window whilst scraping.
			 */
			mainWindow.hideWindow();
			scrapingProgressWindow.showWindow();
			System.out.println("Done Le Scrap.");
			for(int i = 0 ; i <= 10; ++i){
				scrapingProgressBar.setValue(i * (scrapingProgressBar.getMaximum()/10));
				scrapingProgressWindow.updateWindow();
				System.out.println(i);
				wasteTime(500);
			}
			
			
			/*
			 * Move to save window.
			 */
			scrapingProgressWindow.hideWindow();
			exportWindow.showWindow();
		} else if (e.getSource() == openFileButton) {
			System.out.println("Open FIle");
			int response;
			response = fileOpener.showOpenDialog(mainPanel);
			if (response == JFileChooser.APPROVE_OPTION) {
				filePathField.setText(fileOpener.getSelectedFile().getPath());
				// Don't do anything here, it is only to set the path string for scraping.
				// Scrapping should only begin when the a scraping button is pressed.
			} else {
				// Do nothing when no file was selected.
				System.out.println("Didn't choose a file . . .");
			}
		}
	}
	
	private void wasteTime(long time){
		long startTime = System.currentTimeMillis();
		long nowTime = System.currentTimeMillis();
		while(nowTime - startTime < time){
			nowTime = System.currentTimeMillis();
		}
	}
}