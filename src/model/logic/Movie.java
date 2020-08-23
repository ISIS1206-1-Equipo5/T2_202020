package model.logic;

import com.opencsv.bean.CsvBindByPosition;

public class Movie implements Comparable<Movie>{
	
	@CsvBindByPosition(position = 0)
	private int id;
	
	@CsvBindByPosition(position = 1)
	private int budget;

	@CsvBindByPosition(position = 2)
	private String genres;
	
	@CsvBindByPosition(position = 3)
	private String imbd_id;
	
	@CsvBindByPosition(position = 4)
	private String originalLanguage;
	
	@CsvBindByPosition(position = 5)
	private String originalTitle;
	
	@CsvBindByPosition(position = 6)
	private String overview;
	
	@CsvBindByPosition(position = 7)
	private double popularity;
	
	@CsvBindByPosition(position = 8)
	private String productionCompanies;
	
	@CsvBindByPosition(position = 9)
	private String productionCountries;
	
	@CsvBindByPosition(position = 10)
	private String releaseDate;
	
	@CsvBindByPosition(position = 11)
	private int revenue;
		
	@CsvBindByPosition(position = 12)
	private int runtime;
	
	@CsvBindByPosition(position = 13)
	private String spokenLanguages;
		
	@CsvBindByPosition(position = 14)
	private String status;
	
	@CsvBindByPosition(position = 15)
	private String tagline;
	
	@CsvBindByPosition(position = 16)
	private String title;
	
	@CsvBindByPosition(position = 17)
	private double voteAverage;
	
	@CsvBindByPosition(position = 18)
	private int voteCount;
	
	@CsvBindByPosition(position = 19)
	private int productionCompaniesNumber;
	
	@CsvBindByPosition(position = 20)
	private int productionCountriesNumber;
	
	@CsvBindByPosition(position = 21)
	private int spokenLanguagesNumber;
	
	private Casting casting;
	
	
	public Movie(int pId, int pBudget, String pGenres, String pImbd_id, String pOriginalLanguage, String pOrigninalTitle, String pOverview, double pPopularity, String pProductionCompanies, String pProductionCountries, String pReleaseDate, int pRevenue, String pSpokenLanguages, int pRuntime,String pStatus, String pTagline, String pTitle, double pVoteAverage, int pVoteDiscount, int pPCompNumber, int pPCountNumber, int pSpokenLanNumber)
	{
		id = pId;
		budget = pBudget;
		genres = pGenres;
		imbd_id = pImbd_id;
		originalLanguage = pOriginalLanguage;
		originalTitle = pOrigninalTitle;
		overview = pOverview;
		popularity = pPopularity;
		productionCompanies = pProductionCompanies;
		productionCountries = pProductionCountries;
		spokenLanguages = pSpokenLanguages;
		releaseDate = pReleaseDate;
		revenue = pRevenue;
		runtime = pRuntime;
		status = pStatus;
		tagline = pTagline;
		title = pTitle;
		voteAverage = pVoteAverage;
		productionCompaniesNumber = pPCompNumber;
		productionCountriesNumber = pPCountNumber;
		spokenLanguagesNumber = pSpokenLanNumber;
		casting = null;
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
	
	public double getPopularity()
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

	@Override
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
