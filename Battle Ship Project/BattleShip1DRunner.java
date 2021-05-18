import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class BattleShip1DRunner 
{
    public enum Stage 
    {
        PLACING,GUESSING
    }

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static BattleShip1D myBattleShipMap;
    public static BattleShip1D computerBattleShipMap;

    public static Stage stage;
    public static GUI myGui;
    public static GUI computerGui;
    //array of all valid areas the computer can guess, assigned after grid size is determined
    static ArrayList<Integer> computerGuesses = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        //create our battleship
        int xSize = 10;
        int ySize = 10;

        int numOfShips = 1;
        int shipSize = 3;
        myBattleShipMap = new BattleShip1D(xSize, ySize);
        
        //create GUI
        myGui = new GUI(500,500,xSize, ySize, true, "Player board", myBattleShipMap);
        computerGui = new GUI(500,500,xSize, ySize, false, "Computer board", computerBattleShipMap);

        /*
        //creates computerBattleShip map
        computerBattleShipMap = new BattleShip1D(xSize, ySize);
        
        //places computers ships randomly
        computerBattleShipMap.placeBattleShip(random.nextInt(xSize-shipSize),random.nextInt(ySize),shipSize, true);
        */

        //lets user position their ships on the map
        stage = Stage.PLACING;

        myBattleShipMap.currentBattleShip = new BattleShip(5);
        System.out.println("Place Ship 1. It is 5 tiles long. Place it on player board");
        System.out.println("Click on the 5 tiles where you want to place your ship");
        System.out.println("Press enter to move on to next ship once done");
        scanner.nextLine();
        myBattleShipMap.confirmBattleShipPlace();

        myBattleShipMap.currentBattleShip = new BattleShip(4);
        System.out.println("Place Ship 1. It is 4 tiles long. Place it on player board");
        System.out.println("Click on the 4 tiles where you want to place your ship");
        System.out.println("Press enter to move on to next ship once done");
        scanner.nextLine();
        myBattleShipMap.confirmBattleShipPlace();

        myBattleShipMap.currentBattleShip = new BattleShip(3);
        System.out.println("Place Ship 1. It is 3 tiles long. Place it on player board");
        System.out.println("Click on the 3 tiles where you want to place your ship");
        System.out.println("Press enter to move on to next ship once done");
        scanner.nextLine();
        myBattleShipMap.confirmBattleShipPlace();

        myBattleShipMap.currentBattleShip = new BattleShip(3);
        System.out.println("Place Ship 1. It is 3 tiles long. Place it on player board");
        System.out.println("Click on the 3 tiles where you want to place your ship");
        System.out.println("Press enter to move on to next ship once done");
        scanner.nextLine();
        myBattleShipMap.confirmBattleShipPlace();

        myBattleShipMap.currentBattleShip = new BattleShip(2);
        System.out.println("Place Ship 1. It is 2 tiles long. Place it on player board");
        System.out.println("Click on the 2 tiles where you want to place your ship");
        System.out.println("Press enter to move on to next ship once done");
        scanner.nextLine();
        myBattleShipMap.confirmBattleShipPlace();

        stage = Stage.PLACING;
        /*
        //prepares computerGuesses array
        for(int i = 0; i < arraySize; i++)
        {
            computerGuesses.add(i);
        }
        */
        
        //startgame
        /*
        //as long as there are still no one has no battleship
        while(myBattleShipMap.checkForBattleShips() && computerBattleShipMap.checkForBattleShips())
        {
            //ask user where to shoot, and aslong as they get a hit they get to go again
            boolean hit = true;
            
            //as long as there are still no one has no battleship & still haven't missed
            while(hit && myBattleShipMap.checkForBattleShips() && computerBattleShipMap.checkForBattleShips())
            {
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
        */
    }
}