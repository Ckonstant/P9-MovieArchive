package fileEngine;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import dataModel.*;
import java.util.ArrayList;
public class ReportGeneratorForFiles implements IReportGenerator{
	
	
	
	public void reportCountry(ArrayList<Country> countrylen,ArrayList<Genre> genrelen,ArrayList<Movie> movielen,String searchFor,String operation)
	{
		PrintWriter outputStream = null;
		String outputFileName = "./output/results.txt";

		//Opening files for read and write, checking exception
		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening Emp report.");
			System.exit(0);
		}
		
		/*for(Country e: countrylen){
			
			outputStream.println(e.getShortReport());
		
		}*/
		
		
			
		for(Movie e: movielen){
						
				
						//e.getCountry().setCountryName("NULL");
						outputStream.println(e.getShortReport());
					
				
			} 
		
		
			
		outputStream.close();
		return;
	}
	
	
	
	
	
}
