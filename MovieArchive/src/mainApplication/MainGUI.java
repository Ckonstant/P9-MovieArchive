package mainApplication;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dataModel.Country;
import mainManager.IMainApplication;
import mainManager.MainEngineFactory;
import mainManager.MainManager;
import dataModel.*;
public class MainGUI extends JFrame{
private Scanner reader = new Scanner(System.in).useDelimiter(System.lineSeparator());
private JTextField text;
private JEditorPane display;	
	
	public int printMenu(){
		
		int answer = 0 ;
		
		while(answer>5 || answer<=0){
			
			System.out.println("Choose (1-5): 1. Load movie data\n 2. Load tags/ratngs\n"
					+ "3. Submit query\n 4. Create file\n 5. Exit\n");
			answer = reader.nextInt();
			
			if (answer > 5 || answer <= 0)
				System.out.println("Wrong input");
		}
		
		return answer;
		
		}
public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String answer;
		MainEngineFactory mainEngineFactory = new MainEngineFactory();
		IMainApplication mainEngine  = mainEngineFactory.createMainEngine();
		// IMainApplication manager = new MainManager();
		MainGUI app = new MainGUI();
		int operation;
		ArrayList<Movie> movies;
		while (true){
			
			operation = app.printMenu();
			
			if (operation == 1)
				
				mainEngine.loadAllData();
			else if (operation == 2)
			{
				mainEngine.createReports("ReportGeneratorForFiles","France","1");
				
			}
			else if(operation == 3)
			{
				System.out.println("dose ton titlo tis tainias");
				answer = read.nextLine();
			}
			else
				break;
			
			
		}

		
		
	}
	
}
