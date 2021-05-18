
import java.awt.event.*;

class Listener implements ActionListener
{
    boolean playerBoard;
    public int x;
    public int y;

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(BattleShip1DRunner.stage == BattleShip1DRunner.Stage.PLACING && playerBoard)
        {
            BattleShip1DRunner.myBattleShipMap.placeBattleShip(x, y);
            BattleShip1DRunner.myGui.update();
        }
    }

    public Listener (int x,int y, boolean playerBoard)
    {
        this.playerBoard = playerBoard;
        this.x = x;
        this.y = y;
    }
}