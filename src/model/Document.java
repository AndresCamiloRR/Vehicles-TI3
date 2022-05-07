package model;

import java.lang.Math;

public class Document{

	protected double price;
	
	protected String year;
	
	protected int[][] picture = new int[4][4];
	
	
	public Document(double price, String year){
		
		this.price=price;
		
		this.year=year;
		
		CreatePicture();
	}
	
	public void CreatePicture(){
		
		for(int i=0; i<picture.length;i++){
			
			for(int j=0; j<picture[i].length;j++){
				
				picture[i][j]=((int)(Math.random()*100));
				
			}
			
		}
		
	}
	
	public String toString(){
		
		String propertyCard="La tarjeta de propiedad tuvo un precio de: " + price + "\nFue comprado en el ano: " + year + "\nNumero:";
		
		for(int i=0; i<picture.length;i++){
			
			for(int j=0; j<picture[0].length;j++){
				
				if((i+j)%2==0&&(i+j)!=0){
					
					propertyCard += picture[i][j] + " ";
					
				}
			}
			
		}
		
		propertyCard+="\n\nMatriz sin decodificar:\n\n";
		
		for (int i=0; i< picture.length; i++ ) { // filas picture.length
			for (int j = 0; j < picture[0].length; j++) { //columnas picture[0].length
				propertyCard += picture[i][j] + " ";
			}
			propertyCard += "\n";
		}
		
		return propertyCard;
		
	}
	
}