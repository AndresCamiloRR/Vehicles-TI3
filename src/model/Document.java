package model;

import java.lang.Math;

public class Document{
	
	/**
	*price double, is a variable of double type that contains the price of the document
	*/
	
	protected double price;
	
	/**
	*year String, is a variable of String type that contains the year of the document
	*/
	
	protected String year;
	
	/**
	*picture int, is a matrix of String type that contains a picture of the document number
	*/
	
	protected int[][] picture = new int[4][4];
	
	/**
	*Constructor from objects of Document type
	*@param price double, it's initialized
	*@param year String, it's initialized
	*@return an object of Document type
	*/
	
	public Document(double price, String year){
		
		this.price=price;
		
		this.year=year;
		
		CreatePicture();
	}
	
	/**
	*Method that creates a random picture with the number of the document
	*@return an object of Car type
	*/
	
	public void CreatePicture(){
		
		for(int i=0; i<picture.length;i++){
			
			for(int j=0; j<picture[i].length;j++){
				
				picture[i][j]=((int)(Math.random()*100));
				
			}
			
		}
		
	}
	
	/**
	*Method that returns all the info from the document as a message and decipher the picture for the property card
	*@return String with all the attributes
	*/
	
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