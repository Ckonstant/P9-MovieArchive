package dataModel;
import java.util.ArrayList;

public class Genre {
	private int MovieID;
	private String genre;
	private ArrayList<Movie> movies;
	public Genre()
	{
		movies = new ArrayList<Movie>();
	}
	public Genre(int i, String g)
	{
		MovieID = i;
		genre = g;
		movies = new ArrayList<Movie>();
	}
	public int getMovieID()
	{
		return MovieID;
		
	}
	public void setMovieID(int id)
	{
		this.MovieID = id;
	}
	public String getGenre()
	{
		return genre;
	}
	public void setGenre(String ge)
	{
		this.genre = ge;
	}
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	public void addMovie(Movie m){
		movies.add(m);
	}
	public String getShortReport()
	{
		return MovieID +"\t id :" + genre +"\t GENRESSS:"+"size movie:" +movies.size();
	}
}
