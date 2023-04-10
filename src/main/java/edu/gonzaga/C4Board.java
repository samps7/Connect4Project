package edu.gonzaga;

public class C4Board 
{
    private Coin[][] grid = new Coin[6][7];
    //private int[][] grid = new int[7][6]; // we will replace with "Coins" for actual
    public C4Board()
    {
        
    }

    public boolean acceptCoin(Coin c, int col)
    {
        int bot = 6;
        if(col > 6 || col < 0)
        {
            return false;
        }
        for(int i = 0; i < 6; i++)
        {
            if(grid[i][col] == null)
            {
                bot = i;
            }
            else
            {
                break;
            }
        }
        if(bot < 6 && bot > -1)
        {
            grid[bot][col] = c;
            return true;
        }
        return false;
    }

    public String boardDisplay()
    {
        String str = "This is the board: \n";
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == null)
                {
                    str += " - ";
                }
                else
                {
                    str += " " + grid[i][j].getLetter() + " ";
                }
            }
            str += "\n";
        }
        str += " 0  1  2  3  4  5  6 ";

        return str;
    }

    


}
