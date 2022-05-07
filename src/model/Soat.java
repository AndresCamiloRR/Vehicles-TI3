package model;

public class Soat extends Document{
	
	private double coverage;
	
	
	public Soat(double price, String year, double coverage){
	
		super(price, year);
		
		this.coverage=coverage;
		
	}
	
	@Override
	
	public String toString(){
		
		String soat="El soat tuvo un precio de: " + price + "\nFue comprado en el ano: " + year + "\nTiene una cobertura de: " + coverage + "\nNumero:";
		
		for(int i=0; i<picture.length; i++){
			
			
			if(i==picture.length-1){
				
				for(int j=0; j<picture[0].length; j++){
					
					soat+=picture[i][j]+" ";
					
				}
				
			}else{
				
				soat+=picture[i][0]+" ";
				
			}
			
		}
		
		soat+="\n\nMatriz sin decodificar:\n\n";
		
		for (int i=0; i< picture.length; i++ ) { // filas picture.length
			for (int j = 0; j < picture[0].length; j++) { //columnas picture[0].length
				soat += picture[i][j] + " ";
			}
			soat += "\n";
		}
		
		return soat;
		
		
	}
	
}