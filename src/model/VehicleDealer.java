package model;

import java.util.ArrayList;

public class VehicleDealer{
	
	public int soatPlace = 0;
	
	public int mechTechPlace = 1;
	
	public int propertyCardPlace = 2;
	
	private ArrayList<Vehicle> vehicles;
	
	private Vehicle[][] parkingLot;
	
	private Document[] newDocs;
	
	public VehicleDealer(){
		
		vehicles = new ArrayList<Vehicle>();
		newDocs = null;
		
	}
	
	public VehicleDealer(ArrayList<Vehicle> vehicles){
		
		this.vehicles = vehicles;
		
	}
	
	public String addGasCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear, int carOption, int numOfDoors, double capacity, boolean tintedWindows, int fuelOption){
		
		VehicleType typeV=null;
		
		CarType typeC=null;
		
		FuelType typeF=null;
		
		if(optionUsed==1){
			
			typeV=VehicleType.USED;
			
		}else{
			
			typeV=VehicleType.NEW;
			
		}
		
		if(carOption==1){
			
			typeC=CarType.SEDAN;
			
		}else{
			
			typeC=CarType.PICKUP;
			
		}
		
		switch(fuelOption){
			
			case(1):
				typeF=FuelType.CURRENT;
			break;
			case(2):
				typeF=FuelType.EXTRA;
			break;
			case(3):
				typeF=FuelType.DIESEL;
			break;
			
		}
		
		newDocs= new Document[3];
		
		if(soatYear!=null){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=null){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=null){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new GasCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF));
		
		return("El carro de gasolina ha sido añadido");
	}
	
	public String addElectricCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear, int carOption, int numOfDoors, boolean tintedWindows, int chargerOption, double batteryDuration){
		
		VehicleType typeV=null;
		
		ChargerType typeOfCharger=null;
		
		if(optionUsed==1){
			
			typeV=VehicleType.USED;
			
		}else{
			
			typeV=VehicleType.NEW;
			
		}
		
		if(chargerOption==1){
			
			typeOfCharger=ChargerType.FAST;
			
		}else{
			
			typeOfCharger=ChargerType.NORMAL;
			
		}
		
		CarType typeC=null;
		
		if(carOption==1){
			
			typeC=CarType.SEDAN;
			
		}else{
			
			typeC=CarType.PICKUP;
			
		}
		
		newDocs= new Document[3];
		
		if(soatYear!=null){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=null){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=null){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		
		vehicles.add(new ElectricCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, tintedWindows, typeOfCharger, batteryDuration));
		
		
		return("El carro electrico ha sido añadido");
	}
	
	public String addHybridCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear, int carOption, int numOfDoors, double capacity, boolean tintedWindows, int fuelOption, int chargerOption, double batteryDuration){
		
		VehicleType typeV=null;
		
		CarType typeC=null;
		
		if(optionUsed==1){
			
			typeV=VehicleType.USED;
			
		}else{
			
			typeV=VehicleType.NEW;
			
		}
		
		if(carOption==1){
			
			typeC=CarType.SEDAN;
			
		}else{
			
			typeC=CarType.PICKUP;
			
		}
		
		FuelType typeF=null;
		
		switch(fuelOption){
			
			case(1):
				typeF=FuelType.CURRENT;
			break;
			case(2):
				typeF=FuelType.EXTRA;
			break;
			case(3):
				typeF=FuelType.DIESEL;
			break;
			
		}
		
		ChargerType typeOfCharger=null;
		
		if(chargerOption==1){
			
			typeOfCharger=ChargerType.FAST;
			
		}else{
			
			typeOfCharger=ChargerType.NORMAL;
			
		}
		
		newDocs= new Document[3];
		
		if(soatYear!=null){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=null){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=null){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new HybridCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF, typeOfCharger, batteryDuration));
		
		return("El carro hibrido ha sido añadido");
		
	}
	
	public String addMotorbike(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear, int bikeOption, double capacity,int fuelOption){
		
		VehicleType typeV=null;
		
		MotorbikeType typeM=null;
		
		FuelType typeF=null;
		
		if(optionUsed==1){
			
			typeV=VehicleType.USED;
			
		}else{
			
			typeV=VehicleType.NEW;
			
		}
		
		switch(bikeOption){
			
			case(1):
				typeM=MotorbikeType.STANDARD;
			break;
			case(2):
				typeM=MotorbikeType.SPORTS;
			break;
			case(3):
				typeM=MotorbikeType.SCOOTER;
			break;
			case(4):
				typeM=MotorbikeType.CROSS;
			break;
		}
		
		switch(fuelOption){
			
			case(1):
				typeF=FuelType.CURRENT;
			break;
			case(2):
				typeF=FuelType.EXTRA;
			break;
			case(3):
				typeF=FuelType.DIESEL;
			break;
		}
		
		newDocs= new Document[3];
		
		if(soatYear!=null){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=null){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=null){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new Motorbike(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs,typeM,capacity,typeF));
		
		return ("La moto ha sido agregada");
		
	}
	
	public String PrintInfo(int filter, int secondFilter){
		
		FuelType filterF=null;
		
		VehicleType filterV=null;
		
		String msg="Lista de vehiculos:\n\n";
		
		switch(filter){
			
			case(1):
				switch(secondFilter){
				case(1)://Carro
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof Car){
							
							msg+=((Car)vehicles.get(i)).toString();
							
						}
						
					}
				break;
				case(2)://Moto
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof Motorbike){
							
							msg+=((Motorbike)vehicles.get(i)).toString();
							
						}
						
					}
				break;
				}
			break;
			case(2):
				switch(secondFilter){
				case(1)://Gasolina
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof Motorbike||vehicles.get(i) instanceof GasCar){
							
							if(((Motorbike)vehicles.get(i)).typeM==null){
								
								msg+=((Car)vehicles.get(i)).toString();
								
							}else{
								
								msg+=((Motorbike)vehicles.get(i)).toString();
								
							}
							
						}
						
					}
				break;
				case(2)://Bateria
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof ElectricCar){
							
							msg+=((ElectricCar)vehicles.get(i)).toString();
							
						}
						
					}
				break;
				case(3)://Hibrido
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof HybridCar){
							
							msg+=((HybridCar)vehicles.get(i)).toString();
							
						}
						
					}
				break;
				}
			break;
			case(3):
				switch(secondFilter){
				case(1)://Nuevos
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i).typeV==VehicleType.NEW){
							
							if(((Motorbike)vehicles.get(i)).typeM!=null){
								
								msg+=((Motorbike)vehicles.get(i)).toString();
								
							}else if(((HybridCar)vehicles.get(i)).typeOfCharger==null){
								
								msg+=((GasCar)vehicles.get(i)).toString();
								
							}else if(((HybridCar)vehicles.get(i)).typeF==null){
								
								msg+=((ElectricCar)vehicles.get(i)).toString();
								
							}else{
								
								msg+=((HybridCar)vehicles.get(i)).toString();
								
							}
							
						}
						
					}
				case(2)://Usados
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i).typeV==VehicleType.USED){
							
							msg+=vehicles.get(i).toString();
							
						}
						
					}
				break;
				}
				
		}
		
		if(msg.equals("Lista de vehículos:\n\n")){
			
			msg="Lo sentimos pero no hemos encontrado vehiculos con las condiciones que usted desea\n\n\n";
			
		}
		
		return msg;
		
	}
	
	
}