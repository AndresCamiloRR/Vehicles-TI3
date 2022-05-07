package ui; 

import model.*;

import java.util.ArrayList;

public class InitModel {
    
    public InitModel() { }

    public ArrayList<Vehicle> createVehicles(){
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		Document[] documents=new Document[3];
		
		documents[0]=new Soat(15000, "2022", 1000000);
		documents[1]=new MechTechReview(200000, "2023", "115");
		documents[2]=new Document(1400,"2008");
		
		vehicles.add(new Motorbike(12000000, "AKT", "2008", 200, 90000,VehicleType.USED,"CPC749",documents,MotorbikeType.CROSS,10,FuelType.DIESEL));
		
		documents[0]=new Soat(22540, "2022", 2500000);
		documents[1]=new MechTechReview(145000, "2024", "220");
		documents[2]=new Document(2100,"2008");
		
		vehicles.add(new Motorbike(18000000, "Honda", "2008", 250, 150000,VehicleType.USED,"CQB485",documents,MotorbikeType.SCOOTER,20,FuelType.CURRENT));
		
		documents[0]=null;
		documents[1]=new MechTechReview(1400000, "2023", "147");
		documents[2]=null;
		
		vehicles.add(new ElectricCar(200000000, "Tesla", "2021", 300, 0,VehicleType.NEW,null,documents,CarType.SEDAN,4,false,ChargerType.FAST,120));
		
		documents[0]=null;
		documents[1]=new MechTechReview(700000, "2025", "40");
		documents[2]=null;
		
		vehicles.add(new ElectricCar(69500000, "Nissan", "2020", 275, 0,VehicleType.NEW,null,documents,CarType.PICKUP,4,false,ChargerType.NORMAL,80));
		
		documents[0]=new Soat(638000, "2022", 4000000);
		documents[1]=new MechTechReview(67900, "2019", "100");
		documents[2]=new Document(19000,"2018");
		vehicles.add(new HybridCar(85990000, "Ford", "2018", 400, 90000,VehicleType.USED,"RPD115",documents,CarType.PICKUP,4,30,true,FuelType.EXTRA,ChargerType.FAST,100));
		
		documents[0]=new Soat(42500, "2020", 5000000);
		documents[1]=new MechTechReview(25000, "2023", "98");
		documents[2]=new Document(56200,"2021");
		vehicles.add(new HybridCar(62000000, "Mazda", "2021", 350, 10000,VehicleType.USED,"HRX731",documents,CarType.PICKUP,4,30,true,FuelType.EXTRA,ChargerType.FAST,75));
		
        return vehicles;
    }

}