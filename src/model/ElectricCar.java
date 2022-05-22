package model;

public class ElectricCar extends Car implements IElectricity{
	
	/**
	*typeOfCharger ChargerType, is a variable of ChargerType that tell us if the charger is fast or normal
	*/
	
	private ChargerType typeOfCharger;
	
	/**
	*batteryDuration double, is a variable of double that contains the batteryDuration of the ElectricCar
	*/
	
	private double batteryDuration;
	
	/**
	*Constructor from objects of ElectricCar type
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
	*@param typeOfCharger ChargerType, it's initialized
	*@param batteryDuration double, it's initialized
	*@return an object of ElectricCar type
	*/
	
	public ElectricCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, boolean tintedWindows, ChargerType typeOfCharger, double batteryDuration){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.typeOfCharger=typeOfCharger;
		
		this.batteryDuration=batteryDuration;
		
	}

	@Override
	
	/**
	*Method that calculates the electricity consumption of the car
	*@return double with the consumption
	*/
	
	public double ElectricityConsumption(){
		
		double consumption=0;
		
		if(typeOfCharger==ChargerType.FAST){
			
			consumption=(batteryDuration+13)*(getCylinderCapacity()/100);
			
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			consumption=(batteryDuration+18)*(getCylinderCapacity()/100);
			
		}
		
		return consumption;
		
	}
	
	@Override
	
	/**
	*Method that calculates the price of the car
	*@return double with the sale price of the car
	*/
	
	public double CalculatePrice(){
		
		setSalePrice(getBasePrice()*1.2);
		
		if(super.Used()){
			
			setSalePrice(getSalePrice()*0.9);
			
		}
		
		if(super.ExpiredDocumentation()){
			
			setSalePrice(getSalePrice()+500000);
			
		}
		
		
		
		return getSalePrice();
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the car as a message
	*@return String with all the attributes
	*/
	
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

	public ChargerType getTypeOfCharger(){

		return typeOfCharger;

	}

	public double getBatteryDuration(){

		return batteryDuration;

	}
	
}