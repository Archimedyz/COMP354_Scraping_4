package OperationThreads;

import java.awt.event.ActionEvent;

import Common.SharedVariables;

public class ScrapingThread extends Thread implements SharedVariables{
	public ScrapingThread(){
		doneScrap.addActionListener(windowListener);
	}
	
	@Override
	public void run(){
		for(int i = 0 ; i <= 10; ++i){
			scrapingProgressBar.setValue(i * (scrapingProgressBar.getMaximum()/10));
			//scrapingProgressWindow.updateWindow();
			System.out.println(i + 1);
			wasteTime(250);
		}
		doneScrap.doClick();
	}
	
	private void wasteTime(long time){
		long startTime = System.currentTimeMillis();
		long nowTime = System.currentTimeMillis();
		while(nowTime - startTime < time){
			nowTime = System.currentTimeMillis();
		}
	}
}
