package OperationThreads;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Common.SharedVariables;
import Scraper.*;

public class ScrapingThread extends Thread implements SharedVariables{
	public ScrapingThread(){
		doneScrap.addActionListener(windowListener);
	}
	
	@Override
	public void run()
	{
		Scraper scraper = new Scraper();
		ArrayList<String> urls = scraper.GetURLs();
		int increment = 100 / urls.size();
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
