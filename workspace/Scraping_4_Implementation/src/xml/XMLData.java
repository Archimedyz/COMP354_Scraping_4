package xml;

import java.util.ArrayList;

public class XMLData {
	public String name;
	public String offeredBy;
	public String contentRating;
	public float rating;
	public int numOfPeopleRated;
	public int numOfGoogleUpvotes;
	public String category;
	public String dateLastUpdated;
	public String description;
	public int numOfInstalls;
	public String currentVersion;
	public float size;
	public ArrayList<String> similarApps;

	@Override public String toString() {
		String s = name + " " + offeredBy  + " " + contentRating  + " " + rating  + " " + numOfPeopleRated + " " + 
				this.numOfGoogleUpvotes + " " + category  + " " + this.dateLastUpdated + " " + description  + " " + this.numOfInstalls  + " " + this.currentVersion  + " " + size;
		
		for (int i = 0; i < similarApps.size(); ++i) {
			s += " " + similarApps.get(i);
		}
		
		return s;
	}
	
}
