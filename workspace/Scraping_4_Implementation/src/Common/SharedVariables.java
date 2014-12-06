package Common;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import GUI_Controller.WindowListener;
import GUI_Views.*;

public interface SharedVariables {

	final MainWindow mainWindow = new MainWindow();
	final ScrapingProgressWindow scrapingProgressWindow = new ScrapingProgressWindow();
	final HelpWindow helpWindow = new HelpWindow();
	final ExportWindow exportWindow = new ExportWindow();
	final String APP_TITLE = "Scraping Group 4";
	final String FILE_PATH_STRING = "CSV File Path:";
	final String GREETING_STRING = "Welcome to the Scraping Tool";
	JButton scrapingButton = new JButton("Start Scraping");
	JButton helpButton = new JButton("Help");
	JButton openFileButton = new JButton("Open");
	JButton exitButton = new JButton("Exit");
	JTextField filePathField = new JTextField(25);
	JLabel filePathLabel = new JLabel(FILE_PATH_STRING);
	JLabel greetingLabel = new JLabel(GREETING_STRING);
	JPanel mainPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	WindowListener windowListener = new WindowListener();
	JFileChooser fileOpener = new JFileChooser();
	JProgressBar scrapingProgressBar = new JProgressBar(0, 100);
}
