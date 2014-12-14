package OperationThreads;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Common.SharedVariables;
import Scraper.*;

public class ScrapingThread extends Thread implements SharedVariables
{
	String csvFilePath;
	
	public ScrapingThread(String csvFilePath)
	{
		if(doneScrap.getActionListeners().length == 0)
		{
			doneScrap.addActionListener(windowListener);
		}
		this.csvFilePath = csvFilePath;
	}
	
	@Override
	public void run()
	{
		long currTime = System.currentTimeMillis();
		scrapingProgressBar.setValue(1);
		
		Scraper scraper = new Scraper();
		ArrayList<String> urls = null;
		try {
			urls = scraper.GetURLs(csvFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			scrapingProgressWindow.hideWindow();
			errorMessage.setText("Invalid File Path.");
			mainWindow.showWindow();
			return;
		}
		
		if (urls.size() < 1)
		{
			System.out.println("No URLS to scrape, aborting.");
			doneScrap.doClick();
			return;
		}
		
		for (int i = 0; i < urls.size(); i++)
		{
			System.out.println(urls.get(i));
			
			scraper.Scrape(urls.get(i));
			
			int progress = (int) (((double) i / (double) urls.size()) * 100); // i think this should work
			
			scrapingProgressBar.setValue(progress);
		}
		System.out.println("Time taken: " + (System.currentTimeMillis() - currTime));
		doneScrap.doClick();
		
	}
}
