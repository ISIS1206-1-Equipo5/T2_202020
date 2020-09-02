package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;

public class MovieCatalog {

	//CONSTANTES

	private static int POSSITIVE_AVERAGE = 6;
	public static int ARREGLO_DINAMICO = 1;
	public static int LISTA_ENCADENADA = 2;
	//ATRIBUTOS

	private ILista<Movie> movies;

	//CONSTRUCTORES
	public MovieCatalog(int estructura) {
		if(estructura == ARREGLO_DINAMICO)
			movies = new ArregloDinamico<Movie>(1);
		else if(estructura== LISTA_ENCADENADA) 
			movies = new ListaEncadenada<Movie>();
	}

	//MÉTODOS
	public void readData(String path1, String path2, int pEstructura)
	{
		movies = null;

		if(pEstructura == ARREGLO_DINAMICO)
			movies = new ArregloDinamico<Movie>(1);

		else if(pEstructura== LISTA_ENCADENADA) 
			movies = new ListaEncadenada<Movie>();

		try {
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
			CSVReader readerCasting = new CSVReaderBuilder(new FileReader(path2)).withCSVParser(parser).withSkipLines(1).build();
			
			CSVReader readerMovie = new CSVReaderBuilder(new FileReader(path1)).withCSVParser(parser).withSkipLines(1).build();

			String [] nextLineCasting;
			String[] nextLineMovies;
			while ((nextLineCasting = readerCasting.readNext()) != null && (nextLineMovies = readerMovie.readNext()) != null) {
				String pIdC = nextLineCasting[0];
				String actor1Name = nextLineCasting[1];
				String actor1Gender = nextLineCasting[2];
				String actor2Name = nextLineCasting[3];
				String actor2Gender = nextLineCasting[4];
				String actor3Name = nextLineCasting[5];
				String actor3Gender = nextLineCasting[6];
				String actor4Name = nextLineCasting[7];
				String actor4Gender = nextLineCasting[8];
				String actor5Name = nextLineCasting[9];
				String actor5Gender = nextLineCasting[10];
				String pActorNumber = nextLineCasting[11];
				String directorName = nextLineCasting[12];
				String directorGender = nextLineCasting[13];
				String pDirectorNumber = nextLineCasting[14];
				String pProducerName = nextLineCasting[15];
				String pProducerNumber = nextLineCasting[16];
				String screenplayName = nextLineCasting[17];
				String editorName = nextLineCasting[18];
				
				String pIdM = nextLineMovies[0];
				String pBudget = nextLineMovies[1];
				String pGenres = nextLineMovies[2];
				String pImdb = nextLineMovies[3];
				String pOriginalLanguage = nextLineMovies[4];
				String pOriginalTitle = nextLineMovies[5];
				String pOverview = nextLineMovies[6];
				String pPopularity = nextLineMovies[7];
				String pProductionCompanies = nextLineMovies[8];
				String pProductionCountries = nextLineMovies[9];
				String pReleaseDate = nextLineMovies[10];
				String pRevenue = nextLineMovies[11];
				String pRuntime = nextLineMovies[12];
				String pSpokenLanguages = nextLineMovies[13];
				String pStatus = nextLineMovies[14];
				String pTagline = nextLineMovies[15];
				String pTitle = nextLineMovies[16];
				String pVoteAverage = nextLineMovies[17];
				String pVotecount = nextLineMovies[18];
				String pProductionCompaniesNumber = nextLineMovies[19];
				String pProductionCountriesNumber = nextLineMovies[20];
				String pSpokenLanguagesNumber = nextLineMovies[21];

				Casting pCasting = new Casting(pIdC, actor1Name, actor1Gender, actor2Name, actor2Gender, actor3Name, actor3Gender, actor4Name, actor4Gender, actor5Name, actor5Gender, pActorNumber, directorName, directorGender, pDirectorNumber, pProducerName, pProducerNumber, screenplayName, editorName);
				Movie m = new Movie(pIdM, pBudget, pGenres, pImdb, pOriginalLanguage, pOriginalTitle, pOverview, pPopularity, pProductionCompanies, pProductionCountries, pReleaseDate, pRevenue, pRuntime, pSpokenLanguages, pStatus, pTagline, pTitle, pVoteAverage, pVotecount, pProductionCompaniesNumber, pProductionCountriesNumber, pSpokenLanguagesNumber, pCasting);
				if(pEstructura == ARREGLO_DINAMICO)
					movies.addLast(m);
				else if(pEstructura == LISTA_ENCADENADA)
					movies.addFirst(m);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addMovie(Movie movie)
	{
		movies.addLast(movie);
	}


	public Movie[] goodMoviesByDirectorName(String name) throws Exception 
	{
		ArregloDinamico<Movie> goodMovies = new ArregloDinamico<>(1);

		for(int i = 0; i< movies.size(); i++)
		{
			Movie m = movies.getElement(i+1);

			if(m.getVoteAverage()>= POSSITIVE_AVERAGE && m.getCasting().getDirector().getName().equals(name))
				goodMovies.addLast(m);
		}

		if(goodMovies.isEmpty())
		{
			throw new Exception("No se encontro el director o el director no tiene buenas peliculas");
		}
		
		Movie[] arregloFijo = new Movie[goodMovies.size()];

		for(int i = 0; i< goodMovies.size(); i++)
		{
			Movie m = goodMovies.getElement(i+1);
			arregloFijo[i] = m;
		}
		return arregloFijo;
	}

	public int getMovieCount() {
		return movies.size();
	}

	//TODO Revisar el manejo de la excepcion 
	public Movie getFirstMovie() throws Exception{
		try {
			return movies.firstElement();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	//TODO Revisar el manejo de la excepcion 
	public Movie getLastMovie()  throws Exception{
		try {
			return movies.lastElement();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Movie[] getStructureArray() {
		Movie[] arregloFijo = new Movie[movies.size()];

		for(int i = 0; i< movies.size(); i++)
		{
			Movie m = movies.getElement(i+1);
			arregloFijo[i] = m;
		}
		return arregloFijo;
	}
	
	public Movie[] getWorstMovies()
	{
		Movie[] arreglo= this.getStructureArray();
		Movie[] worseMovies = new Movie[20];
		ShellSort.shellSort(arreglo);
		
		int i = 0;
		int j = 0;
		
		while(i<worseMovies.length && j<arreglo.length)
		{
			if(arreglo[j].getVoteCount() != 0)
			{
				worseMovies[i] = arreglo[j];
				i++;
			}			
			j++;			
		}
		
		return worseMovies;
	}


}
