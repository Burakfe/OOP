package Lab9;

public class Item 
{
    private static int number = 1;
    private int ID;
    private int weight;
    private int price;
    private int count;
    private String type;
    private int totalWeight;

    public Item(String type, int weight, int price, int count)
    {
        ID = number;
        this.weight = weight;
        this.price = price;
        this.count = count;
        this.type = type;
        number++;
        totalWeight = weight * count; 
    }
    public Item(Item item)
    {
        item = new Item(item);
    }
    public int getTotalWeight()
    {
        return totalWeight;
    }
    public int getSingleWeight()
    {
        return this.weight;
    }
    public int getCount()
    {
        return count;
    }
    public void decreaseCount(int n)
    {
        this.count -= n;
    }
    public void setCount(int number)
    {
        this.count = number;
    }
    public void switchID(Item item)
    {
        int temp = 0;
        temp = item.ID;
        item.ID = this.ID;
        this.ID = temp;
    }
    public String toString()
    {
        String result = "";
        result += "Item " + ID + " : \n";
        result += "         Type : " + type + "\n";
        result += "         Count : " + count + "\n";
        result += "         Weight : " + weight + "\n";
        result += "         Price : " + price + "\n";
        return result;
    }
}
