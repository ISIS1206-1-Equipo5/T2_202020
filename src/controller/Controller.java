package controller;

import java.util.Scanner;

import model.logic.MovieCatalog;
import model.logic.Stopwatch;
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
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int estructura = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \n¿A qué estructura de datos desea cargar?");
				view.printMessage("\n1.Arreglo Dinámico");
				view.printMessage("2.Lista encadenada");
				estructura = lector.nextInt();
				catalogo = new MovieCatalog(estructura);
				view.printMessage("--------- \nSe estan cargando los datos ");
				Stopwatch timer = new Stopwatch();
				catalogo.readData(PATH_INFO_PELICULAS, PATH_CASTING_PELICULAS, estructura);
				double tiempo = timer.elapsedTime();
				view.printMessage("Catalogo creado");
				//TODO Revisar el manejo de la excepci�n
				try
				{
					view.printMovieInfo(catalogo.getFirstMovie());
					view.printMovieInfo(catalogo.getLastMovie());
				}
				catch(Exception e)
				{
					view.printMessage(e.getMessage());
				}
				view.printMessage("Se encontraron " + catalogo.getMovieCount() + " peliculas " + "\n----------------------------------------------------------------------------------------------------------------------------------------------------------");		
				view.printMessage("Los datos fueron cargados en " + tiempo + " segundos.");
				break;

			case 2:
				view.printMessage("--------- \nDar el nombre completo del director a buscar:");
				String name = lector.next();
				String lastname = lector.next();

				String mensaje = name + " " + lastname;
				try {
					if(catalogo != null)
						view.printMoviesInfo(catalogo.goodMoviesByDirectorName(mensaje));
					else
						System.out.println("No se han cargado los datos." );
					break;
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}						
			
			case 3: 
				view.printMessage("Las 20 películas con el peor promedio de votación son:");
				try {
					if(catalogo != null)
						view.printMoviesInfo(catalogo.getWorstMovies());
					else
						System.out.println("No se han cargado los datos." );
					break;
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}

			case 4: 
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
