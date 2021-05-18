import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI 
{
    BattleShip1D battleShipMap;
    JButton[][] myBoard;
    static Icon water = new ImageIcon("Images/Water.png");
    static Icon ship = new ImageIcon("Images/Ship.png");
    static Icon sunkShip = new ImageIcon("Images/SunkShip.png");

    int width;
    int height;
    public GUI(int width, int height, int xSize, int ySize, boolean playerBoard,String boardName,BattleShip1D battleShipMap)
    {
        this.battleShipMap = battleShipMap;
        this.width = width;
        this.height = height;

        JFrame frame = new JFrame(boardName);
        frame.setLayout(null);//this allows me to choose where each component is since ther is no layout

        //create button grids
        myBoard = new JButton[ySize][xSize];
        for(int x = 0; x < myBoard.length; x++)
        {
            for(int y = 0; y < myBoard[x].length; y++)
            {
                myBoard[x][y] = new JButton(water);
                myBoard[x][y].setBounds(x*(width/xSize),y*(height/ySize),width/xSize,height/ySize);
                myBoard[x][y].addActionListener(new Listener(x,y,playerBoard));
                frame.add(myBoard[x][y]);
            }
        }

        frame.setSize(width+16,height+39);
        frame.setVisible(true);
    }

    public void update()
    {
        for(int x = 0; x < myBoard.length; x++)
        {
            for(int y = 0; y < myBoard[x].length; y++)
            {
                if(battleShipMap.battleShipGrid[x][y] == null)
                {
                    myBoard[x][y].setIcon(water);
                }
                else if(battleShipMap.battleShipGrid[x][y].health > 0)
                {
                    myBoard[x][y].setIcon(ship);
                }
                else
                {
                    myBoard[x][y].setIcon(sunkShip);
                }
                
            }
        }
    }
}
