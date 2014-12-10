package Scraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import Common.SharedVariables;

public class Scraper implements SharedVariables
{	
	String filter(String pattern, String data)
	{
		int index = data.indexOf(pattern);
		String substring = data.substring(index, index + 1000);
		String m = substring.split(">")[1].split("<")[0];	
		
		return m;
	}
	
	ArrayList<String> getSimilarApps(String pattern, String data)
	{
		ArrayList<String> m = new ArrayList<String>();
		int index = data.indexOf(pattern);
		String substring = data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		index = data.indexOf(pattern, index+20);
		substring = data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		index = data.indexOf(pattern, index+20);
		substring = data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		return m;
	}
	
	void parse(String file)
	{
		File f = new File(file);
		
		try
		{
			Scanner in = new Scanner(f);
			String data = in.nextLine();
			in.close();
			
			String App_name = filter("<title id=\"main-title\">", data);
			String App_company = filter("<span itemprop=\"name\">", data);
			String App_rating = filter("<div class=\"score\">", data);
			String App_category = filter("<span itemprop=\"genre\">", data);
		    String App_numOfPeopleRated = filter("<span class=\"reviews-num\">", data);
			String App_dateLastUpdated = filter("<div class=\"content\" itemprop=\"datePublished\">", data);
		    String App_numOfInstalls = filter("<div class=\"content\" itemprop=\"numDownloads\">", data);
		    String App_currentVersion = filter("<div class=\"content\" itemprop=\"softwareVersion\">", data);
		    String App_size = filter("<div class=\"content\" itemprop=\"fileSize\">", data);
		    ArrayList<String> App_similar = getSimilarApps("<img class=\"cover-image\" alt=", data);
			
			System.out.println("App_name: "+App_name);
			System.out.println("App_company: "+App_company);
			System.out.println("App_rating: "+App_rating);
			System.out.println("App_category: "+App_category);	
			System.out.println("App_numOfPeopleRated: "+App_numOfPeopleRated);
			System.out.println("App_dateLastUpdated: "+App_dateLastUpdated);	
			System.out.println("App_numOfInstalls: "+App_numOfInstalls);
			System.out.println("App_currentVersion: "+App_currentVersion);	
		    System.out.println("App_size: "+App_size);	
		    System.out.println("App_similar1: "+App_similar.get(0));
		    System.out.println("App_similar2: "+App_similar.get(1));
		    System.out.println("App_similar3: "+App_similar.get(2));
		    
		    xmlData.name = App_name;
			xmlData.offeredBy = App_company;
			xmlData.contentRating = "NA";
			xmlData.rating = Float.parseFloat(App_rating);
			xmlData.numOfPeopleRated = App_numOfPeopleRated;
			xmlData.numOfGoogleUpvotes = 0;
			xmlData.category = App_category;
			xmlData.dateLastUpdated = App_dateLastUpdated;
			xmlData.description = "Too long for some reason";
			xmlData.numOfInstalls = App_numOfInstalls;
			xmlData.currentVersion = App_currentVersion;
			xmlData.size = App_size;
			xmlData.similarApps = App_similar;
		   
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
	}
	
	public void Scrape(String url)
	{
		String scrapingData = "";
		
		try
		{
		    URL web = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(web.openStream()));
            String inputLine;
            
            System.out.println("Scraping started on '" + url + "'."); 
            
            while ((inputLine = in.readLine()) != null)
            {
            	scrapingData += inputLine;
            }
            
            in.close();
            
            String fileName = "temp.txt";
            
            System.out.println(fileName);
            
            PrintWriter out = new PrintWriter(fileName);
            out.write(scrapingData);
            out.close();
            
            parse(fileName);
            
            System.out.println("Scraping finished on '" + url + "'."); 
		} 
		catch (Exception e)
		{ 	
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> GetURLs(String csvFilePath)
	{
		if (csvFilePath == null)
		{
			csvFilePath = "res/sample.csv";
		}
		
		File csvFile = new File(csvFilePath);
		Scanner reader;
		
		try 
		{
			reader = new Scanner(csvFile);
			reader.nextLine();
			
			while(reader.hasNextLine())
			{
				String line = reader.nextLine();
				System.out.println(line.split(";")[0]);
				urls.add(line.substring(1).split(";")[0]);
			}
			
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return urls;
	}
	
	public void ScrapeFromList(ArrayList<String> urls) //don't use this
	{
		for (int i = 0; i < urls.size(); i++)
		{
			Scrape(urls.get(i));
		}
	}
	
}
