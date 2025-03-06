package Lab9;
import java.util.Scanner;
import java.util.ArrayList;
//!! TOTAL PRICE AND WEIGHT !!!!
public class Inventory {
    Scanner in = new Scanner(System.in);

    private ArrayList<Item> items;
    private int totalPrice = 0;
    private int totalWeight = 0;
    
    public void fillInventory()
    {
        items = new ArrayList<>();
        System.out.println("Type the number of the item you want to add to the inventory");
        System.out.println("1) Book, 2) Television, 3) Water, 4) Milk, 5) Exit");
        int typeSelection = in.nextInt();
        String otherValues;
        int weight = 0;
        int price = 0;
        int count = 0;
        
        while (typeSelection != 5) 
        {
            
            if (typeSelection == 1) 
            {
                
                System.out.println("Enter the weight, price, and count for the Book. Use a comma to separate each value." + in.nextLine());    
                otherValues = in.nextLine();
                int i = 0; // substring checker for weight
                while (otherValues.charAt(i) != ',') 
                {
                    i++;
                }
                weight = Integer.parseInt(otherValues.substring(0,i));
                
                int j = i + 1;
                while (otherValues.charAt(j) != ',') 
                {
                    j++;    
                }
                price = Integer.parseInt(otherValues.substring(i + 1, j));
                count = Integer.parseInt(otherValues.substring(j + 1, otherValues.length()));
                totalWeight += weight * count;
                totalPrice += price * count;

                Item Item = new Item("Book", weight, price, count);
                items.add(Item);
                weight = 0; price = 0; count = 0;
            }
            else if (typeSelection == 2) 
            {
                System.out.println("Enter the weight, price, and count for the Television. Use a comma to separate each value." + in.nextLine());
                otherValues = in.nextLine();
                int i = 0; // substring checker for weight
                while (otherValues.charAt(i) != ',') 
                {
                    i++;
                }
                weight = Integer.parseInt(otherValues.substring(0,i));
                
                int j = i + 1;
                while (otherValues.charAt(j) != ',') 
                {
                    j++;    
                }
                price = Integer.parseInt(otherValues.substring(i + 1, j));      
                
                count = Integer.parseInt(otherValues.substring(j + 1, otherValues.length()));
                totalWeight += weight * count;
                totalPrice += price * count;
                Item Item = new Item("Television", weight, price, count);
                items.add(Item);
                weight = 0; price = 0; count = 0;
            }
            else if (typeSelection == 3) 
            {
                System.out.println("Enter the weight, price, and count for the Water. Use a comma to separate each value." + in.nextLine());
                otherValues = in.nextLine();
                int i = 0; // substring checker for weight
                while (otherValues.charAt(i) != ',') 
                {
                    i++;
                }
                weight = Integer.parseInt(otherValues.substring(0,i));
                
                int j = i + 1;
                while (otherValues.charAt(j) != ',') 
                {
                    j++;
                }
                price = Integer.parseInt(otherValues.substring(i + 1, j));
                
                count = Integer.parseInt(otherValues.substring(j + 1, otherValues.length()));
                totalWeight += weight * count;
                totalPrice += price * count;
                Item Item = new Item("Water", weight, price, count);
                items.add(Item);
                weight = 0; price = 0; count = 0;
            }
            else
            {
                System.out.println("Enter the weight, price, and count for the Milk. Use a comma to separate each value." + in.nextLine());
                otherValues = in.nextLine();
                int i = 0; // substring checker for weight
                while (otherValues.charAt(i) != ',') 
                {
                    i++;
                }
                weight = Integer.parseInt(otherValues.substring(0,i));
               
                int j = i + 1; // for the second , initializing a integer to look up.
                while (otherValues.charAt(j) != ',') 
                {
                    j++;    
                }
                price = Integer.parseInt(otherValues.substring(i + 1, j));
                
                count = Integer.parseInt(otherValues.substring(j + 1, otherValues.length()));
                totalWeight += weight * count;
                totalPrice += price * count;
                Item Item = new Item("Milk", weight, price, count);
                items.add(Item);
                weight = 0; price = 0; count = 0; //making them all 0 for the next item inputs.
            }
            System.out.println("Type the number of the item you want to add to the inventory");
            System.out.println("1) Book, 2) Television, 3) Water, 4) Milk, 5) Exit");
            typeSelection = in.nextInt();
        }
    }
    public void listInventory()
    {
        for(int i = 0; i < items.size(); i++)
        {
            System.out.println(items.get(i));
        }
    }
    public ArrayList<Item> getItems()
    {
        return items;
    }
    public int getTotalPrice()
    {
        return totalPrice;
    }
    public int getTotalWeight()
    {
        return totalWeight;
    }
}
