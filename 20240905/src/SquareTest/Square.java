package SquareTest;

public class Square
{
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea()
    {
        return Math.pow(length,2);
        //return length * length;
    }

}
