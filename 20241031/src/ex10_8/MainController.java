package ex10_8;

public class MainController
{
    public static void main(String[] args) {
        Truck truck = new Truck("포터",1.5);

        truck.move();
        truck.load();
    }
}
