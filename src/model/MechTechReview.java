package model;

public class MechTechReview extends Document{
	
	/**
	*gasLevels String, is a variable of String type that contains the gasLevels registered in the mechanical technical review
	*/
	
	private String gasLevels;
	
	/**
	*Constructor from objects of Car type
	*@param price double, it's initialized
	*@param year String, it's initialized
	*@param gasLevels String, it's initialized
	*@return an object of Document type
	*/
	
	public MechTechReview(double price, String year, String gasLevels){
	
		super(price, year);
		
		this.gasLevels=gasLevels;
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the document as a message and decipher the picture for the mechanical technical review
	*@return String with all the attributes
	*/
	
	public String toString(){
		
		String mechTech="La revision tecnico mecanica tuvo un precio de: " + price + "\nFue comprado en el ano: " + year + "\nY el nivel de los gases es: " + gasLevels + "\nNumero:";
		
		for(int i=0; i<picture.length; i++){
			
			if(i==0){
				
				for(int j=0; j<picture[0].length; j++){
					
					mechTech+=picture[i][j]+" ";
					
				}
				
			}else if(i==picture.length-1){
				
				for(int j=0; j<picture[0].length; j++){
					
					mechTech+=picture[i][j]+" ";
					
				}
				
			}else{
				
				mechTech+=picture[i][picture.length-i-1]+" ";
				
			}
			
			
		}
		
		mechTech+="\n\nMatriz sin decodificar:\n\n";
		
		for (int i=0; i< picture.length; i++ ) { // filas picture.length
			for (int j = 0; j < picture[0].length; j++) { //columnas picture[0].length
				mechTech += picture[i][j] + " ";
			}
			mechTech += "\n";
		}
		
		return mechTech;
		
	}
	
}