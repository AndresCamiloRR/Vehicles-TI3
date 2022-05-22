package model;

import java.time.Year;
import java.util.ArrayList;

public class VehicleDealer{
	
	public int soatPlace = 0;
	
	public int mechTechPlace = 1;
	
	public int propertyCardPlace = 2;
	
	/**
	*vehicles ArrayList<Vehicle>, is an array of ArrayList<Vehicle> that contains the vehicles of the concessionaire
	*/
	
	private ArrayList<Vehicle> vehicles;
	
	/**
	*parkingLot Vehicle[][], is a matrix of Vehicle that contains the vehicles parked in the parking lot
	*/
	
	private Vehicle[][] parkingLot= new Vehicle[10][5];;
	
	/**
	*documents Document[], is a variable of Document type that contains the documents of the vehicle like soat, technical mechanical review and property card
	*/
	
	private Document[] newDocs;
	
	/**
	*Constructor from objects of VehicleDealer type
	*@return an object of VehicleDealer type
	*/
	
	public VehicleDealer(){
		
		vehicles = new ArrayList<Vehicle>();
		newDocs = null;
		
	}
	
	/**
	*Constructor from objects of VehicleDealer type that uses the init class of package ui to fill the array
	*@param vehicles ArrayList<Vehicle>, it's initialized
	*@return an object of VehicleDealer type
	*/
	
	public VehicleDealer(ArrayList<Vehicle> vehicles){
		
		this.vehicles = vehicles;
		for(int i=0; i<vehicles.size();i++){
			
			if((vehicles.get(i)).getTypeV()==VehicleType.USED){
				toParking(vehicles.get(i));
			}
		}
		newDocs = null;

	}
	
	/**
	*Method that creates a Document array and uses it, and the other parameters to create an object of GasCar type and send it to the vehicles array
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear int, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear int, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear int, it's initialized
	*@param carOption int, it's initialized
	*@param numOfDoors int, it's initialized
	*@param capacity double, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@param fuelOption int, it's initialized
	*@return an String to confirm that the vehicle was added
	*/
	
