package model;

public class Motorbike extends Vehicle implements IGas{
	
	/**
	*typeM MotorbikeType, is a variable of MotorbikeType wich tell us if the motorbike is the type standard, sports, scooter or cross
	*/
	
	protected MotorbikeType typeM;
	
	/**
	*capacity double, is a variable of double that contains the fuel capacity of the Motorbike
	*/
	
	private double capacity;
	
	/**
	*typeF FuelType, is a variable of FuelType that tell us if the motorbike needs current, extra or diesel
	*/
	
	private FuelType typeF;
	
	/**
	*Constructor from objects of Motorbike type
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param typeV VehicleType, it's initialized
	*@param licensePlate String, it's initialized
	*@param documents Document[], it's initialized
	*@param typeM MotorbikeType, it's initialized
	*@param capacity double, it's initialized
	*@param typeF FuelType, it's initialized
	*@return an object of Motorbike type
	*/
	
	public Motorbike(double basePrice, String brand, int model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, MotorbikeType typeM, double capacity, FuelType typeF){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents);
		
		this.typeM=typeM;
		
		this.typeF=typeF;
	}
	
	@Override
	
	/**
	*Method that calculates the gasoline consumption of the motorbike
	*@return double with the consumption
	*/
	
	public double GasolineConsumption(){
		
		return capacity*(getCylinderCapacity()/75);
		
	}
	
	@Override
	
	/**
	*Method that calculates the price of the motorbike
	*@return double with the sale price of the motorbike
	*/
	
	public double CalculatePrice(){
		
		setSalePrice(getBasePrice());
		
		if(super.Used()){
			
			setSalePrice(getSalePrice()*0.98);
			
		}else{
			
			setSalePrice(getSalePrice()*1.04);
			
		}
		
		if(super.ExpiredDocumentation()){
			
			setSalePrice(getSalePrice()+500000);
			
		}
		
		
		
		return getSalePrice();
		
	}
	
	@Override
	
	/**
	*Method that returns all the info from the motorbike as a message
	*@return String with all the attributes
	*/
	
	public String toString(){
		
		String msg=super.toString();
		
		msg+="\nLa moto es ";
		
		if(typeM==MotorbikeType.STANDARD){
			
			msg+="de tipo estandar";
			
		}
		if(typeM==MotorbikeType.SPORTS){
			
			msg+="deportiva";
			
		}
		if(typeM==MotorbikeType.SCOOTER){
			
			msg+="de tipo scooter";
			
		}
		if(typeM==MotorbikeType.CROSS){
			
			msg+="de tipo cross";
			
		}
		
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

	public MotorbikeType getTypeM(){

		return typeM;

	}

	public double getCapacity(){

		return capacity;

	}

	public FuelType getTypeF(){

		return typeF;

	}
	
}