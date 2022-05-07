package model;

public class MechTechReview extends Document{
	
	private String gasLevels;
	
	
	public MechTechReview(double price, String year, String gasLevels){
	
		super(price, year);
		
		this.gasLevels=gasLevels;
		
	}
	
	@Override
	
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