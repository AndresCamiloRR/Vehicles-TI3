package ui;

import model.VehicleDealer;
import java.util.Scanner;

public class Main{
	
	/**
	*shop VehicleDealer, is an object of VehicleDealer type, and it will work as the controller
	*/
	
	private VehicleDealer shop;
	
	/**
	*sc Scanner, is an object of Scanner type that reads the inputs inserted by the user
	*/
	
	private Scanner sc;
	
	/**
	*Constructor from objects of Main type that uses the init class of package ui to send it as a parameter to the constructor of VehicleDealer
	*@param vehicles ArrayList<Vehicle>, it's initialized
	*@return an object of VehicleDealer type
	*/
	
	public Main(){
		
		InitModel init = new InitModel();
		
		shop = new VehicleDealer(init.createVehicles());
		sc= new Scanner(System.in);
		
	}
	
	/**
	*Main method
	*/
	
	public static void main (String[] args){
		
		System.out.println("Iniciando la aplicacion");
		
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	/**
	*Method that will show the menu and read the user input
	*/
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Seleccione una opcion para empezar\n" +
				"(1) Para registrar un vehiculo\n" +
				"(2) Para ver los informes de los vehiculos\n"+
				"(3) Datos de los documentos\n" +
				"(4) Mostrar el parqueadero\n" +
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	*Method that based on the parameter operation will call the method that can fulfill the request
	*@param operation int that contains the choice made by the user
	*/
	
	public void executeOperation(int operation) {
		
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			wichVehicle();
			break;
		case 2:
			WichInfoV();
			break;
		case 3:
			DocumentsInfo();
			break;
		case 4:
			Parking();
			break;
		default:
			System.out.println("Error, opcion no valida");
		
		}
	}
	
	/**
	*Method that will ask the user if we wants to create a motorbike or a car, if it's a car ask the type of fuel (gasoline, battery, hybrid), and if it's a motorbike it will be gasoline, to then call a method based on the user inputs
	*/
	
	public void wichVehicle(){
		
		int option;
		
		do{
			
			System.out.println("Que tipo de vehiculo es?"+
			"\nCarro(1)"+
			"\nMoto(2)");
			
			option=sc.nextInt();
			
		}while(option!=1&&option!=2);
		
		int optionFuel=1;
		
		if(option==1){
			
			do{
			
				System.out.println("De que tipo es el carro?"+
				"\nGasolina(1)"+
				"\nBateria(2)"+
				"\nHibrido(3)");
				
				optionFuel=sc.nextInt();
				
			}while(optionFuel!=1&&optionFuel!=2&&optionFuel!=3);
			
			DefaultVehicle(option, optionFuel);
			
		}else if(option==2){
			
			DefaultVehicle(option, optionFuel);
			
		}
		
	}
	
	/**
	*Method that ask the user for the common attributes of all vehicles and based on his parameters will call one of the add method than can fulfill the user request
	*@param carOrBike int, it's initialized
	*@param optionFuel int, it's initialized
	*/
	