	public String addGasCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear, int carOption, int numOfDoors, double capacity, boolean tintedWindows, int fuelOption){
		
		VehicleType typeV=null;
		
		CarType typeC=null;
		
		FuelType typeF=null;
		
		String out="";

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
		
		if(soatYear!=0){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=0){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=0){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new GasCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF));
		
		out="El carro de gasolina ha sido anadido y tiene id: " + vehicles.size() + "\n\n";

		if(typeV==VehicleType.USED){
			
			out+=toParking(new GasCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF));
		
		}
		
		return out;
	}
	
	/**
	*Method that creates a Document array and uses it, and the other parameters to create an object of ElectricCar type and send it to the vehicles array
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear int, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear int, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear int, it's initialized
	*@param carOption int, it's initialized
	*@param numOfDoors int, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@param chargerOption int, it's initialized
	*@param batteryDuration double, it's initialized
	*@return an String to confirm that the vehicle was added
	*/
	
	public String addElectricCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear, int carOption, int numOfDoors, boolean tintedWindows, int chargerOption, double batteryDuration){
		
		VehicleType typeV=null;
		
		ChargerType typeOfCharger=null;
		
		String out="";

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
		
		if(soatYear!=0){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=0){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=0){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		
		vehicles.add(new ElectricCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, tintedWindows, typeOfCharger, batteryDuration));
		
		out="El carro electrico ha sido anadido y tiene id: " + vehicles.size() + "\n\n";

		if(typeV==VehicleType.USED){
			
			out+=toParking(new ElectricCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, tintedWindows, typeOfCharger, batteryDuration));
		
		}


		return out;
	}
	
	/**
	*Method that creates a Document array and uses it, and the other parameters to create an object of HybridCar type and send it to the vehicles array
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear int, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear int, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear int, it's initialized
	*@param carOption int, it's initialized
	*@param numOfDoors int, it's initialized
	*@param capacity double, it's initialized
	*@param tintedWindows boolean, it's initialized
	*@param fuelOption int, it's initialized
	*@param chargerOption int, it's initialized
	*@param batteryDuration double, it's initialized
	*@return an String to confirm that the vehicle was added
	*/
	
	public String addHybridCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear, int carOption, int numOfDoors, double capacity, boolean tintedWindows, int fuelOption, int chargerOption, double batteryDuration){
		
		VehicleType typeV=null;
		
		CarType typeC=null;

		String out="";
		
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
		
		if(soatYear!=0){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=0){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=0){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new HybridCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF, typeOfCharger, batteryDuration));
		
		out="El carro hibrido ha sido anadido y tiene id: " + vehicles.size() + "\n\n";

		if(typeV==VehicleType.USED){
			
			out+=toParking(new HybridCar(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs, typeC, numOfDoors, capacity, tintedWindows, typeF, typeOfCharger, batteryDuration));
		
		}
		
		return out;
		
	}
	
	/**
	*Method that creates a Document array and uses it, and the other parameters to create an object of Motorbike type and send it to the vehicles array
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model int, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear int, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear int, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear int, it's initialized
	*@param bikeOption int, it's initialized
	*@param capacity double, it's initialized
	*@param fuelOption int, it's initialized
	*@return an String to confirm that the vehicle was added
	*/
	
	public String addMotorbike(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear, int bikeOption, double capacity,int fuelOption){
		
		VehicleType typeV=null;
		
		MotorbikeType typeM=null;
		
		FuelType typeF=null;

		String out="";
		
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
		
		if(soatYear!=0){
			
			
			newDocs[soatPlace]= new Soat(soatPrice, soatYear, soatCoverage);
			
		}
		
		
		if(mechTechYear!=0){
			
			newDocs[mechTechPlace] = new MechTechReview(mechTechPrice, mechTechYear, mechTechGasLevels);
			
		}
		
		if(propertyYear!=0){
			
			newDocs[propertyCardPlace] = new Document(propertyPrice,propertyYear);
			
		}
		
		vehicles.add(new Motorbike(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs,typeM,capacity,typeF));
		
		out="La moto ha sido agregada y tiene id: " + vehicles.size() + "\n\n";

		if(typeV==VehicleType.USED){
			
			out+=toParking(new Motorbike(basePrice, brand, model, cylinderCapacity, mileage, typeV, licensePlate, newDocs,typeM,capacity,typeF));

		}

		return out;
	}
	
	/**
	*Method that gets the info from all the vehicles that meet the chosen conditions by the user
	*@param filter int, it's initialized
	*@param secondFilter int, it's initialized
	*@return an String with the wanted info
	*/
	
	public String PrintInfo(int filter, int secondFilter){
		
		String msg="Lista de vehiculos:\n\n";
		
		switch(filter){
			
			case(1):
				switch(secondFilter){
				case(1)://Carro
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof Car){
							
							msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((Car)vehicles.get(i)).toString());
							
						}
						
					}
				break;
				case(2)://Moto
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof Motorbike){
							
							msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((Motorbike)vehicles.get(i)).toString());
							
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
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((Car)vehicles.get(i)).toString());
								
							}else{
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((Motorbike)vehicles.get(i)).toString());
								
							}
							
						}
						
					}
				break;
				case(2)://Bateria
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof ElectricCar){
							
							msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((ElectricCar)vehicles.get(i)).toString());
							
						}
						
					}
				break;
				case(3)://Hibrido
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i) instanceof HybridCar){
							
							msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((HybridCar)vehicles.get(i)).toString());
							
						}
						
					}
				break;
				}
			break;
			case(3):
				switch(secondFilter){
				case(1)://Nuevos
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i).getTypeV()==VehicleType.NEW){
							
							if(((Motorbike)vehicles.get(i)).getTypeM()!=null){
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((Motorbike)vehicles.get(i)).toString());
								
							}else if(((HybridCar)vehicles.get(i)).getTypeOfCharger()==null){
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((GasCar)vehicles.get(i)).toString());
								
							}else if(((HybridCar)vehicles.get(i)).getTypeF()==null){
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((ElectricCar)vehicles.get(i)).toString());
								
							}else{
								
								msg+=("Vehiculo con id: " + (i+1) + "\n\n"+((HybridCar)vehicles.get(i)).toString());
								
							}
							
						}
						
					}
				case(2)://Usados
					for(int i=0; i<vehicles.size(); i++){
						
						if(vehicles.get(i).getTypeV()==VehicleType.USED){
							
							msg+=("Vehiculo con id: " + (i+1) + "\n\n"+vehicles.get(i).toString());
							
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
	
	/**
	*Method that gets the documents info from a vehicle, based on his id
	*@param id int, contains the position of the array list where the vehicle is located
	*@return an String with the documents info
	*/

	public String infoWithId(int id){

		String msg="";

		if(id<=vehicles.size()&&id>0){

			msg="Vehiculo con id: " + (id) + "\n\n"+vehicles.get(id-1).Documents();

		}else{

			msg="El vehiculo no fue encontrado";

		}

		return msg;

	}

	/**
	*Method that calls methods to add a vehicle in the parking, if it fulfills the conditions and if there's space
	*@param vehicletoAdd Vehicle, and object of vehicle type that contains the vehicle that will be added to parking
	*@return an String wich will tell if the car was or wasn't sent to the parking
	*/

	public String toParking (Vehicle vehicleToAdd){

		String msg="";

		if (vehicleToAdd.getModel()<=2014){

			int[] emptyPlace = ParkingSpace(vehicleToAdd.getModel());

			if(emptyPlace[0]!=-1){

				addToParking(vehicleToAdd, emptyPlace);
				msg="El vehiculo ha sido guardado";

			}else if(emptyPlace[0]==-1){

				msg="Lo sentimos pero no hay espacio en el parqueadero";

			}else{

				msg="El año del vehiculo es " + vehicleToAdd.getModel() + " por lo que no puede ingresar en el parqueadero";

			}

		}

		return msg;
	}

	/**
	*Method that search for spaces in the parking based on the model/year of the vehicle
	*@param model int, contains the model/year of the vehicle that we want to add
	*@return an int with the empty position or -1 if there's no space
	*/

	public int[] ParkingSpace (int model){

		int[] emptyPlace= new int[2];

		emptyPlace[1]=-1;
		emptyPlace[0]=-1;

		switch(model){

			case 2014:
				emptyPlace[1]=0;
			break;

			case 2013:
				emptyPlace[1]=1;
			break;

			case 2012:
				emptyPlace[1]=2;
			break;

			case 2011:
				emptyPlace[1]=3;
			break;

			default:
				emptyPlace[1]=4;
			break;
		}

		if(emptyPlace[1]!=-1){

			for(int i=0; i<parkingLot.length; i++){

				if(parkingLot[i][emptyPlace[1]]==null){

					emptyPlace[0]=i;

				}

			}

		}

		return emptyPlace;

	}

	/**
	*Method that adds a vehicle in the parking
	*@param vehicletoAdd Vehicle, it is the vehicle we want to add
	*@param emptyPlace int[][], it an array of two positions that contains the [i] and [j] were the vehicle will be sent
	*/

	public void addToParking(Vehicle vehicletoAdd, int[] emptyPlace){

		parkingLot[emptyPlace[0]][emptyPlace[1]]=vehicletoAdd;

	}
	
	/**
	*Method that adds a vehicle in the parking
	*@return String with the form of the parking, the occupied and free places
	*/

	public String printParking(){

		String parking=" GC -> Carro de Gasolina\n EC -> Carro Electrico\n HC -> Carro Hibrido\n GM -> Moto de Gasolina\n";

		parking+="|    2014   |    2013   |    2012   |    2011   |   <2011   |\n";

		parking+="-------------------------------------------------------------\n";

		for(int i=0; i<parkingLot.length;i++){


			for(int j=0; j<parkingLot[0].length;j++){


				if(parkingLot[i][j]!=null){

					if(parkingLot[i][j] instanceof GasCar){

						parking+="|     GC    ";

					}
	
					if(parkingLot[i][j] instanceof ElectricCar){
	
						parking+="|     EC    ";
	
					}
	
					if(parkingLot[i][j] instanceof HybridCar){
	
						parking+="|     HC    ";
	
					}
	
					if(parkingLot[i][j] instanceof Motorbike){
	
						parking+="|     GM    ";
	
					}



				}else{

					parking+="|           ";

				}

			}
	
			parking+="|\n";

			parking+="-------------------------------------------------------------";

			parking+="\n";

		}

		return parking;
	}

	/**
	*Method that calculates the percentage of occupation of the parking lot
	*@return double with the percentage
	*/

	public double ParkingPercentage(){

		double numOfVehicles=0;

		double numOfSpaces=0;

		for(int i=0; i<parkingLot.length; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null){

					numOfVehicles++;

				}

				numOfSpaces++;

			}


		}

		return(numOfVehicles/numOfSpaces)*100;

	}

	/**
	*Method that gets the info from all the vehicles that are between the years selected by the user
	*@param minY int, it's initialized
	*@param maxY int, it's initialized
	*@return an String with the vehicles between the years
	*/

	public String BasedYears(int minY, int maxY){

		String yearsVehicles="";

		boolean flag=true;

		for(int i=0; i<parkingLot.length&&flag; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null&&parkingLot[i][j].getModel()>=minY && parkingLot[i][j].getModel()<=maxY ){

					if(parkingLot[i][j] instanceof GasCar){

						yearsVehicles+=((GasCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof ElectricCar){
	
						yearsVehicles+=((ElectricCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof HybridCar){
	
						yearsVehicles+=((HybridCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof Motorbike){
	
						yearsVehicles+=((Motorbike)parkingLot[i][j]).toString()+"\n\n";
	
					}

				}

			}

		}

		if(yearsVehicles.equals("")){

			yearsVehicles="No hay vehiculos en el parqueadero en el rango de años elegidos\n\n";

		}

		return yearsVehicles;

	}

	/**
	*Method that gets the info from the oldest vehicle/vehicles in the parking lot
	*@return an String with the oldest vehicle/vehicles info
	*/

	public String oldestVehicle(){

		double oldestYear=-1;

		String oldestVehicles="";

		for(int i=0; i<parkingLot.length; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null && (oldestYear==-1||parkingLot[i][j].getModel()<oldestYear)){

					oldestYear=(parkingLot[i][j]).getModel();

				}

			}

		}

		if(oldestYear!=-1){

			oldestVehicles="Los vehiculos mas antiguos del parqueadero son: \n\n";

		}else{

			oldestVehicles="Lo sentimos pero no hay vehiculos en el parqueadero\n";

		}

		for(int i=0; i<parkingLot.length; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null&&(parkingLot[i][j]).getModel()==oldestYear){

					if(parkingLot[i][j] instanceof GasCar){

						oldestVehicles+=((GasCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof ElectricCar){
	
						oldestVehicles+=((ElectricCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof HybridCar){
	
						oldestVehicles+=((HybridCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof Motorbike){
	
						oldestVehicles+=((Motorbike)parkingLot[i][j]).toString()+"\n\n";
	
					}

				}

			}

		}

		return oldestVehicles;

	}

	/**
	*Method that gets the info from the most recent vehicle/vehicles in the parking lot
	*@return an String with the most recent vehicle/vehicles info
	*/

	public String recentVehicle(){

		double recentYear=-1;

		String recentVehicles="";

		for(int i=0; i<parkingLot.length; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null && (recentYear==-1||(parkingLot[i][j]).getModel()>recentYear)){

					recentYear=(parkingLot[i][j]).getModel();

				}

			}

		}

		if(recentYear!=-1){

			recentVehicles="Los vehiculos mas recientes del parqueadero son: \n\n";

		}else{

			recentVehicles="Lo sentimos pero no hay vehiculos en el parqueadero\n";

		}

		for(int i=0; i<parkingLot.length; i++){

			for(int j=0; j<parkingLot[0].length; j++){

				if(parkingLot[i][j]!=null&&(parkingLot[i][j]).getModel()==recentYear){

					if(parkingLot[i][j] instanceof GasCar){

						recentVehicles+=((GasCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof ElectricCar){
	
						recentVehicles+=((ElectricCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof HybridCar){
	
						recentVehicles+=((HybridCar)parkingLot[i][j]).toString()+"\n\n";
	
					}
	
					if(parkingLot[i][j] instanceof Motorbike){
	
						recentVehicles+=((Motorbike)parkingLot[i][j]).toString()+"\n\n";
	
					}

				}

			}

		}

		return recentVehicles;

	}

}