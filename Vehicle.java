package Lab9;
import java.util.ArrayList;
public class Vehicle {
    private static int number = 1;
    private int ID;
    private final int WEIGHT_CAPACITY = 100;
    private final int SHOPPING_COST = 100;
    private int currentWeight;
    private ArrayList <Item> items;

    public Vehicle(int shippingCost, int currentWeight, ArrayList<Item> items)
    {
        items = new ArrayList<>();
        this.ID = number;
        shippingCost = this.SHOPPING_COST;
        this.currentWeight = currentWeight;
        this.items = items;
        number++;
    }
    public void increaseCurrentWeight(int value)
    {
        this.currentWeight += value;
    }
    public void decreaseCurrentWeight(int value)
    {
        this.currentWeight -= value;
    }
    public void setCurrentWeight(int value)
    {
        this.currentWeight = 0;
    }
    public void setItems(Item item)
    {
        items.add(item);
    }
    public void removeItems(Item item)
    {
        items.remove(item);
    }
    public int getCurrentWeight()
    {
        return currentWeight;
    }
    public String toString()
    {
        String result = "";
        result += "Vehicle " + this.ID + " : \n";
        result += "         Remaining Capacity: " + (this.WEIGHT_CAPACITY - this.currentWeight) + "\n";
        result += "         Shipping Cost: " + this.SHOPPING_COST + "\n";
        result += "         Current Weight: " + this.currentWeight + "\n";
        result += "Items: \n";
        for(int i = 0; i < items.size(); i++)
        {
            result += items.get(i);
        }
        return result;
    }
}
