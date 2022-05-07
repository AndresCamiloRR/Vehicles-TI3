package model;

public class HybridCar extends Car implements IGas, IElectricity{
	
	private double capacity;
	
	protected FuelType typeF;
	
	protected ChargerType typeOfCharger;
	
	private double batteryDuration;
	
	public HybridCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, double capacity, boolean tintedWindows, FuelType typeF, ChargerType typeOfCharger, double batteryDuration){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.capacity=capacity;
		
		this.typeF=typeF;
		
		this.typeOfCharger=typeOfCharger;
		
		this.batteryDuration=batteryDuration;
		
		
	}
	
	@Override
	
	public double GasolineConsumption(){
		
		return capacity*(cylinderCapacity/180);
		
	}
	
	
	@Override
	
	public double ElectricityConsumption(){
		
		double consumption=0;
		
		if(typeOfCharger==ChargerType.FAST){
			
			consumption=batteryDuration*(cylinderCapacity/200);
			
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			consumption=(batteryDuration+7)*(cylinderCapacity/200);
			
		}
		
		return consumption;
		
	}
	
	@Override
	
	public double CalculatePrice(){
		
		salePrice=basePrice*1.15;
		
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