import java.util.Scanner;
  
public class TicTacToeTest
{
  
    public static void main(String[ ] args) 
	{
          
        TicTacToe t = new TicTacToe();
		Display t2=new Display();
        Scanner s = new Scanner(System.in);
        int x=0,y=0,bn;
        do
        {
			t2.Matrix();
            t.Matrix();
            System.out.println(t.player==t.X?"Player X turn":"Player O turn");
            System.out.println("Enter Box Num:");
			bn=s.nextInt();
            
			switch(bn)
			{
				case 1:
				t.putSign(0,0);
				break;
				
				case 2:
				t.putSign(0,1);
				break;
				
				case 3:
				t.putSign(0,2);
				break;
				
				case 4:
				t.putSign(1,0);
				break;
				
				case 5:
				t.putSign(1,1);
				break;
				
				case 6:
				t.putSign(1,2);
				break;
				
				case 7:
				t.putSign(2,0);
				break;
				
				case 8:
				t.putSign(2,1);
				break;
				
				case 9:
				t.putSign(2,2);
				break;
				
				default:
				System.out.println("Invalid Input");
				
			}
              
            t.Matrix();
            System.out.println("_____________________________");
            t.displayWinner();
              
        }while(t.isEmpty);
    }
}
  
class TicTacToe
{
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
      
    public int player = X;
    private int[][] board = new int[3][3];
    public boolean isEmpty = false;
      
    /** Puts an X or O mark at position i,j. */
    public void putSign(int x, int y)
    {
        if(x<0 || x>2 || y<0 || y>2)
        {
            System.out.println("Invalid board position");
            return;
        }
        if(board[x][y] != EMPTY)
        {
            System.out.println("Board position occupied");
            return;
        }
        board[x][y] = player;   // place the mark for the current player
        player = -player;       // switch players (uses fact that O = - X)
    }
      
    /** Checks whether the board configuration is a win for the given player. */
    public boolean isWin(int player)
    {
        return ((board[0][0] + board[0][1] + board[0][2] == player*3) ||
                (board[1][0] + board[1][1] + board[1][2] == player*3) ||
                (board[2][0] + board[2][1] + board[2][2] == player*3) ||
                (board[0][0] + board[1][0] + board[2][0] == player*3) ||
                (board[0][1] + board[1][1] + board[2][1] == player*3) ||
                (board[0][2] + board[1][2] + board[2][2] == player*3) ||
                (board[0][0] + board[1][1] + board[2][2] == player*3) ||
                (board[2][0] + board[1][1] + board[0][2] == player*3));
    }
      
    /**display the winning player or indicate a tie (or unfinished game).*/
    public void displayWinner()
    {
        if(isWin(X))
        {
            System.out.println("\n X Wins...!!");
            isEmpty=false;
        }
        else if(isWin(O))
        {
            System.out.println("\n O Wins...!!");
            isEmpty=false;
        }
        else
        {
            if(!isEmpty)
            {
                System.out.println("It's a Tie");
            }
              
        }
    }
     	
	 
    public void Matrix()
    {
        StringBuilder s = new StringBuilder();
        isEmpty = false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(board[i][j])
                {
                case X:
                    s.append(" X ");
                    break;
                case O:
                    s.append(" O ");
                    break;
                case EMPTY:
                    s.append("   ");
                    isEmpty=true;
                    break;
                }
                if(j<2)
                {
                    s.append("|");
                }
                  
            }
            if(i<2)
            {
                s.append("\n-----------\n");
            }
        }
        System.out.println(s);
    }
}

class Display extends TicTacToe
{
	public void Matrix()
	{
		int z=1;
		for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.printf(" %d ",z);
                if(j<2)
                {
                    System.out.printf("|");
                }
                 z++; 
            }
            if(i<2)
            {
                System.out.println("\n-----------");
            }
			
        }
		System.out.println("\n");
		
	}
}