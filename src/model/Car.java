package model;

import javax.swing.RowFilter.ComparisonType;

public abstract class Car extends Vehicle{
	
	/**
	*typeC CarType, is a variable of CarType wich tell us if the car is a Sedan or a Pick up
	*/
	
	private CarType typeC;
	
	/**
	*numOfDoors int, is a variable of int type that contains the number of doors from the car
	*/
	
	private int numOfDoors;
	
	/**
	*tintedWindows boolean, is a variable of boolean type that tell us if the windows ar tinted or not
	*/
	
	private boolean tintedWindows;
	
	/**
	*Constructor from objects of Car type
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param typeV VehicleType, it's initialized
	*@param licensePlate String, it's initialized
	*@param documents Document[], it's initialized
	*@param typeC CarType, it's initialized
	*@param numOfDoors int, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@return an object of Car type
	*/
	
	public Car(double basePrice, String brand, int model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, boolean tintedWindows){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents);
		
		this.typeC=typeC;
		
		this.numOfDoors=numOfDoors;
		
		this.tintedWindows=tintedWindows;
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the car as a message
	*@return String with all the attributes
	*/
	
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

	public CarType getTypeC(){

		return typeC;

	}

	public int getNumOfDoors(){

		return numOfDoors;
		
	}

	public boolean getTintedWindows(){

		return tintedWindows;

	}

}