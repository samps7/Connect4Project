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


    /* 
    * Note we only have to check if there is a winner (at the end of each round)
    * The winner is whoever moved right before the check 
    * (because you can't win on an opponent's turn)
    */
    public boolean checkWinner()
    {
        // check across horizontally
        for(int i = 5; i > -1; i--)
        {
            for(int j = 0; j < 4; j++)
            {
                if(!(grid[i][j] == null || grid[i][j+1] == null || grid[i][j+2] == null || grid[i][j+3] == null))
                {
                    if(grid[i][j].equals(grid[i][j + 1]) && grid[i][j+1].equals(grid[i][j + 2]) 
                    && grid[i][j+2].equals(grid[i][j + 3]))
                    {
                        // can highlight winning coins here before returning
                        return true;
                    }
                }
            }
        }

        // check upward vertically
        for(int i = 2; i > -1; i--)
        {
            for(int j = 0; j < 7; j++)
            {
                if(!(grid[i][j] == null || grid[i+1][j] == null || grid[i+2][j] == null || grid[i+3][j] == null))
                {
                    if(grid[i][j].equals(grid[i + 1][j]) && grid[i + 1][j].equals(grid[i + 2][j]) 
                    && grid[i + 2][j].equals(grid[i + 3][j]))
                    {
                        // can highlight winning coins here before returning
                        return true;
                    }
                }
            }
        }
        
        // Diagonal Check 1
        for(int i = 2; i > -1; i--)
        {
            for(int j = 0; j < 4; j++)
            {
                if(!(grid[i][j] == null || grid[i+1][j+1] == null || grid[i+2][j+2] == null || grid[i+3][j+3] == null))
                {
                    if(grid[i][j].equals(grid[i + 1][j + 1]) && grid[i + 1][j + 1].equals(grid[i + 2][j + 2]) 
                    && grid[i + 2][j + 2].equals(grid[i + 3][j + 3]))
                    {
                        // can highlight winning coins here before returning
                        return true;
                    }
                }
            }
        }


        // Diagonal Check 2
        for(int i = 2; i > -1; i--)
        {
            for(int j = 0; j < 4; j++)
            {
                if(!(grid[i][j] == null || grid[i+1][j-1] == null || grid[i+2][j-2] == null || grid[i+3][j-3] == null))
                {
                    if(grid[i][j].equals(grid[i + 1][j - 1]) && grid[i + 1][j - 1].equals(grid[i + 2][j - 2]) 
                    && grid[i + 2][j - 2].equals(grid[i + 3][j - 3]))
                    {
                        // can highlight winning coins here before returning
                        return true;
                    }
                }
            }
        }


        return false;
    }

    


}
