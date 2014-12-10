package OperationThreads;

import java.awt.event.ActionEvent;
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
		scrapingProgressBar.setValue(1);
		
		Scraper scraper = new Scraper();
		ArrayList<String> urls = scraper.GetURLs(csvFilePath);
		
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
	
		doneScrap.doClick();
	}
}
