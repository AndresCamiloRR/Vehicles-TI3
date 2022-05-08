package model;

public class GasCar extends Car implements IGas{
	
	/**
	*capacity double, is a variable of double that contains the fuel capacity of the car
	*/
	
	private double capacity;
	
	/**
	*typeF FuelType, is a variable of FuelType that tell us if the car needs current, extra or diesel
	*/
	
	private FuelType typeF;
	
	/**
	*Constructor from objects of GasCar type
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param typeV VehicleType, it's initialized
	*@param licensePlate String, it's initialized
	*@param documents Document[], it's initialized
	*@param typeC CarType, it's initialized
	*@param numOfDoors int, it's initialized
	*@param capacity double, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@param typeF FuelType, it's initialized
	*@return an object of GasCar type
	*/
	
	public GasCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, double capacity, boolean tintedWindows, FuelType typeF){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.capacity=capacity;
		
		this.typeF=typeF;
		
	}

	@Override
	
	/**
	*Method that calculates the gasoline consumption of the car
	*@return double with the consumption
	*/
	
	public double GasolineConsumption(){
		
		return capacity*(cylinderCapacity/150);
		
	}
	
	@Override
	
	/**
	*Method that calculates the price of the car
	*@return double with the sale price of the car
	*/
	
	public double CalculatePrice(){
		
		salePrice=basePrice;
		
		if(super.Used()){
			
			salePrice=salePrice*0.9;
			
		}
		
		if(super.ExpiredDocumentation()){
			
			salePrice+=500000;
			
		}
		
		return salePrice;
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the car as a message
	*@return String with all the attributes
	*/
	
	public String toString(){
		
		String msg=super.toString();
		
		msg+="\nTiene un consumo de gasolina de: " + GasolineConsumption();
		
		if(typeF==FuelType.CURRENT){
			
			msg+="\nUtiliza gasolina corriente";
			
		}else if(typeF==FuelType.EXTRA){
			
			msg+="\nUtiliza gasolina extra";
			
		}else{
			
			msg+="\nUtiliza gasolina diesel";
			
		}
		
		
		msg+="\nTiene un precio de:" + CalculatePrice()+"\n--------------------------------\n";
		
		return msg;
		
	}
	
}