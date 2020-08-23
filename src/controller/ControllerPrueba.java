package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class ControllerPrueba {

	/* Instancia del Modelo*/
	private ModeloPrueba modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public ControllerPrueba ()
	{
		view = new View();
		modelo = new ModeloPrueba();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer dato = 0;
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				int capacidad = lector.nextInt();
				modelo = new ModeloPrueba(capacidad); 
				view.printMessage("Arreglo Dinamico creado");
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 2:
				modelo.readData("./data/SmallMoviesDetailsCleaned.csv", "./data/MoviesCastingRaw-small.csv");
				view.printMessage("Datos agregados");
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 5:
				
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}
}
