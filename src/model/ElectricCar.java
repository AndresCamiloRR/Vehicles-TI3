package model;

public class ElectricCar extends Car implements IElectricity{
	
	private ChargerType typeOfCharger;
	
	private double batteryDuration;
	
	public ElectricCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, boolean tintedWindows, ChargerType typeOfCharger, double batteryDuration){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.typeOfCharger=typeOfCharger;
		
		this.batteryDuration=batteryDuration;
		
	}

	@Override
	
	public double ElectricityConsumption(){
		
		double consumption=0;
		
		if(typeOfCharger==ChargerType.FAST){
			
			consumption=(batteryDuration+13)*(cylinderCapacity/100);
			
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			consumption=(batteryDuration+18)*(cylinderCapacity/100);
			
		}
		
		return consumption;
		
	}
	
	@Override
	
	public double CalculatePrice(){
		
		salePrice=basePrice*1.2;
		
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
		
		msg+="\nTiene un consumo de bateria de: " + ElectricityConsumption();
		
		if(typeOfCharger==ChargerType.FAST){
			
			msg+="\nUtiliza un cargador rapido";
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			msg+="\nUtiliza un cargador normal";
			
		}
		
		msg+="\nLa bateria dura: " + batteryDuration + " horas";
		
		msg+="\nTiene un precio de:" + CalculatePrice()+"\n--------------------------------\n";
		
		return msg;
		
	}
	
}