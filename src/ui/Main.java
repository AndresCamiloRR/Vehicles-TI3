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
		
		boolean replace=false;
		int replaceId=-1;
		
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
		default:
			System.out.println("Error, opción no válida");
		
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
		String model=null;
		double cylinderCapacity=-1;
		double mileage=0;
		String licensePlate=null;
		
		
		//To create Documents
		
		//Soat
		int hasSoat=0;
		double soatPrice=-1;
		String soatYear=null;
		double soatCoverage=-1;
		
		
		//TecnicoMecanica
		int hasmechTech=0;
		double mechTechPrice=-1;
		String mechTechYear=null;
		String mechTechGasLevels=null;
		
		//T de propiedad
		double propertyPrice=-1;
		String propertyYear=null;
		
		
		//Usado
		int optionUsed=-1;
		
		
		
		System.out.println("Ingrese el precio base del vehiculo");
		
		basePrice=sc.nextDouble();
		
		System.out.println("Ingrese la marca del vehiculo");
		
		brand=sc.next();
		
		System.out.println("Ingrese el modelo del vehiculo");
		
		model=sc.next();
		
		System.out.println("Ingrese el cilindraje del vehiculo");
		
		cylinderCapacity=sc.nextDouble();
		
		System.out.println("El vehiculo es usado? Si(1) No(2)");
		
		optionUsed=sc.nextInt();
		
		if(optionUsed==2){
			
			System.out.println("Ingrese el precio de la tecnico mecanica");
			mechTechPrice=sc.nextDouble();
				
			System.out.println("Ingrese el ano de la tecnico mecanica");
			mechTechYear=sc.next();
				
			System.out.println("Ingrese el nivel de los gases de la tecnico mecanica");
			mechTechGasLevels=sc.next();
			
		}else{
			
			System.out.println("Ingrese la placa del carro");
			licensePlate=sc.next();
			
			do{
				System.out.println("Tiene soat? Si(1) No(2)");
				hasSoat=sc.nextInt();
			}while(hasSoat!=1&&hasSoat!=2);
			
			if(hasSoat==1){
				
				System.out.println("Ingrese el precio del soat");
				soatPrice=sc.nextDouble();
				
				System.out.println("Ingrese el ano del soat");
				soatYear=sc.next();
				
				System.out.println("Ingrese la cobertura del soat");
				soatCoverage=sc.nextDouble();
				
			}
			
			do{
				System.out.println("Tiene tecnico mecanica? Si(1) No(2)");
				hasmechTech=sc.nextInt();
			}while(hasmechTech!=1&&hasmechTech!=2);
			
			if(hasmechTech==1){
				
				System.out.println("Ingrese el precio de la tecnico mecanica");
				mechTechPrice=sc.nextDouble();
				
				System.out.println("Ingrese el ano de la tecnico mecanica");
				mechTechYear=sc.next();
				
				System.out.println("Ingrese el nivel de los gases de la tecnico mecanica");
				mechTechGasLevels=sc.next();
				
			}
			
			
			System.out.println("Ingrese el precio de la tarjeta de propiedad");
			propertyPrice=sc.nextDouble();
			
			System.out.println("Ingrese el ano de la tarjeta de propiedad");
			propertyYear=sc.next();
			
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
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear String, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear String, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear String, it's initialized
	*/
	
	public void addGasCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear){
		
		int carOption=0;
		int tintedOption=0;
		int fuelOption=0;
		
		
		double capacity=-1;
		
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		System.out.println("De que tipo es el carro?"+
		"\nSedan(1)"+
		"\nCamioneta(2)");
		
		carOption=sc.nextInt();
		
		System.out.println("Cual es la capacidad del tanque?");
		capacity=sc.nextDouble();
		
		System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
		tintedOption=sc.nextInt();
		
		System.out.println("Cuantas puertas tiene?");
		numOfDoors=sc.nextInt();
		
		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		System.out.println("De que tipo es la gasolina?"+
		"\nCorriente(1)"+
		"\nExtra(2)"+
		"\nDiesel(3)");
		
		fuelOption=sc.nextInt();
		
		shop.addGasCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, capacity, tintedWindows, fuelOption);
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a ElectricCar and send them as parameters to the addElectricCar method in controller class
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear String, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear String, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear String, it's initialized
	*/
	
	public void addElectricCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear){
		
		
		int carOption=0;
		int tintedOption=0;
		int chargerOption=0;
		double batteryDuration;
		
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		System.out.println("De que tipo es el carro?"+
		"\nSedan(1)"+
		"\nCamioneta(2)");
		
		carOption=sc.nextInt();
		
		System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
		tintedOption=sc.nextInt();
		
		System.out.println("Cuantas puertas tiene?");
		numOfDoors=sc.nextInt();
		
		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		System.out.println("Ingrese la duración de la bateria");
		batteryDuration=sc.nextInt();
		
		System.out.println("De que tipo es el cargador?"+
		"\nRapido(1)"+
		"\nNormal(2)");
		chargerOption=sc.nextInt();
		
		shop.addElectricCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, tintedWindows, chargerOption, batteryDuration);
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a HybridCar and send them as parameters to the addHybridCar method in controller class
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear String, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear String, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear String, it's initialized
	*/
	
	public void addHybridCar(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear){
		
		int carOption=0;
		int tintedOption=0;
		int fuelOption=0;
		int chargerOption=0;
		double batteryDuration;
		
		double capacity=-1;
		int numOfDoors=0;
		boolean tintedWindows=false;
		
		System.out.println("De que tipo es el carro?"+
		"\nSedan(1)"+
		"\nCamioneta(2)");
		
		carOption=sc.nextInt();
		
		System.out.println("Cual es la capacidad del tanque?");
		capacity=sc.nextDouble();
		
		System.out.println("Tiene los vidirios polarizados? Si(1) No(2)");
		tintedOption=sc.nextInt();
		
		System.out.println("Cuantas puertas tiene?");
		numOfDoors=sc.nextInt();
		
		if(tintedOption==1){
			
			tintedWindows=true;
			
		}else{
			
			tintedWindows=false;
			
		}
		
		System.out.println("De que tipo es la gasolina?"+
		"\nCorriente(1)"+
		"\nExtra(2)"+
		"\nDiesel(3)");
		
		fuelOption=sc.nextInt();
		
		System.out.println("Ingrese la duración de la bateria");
		batteryDuration=sc.nextInt();
		
		System.out.println("De que tipo es el cargador?"+
		"\nRapido(1)"+
		"\nNormal(2)");
		chargerOption=sc.nextInt();
		
		shop.addHybridCar(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, carOption, numOfDoors, capacity, tintedWindows, fuelOption, chargerOption, batteryDuration);
		
		
	}
	
	/**
	*Method that ask the user for the missing attributes of a Motorbike and send them as parameters to the addMotorbike method in controller class
	*@param basePrice double, it's initialized
	*@param brand String, it's initialized
	*@param model String, it's initialized
	*@param cylinderCapacity double, it's initialized
	*@param mileage double, it's initialized
	*@param optionUsed int, it's initialized
	*@param licensePlate String, it's initialized
	*@param soatPrice double, it's initialized
	*@param soatYear String, it's initialized
	*@param soatCoverage double, it's initialized
	*@param mechTechPrice double, it's initialized
	*@param mechTechYear String, it's initialized
	*@param mechTechGasLevels String, it's initialized
	*@param propertyPrice double, it's initialized
	*@param propertyYear String, it's initialized
	*/
	
	public void addMotorbike(double basePrice, String brand, String model, double cylinderCapacity, double mileage, int optionUsed, String licensePlate, double soatPrice, String soatYear, double soatCoverage, double mechTechPrice, String mechTechYear, String mechTechGasLevels, double propertyPrice, String propertyYear){
		
		int bikeOption=0;
		int fuelOption=0;
		
		double capacity=-1;
		boolean tintedWindows=false;
		
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
		
		shop.addMotorbike(basePrice, brand, model, cylinderCapacity, mileage, optionUsed, licensePlate, soatPrice, soatYear, soatCoverage, mechTechPrice, mechTechYear, mechTechGasLevels, propertyPrice, propertyYear, bikeOption, capacity, fuelOption);
		
		
	}
	
	/**
	*Method that will ask the user the conditions that he wants the vehicles to meet
	*/
	
	public void WichInfoV(){
		
		int filter=-1;
		int secondFilter=-1;
		
		System.out.println("Con que filtro deseas imprimir la informacion?"+
		"\nTipo de vehiculo(1)"+
		"\nTipo de Combustible(2)"+
		"\nAutos nuevos/usados(3)");
		filter=sc.nextInt();
		
		switch(filter){
			
			case(1):
				System.out.println("Carros(1)"+
				"\nMotos(2)");
				secondFilter=sc.nextInt();
			break;
			case(2):
				System.out.println("Gasolina(1)"+
				"\nBateria(2)"+
				"\nHibrido(3)");
				secondFilter=sc.nextInt();
			break;
			case(3):
				System.out.println("Nuevos(1)"+
				"\nUsados(2)");
				secondFilter=sc.nextInt();
			break;
			
			
		}
		
		System.out.println(shop.PrintInfo(filter, secondFilter));
		
	}
}