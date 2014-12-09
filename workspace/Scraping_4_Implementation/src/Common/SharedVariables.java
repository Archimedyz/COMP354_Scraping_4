package Common;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import GUI_Controller.WindowListener;
import GUI_Views.ExportWindow;
import GUI_Views.HelpWindow;
import GUI_Views.MainWindow;
import GUI_Views.ScrapingProgressWindow;

public interface SharedVariables {
	
	enum AppDataType {
		NAME,
		SIZE,
		COMPANY,
		DESCRIPTION,
		RATING,
		CATEGORY,
		NUMBER_OF_RATERS,
		INSTALLS,
		DATE_LAST_UPDATED,
		CURRENT_VERSION,
		SIMILARAPP1,
		SIMILARAPP2,
		SIMILARAPP3
	}

	final String APP_TITLE = "Scraping Group 4";
	final String FILE_PATH_STRING = "CSV File Path:";
	final String GREETING_STRING = "Welcome to the Scraping Tool";
	final String PROGRESS_STRING = "Scraping In Progress";
	final String EXPORT_STRING = "Export Data";

	ArrayList<String> urls = new ArrayList<String>();
	Map<AppDataType, String> dataMap = new HashMap<AppDataType, String>();
	
	JButton scrapingButton = new JButton("Start Scraping");
	JButton newScrapButton = new JButton("   New Scrap  ");
	JButton helpButton = new JButton("Help");
	JButton openFileButton = new JButton("Open");
	JButton saveFileButton = new JButton("Save");
	JButton exitButton = new JButton("Exit");
	JButton doneScrap = new JButton(); // hidden button for thread to indicate it's done.
	JTextField filePathField = new JTextField(25);
	JLabel filePathLabel = new JLabel(FILE_PATH_STRING);
	JLabel windowLabel = new JLabel();
	JLabel saveFileName = new JLabel();
	JLabel saveFilePath = new JLabel();
	JPanel mainPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	WindowListener windowListener = new WindowListener();
	JFileChooser fileOpener = new JFileChooser();
	JProgressBar scrapingProgressBar = new JProgressBar(0, 100);
	JRadioButton xmlFormat = new JRadioButton("Save as XML");
	JRadioButton rdfFormat = new JRadioButton("Save as RDF");
	
	final MainWindow mainWindow = new MainWindow();
	final ScrapingProgressWindow scrapingProgressWindow = new ScrapingProgressWindow();
	final HelpWindow helpWindow = new HelpWindow();
	final ExportWindow exportWindow = new ExportWindow();
}
