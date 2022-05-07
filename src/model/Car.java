package model;

public abstract class Car extends Vehicle{

	private CarType typeC;
	
	private int numOfDoors;
	
	private boolean tintedWindows;
	
	
	public Car(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, boolean tintedWindows){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents);
		
		this.typeC=typeC;
		
		this.numOfDoors=numOfDoors;
		
		this.tintedWindows=tintedWindows;
		
	}
	
	@Override
	
	public String toString(){
		
		String msg=super.toString();
		
		msg+="\nEl carro es un ";
		
		if(typeC==CarType.SEDAN){
			
			msg+="Sedan ";
			
		}else{
			
			msg+="Pick up ";
			
		}
		
		msg+="\nTiene " + numOfDoors + " puertas ";
		
		if(tintedWindows){
			
			msg+="\nSus vidrios son polarizados";
			
		}else{
			
			msg+="\nSus vidrios no son polarizados";
			
		}
		
		return msg;
		
	}

}