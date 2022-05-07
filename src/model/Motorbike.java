package model;

public class Motorbike extends Vehicle implements IGas, ICalculatePrice{
	
	protected MotorbikeType typeM;
	
	private double capacity;
	
	private FuelType typeF;
	
	public Motorbike(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents, MotorbikeType typeM, double capacity, FuelType typeF){
		
		super(basePrice,brand,model,cylinderCapacity,mileage,typeV,licensePlate,documents);
		
		this.typeM=typeM;
		
		this.typeF=typeF;
	}
	
	@Override
	
	public double GasolineConsumption(){
		
		return capacity*(cylinderCapacity/75);
		
	}
	
	@Override
	
	public double CalculatePrice(){
		
		salePrice=basePrice;
		
		if(super.Used()){
			
			salePrice=salePrice*0.98;
			
		}else{
			
			salePrice=salePrice*1.04;
			
		}
		
		if(super.ExpiredDocumentation()){
			
			salePrice+=500000;
			
		}
		
		
		
		return salePrice;
		
	}
	
	@Override
	
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
	
}