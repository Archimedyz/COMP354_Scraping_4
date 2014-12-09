package Scraper;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Common.SharedVariables;

public class Parsing implements SharedVariables
{
    /*
	<xml.XMLData>
	<name>TestName</name>
	<offeredBy>TestOfferedBy</offeredBy>
	<contentRating>TestContentRating</contentRating>
	<rating>12314.124</rating>
	<numOfPeopleRated>777</numOfPeopleRated>
	<numOfGoogleUpvotes>100</numOfGoogleUpvotes>
	<category>TestCategory</category>
	<dateLastUpdated>TestdateLastUpdated</dateLastUpdated>
	<description>TestDescription</description>
	<numOfInstalls>44444</numOfInstalls>
	<currentVersion>TestcurrentVersion</currentVersion>
	<size>500.0</size>
	<similarApps>
	<string>TestApp1</string>
	<string>TestApp2</string>
	<string>TestApp3</string>
	</similarApps>
	</xml.XMLData>
	*/
	
	String data="";
	String App_name="";  //ok
	String App_company="";  //ok
	String App_rating="";  //ok
	String App_numOfPeopleRated="";  //ok
	String App_category="";  //ok
	String App_dateLastUpdated="";  //ok
	String App_description="";  //no, the text is very very very long....
	String App_numOfInstalls="";  //ok
	String App_currentVersion=""; //ok
    String App_size=""; //ok
    ArrayList<String> App_similar = new ArrayList<String>();  //ok
    
    public void parse(String file)
	{
		File f=new File(file);
		
		try
		{
			Scanner in = new Scanner(f);
			data = in.nextLine();
			in.close();
			
			App_name=filter("<title id=\"main-title\">");
			App_company=filter("<span itemprop=\"name\">");
			App_rating=filter("<div class=\"score\">");
			App_category=filter("<span itemprop=\"genre\">");
		    App_numOfPeopleRated=filter("<span class=\"reviews-num\">");
			App_dateLastUpdated=filter("<div class=\"content\" itemprop=\"datePublished\">");
		    App_numOfInstalls=filter("<div class=\"content\" itemprop=\"numDownloads\">");
		    App_currentVersion=filter("<div class=\"content\" itemprop=\"softwareVersion\">");
		    App_size=filter("<div class=\"content\" itemprop=\"fileSize\">");
		    App_similar = app_similar("<img class=\"cover-image\" alt=");
			
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
		
		    dataMap.put(AppDataType.NAME, App_name);
		    dataMap.put(AppDataType.COMPANY, App_company);
		    dataMap.put(AppDataType.RATING, App_rating);
		    dataMap.put(AppDataType.NUMBER_OF_RATERS, App_numOfPeopleRated);
		    dataMap.put(AppDataType.CATEGORY, App_category);
		    dataMap.put(AppDataType.DATE_LAST_UPDATED, App_dateLastUpdated);
		    dataMap.put(AppDataType.DESCRIPTION, App_description);
		    dataMap.put(AppDataType.INSTALLS, App_numOfInstalls);
		    dataMap.put(AppDataType.CURRENT_VERSION, App_currentVersion);
		    dataMap.put(AppDataType.SIZE, App_size);
		    dataMap.put(AppDataType.SIMILARAPP1, App_similar.get(0));
		    dataMap.put(AppDataType.SIMILARAPP2, App_similar.get(1));
		    dataMap.put(AppDataType.SIMILARAPP3, App_similar.get(2));
		    
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
	}
	
	public String filter(String pattern)
	{
		int index=data.indexOf(pattern);
		String substring=data.substring(index, index+1000);
		String m=substring.split(">")[1].split("<")[0];	
		
		return m;
	}
	
	public ArrayList<String> app_similar(String pattern)
	{
		ArrayList<String> m = new ArrayList<String>();
		int index=data.indexOf(pattern);
		String substring=data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		index=data.indexOf(pattern, index+20);
		substring=data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		index=data.indexOf(pattern, index+20);
		substring=data.substring(index, index+1000);
		m.add(substring.split("alt=\"")[1].split("\"")[0]);
		
		return m;
	}
}
