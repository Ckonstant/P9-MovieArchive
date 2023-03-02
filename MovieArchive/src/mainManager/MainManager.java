package mainManager;
import java.util.ArrayList;
import dataModel.*;
import loadData.DataLoader;
import loadData.LoaderFactory;
import loadData.IDataLoader;
import fileEngine.*;
public class MainManager implements IMainApplication  {
	private SearchManager sManager;
	private ModelManager mManager;
	private FileManager fManager;
	private ArrayList<Country> countrylen;
	private ArrayList<Genre> genrelen;
	private ArrayList<Movie> movielen;
	private IDataLoader dataLoader;
	private LoaderFactory dataLoaderFactory;
	public MainManager(){
		countrylen = new ArrayList<Country>();
		genrelen = new ArrayList<Genre>();
		movielen = new ArrayList<Movie>();
		dataLoaderFactory = new LoaderFactory();
		dataLoader = dataLoaderFactory.createDataLoader("DataLoader");
		
		
	}
	
	public  int loadAllData(){
		
		return dataLoader.loadAllData(countrylen,genrelen,movielen);
		
	}
	public void createReports(String mode,String searchFor,String operation){
		ReporterFactory reporterFactory = new ReporterFactory();
		IReportGenerator reporter = reporterFactory.createReporter(mode,searchFor,operation);
		reporter.reportCountry(countrylen,genrelen,movielen,searchFor,operation);
		
	
	}
	
	public  int loadTagsRatings(){
		
		return 0;
	}
	
	public  int submitQuery(){
		
		
		return 0;
	}
	
	public  int createFile(){
		
		return 0;
	}
}
