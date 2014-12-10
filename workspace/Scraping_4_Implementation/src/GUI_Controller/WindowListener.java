package GUI_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Common.SharedVariables;
import OperationThreads.ScrapingThread;
import Scraper.Scraper;

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

public class WindowListener implements ActionListener, ChangeListener, SharedVariables {
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			System.exit(0);
		} else if (e.getSource() == helpButton) {
			System.out.println("Help");
		} else if (e.getSource() == scrapingButton) {
			/*
			 * Scraping should start here. show a "loading" window whilst scraping.
			 */
			mainWindow.hideWindow();
			scrapingProgressWindow.showWindow();
			new ScrapingThread(null).start();	
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
		} else if(e.getSource() == doneScrap){
			System.out.println("Done Le Scrape.");	
			// when scraping is done, display the export window.
			scrapingProgressWindow.hideWindow();
			exportWindow.showWindow();
		} else if (e.getSource() == saveFileButton) {
			int response;
			response = fileOpener.showSaveDialog(mainPanel);
			if (response == JFileChooser.APPROVE_OPTION) {
				// This is the filename.
				saveFileName.setText(fileOpener.getSelectedFile().getName());
				// This is the path for saving the file including the fileName.
				saveFilePath.setText(fileOpener.getSelectedFile().getPath());
				// this is the real save path.
				String savePath = saveFilePath.getText();
				if(xmlFormat.isSelected()){
					savePath += ".xml";
				} else if(rdfFormat.isSelected()){
					savePath += ".rdf";
				} else{
					return;
				}
				System.out.println("HERE ME!");
			} else {
				System.out.println("Didn't choose a file . . .");
			}
		} else if (e.getSource() == newScrapButton) {
			exportWindow.hideWindow();
			mainWindow.showWindow();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == xmlFormat && xmlFormat.isSelected()){	
			System.out.println("XML");
			rdfFormat.setSelected(false);
		} else if(e.getSource() == rdfFormat && rdfFormat.isSelected()){
			System.out.println("RDF");
			xmlFormat.setSelected(false);
		}
	}
}