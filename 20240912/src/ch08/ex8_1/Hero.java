package ch08.ex8_1;

public class Hero
{

    private String name;
    private int power;
    private int speed;

    public Hero(String name, int power, int speed)
    {
        this.name = name;
        this.power = power;
        this.speed = speed;
    }

    public Hero(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("Hero{name: %s, power=%d, speed=%d}", name, power, speed);
    }

    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }
    public int getSpeed() {
    return speed;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
