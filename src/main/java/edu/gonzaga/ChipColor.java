package edu.gonzaga;

import javax.swing.*;

public class ChipColor
{
    private final String red = "https://kevinshannon.com/connect4/img/bestchipred.png";
    private final String blue = "https://kevinshannon.com/connect4/img/bestchipblue.png";
    private final String green = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Eo_circle_green_blank.svg/2048px-Eo_circle_green_blank.svg.png";

    private String selectedColor;
    /**
     * The function sets the selected color based on the input string.
     * 
     * @param color A String representing the color to be set. It can be "Green", "Blue", or "Red".
     */
    public void setColor(String color)
    {
        if(color.equals("Green"))
            this.selectedColor = this.green;
        if(color.equals("Blue"))
            this.selectedColor = this.blue;
        if(color.equals("Red"))
            this.selectedColor = this.red;
    }
    
    /**
     * The function returns the selected color.
     * 
     * @return The method `getColor()` is returning the value of the instance variable `selectedColor`.
     */
    public String getColor()
    {
        return this.selectedColor;
    }

    /**
     * The function returns a new ImageIcon object with the selected color.
     * 
     * @return An ImageIcon object is being returned.
     */
    private ImageIcon setIcon()
    {
        return new ImageIcon(this.selectedColor);
    }

    /**
     * The function returns a new JLabel object with an icon set.
     * 
     * @return A `JLabel` object with an icon set by the `setIcon()` method is being returned.
     */
    public JLabel newChip()
    {
        return new JLabel(setIcon());
    }
}
