package edu.gonzaga;

public class ChipColor
{
    private String red = "https://kevinshannon.com/connect4/img/bestchipred.png";
    private String blue = "https://kevinshannon.com/connect4/img/bestchipblue.png";
    private String green = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Eo_circle_green_blank.svg/2048px-Eo_circle_green_blank.svg.png";

    private String selectedColor;
    public void setColor(String color)
    {
        if(color == "Green")
            this.selectedColor = this.green;
        if(color == "Blue")
            this.selectedColor = this.blue;
        if(color == "Red")
            this.selectedColor = this.red;
    }
    public String getColor()
    {
        return this.selectedColor;
    }
}
