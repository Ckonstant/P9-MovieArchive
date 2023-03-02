package loadData;

import java.util.ArrayList;
import java.util.TreeMap;
import dataModel.Country;

public class CountryLoader extends AbstractRecordLoader<Country>{
public CountryLoader(){
		
		
	}

	public int constructObjectFromRow(String[] tokens, ArrayList<Country> countrylen) {
		int MovieID;
		String country;
		MovieID = Integer.parseInt(tokens[0]);
		country = tokens[1];
		Country c  = new Country(MovieID,country);
		
		countrylen.add(c);
		
		return 0;
	}
	

}
