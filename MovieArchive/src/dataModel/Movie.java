package dataModel;

public class Movie {
	private int id;	
	private String title;	
	private Genre genr;
	private Country count = null;
	public Movie(){
		
	}
	public Movie(int i, String titl)
	{
		id =i;
		title = titl;
		genr = null;
		count = null;
	}
	public Genre getGenre()
	{
		return genr;
		
	}
	public void setGenre(Genre g)
	{
		this.genr = g;
	}
	public Country getCountry()
	{
		return count;
	}
	public void setCountry(Country c)
	{
		this.count = c;
		
	}
	
	
	public int getID()
	{
		return id;
	}
	public void setID(int i)
	{
		this.id = i;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String tit)
	{
		this.title = tit;
	}
	public String getShortReport()
	{
		return "title: " + title +"Country Name: "+genr.getGenre();
	}
}
