package com.pbermejo.boletin5;

import java.io.Serializable;
	@SuppressWarnings("serial")
	public class Ej04Ticket implements Serializable{
		String visitante;
		int tipo;
		int precio;
	
		public Ej04Ticket(String v, int t){
			visitante=v;
			tipo=t;
			precio=calcula(t);
		}
		
		int calcula(int tipo){//Calcula el precio en función del tipo.
			int t=tipo;
			switch(t){
				case 0:return 10;
				case 1:return 3;
				case 2:return 5;
				case 3:return 4;
				default: return -1;
				}
			}
		
	String getVisitante(){return visitante;}
	
	int getTipo(){return tipo;}
	
	String muestraTipo(int tipo){
		int t=tipo;
		switch(t){
			case 0:return "Normal";
			case 1:return "Niños";
			case 2:return "Carnet joven";
			case 3:return "3ª edad";
			default: return "Tipo desconocido";
			}
	}
	
	int getPrecio(){return precio;}
	
	
}