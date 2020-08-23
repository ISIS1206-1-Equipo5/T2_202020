package model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

public class MovieCatalog {
	
	private IArregloDinamico<Movie> movies;
	
	public MovieCatalog() {
		movies = new ArregloDinamico<Movie>(0);
	}
	
	public MovieCatalog(int capacidad) {
		movies = new ArregloDinamico<Movie>(capacidad);
	}
	
	public void readData(String path1, String path2)
	{
		try {
			
			List<Movie> infoPeliculas = new CsvToBeanBuilder(new FileReader(path1)).withType(Movie.class).withSeparator(';').build().parse();
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

}
