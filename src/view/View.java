package view;

import model.data_structures.ArregloDinamico;
import model.logic.Actor;
import model.logic.Modelo;
import model.logic.Movie;

public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Cargar información de las películas");
		System.out.println("2. Buscar las buenas películas de un director");
		System.out.println("3. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		


	public void printMovieInfo(Movie pMovie) {
		Actor[] actores = pMovie.getCasting().getActors();
		String nombresActores = "";
		for(Actor a : actores)
		{
			if(a!= null)
				nombresActores += a.getName() + " | ";
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("ID: " + pMovie.getId() + "\n" +
						   "Título: " + pMovie.getTitle() + "\n" + 
						   "Géneros: " + pMovie.getGenres() + "\n" + //TODO arreglar esto
						   "Fecha de estreno : "+ pMovie.getReleaseDate() + "\n" + 
						   "Actores: " + nombresActores); //TODO arreglar esto
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void printMoviesInfo(ArregloDinamico<Movie> pMovies) {
		
		System.out.println("Películas encontradas: " + pMovies.size());
		
		for(int i = 1; i < pMovies.size(); i++)
		{
			printMovieInfo(pMovies.getElement(i));
		}
		
	}
}
