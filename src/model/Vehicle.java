package model;

public abstract class Vehicle implements ICalculatePrice{
	
	public final String ACTUALYEAR="2022";
	
	public int numOfDocuments=3;
	
	public int soatPlace = 0;
	
	public int mechTechPlace = 1;
	
	public int propertyCardPlace = 2;
	
	/**
	*basePrice double, is a variable of double type that contains the original price of the vehicle
	*/
	
	protected double basePrice;
	
	/**
	*basePrice double, is a variable of double type that contains the sale price of the vehicle
	*/
	
	protected double salePrice;
	
	/**
	*brand String, is a variable of String type that contains the brand of the vehicle
	*/
	
	protected String brand;
	
	/**
	*model String, is a variable of String type that contains the model/year of the vehicle
	*/
	
	protected String model;
	
	/**
	*cylinderCapacity double, is a variable of double type that contains the cylinderCapacity of the vehicle
	*/
	
	protected double cylinderCapacity;
	
	/**
	*mileage double, is a variable of String type that contains the mileage of the vehicle
	*/
	
	protected double mileage;
	
	/**
	*typeV VehicleType, is a variable of VehicleType type that tells if the vehicle is used or new
	*/
	
	protected VehicleType typeV;
	
	/**
	*licensePlate String, is a variable of String type that contains the licensePlate of the vehicle
	*/
	
	protected String licensePlate;
	
	/**
	*documents Document[], is a variable of Document type that contains the documents of the vehicle like soat, technical mechanical review and property card
	*/
	
	protected Document[] documents= new Document[numOfDocuments];
	
	/**
	*Constructor from objects of Vehicle type
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param typeV VehicleType, it's initialized
	*@param licensePlate String, it's initialized
	*@param documents Document[], it's initialized
	*@return an object of vehicle type
	*/
	
	public Vehicle(double basePrice, String brand, String model, double cylinderCapacity, double mileage, VehicleType typeV, String licensePlate, Document[] documents){
		
		this.basePrice=basePrice;
		
		this.brand=brand;
		
		this.model=model;
		
		this.cylinderCapacity=cylinderCapacity;
		
		this.mileage=mileage;
		
		this.typeV=typeV;
		
		this.licensePlate=licensePlate;
		
		this.documents=documents;
		
		
	}
	
	/**
	*F
	*@param nombre<tipo>, condición
	*@return <tipo>
	*/
	
	/**
	*Method that returns a boolean based on the expiration date of the soat and technical mechanical review
	*@return boolean, true if a document has expired, false if it hasn't
	*/
	
	public boolean ExpiredDocumentation(){
		
		boolean out=false;
		
		if(documents[soatPlace]==null||documents[mechTechPlace]==null||(ACTUALYEAR.compareTo(documents[soatPlace].year)>0)||(ACTUALYEAR.compareTo(documents[mechTechPlace].year)>0)){
			
			out=true;
			
		}
		
		return out;
	}
	
	/**
	*Method that returns a boolean based on the type of vehicle
	*@return boolean, true if it's a used vehicle, false if it a new vehicle
	*/
	
	public boolean Used(){
		
		boolean out=false;
		
		if(typeV==VehicleType.USED){
			
			out=true;
			
		}
		
		return out;
		
	}
	
	/**
	*Method that calculates the price of the vehicle, it's empty here because in every subclass it's override
	*@return <double>
	*/
	
	public double CalculatePrice(){
		
		return-1;
		
	}
	
	/**
	*Method that returns all the info from the vehicle as a message
	*@return String with all the attributes
	*/
	
	public String toString(){
		
		String msg="Marca: " + brand + "\nModelo:" + model + "\nCilindraje: " + cylinderCapacity;  
		
		if(typeV==VehicleType.USED){
			
			msg+="\nEl vehiculo es usado" + "\nTiene un kilometraje de: " + mileage +"\nSu placa es: " + licensePlate;
			
			for(int i=0; i<documents.length;i++){
				
				if(documents[i]==null||(ACTUALYEAR.compareTo(documents[i].year)>0)){
					
					switch(i) {
						
						case 0:
							msg+="\nNo tiene soat o esta vencido";
						break;
						
						case 1:
							msg+="\nNo tiene revision tecnico mecanica o esta vencida";
						break;
						
						case 2:
							if(documents[i]!=null){
								
								msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString();
								
							}else{
								
								msg+="\nNo tiene tarjeta de propiedad";
								
							}
						break;
						
					}
					
				}else{
					
					switch(i) {
						
						case 0:
							msg+="\n"+((Soat)documents[soatPlace]).toString();
						break;
						
						case 1:
							msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString();
						break;
						
						case 2:
							msg+="\n"+(documents[propertyCardPlace]).toString();
						break;
						
					}
					
				}
				
			}
			
		}else{
			
			msg+="\n"+((MechTechReview)documents[mechTechPlace]).toString()+"\nEl vehiculo es nuevo por lo que su kilometraje es 0, no tiene placa, ni soat, ni licensia de propiedad";
			
		}
		
		return msg;
	}
	

}
	