	public void DefaultVehicle(int carOrBike, int optionFuel){
		
		double basePrice=-1;
		String brand=null;
		int model=0;
		double cylinderCapacity=-1;
		double mileage=0;
		String licensePlate=null;
		
		
		//To create Documents
		
		//Soat
		int hasSoat=0;
		double soatPrice=-1;
		int soatYear=0;
		double soatCoverage=-1;
		
		
		//TecnicoMecanica
		int hasmechTech=0;
		double mechTechPrice=-1;
		int mechTechYear=0;
		String mechTechGasLevels=null;
		
		//T de propiedad
		double propertyPrice=-1;
		int propertyYear=0;
		
		
		//Usado
		int optionUsed=-1;
		
		
		
		do{
			System.out.println("Ingrese el precio base del vehiculo");
		
			basePrice=sc.nextDouble();
		}while(basePrice<=0);

		System.out.println("Ingrese la marca del vehiculo");
		
		brand=sc.next();
		
		System.out.println("Ingrese el modelo del vehiculo");
		
		model=sc.nextInt();
		
		do{
			System.out.println("Ingrese el cilindraje del vehiculo");
		
			cylinderCapacity=sc.nextDouble();
		}while(cylinderCapacity<=0);

		do{
			System.out.println("El vehiculo es usado? Si(1) No(2)");
			
			optionUsed=sc.nextInt();
		}while(optionUsed!=1&&optionUsed!=2);

		if(optionUsed==2){
			
			do{
				System.out.println("Ingrese el precio de la tecnico mecanica");
				mechTechPrice=sc.nextDouble();
			}while(mechTechPrice<=0);

			do{
				System.out.println("Ingrese el ano de la tecnico mecanica");
				mechTechYear=sc.nextInt();
			}while(mechTechYear<=0);

			do{
				System.out.println("Ingrese el nivel de los gases de la tecnico mecanica");
				mechTechGasLevels=sc.next();
			}while(mechTechGasLevels==null);

		}else{
			
			do{
				System.out.println("Ingrese la placa del carro");
				licensePlate=sc.next();
			}while(licensePlate==null);


			do{
				System.out.println("Tiene soat? Si(1) No(2)");
				hasSoat=sc.nextInt();
			}while(hasSoat!=1&&hasSoat!=2);
			
			if(hasSoat==1){
				
				do{
					System.out.println("Ingrese el precio del soat");
					soatPrice=sc.nextDouble();
				}while(soatPrice<=0);

				do{
					System.out.println("Ingrese el ano del soat");
					soatYear=sc.nextInt();
				}while(soatYear<=0);

				do{
					System.out.println("Ingrese la cobertura del soat");
					soatCoverage=sc.nextDouble();
				}while(soatCoverage<=0);
			}
			
			do{
				System.out.println("Tiene tecnico mecanica? Si(1) No(2)");
				hasmechTech=sc.nextInt();
			}while(hasmechTech!=1&&hasmechTech!=2);
			
			if(hasmechTech==1){
				
				do{
					System.out.println("Ingrese el precio de la tecnico mecanica");
					mechTechPrice=sc.nextDouble();
				}while(mechTechPrice<=0);
	
				do{
					System.out.println("Ingrese el ano de la tecnico mecanica");
					mechTechYear=sc.nextInt();
				}while(mechTechYear<=0);
	
				do{
					System.out.println("Ingrese el nivel de los gases de la tecnico mecanica");
					mechTechGasLevels=sc.next();
				}while(mechTechGasLevels==null);
				
			}
			
			
			do{
				System.out.println("Ingrese el precio de la tarjeta de propiedad");
				propertyPrice=sc.nextDouble();
			}while(propertyPrice<=0);


			do{
				System.out.println("Ingrese el ano de la tarjeta de propiedad");
				propertyYear=sc.nextInt();
			}while(propertyYear<=0);

		}
		
		switch(carOrBike) {
				
				case 1:
						
					switch(optionFuel) {
						case 1:
							addGasCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear);
							
							break;
						case 2:
							addElectricCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear);
							break;
						case 3:
							addHybridCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear);
							break;
						default:
							System.out.println("Error, opción no válida");
					}
					
				break;
				
				
				case 2:
					
					addMotorbike(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear);
					
				break;
		}
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a GasCar and send them as parameters to the addGasCar method in controller class
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
	*/
	
	public void addGasCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear){
		
		int carOption=0;
		int tintedOption=0;
		int fuelOption=0;
		
		
		double capacity=-1;
		
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		do{
			System.out.println("De que tipo es el carro?"+
			"\nSedan(1)"+
			"\nCamioneta(2)");
			carOption=sc.nextInt();
		}while(carOption!=1&&carOption!=2);
		
		do{
			System.out.println("Cual es la capacidad del tanque?");
			capacity=sc.nextDouble();
		}while(capacity<=0);

		do{
			System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
			tintedOption=sc.nextInt();
		}while(tintedOption!=1 && tintedOption!=2);

		do{
			System.out.println("Cuantas puertas tiene?");
			numOfDoors=sc.nextInt();
		}while(numOfDoors<=0);

		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		do{
			System.out.println("De que tipo es la gasolina?"+
			"\nCorriente(1)"+
			"\nExtra(2)"+
			"\nDiesel(3)");
		
			fuelOption=sc.nextInt();
		
		}while(fuelOption!=1&&fuelOption!=2&&fuelOption!=3);

		System.out.println(shop.addGasCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, capacity, tintedWindows, fuelOption));
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a ElectricCar and send them as parameters to the addElectricCar method in controller class
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
	*/
	
	public void addElectricCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear){
		
		
		int carOption=0;
		int tintedOption=0;
		int chargerOption=0;
		double batteryDuration;
		
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		do{
			System.out.println("De que tipo es el carro?"+
			"\nSedan(1)"+
			"\nCamioneta(2)");
			carOption=sc.nextInt();
		}while(carOption!=1&&carOption!=2);
		
		do{
			System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
			tintedOption=sc.nextInt();
		}while(tintedOption!=1 && tintedOption!=2);

		do{
			System.out.println("Cuantas puertas tiene?");
			numOfDoors=sc.nextInt();
		}while(numOfDoors<=0);
		
		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		do{
			System.out.println("Ingrese la duracion de la bateria en horas");
			batteryDuration=sc.nextInt();
		}while(batteryDuration<=0);

		do{
			System.out.println("De que tipo es el cargador?"+
			"\nRapido(1)"+
			"\nNormal(2)");
			chargerOption=sc.nextInt();
		}while(chargerOption!=1&&chargerOption!=2);

		System.out.println(shop.addElectricCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, tintedWindows, chargerOption, batteryDuration));
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a HybridCar and send them as parameters to the addHybridCar method in controller class
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
	*/
	
	public void addHybridCar(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear){
		
		int carOption=0;
		int tintedOption=0;
		int fuelOption=0;
		int chargerOption=0;
		double batteryDuration;
		
		double capacity=-1;
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		do{
			System.out.println("De que tipo es el carro?"+
			"\nSedan(1)"+
			"\nCamioneta(2)");
			carOption=sc.nextInt();
		}while(carOption!=1&&carOption!=2);
		
		do{
			System.out.println("Cual es la capacidad del tanque?");
			capacity=sc.nextDouble();
		}while(capacity<=0);

		do{
			System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
			tintedOption=sc.nextInt();
		}while(tintedOption!=1 && tintedOption!=2);

		do{
			System.out.println("Cuantas puertas tiene?");
			numOfDoors=sc.nextInt();
		}while(numOfDoors<=0);
		
		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		do{
			System.out.println("De que tipo es la gasolina?"+
			"\nCorriente(1)"+
			"\nExtra(2)"+
			"\nDiesel(3)");
		
			fuelOption=sc.nextInt();
		
		}while(fuelOption!=1&&fuelOption!=2&&fuelOption!=3);
		
		do{
			System.out.println("Ingrese la duracion de la bateria en horas");
			batteryDuration=sc.nextInt();
		}while(batteryDuration<=0);

		do{
			System.out.println("De que tipo es el cargador?"+
			"\nRapido(1)"+
			"\nNormal(2)");
			chargerOption=sc.nextInt();
		}while(chargerOption!=1&&chargerOption!=2);
		
		System.out.println(shop.addHybridCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, capacity, tintedWindows, fuelOption, chargerOption, batteryDuration));
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a Motorbike and send them as parameters to the addMotorbike method in controller class
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
	*/
	
	public void addMotorbike(double basePrice, String brand, int model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, int soatYear, double soatCoverage, double mechTechPrice, int mechTechYear, String mechTechGasLevels, double propertyPrice, int propertyYear){
		
		int bikeOption=0;
		int fuelOption=0;
		
		double capacity=-1;
		
		System.out.println("De que tipo es la moto?"+
		"\nEstandar(1)"+
		"\nDeportiva(2)"+
		"\nScooter(3)"+
		"\nCross(4)");
		
		bikeOption=sc.nextInt();
		
		
		
		System.out.println("De que tipo es la gasolina?"+
		"\nCorriente(1)"+
		"\nExtra(2)"+
		"\nDiesel(3)");
		
		fuelOption=sc.nextInt();
		
		System.out.println("Cual es la capacidad del tanque?");
		capacity=sc.nextDouble();
		
		System.out.println(shop.addMotorbike(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, bikeOption, capacity, fuelOption));
		
		
	}
	
	/**
	*Method that will ask the user the conditions that he wants the vehicles to meet
	*/
	
	public void WichInfoV(){
		
		int filter=-1;
		int secondFilter=-1;
		
		do{
			System.out.println("Con que filtro deseas imprimir la informacion?"+
			"\nTipo de vehiculo(1)"+
			"\nTipo de Combustible(2)"+
			"\nAutos nuevos/usados(3)");
			filter=sc.nextInt();
		}while(filter!=1&&filter!=2);

		switch(filter){
			
			case(1):
				do{
					System.out.println("Carros(1)"+
					"\nMotos(2)");
					secondFilter=sc.nextInt();
				}while(secondFilter!=1&&secondFilter!=2);
			break;
			case(2):
				do{
					System.out.println("Gasolina(1)"+
					"\nBateria(2)"+
					"\nHibrido(3)");
					secondFilter=sc.nextInt();
				}while(secondFilter!=1&&secondFilter!=2&&secondFilter!=3);
			break;
			case(3):
				do{
					System.out.println("Nuevos(1)"+
					"\nUsados(2)");
					secondFilter=sc.nextInt();
				}while(secondFilter!=1&&secondFilter!=2);
			break;
			
			
		}
		
		System.out.println(shop.PrintInfo(filter, secondFilter));
		
	}

	/**
	*Method that will ask for the id of the vehicle of which the user wants to know the status of their documents
	*/

	public void DocumentsInfo(){

		int id=-1;

		System.out.println("Ingrese el id del vehiculo del que desea conocer el estado de los documentos");

		id=sc.nextInt();

		System.out.println(shop.infoWithId(id));
	}

	/**
	*Method that will print the parking, deploy the parking menu and ask the user for what we wants
	*/

	public void Parking(){

		System.out.println(shop.printParking());

		int option=-1;

		do{
			option = ParkingMenu();
			executeParkingOperation(option);
			
		}while (option!=0);

	}

	/**
	*Method that creates the parking menu
	*/

	public int ParkingMenu(){

		int option=-1;

		System.out.println("(1) Vehiculos por rango de anos\n"+
		"(2) Datos del vehiculo mas antiguo y mas nuevo\n" +
		"(3) Porcentaje de ocupacion del parqueadero\n" +
		"(0) Salir del menu del parqueadero");

		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	*Method that based on the parameter operation will call the method that can fulfill the request
	*@param operation int that contains the choice made by the user
	*/
	
	public void executeParkingOperation(int operation) {
		
		
		switch(operation) {
		case 0:
			System.out.println("Regresaremos al menu principal");
			break;
		case 1:
			YearsVehicles();
			break;
		case 2:
			OldestRecentVehicles();
			break;
		case 3:
			ShowPercentage();
			break;
		default:
			System.out.println("Error, opcion no valida");
		
		}
	}

	/**
	*Method that will ask the user for years and print the vehicles of the parking that are between the years
	*/

	public void YearsVehicles(){

		int minY=0;
		int maxY=0;

		System.out.println("Ingrese el ano minimo de los vehiculos");
		minY=sc.nextInt();
		System.out.println("Ingrese el ano maximo de los vehiculos");
		maxY=sc.nextInt();
		System.out.println(shop.BasedYears(minY,maxY));

	}

	/**
	*Method that will print the percentage of occupation of the parking lot
	*/

	public void ShowPercentage(){

		System.out.println("El porcentaje de ocupacion del parqueadero es de: " + shop.ParkingPercentage() + "%\n\n");

	}

	/**
	*Method that will print the oldest and most recent vehicles of the parking
	*/

	public void OldestRecentVehicles(){

		System.out.println(shop.oldestVehicle()+"\n\n\n\n"+shop.recentVehicle());

	}
	
}