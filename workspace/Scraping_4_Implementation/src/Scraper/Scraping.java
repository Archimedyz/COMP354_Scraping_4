package Scraper;

import java.io.*;
import java.net.*;

public class Scraping 
{
	public String fileName = "";
	
	public void Scrape(String url)
	{
		String scrapingData = "";
		
		try
		{
		    URL web = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(web.openStream()));
            String inputLine;
            String name[] = url.split("\\.");
            
            while ((inputLine = in.readLine()) != null)
            {
            	scrapingData += inputLine;
            }
            
            in.close();
            
            fileName = name[4] + ".txt";
            PrintWriter out = new PrintWriter(fileName);
            out.write(scrapingData);
            out.close();
            
            System.out.println("Scraping finished!"); 
		} 
		catch(Exception e)
		{ 	
			e.printStackTrace();
		}
	}
}
