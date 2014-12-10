package Export;

import java.io.PrintWriter;
import java.util.ArrayList;
import Common.SharedVariables;
import Scraper.ScrapingEntry;

public class ExportData implements SharedVariables 
{
	public void exportXML(String path)
	{
		
	}
	
	public void exportRDF(String path)
	{
		String rdf = "<?xml version=\"1.0\"?>\n<RDF>\n";
		
		for (int i = 0; i < scrapedEntries.size(); i++)
		{
			ScrapingEntry ent = scrapedEntries.get(i);
			
			rdf += ("<Description about=\"" + ent.name + "\">\n");
			rdf += ("<name>" + ent.name + "</name>\n");
			rdf += ("<author>" + ent.offeredBy + "</author>\n");
			rdf += ("<rating>" + ent.contentRating + "</rating>\n");
			rdf += ("<ratings>" + ent.numOfPeopleRated + "</ratings>\n");
			rdf += ("<upvotes>" + ent.numOfGoogleUpvotes + "</upvotes>\n");
			rdf += ("<category>" + ent.category + "</category>\n");
			rdf += ("<date>" + ent.dateLastUpdated + "</date>\n");
			rdf += ("<description>" + ent.description + "</description>\n");
			rdf += ("<installs>" + ent.numOfInstalls + "</installs>\n");
			rdf += ("<version>" + ent.currentVersion + "</version>\n");
			rdf += ("<size>" + ent.size + "</size>\n");
			rdf += ("<similar1>" + ent.similarApps.get(0) + "</similar1>\n");
			rdf += ("<similar2>" + ent.similarApps.get(1) + "</similar2>\n");
			rdf += ("<similar3>" + ent.similarApps.get(2) + "</similar3>\n");
			rdf += "</Description>\n";
		}
		
		rdf += "</RDF>";
		
		try
		{
			PrintWriter out = new PrintWriter(path);
			out.write(rdf);
			out.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: Could not export data as rdf.");
		}
	}
	
}
