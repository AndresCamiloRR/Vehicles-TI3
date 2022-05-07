package model;

public abstract class Vehicle implements ICalculatePrice{
	
	public final String ACTUALYEAR="2022";
	
	public int numOfDocuments=3;
	
	public int soatPlace = 0;
	
	public int mechTechPlace = 1;
	
	public int propertyCardPlace = 2;
	
	protected double basePrice;
	
	protected double salePrice;
	
	protected String brand;
	
	protected String model;
	
	protected double cylinderCapacity;
	
	protected double mileage;
	
	protected VehicleType typeV;
	
	protected String licensePlate;
	
	protected Document[] documents= new Document[numOfDocuments];
	
	public Vehicle(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents){
		
		this.basePrice=basePrice;
		
		this.brand=brand;
		
		this.model=model;
		
		this.cylinderCapacity=cylinderCapacity;
		
		this.mileage=mileage;
		
		this.typeV=typeV;
		
		this.licensePlate=licensePlate;
		
		this.documents=documents;
		
		
	}
	
	public boolean ExpiredDocumentation(){
		
		boolean out=false;
		
		if(documents[soatPlace]==null||documents[mechTechPlace]==null||(ACTUALYEAR.compareTo(documents[soatPlace].year)>0)||(ACTUALYEAR.compareTo(documents[mechTechPlace].year)>0)){
			
			out=true;
			
		}
		
		return out;
	}
	
	public boolean Used(){
		
		boolean out=false;
		
		if(typeV==VehicleType.USED){
			
			out=true;
			
		}
		
		return out;
		
	}
	
	public double CalculatePrice(){
		
		return-1;
		
	}
	
	public String toString(){
		
		String msg="Marca: " + brand + "\nModelo:" + model + "\nCilindraje: " + cylinderCapacity;  
		
		if(typeV==VehicleType.USED){
			
			msg+="\nEl vehiculo es usado" + "\nTiene un kilometraje de: " + mileage +"\nSu placa es: " + licensePlate;
			
			for(int i=0; i<documents.length;i++){
				
				if(documents[i]==null||(ACTUALYEAR.compareTo(documents[i].year)>0)){
					
					switch(i) {
						
						case 0:
							msg+="\nNo tiene soat o esta vencido";
						break;
						
						case 1:
							msg+="\nNo tiene revision tecnico mecanica o esta vencida";
						break;
						
						case 2:
							if(documents[i]!=null){
								
								msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString();
								
							}else{
								
								msg+="\nNo tiene tarjeta de propiedad";
								
							}
						break;
						
					}
					
				}else{
					
					switch(i) {
						
						case 0:
							msg+="\n"+((Soat)documents[soatPlace]).toString();
						break;
						
						case 1:
							msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString();
						break;
						
						case 2:
							msg+="\n"+(documents[propertyCardPlace]).toString();
						break;
						
					}
					
				}
				
			}
			
		}else{
			
			msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString()+"\nEl vehiculo es nuevo por lo que su kilometraje es 0, no tiene placa, ni soat, ni licensia de propiedad";
			
		}
		
		return msg;
	}
	

}
	
