package loadData;

import java.util.ArrayList;
import java.util.TreeMap;

import dataModel.Country;
import dataModel.Movie;
import dataModel.Genre;

public class MovieLoader extends AbstractRecordLoader<Movie>{
	private int id;	
	private String title;	
	
	
	
	public MovieLoader(){
	
		
	}
	public int constructObjectFromRow(String[] tokens, ArrayList<Movie> movies) {
		int id;	
		String title;	
		id = Integer.parseInt(tokens[0]);
		title = tokens[1];
		Movie  mov  = new Movie(id,title);
		
		movies.add(mov);
		return 0;
	}
	
}

