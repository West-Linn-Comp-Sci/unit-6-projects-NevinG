public class ChessBoard1
 
{
    public static void main(String[] args)
    {
        //Create an 8x8 2D String array called chess.
        String[][] chess = new String[8][8];
        chess[0][0] = "Rook";
        chess[0][1] = "Knight";
        chess[0][2] = "Bishop";
        chess[0][3] = "Queen";
        chess[0][4] = "King";
        chess[0][5] = "Bishop";
        chess[0][6] = "Knight";
        chess[0][7] = "Rook";

        for(int i = 0; i < chess[1].length; i++)
        {
            chess[1][i] = "Pawn";
        }

        for(int x = 2; x <= 5; x++)
        {
            for(int y = 0; y < chess[x].length; y++)
            {
                chess[x][y] = "-";
            }
        }

        for(int i = 0; i < chess[6].length; i++)
        {
            chess[6][i] = "Pawn";
        }

        chess[7][0] = "Rook";
        chess[7][1] = "Knight";
        chess[7][2] = "Bishop";
        chess[7][3] = "Queen";
        chess[7][4] = "King";
        chess[7][5] = "Bishop";
        chess[7][6] = "Knight";
        chess[7][7] = "Rook";
        
        //Use this method to print the chess board onto the console
        print(chess);
        
 
    }
    
    //Do not make alterations to this method!
    public static void print(String[][] array)
    {
        for(String[] row: array)
        {
            for(String thing: row)
            {
                System.out.print(thing + "\t");
            }
            System.out.println();
        }
    }
}
 
