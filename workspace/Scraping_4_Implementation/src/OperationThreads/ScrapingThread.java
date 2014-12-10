package OperationThreads;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Common.SharedVariables;
import Scraper.*;

public class ScrapingThread extends Thread implements SharedVariables{
	String csvFilePath;
	
	public ScrapingThread(String csvFilePath){
		if(doneScrap.getActionListeners().length == 0){
			doneScrap.addActionListener(windowListener);
		}
		this.csvFilePath = csvFilePath;
	}
	
	@Override
	public void run()
	{
		Scraper scraper = new Scraper();
		ArrayList<String> urls = scraper.GetURLs(csvFilePath);
		int increment = 100 / urls.size(); // VERY NICE TWOSKI
		int progress = 0;
		
		for (int i = 0; i < urls.size(); i++)
		{
			scraper.Scrape(urls.get(i));
			
			progress += increment;
			
			scrapingProgressBar.setValue(progress);
		}
	
		doneScrap.doClick();
	}
	
	private void wasteTime(long time)
	{
		long startTime = System.currentTimeMillis();
		long nowTime = System.currentTimeMillis();
		
		while(nowTime - startTime < time)
		{
			nowTime = System.currentTimeMillis();
		}
	}
}
