public class BattleShip 
{
    int health;
    public boolean placed = false;

    public BattleShip(int size)
    {
        this.health = size;
    }

    public void shoot()
    {
        health--;       
    }
}
