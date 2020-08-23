package model.logic;

public class Movie implements Comparable<Movie>{
	
	private int id;
	
	private int budget;
	
	private String imbd_id;
	
	private String originalLanguage;
	
	private String originalTitle;
	
	private String overview;
	
	private double popularity;
	
	private String productionCompanies;
	
	private String productionCountries;
	
	private String releaseDate;
	
	private int revenue;
	
	private String status;
	
	private String tagline;
	
	private String title;
	
	private double voteAverage;
	
	private int voteCount;
	
	private int productionCompaniesNumber;
	
	private int productionCountriesNumber;
	
	private int spokenLanguagesNumber;
	
	private Casting casting;
	
	
	public Movie(int pId, int pBudget, String pImbd_id, String pOriginalLanguage, String pOrigninalTitle, String pOverview, double pPopularity, String pProductionCompanies, String pProductionCountries, String pReleaseDate, int pRevenue, String pStatus, String pTagline, String pTitle, double pVoteAverage, int pVoteDiscount, int pPCompNumber, int pPCountNumber, int pSpokenLanNumber)
	{
		id = pId;
		budget = pBudget;
		imbd_id = pImbd_id;
		originalLanguage = pOriginalLanguage;
		originalTitle = pOrigninalTitle;
		overview = pOverview;
		popularity = pPopularity;
		productionCompanies = pProductionCompanies;
		productionCountries = pProductionCountries;
		releaseDate = pReleaseDate;
		revenue = pRevenue;
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
	
	public String getReleaseDate()
	{
		return releaseDate;
	}
	
	public int getRevenue()
	{
		return revenue;
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
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
