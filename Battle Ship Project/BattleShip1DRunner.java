import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class BattleShip1DRunner 
{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static BattleShip1D myBattleShipMap;
    static BattleShip1D computerBattleShipMap;
    
    //array of all valid areas the computer can guess, assigned after grid size is determined
    static ArrayList<Integer> computerGuesses = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        //create our battleship
        System.out.println("Enter in the size of the lake you want your battleship to be in");
        int arraySize = scanner.nextInt();
        
        System.out.println("Enter the number of battleships you want");
        int numOfShips = scanner.nextInt();
        
        System.out.println("Enter in the size of your battleship");
        int shipSize = scanner.nextInt();
        myBattleShipMap = new BattleShip1D(arraySize);
        
        //creates computerBattleShip map
        computerBattleShipMap = new BattleShip1D(arraySize);
        
        //places computers ships randomly
        computerBattleShipMap.placeBattleShip(random.nextInt(arraySize-shipSize),shipSize);

        //lets user position their ships on the map
        for(int i = 0; i < numOfShips; i++)
        {
            System.out.println(
            "\nThis is ship " + i + "." +
            "\nWhere would you like to place the left most part of the battleship on the sea?"+
            "\nYour Ship will be placed horizontally."+
            "\nYou can place this ship on positions 0-" + (arraySize-shipSize) + ".");
            int shipPosition = scanner.nextInt();
            myBattleShipMap.placeBattleShip(shipPosition, shipSize);
            System.out.println("Ship successfully placed");
        }
        
        //prepares computerGuesses array
        for(int i = 0; i < arraySize; i++)
        {
            computerGuesses.add(i);
        }
        
        //startgame
        
        //as long as there are still no one has no battleship
        while(myBattleShipMap.checkForBattleShips() && computerBattleShipMap.checkForBattleShips())
        {
            //ask user where to shoot, and aslong as they get a hit they get to go again
            boolean hit = true;
            
            //as long as there are still no one has no battleship & still haven't missed
            while(hit && myBattleShipMap.checkForBattleShips() && computerBattleShipMap.checkForBattleShips())
            {
                System.out.println("\nIt's time for you to fire a missle. Type the cordinates of the location you want to shoot");
                int shootPosition = scanner.nextInt();
                hit = computerBattleShipMap.shootBattleShip(shootPosition);
            }
            
            //computers turn
            //eventually imporve ai to shoot adjacent tiles after getting a hit.
            hit = true;
            
            //as long as there are still no one has no battleship & still havent missed
            while(hit && myBattleShipMap.checkForBattleShips() && computerBattleShipMap.checkForBattleShips())
            {
                //Gets new position for computer to shoot
                int shootIndex = random.nextInt(computerGuesses.size()); //gets a random index in our computerGuesses array
                int positionShot = computerGuesses.get(shootIndex); //get the position for our random guess
                computerGuesses.remove(shootIndex); //removed the used position from our array
                
                //shoots that position
                System.out.println("\nThe computer shot " + positionShot);
                hit = myBattleShipMap.shootBattleShip(positionShot);
            }
            
        }
        
        //this is what runs when someone has won
        
        //if user wins
        if(!computerBattleShipMap.checkForBattleShips())//if computer battle ship grid has no more battleships
        {
            System.out.println("YOU WIN");
            System.out.println("You did " + computerBattleShipMap.overallRating());
        }
        
        //if computer wins
        if(!myBattleShipMap.checkForBattleShips())//if computer battle ship grid has no more battleships
        {
            System.out.println("You Lost to the computer. LOL");
        }
        
        //need to add replayabiity to code restarts once someone wins.
    }
}