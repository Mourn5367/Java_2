package Cat;

public class Cat
{
    private String name;
    private String breeds;
    private double weight;

    public void claw()
    {
        System.out.println("할퀴기");
    }
    public void meow()
    {
        System.out.println("냥");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
