package model;

public class HybridCar extends Car implements IGas, IElectricity{
	
	/**
	*capacity double, is a variable of double that contains the fuel capacity of the car
	*/
	
	private double capacity;
	
	/**
	*typeF FuelType, is a variable of FuelType that tell us if the car needs current, extra or diesel
	*/
	
	protected FuelType typeF;
	
	/**
	*typeOfCharger ChargerType, is a variable of ChargerType that tell us if the charger is fast or normal
	*/
	
	protected ChargerType typeOfCharger;
	
	/**
	*batteryDuration double, is a variable of double that contains the batteryDuration of the ElectricCar
	*/
	
	private double batteryDuration;
	
	/**
	*Constructor from objects of HybridCar type
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
	*@param capacity double, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@param typeF FuelType, it's initialized
	*@param typeOfCharger ChargerType, it's initialized
	*@param batteryDuration double, it's initialized
	*@return an object of HybridCar type
	*/
	
	public HybridCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, CarType typeC, int numOfDoors, double capacity, boolean tintedWindows, FuelType typeF, ChargerType typeOfCharger, double batteryDuration){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents,typeC,numOfDoors,tintedWindows);
		
		this.capacity=capacity;
		
		this.typeF=typeF;
		
		this.typeOfCharger=typeOfCharger;
		
		this.batteryDuration=batteryDuration;
		
		
	}
	
	@Override
	
	/**
	*Method that calculates the gasoline consumption of the car
	*@return double with the consumption
	*/
	
	public double GasolineConsumption(){
		
		return capacity*(getCylinderCapacity()/180);
		
	}
	
	
	@Override
	
	/**
	*Method that calculates the electricity consumption of the car
	*@return double with the consumption
	*/
	
	public double ElectricityConsumption(){
		
		double consumption=0;
		
		if(typeOfCharger==ChargerType.FAST){
			
			consumption=batteryDuration*(getCylinderCapacity()/200);
			
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			consumption=(batteryDuration+7)*(getCylinderCapacity()/200);
			
		}
		
		return consumption;
		
	}
	
	@Override
	
	/**
	*Method that calculates the price of the car
	*@return double with the sale price of the car
	*/
	
	public double CalculatePrice(){
		
		setSalePrice(getBasePrice()*1.15);
		
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
		
		msg+="\nTiene un consumo de gasolina de: " + String.format("%.2f", GasolineConsumption());
		
		if(typeF==FuelType.CURRENT){
			
			msg+="\nUtiliza gasolina corriente";
			
		}else if(typeF==FuelType.EXTRA){
			
			msg+="\nUtiliza gasolina extra";
			
		}else{
			
			msg+="\nUtiliza gasolina diesel";
			
		}
		
		
		msg+="\nTiene un consumo de bateria de: " + String.format("%.2f", ElectricityConsumption());
		
		if(typeOfCharger==ChargerType.FAST){
			
			msg+="\nUtiliza un cargador rapido";
			
		}else if(typeOfCharger==ChargerType.NORMAL){
			
			msg+="\nUtiliza un cargador normal";
			
		}
		
		msg+="\nLa bateria dura: " + batteryDuration + " horas";
		
		msg+="\nTiene un precio de:" + String.format("%.2f", CalculatePrice())+"\n--------------------------------\n";
		
		return msg;
		
	}

	public double getCapacity(){

		return capacity;

	}

	public FuelType getTypeF(){

		return typeF;

	}

	public ChargerType getTypeOfCharger(){

		return typeOfCharger;

	}

	public double getBatteryDuration(){

		return batteryDuration;

	}
	
}