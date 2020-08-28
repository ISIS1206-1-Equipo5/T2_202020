package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;

public class MovieCatalog {

	//CONSTANTES

	private static int POSSITIVE_AVERAGE = 6;
	public static int ARREGLO_DINAMICO = 1;
	public static int LISTA_ENCADENADA = 2;
	//ATRIBUTOS

	private IArregloDinamico<Movie> moviesArregloDinamico;

	private ILista<Movie> moviesListaEncadenada;

	//CONSTRUCTORES
	public MovieCatalog() {
		moviesArregloDinamico = new ArregloDinamico<Movie>(1);
		moviesListaEncadenada = new ListaEncadenada<Movie>(0);
	}

	public MovieCatalog(int capacidad) {
		moviesArregloDinamico = new ArregloDinamico<Movie>(capacidad);
	}

	//MÉTODOS
	public void readDataArregloDinamico(String path1, String path2, int pEstructura)
	{
		try {
			List<Movie> infoPeliculas = new CsvToBeanBuilder(new FileReader(path1)).withType(Movie.class).withSeparator(';').withSkipLines(1).build().parse();
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(path2)).withCSVParser(parser).withSkipLines(1).build();
			String [] nextLine;
			int i = 0;
			while ((nextLine = reader.readNext()) != null) {
				String pId = nextLine[0];
				String actor1Name = nextLine[1];
				String actor1Gender = nextLine[2];
				String actor2Name = nextLine[3];
				String actor2Gender = nextLine[4];
				String actor3Name = nextLine[5];
				String actor3Gender = nextLine[6];
				String actor4Name = nextLine[7];
				String actor4Gender = nextLine[8];
				String actor5Name = nextLine[9];
				String actor5Gender = nextLine[10];
				String pActorNumber = nextLine[11];
				String directorName = nextLine[12];
				String directorGender = nextLine[13];
				String pDirectorNumber = nextLine[14];
				String pProducerName = nextLine[15];
				String pProducerNumber = nextLine[16];
				String screenplayName = nextLine[17];
				String editorName = nextLine[18];

				if(pEstructura == ARREGLO_DINAMICO)
				{
					Movie m = infoPeliculas.get(i);
					m.setCasting(new Casting(pId, actor1Name, actor1Gender, actor2Name, actor2Gender, actor3Name, actor3Gender, actor4Name, actor4Gender, actor5Name, actor5Gender, pActorNumber, directorName, directorGender, pDirectorNumber, pProducerName, pProducerNumber, screenplayName, editorName));
					moviesArregloDinamico.addLast(m);
					i++;
				}
				else if(pEstructura == LISTA_ENCADENADA)
				{
					Movie m = infoPeliculas.get(i);
					m.setCasting(new Casting(pId, actor1Name, actor1Gender, actor2Name, actor2Gender, actor3Name, actor3Gender, actor4Name, actor4Gender, actor5Name, actor5Gender, pActorNumber, directorName, directorGender, pDirectorNumber, pProducerName, pProducerNumber, screenplayName, editorName));
					moviesListaEncadenada.addFirst(m);
					i++;
				}
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
		moviesArregloDinamico.addLast(movie);
	}


	public ArregloDinamico<Movie> goodMoviesByDirectorName(String name) throws Exception 
	{
		ArregloDinamico<Movie> goodMovies = new ArregloDinamico<>(1);

		for(int i = 0; i< moviesArregloDinamico.size(); i++)
		{
			Movie m = moviesArregloDinamico.getElement(i+1);

			if(m.getVoteAverage()>= POSSITIVE_AVERAGE && m.getCasting().getDirector().getName().equals(name))
				goodMovies.addLast(m);
		}

		if(goodMovies.isEmpty())
		{
			throw new Exception("No se encontro el director o el director no tiene buenas peliculas");
		}

		return goodMovies;
	}

	public int getMovieCount() {
		return moviesArregloDinamico.size();
	}

	//TODO Revisar el manejo de la excepcion 
	public Movie getFirstMovie() throws Exception{
		try {
			return moviesArregloDinamico.firstElement();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	//TODO Revisar el manejo de la excepcion 
	public Movie getLastMovie()  throws Exception{
		try {
			return moviesArregloDinamico.lastElement();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


}
