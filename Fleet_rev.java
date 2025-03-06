package Lab9;
import java.util.ArrayList;


public class Fleet_rev
{
    //collection of vehicle object
    private ArrayList<Vehicle> vehicles;
    //necessary constants for instantiating vehicle objects.
    private final int weightCapacity = 100;
    private final int shippingCost = 100;
    private ArrayList <Item> items;


    public void createShipmentRevision(Inventory inventory)
    {
        items = new ArrayList<>(); 
        vehicles = new ArrayList<>();
        items = inventory.getItems();

        int i = 0; // checker for every item in the inventory
        Boolean loopChecker = true; // lets the program to go out of the loop when the max capacity is extended so when it is changed a new vehicle will be send
        
        Vehicle vehicle = new Vehicle(shippingCost, 0, null); // creates a new vehicle
        while(i < items.size()) // looks for every item
        {
            if (vehicle.getCurrentWeight() <= weightCapacity && loopChecker) // it may have a lower value but in the loop it can be increased to higher value
            {
                vehicle.setItems(items.get(i));
                vehicle.increaseCurrentWeight(items.get(i).getTotalWeight());
                   
               
            }
            if (vehicle.getCurrentWeight() > weightCapacity ) // so this if is used
            {
                vehicle.removeItems(items.get(i));
                vehicle.decreaseCurrentWeight(items.get(i).getTotalWeight());
                //removed all the items that overloads the vehicle
                int constantCount = items.get(i).getCount(); //constant for loop
                int itemSingleWeight = items.get(i).getSingleWeight();
                for(int j = 0; j < constantCount; j++) // checker for every items count
                {
                    vehicle.increaseCurrentWeight(itemSingleWeight);
                    if (vehicle.getCurrentWeight() <= weightCapacity) // if its smaller added 1 count
                    {
                        Item item = new Item(items.get(i));
                        item.switchID(items.get(i));
                        item.setCount(j + 1);
                        vehicle.setItems(item);
                    }
                    else 
                    {
                        items.get(i).decreaseCount(j); // decreasing amount because it is added
                        vehicle.decreaseCurrentWeight(items.get(i).getSingleWeight());
                        vehicles.add(vehicle);
                        vehicle = new Vehicle(shippingCost, 0, null);
                        vehicle.setItems(items.get(i));
                        vehicle.increaseCurrentWeight(items.get(i).getTotalWeight());
                        vehicles.add(vehicle);
                        loopChecker = false;
                    }
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
