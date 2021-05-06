public class BattleShip1D
{
   boolean[] battleShipGrid; 
   int guesses = 0;
   int gridSize;
   
   
   //Constructor
   public BattleShip1D(int gridSize)
   {
       battleShipGrid= new boolean[gridSize];
   }
   
   public boolean checkForBattleShips() //checks if there are alive battleships remaining, returns true or false
   {
       for(int i = 0; i < battleShipGrid.length; i++)
       {
           if(battleShipGrid[i])
           {
               return true;
           }
       }
       return false;
   }
   
   public boolean shootBattleShip(int index)
   {
       guesses++;
       if(battleShipGrid[index])
       {
           battleShipGrid[index] = false;
           System.out.println("Hit!");
           //eventually change to say sink if it sinks the full ship
           return true;
       }
       else
       {
           System.out.println("Miss!");
       }
       return false;
   }
        
   
   //placeBattleShip(int[] indexs)
   public void placeBattleShip(int leftIndex, int size)
   {
      // int something= Math.Random()*6
       //int 
       for(int i=0 ;i<size; i++)
       {
           battleShipGrid[leftIndex+i] = true;
       }
   }
   
   public String overallRating()
   {
      String rating;
       if(guesses==3)
        {
            rating="perfect"; 
        }
        else if(guesses==4)
        {
            rating="Great"; 
        }
        else if(guesses==5)
        {
            rating="Ok"; 
        }
        else if(guesses==6)
        {
            rating="Bad"; 
        }
        else
        {
            rating="Pretty Bad"; 
        }
        
        return rating;
   }
}