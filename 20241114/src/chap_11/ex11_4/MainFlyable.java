package chap_11.ex11_4;

import java.util.ArrayList;
import java.util.List;

public class MainFlyable
{
    public static void main(String[] args)
    {
        Bird bird = new Bird();
        Helicopter helicopter = new Helicopter();
        Rocket rocket = new Rocket();

        Flyable[] flyables = {bird, helicopter, rocket};
        for(Flyable flyable : flyables)
        {
            flyable.fly();
        }
        ArrayList<Flyable> FlyablesList = new ArrayList<>();
        FlyablesList.add(helicopter);
        FlyablesList.add(rocket);
        FlyablesList.add(bird);

        for (Flyable flyable : FlyablesList)
        {
            flyable.fly();
        }
    }
}
