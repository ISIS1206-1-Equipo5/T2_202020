package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.logic.Casting;
import model.logic.Movie;

public class ModeloPrueba {

	private IArregloDinamico<Movie> datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public ModeloPrueba()
	{
		datos = new ArregloDinamico<Movie>(7);
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public ModeloPrueba(int capacidad)
	{
		datos = new ArregloDinamico<Movie>(capacidad);
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
				datos.addLast(m);
			}
			
			System.out.println(datos.darElemento(2).getId());
			System.out.println(datos.darElemento(2).getCasting().getId());
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int darTamano() {
		return datos.size();
	}
	
}
