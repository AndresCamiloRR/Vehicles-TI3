package model;

public class Soat extends Document{
	
	/**
	*coverage double, is a variable of double type that contains the coverage that the soat has
	*/
	
	private double coverage;
	
	
	/**
	*Constructor from objects of Car type
	*@param price double, it's initialized
	*@param year String, it's initialized
	*@param coverage double, it's initialized
	*@return an object of Soat type
	*/
	
	public Soat(double price, int year, double coverage){
	
		super(price, year);
		
		this.coverage=coverage;
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the document as a message and decipher the picture for the soat
	*@return String with all the attributes
	*/
	
	public String toString(){
		
		String soat="El soat tuvo un precio de: " + getPrice() + "\nFue comprado en el ano: " + getYear() + "\nTiene una cobertura de: " + coverage + "\nNumero:";
		
		for(int i=0; i<getPicture().length; i++){
			
			
			if(i==(getPicture()).length-1){
				
				for(int j=0; j<(getPicture())[0].length; j++){
					
					soat+=(getPicture())[i][j]+" ";
					
				}
				
			}else{
				
				soat+=(getPicture())[i][0]+" ";
				
			}
			
		}
		
		soat+="\n\nMatriz sin decodificar:\n\n";
		
		for (int i=0; i< (getPicture()).length; i++ ) { // filas picture.length
			for (int j = 0; j < (getPicture())[0].length; j++) { //columnas picture[0].length
				soat += (getPicture())[i][j] + " ";
			}
			soat += "\n";
		}
		
		return soat;
		
		
	}
	
}