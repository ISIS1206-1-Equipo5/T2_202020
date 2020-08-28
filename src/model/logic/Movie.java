package model.logic;

public class Movie implements Comparable<Movie>{
	
	private int id;
	
	private int budget;

	private String genres;
	
	private String imbd_id;
	
	private String originalLanguage;
	
	private String originalTitle;
	
	private String overview;
	
	private String popularity;
	
	private String productionCompanies;
	
	private String productionCountries;
	
	private String releaseDate;
	
	private int revenue;
		
	private int runtime;
	
	private String spokenLanguages;
		
	private String status;
	
	private String tagline;
	
	private String title;
	
	private double voteAverage;
	
	private int voteCount;
	
	private int productionCompaniesNumber;
	
	private int productionCountriesNumber;
	
	private int spokenLanguagesNumber;
	
	private Casting casting;
	
	public Movie(String pId, String pBudget, String pGenres, String pImdb, String pOriginalLanguage, String pOriginalTitle, String pOverview, String pPopularity, String pProductionCompanies, String pProductionCountries, String pReleaseDate, String pRevenue, String pRuntime, String pSpokenLanguages, String pStatus, String pTagline, String pTitle, String pVoteAverage, String pVotecount, String pProductionCompaniesNumber, String pProductionCountriesNumber,String pSpokenLanguagesNumber, Casting pCasting)
	{
		id = Integer.parseInt(pId);
		budget = Integer.parseInt(pBudget);
		genres = pGenres;
		imbd_id = pImdb;
		originalLanguage = pOriginalLanguage;
		originalTitle = pOriginalTitle;
		overview = pOverview;
		popularity = pPopularity;
		productionCompanies = pProductionCompanies;
		productionCountries = pProductionCountries;
		releaseDate = pReleaseDate;
		revenue = Integer.parseInt(pRevenue);
		runtime = Integer.parseInt(pRuntime);
		spokenLanguages = pSpokenLanguages;
		status = pStatus;
		tagline = pTagline;
		title = pTitle;
		voteAverage = Double.parseDouble(pVoteAverage);
		voteCount = Integer.parseInt(pVotecount);
		productionCompaniesNumber = Integer.parseInt(pProductionCompaniesNumber);
		productionCountriesNumber = Integer.parseInt(pProductionCountriesNumber);
		spokenLanguagesNumber = Integer.parseInt(pSpokenLanguagesNumber);
		casting = pCasting;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getBudget()
	{
		return budget;
	}
	
	public String getGenres()
	{
		return genres;
	}
	
	public String[] getListGenres()
	{
		String[] listGenres = genres.split("|");
		
		return listGenres;
	}
	
	public String getImbd_id()
	{
		return imbd_id;
	}
	
	public String getOriginalLanguge()
	{
		return originalLanguage;
	}
	
	public String getOriginalTitle()
	{
		return originalTitle;
	}
	
	public String getOverview()
	{
		return overview;
	}
	
	public String getPopularity()
	{
		return popularity;
	}
	
	public String getProductionCompanies()
	{
		return productionCompanies;
	}
	
	public String getProductionCountries()
	{
		return productionCountries;
	}
	
	public String getSpokenLanguages()
	{
		return spokenLanguages;
	}
	
	public String getReleaseDate()
	{
		return releaseDate;
	}
	
	public int getRevenue()
	{
		return revenue;
	}
	
	public int getRuntime()
	{
		return runtime;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public String getTagline()
	{
		return tagline;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getVoteAverage()
	{
		return voteAverage;
	}
	
	public int getVoteCount()
	{
		return voteCount;
	}
	
	public int getProductionCompaniesNumber()
	{
		return productionCompaniesNumber;
	}
	
	public int getProdutionCountriesNumber()
	{
		return productionCountriesNumber;
	}
	
	public int getSpokenLanguagesNumber()
	{
		return spokenLanguagesNumber;
	}
	
	public Casting getCasting()
	{
		return casting;
	}
	
	public void setCasting(Casting pCasting)
	{
		casting = pCasting;
	}

	public int compareTo(Movie o) 
	{
		if(this.voteAverage < o.getVoteAverage())
			return -1;
		else if(this.voteAverage > o.getVoteAverage())
			return 1;
		else 
			return 0;				
	}
	

}
