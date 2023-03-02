package loadData;
import java.util.ArrayList;

import dataModel.*;

public class DataLoader implements IDataLoader{
	private LoaderFactory loaderFactory;
	private AbstractRecordLoader loader;
	private String countryFile ;
	private String genreFile;
	private String actorsFile;
	private String moviesFile;
	private String locationFile;
	private CountryLoader countryLoader;
	private GenreLoader genreLoader;
	private MovieLoader movieLoader;
	public DataLoader(){
		countryFile = "./input/movie_countries.dat";
		countryLoader = new CountryLoader();
		genreFile = "./input/movie_genres.dat";
		genreLoader = new GenreLoader();
		moviesFile ="./input/movies.dat";
		movieLoader = new MovieLoader();
		
	}

public void assignCountries(ArrayList<Country> countrylen, ArrayList<Movie> movies)
{
	for(Movie o:movies)
	{
		
		int movieID = o.getID();
		for (Country d: countrylen){
			
			if (d.getMovieID()==movieID){
				
				d.addMovie(o);
				o.setCountry(d);
			}
			
		}
		
	}
}	
public void assignGenres(ArrayList<Genre> genrelen, ArrayList<Movie> movies)
	{
		for(Movie o:movies)
		{
			int movieID = o.getID();
			for (Genre d: genrelen){
				if (d.getMovieID()==movieID){
					d.addMovie(o);
					o.setGenre(d);
				}
			}
			
		}
	}

	
	@Override
	public int loadAllData(ArrayList<Country> countrylen,ArrayList<Genre> genrelen,ArrayList<Movie> movielen) {
		countryLoader.load(countryFile, "\t", true, 2, countrylen);
		genreLoader.load(genreFile, "\t", true, 2, genrelen);
		movieLoader.load(moviesFile, "\t" , true, 2, movielen);
		assignCountries(countrylen,movielen);
		assignGenres(genrelen,movielen);
		return 0;
	}
}
