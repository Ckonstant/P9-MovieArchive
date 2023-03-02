package loadData;

import java.util.ArrayList;

import dataModel.Genre;

public class GenreLoader extends AbstractRecordLoader<Genre> {

	public int constructObjectFromRow(String[] tokens, ArrayList<Genre> genrelen) {
		int MovieID;
		String genre;
		MovieID = Integer.parseInt(tokens[0]);
		genre = tokens[1];
		Genre c  = new Genre(MovieID,genre);
		genrelen.add(c);
		
		return 0;
	}
}
