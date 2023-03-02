package fileEngine;
import java.util.ArrayList;
import dataModel.*;
public interface IReportGenerator {
	public abstract void reportCountry(ArrayList<Country> countrylen,ArrayList<Genre> genrelen,ArrayList<Movie> movielen,String genreFor,String operation);

}
