public class Dog
{
    private String name;
    private int age;
    private String breeds;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public void wag()
    {
        System.out.println(name + "이(가)살랑살랑 꼬리를 친다.");
    }

    public void bark()
    {
        System.out.println("왈왈크르르르르");
    }

    public void bark(int times, String sound)
    {
        System.out.printf(name + "이(가) %d번 %s 짖는다.",times,sound );
    }




}
