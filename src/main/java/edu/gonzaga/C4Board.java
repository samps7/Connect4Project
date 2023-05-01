package edu.gonzaga;

public class C4Board 
{
    private Coin[][] grid = new Coin[6][7];
    //private int[][] grid = new int[7][6]; // we will replace with "Coins" for actual
    public C4Board()
    {
        
    }

    /**
     * This function accepts a coin and a column number, and places the coin in the lowest available
     * slot in that column of a grid.
     * 
     * @param c The coin that is being inserted into the grid.
     * @param col col is an integer parameter representing the column in which the coin is being
     * inserted in a grid.
     * @return The method is returning a boolean value. It returns true if the coin was successfully
     * accepted and placed in the specified column of the grid, and false if the column is full or the
     * specified column is out of bounds.
     */
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

    /**
     * The function returns a string representation of a game board with letters or dashes in each
     * cell.
     * 
     * @return The method `boardDisplay()` returns a string that represents the current state of the
     * game board. The string includes a visual representation of the board with each cell either
     * displaying a letter or a dash if the cell is empty. The last line of the string displays the
     * column numbers for reference.
     */
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
            for(int j = 3; j < 7; j++)
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

    /**
     * This Java function returns the element at the specified row and column index in a 2D array of
     * Coin objects.
     * 
     * @param row The row index of the element in the 2D array that we want to retrieve.
     * @param col The "col" parameter in the above code represents the column index of a 2D array
     * called "grid". The method "returnArrayIndex" takes two parameters, "row" and "col", and returns
     * the value at the specified row and column index in the "grid" array.
     * @return The method `returnArrayIndex` is returning the `Coin` object located at the specified
     * `row` and `col` indices in the `grid` array.
     */
    public Coin returnArrayIndex(int row, int col)
    {
        return grid[row][col];
    }


}
