package dataModel;

import java.util.ArrayList;
public class Country {
	private int MovieID;
	private String countryName;
	private ArrayList<Movie> movies;
	
	public Country(){
		movies = new ArrayList<Movie>();
	}
	public Country(int  i, String n){
		MovieID = i;
		countryName = n;
		movies = new ArrayList<Movie>();
		
	}
	public int getMovieID() {
		return MovieID;
	}
	
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String country) {
		this.countryName = country;
	}
	public void setMoviedID(int id )
	{
		this.MovieID = id;
	}
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	public void addMovie(Movie m){
		movies.add(m);
	}
	
	public String getShortReport()
	{
		return MovieID +"\t id :" + countryName;
	}
}
