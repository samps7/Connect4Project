package edu.gonzaga;

import javax.swing.*;

public class ChipColor
{
    private final String red = "https://kevinshannon.com/connect4/img/bestchipred.png";
    private final String blue = "https://kevinshannon.com/connect4/img/bestchipblue.png";
    private final String green = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Eo_circle_green_blank.svg/2048px-Eo_circle_green_blank.svg.png";

    private String selectedColor;
    public void setColor(String color)
    {
        if(color.equals("Green"))
            this.selectedColor = this.green;
        if(color.equals("Blue"))
            this.selectedColor = this.blue;
        if(color.equals("Red"))
            this.selectedColor = this.red;
    }
    public String getColor()
    {
        return this.selectedColor;
    }

    private ImageIcon setIcon()
    {
        return new ImageIcon(this.selectedColor);
    }

    public JLabel newChip()
    {
        return new JLabel(setIcon());
    }
}
