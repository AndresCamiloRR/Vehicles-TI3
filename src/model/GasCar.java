package model;

public class GasCar extends Car implements IGas{
	
	private double capacity;
	
	private FuelType typeF;
	
	public GasCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, double capacity, boolean tintedWindows, FuelType typeF){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.capacity=capacity;
		
		this.typeF=typeF;
		
	}

	@Override
	
	public double GasolineConsumption(){
		
		return capacity*(cylinderCapacity/150);
		
	}
	
	@Override
	
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