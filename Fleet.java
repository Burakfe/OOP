package Lab9;
import java.util.ArrayList;

public class Fleet 
{
    //collection of vehicle object
    private ArrayList<Vehicle> vehicles;
    //necessary constants for instantiating vehicle objects.
    private final int WEIGHT_CAPACITY = 100;
    private final int SHIPPING_COST = 100;
    private ArrayList <Item> items;
    

    public void createShipment(Inventory inventory)
    {
        items = new ArrayList<>();
        vehicles = new ArrayList<>();
        items = inventory.getItems();

        int i = 0; // checker for every item in the inventory
        Boolean loopChecker = true; // lets the program to go out of the loop when the max capacity is extended so when it is changed a new vehicle will be send
        Vehicle vehicle = new Vehicle(SHIPPING_COST, 0, null); // creates a new vehicle
       
        while(i < items.size()) // looks for every item
        {
            if (vehicle.getCurrentWeight() <= WEIGHT_CAPACITY && loopChecker) // it may have a lower value but in the loop it can be increased to higher value
            {
                vehicle.setItems(items.get(i));
                vehicle.increaseCurrentWeight(items.get(i).getTotalWeight());
                if (vehicle.getCurrentWeight() > WEIGHT_CAPACITY) // so this if is used
                {
                    vehicle.removeItems(items.get(i));
                    vehicle.decreaseCurrentWeight(items.get(i).getTotalWeight());
                    vehicles.add(vehicle);
                    vehicle = new Vehicle(SHIPPING_COST, 0, null);
                    vehicle.setItems(items.get(i));
                    vehicle.increaseCurrentWeight(items.get(i).getTotalWeight());
                    vehicles.add(vehicle);
                    loopChecker = false;
                }
            }
            i++;
        }
    }
    public void listFleet()
    {
       for(int i = 0; i < vehicles.size(); i++)
       {
            System.out.println(vehicles.get(i));
       } 
    }
}
