package ParkingLot;

import java.util.Date;
import java.util.List;
// 1. Always think of righting the base clas first
import java.util.Map;

class ParkingLot{
    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exits;
    
    Address address;
    String parkingLotName;

    public boolean isParkingSpaceAvailableForVehicle(Vehicle Vehicle){
        // TODO Immplementation
        return true;
    };
    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId){
        // TODO Immplementation
        return true;
    };

} 

class ParkingFloor{
    int levelId;
    boolean isFull;
    List<ParkingSpace> parkingSpaces;
    ParkingDisplayBoard parkingDisplayBoard;
}


class Gate{
    int gateId;
    ParkingAttendant parkingAttendant;
}

class Entrance extends Gate{
    public ParkingTicket getParkingTicket(Vehicle vehicle){
        return new ParkingTicket();
        // TODO Immplementation
    };
}

class Exit extends Gate{
    public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType){
        return new ParkingTicket();
        // TODO Immplementation
    };
}

class Address{
    String country;
    String state;
    String city;
    String street;
    String pinCode;
}

class ParkingSpace{
    int spaceId;
    boolean isFull;
    double costPerHour;
    Vehicle vehicle;
    ParkingSpaceType parkingSpaceType;
}

class ParkingDisplayBoard{
    Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;
    public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces){
        //TODO implemmentaiton
    };
}

class Account{
    String name;
    String email;
    String password;
    String empId;
    Address address;
}

class Admin extends Account{
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        return true;
    };

    public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace){
        return true;
    };

    public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoard){
        return true;
    };
}

class ParkingAttendant extends Account{
    Payment paymentService;
    
    public boolean processVehicleEntry(Vehicle vehicle){
        return true;
    }

    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType){
        // TODO Immplementation
        return new PaymentInfo();
    };

}

class Vehicle{
    String licenseNumber;
    VehicleType vehicleType;
    ParkingTicket parkingTicket;
    PaymentInfo paymentInfo;
}

class ParkingTicket{
    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDate;
    Date vehicleExitDate;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    public void updateTotalCost(){
        // TODO Immplementation
    };
    public void updateVehicleExitTime(Date vehicleExitTime){
        // TODO Immplementation
    };
}


class Payment{
    public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType){
        // TODO Implementation
        return new PaymentInfo();
    }
}

class PaymentInfo{
    double amount;
    Date paymentDate;
    int transactionId;
    ParkingTicket parkingTicket;
    PaymentStatus paymentStatus;
}

enum PaymentType{
    CREDIT_CARD, DEBIT_CARD, UPI;
}

enum ParkingSpaceType{
    BIKE_PARKING, CAR_PARKING, TRUCK_PARKING;
}

enum VehicleType{
    BIKE, CAR, TRUCK;
}

enum ParkingTicketStatus{
    PAID, ACTIVE;
}

enum PaymentStatus{
    UNPAID, PAID, COMPLETED, DECLINED, CANCELLED, REFUNDED;
}