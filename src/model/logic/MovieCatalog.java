package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

public class MovieCatalog {
	
	//CONSTANTES
	
	private static int POSSITIVE_AVERAGE = 6;
	//ATRIBUTOS
	
	private IArregloDinamico<Movie> movies;
	
	//CONSTRUCTORES
	public MovieCatalog() {
		movies = new ArregloDinamico<Movie>(0);
	}
	
	public MovieCatalog(int capacidad) {
		movies = new ArregloDinamico<Movie>(capacidad);
	}
	
	//MÉTODOS
	public void readData(String path1, String path2)
	{
		try {
			
			List<Movie> infoPeliculas = new CsvToBeanBuilder(new FileReader(path1)).withType(Movie.class).withSeparator(';').withSkipLines(1).build().parse();
			List<Casting> infoCasting = new CsvToBeanBuilder(new FileReader(path2)).withType(Casting.class).withSeparator(';').build().parse();

			
			for(int i = 0; i < infoPeliculas.size(); i++)
			{
				Movie m = infoPeliculas.get(i);
				m.setCasting(infoCasting.get(i));
				movies.addLast(m);
			}
			
			System.out.println(movies.darElemento(2).getId());
			System.out.println(movies.darElemento(2).getCasting().getId());
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addMovie(Movie movie)
	{
		movies.addLast(movie);
	}
	
	
	public ArregloDinamico<Movie> goodMoviesByDirectorName(String name) throws Exception{
		ArregloDinamico<Movie> goodMovies = new ArregloDinamico<>(0);
		
		for(int i = 1; i< movies.size(); i++)
		{
			Movie m = movies.getElement(i);
			
			if(m.getVoteAverage()>= POSSITIVE_AVERAGE && m.getCasting().getDirector().getName().equals(name))
				goodMovies.addLast(m);
		}
		
		if( goodMovies.isEmpty())
		{
			throw new Exception("No se encontró el director o el driector no tiene buenas películas");
		}
		
		return goodMovies;
	}

	public int getMovieCount() {
		return movies.size();
	}

	public Movie getFirstMovie() {
		return movies.firstElement();
	}

	public Movie getLastMovie() {
		return movies.lastElement();
	}


}
