import java.util.ArrayList;

public class Purse 
{ 
    private ArrayList<Coin> coins; 
    
    public Purse() 
    { 
        coins = new ArrayList<Coin>(); 
    }
    
    // adds aCoin to the purse 
    public void add(Coin aCoin) 
    { 
        coins.add(aCoin); 
    } 
    
    // returns total value of all coins in purse 
    public double getTotal() 
    { 
        double total = 0;
        for(Coin coin : coins)
        {
            total+= coin.getValue();
        }
        return total;
    } 
    
    // returns the number of coins in the Purse that matches aCoin 
    // (both myName & myValue) 
    public int count(Coin aCoin) 
    {
        int total = 0;
        for(Coin coin : coins)
        {
            if(coin.equals(aCoin))
            {
                total++;
            }
        }
        return total;
    } 
    
    // returns the name of the Coin in the Purse that has the smallest value
    public String findSmallest()
    {
        Coin smallestCoin = coins.get(0);
        for(Coin c : coins)
        {
            if(c.getValue() < smallestCoin.getValue())
            {
                smallestCoin = c;
            }
        }
        return smallestCoin.getName();
    } 
}