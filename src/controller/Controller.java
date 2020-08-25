package controller;

import java.util.Scanner;

import model.logic.MovieCatalog;
import view.View;

public class Controller {

	/* Instancia del catalogo*/
	private MovieCatalog catalogo;

	/* Instancia de la Vista*/
	private View view;

	private static final String PATH_CASTING_PELICULAS = "./data/MoviesCastingRaw-small.csv";

	private static final String PATH_INFO_PELICULAS = "./data/SmallMoviesDetailsCleaned.csv";

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		catalogo = new MovieCatalog();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nSe estan cargando los datos ");
				catalogo.readData(PATH_INFO_PELICULAS, PATH_CASTING_PELICULAS);
				view.printMessage("Catalogo creado");
				//TODO Revisar el manejo de la excepción
				try
				{
					view.printMovieInfo(catalogo.getFirstMovie());
					view.printMovieInfo(catalogo.getLastMovie());
				}
				catch(Exception e)
				{
					view.printMessage(e.getMessage());
				}
				view.printMessage("Se encontraron  " + catalogo.getMovieCount() + " peliculas " + "\n----------------------------------------------------------------------------------------------------------------------------------------------------------");						
				break;

			case 2:
				view.printMessage("--------- \nDar el nombre completo del director a buscar:");
				String name = lector.next();
				String lastname = lector.next();

				String mensaje = name + " " + lastname;
				try {

					view.printMoviesInfo(catalogo.goodMoviesByDirectorName(mensaje));
					break;
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}						


			case 3: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
