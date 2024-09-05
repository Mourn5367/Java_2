package ex12;

public class Cube {
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;

    public double getVolume()
    {
        return Math.pow(length, 3);
    }
    public double getSurfaceArea()
    {
        return Math.pow(length, 2) * 6;
    }


}
