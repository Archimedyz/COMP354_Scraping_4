package export;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// external libs
import com.thoughtworks.xstream.XStream;

public class ClassConverter {

	public static void write(ArrayList<ExportData> xmlDatas, String xmlFileNameWithoutExtension) {
		FileWriter encode = null;
		try {
			encode = new FileWriter(xmlFileNameWithoutExtension + ".xml");
			XStream xstream = new XStream();
			String xml;
			 
			for (int i = 0; i < xmlDatas.size(); ++i) {
				xml = xstream.toXML(xmlDatas.get(i));
				encode.write(xml + "\n");
			}
			
			encode.close();
		} catch (IOException e) {
			System.out.println("IOException in ClassConverter!");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ExportData> read(String xmlFileNameWithoutExtension) {
		Scanner decoder = null;
		try {
			decoder = new Scanner(
					new BufferedReader(
							new FileReader(xmlFileNameWithoutExtension + ".xml")
							)
					);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR: Could not read " + xmlFileNameWithoutExtension + ".xml, so exiting!");
			return null;
		}
		
		ArrayList<ExportData> xmlDatas = new ArrayList<ExportData>();
		
		XStream xstream = new XStream();
			
		int tagCounter = 0;
		String parsedLine = "";
		String parsedObject = "";
		while (decoder.hasNextLine()) {
			parsedLine = decoder.nextLine();
			
			if (parsedLine.contains("xml.XMLData")) {
				tagCounter++;
			}
			
			parsedObject += parsedLine;
			parsedLine = "";
			
			if (tagCounter >= 2) {
				tagCounter = 0;
				
				xmlDatas.add((ExportData)xstream.fromXML(parsedObject));
				
				parsedObject = "";
			}
		}
			
		decoder.close();
		
		xmlDatas.trimToSize();
		return xmlDatas;
	}
}
