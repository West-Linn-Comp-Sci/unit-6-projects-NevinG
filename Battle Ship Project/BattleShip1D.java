public class BattleShip1D
{
   public BattleShip[][] battleShipGrid; 
   int guesses = 0;
   int gridWidth;
   int gridHeight;
   
   public BattleShip currentBattleShip;
   //Constructor
   public BattleShip1D(int gridWidth, int gridHeight)
   {
       battleShipGrid= new BattleShip[gridWidth][gridHeight];
   }
   
   public boolean checkForBattleShips() //checks if there are alive battleships remaining, returns true or false
   {
       for(int x = 0; x < battleShipGrid.length; x++)
       {
            for(int y = 0; y < battleShipGrid[x].length; y++)
            {
                if(battleShipGrid[x][y] != null && battleShipGrid[x][y].stillFloating)
                {
                    return true;
                }
            }
       }
       return false;
   }
   
   public boolean shootBattleShip(int xIndex, int yIndex)
   {
       guesses++;
       if(battleShipGrid[xIndex][yIndex] != null)
       {
           battleShipGrid[xIndex][yIndex].shoot();
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
   public void placeBattleShip(int x, int y)
   {
       // int something= Math.Random()*6
       //int 
       if(battleShipGrid[x][y] == null)
       {
        battleShipGrid[x][y] = currentBattleShip;
       }
       else if(!battleShipGrid[x][y].placed)
       {
        battleShipGrid[x][y] = null;
       }
       
   }

   public void confirmBattleShipPlace()
   {
        for(int x = 0; x < battleShipGrid.length; x++)
        {
            for(int y = 0; y < battleShipGrid[x].length; y++)
            {
                if(battleShipGrid[x][y] != null)
                {
                    battleShipGrid[x][y].placed = true;
                }
            }
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