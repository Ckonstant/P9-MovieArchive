package loadData;
import dataModel.*;
import java.util.ArrayList;
public interface IDataLoader {
	
	
	
	public abstract int loadAllData(ArrayList<Country> countrylen,ArrayList<Genre> genre,ArrayList<Movie> movieslen);
}
