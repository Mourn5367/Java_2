package chap9.ex09_4;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<String>();

//        names.add("ass");
//        names.add(0,"bob");
//        names.add("bob");
        // add(인덱스,추가 자료)일 때 인덱스에 이미 자리가 있으면 그자리 밀어내고 추가됨
        // 0번째에 자리가 있을경우 1번째로 밀어내고 추가됨

        names.add("Kim");
        names.add("Park");
        names.add("Lee");
        names.add("Jung");

        names.set(0,"Cha");

        String removedName = names.remove(2);

        System.out.println(names);
        System.out.println("삭제된 요소:"+removedName);
        for (int i = 0; i < names.size(); i++)
        {
            System.out.printf("%s ",names.get(i));
            if (i != names.size()-1)
                System.out.print("| ");
        }
//        for (String name : names) {
//            System.out.printf("%s |", name);
//        }
        Random rand = new Random();
        System.out.println(rand.nextDouble());
        //ArrayList<Item>ItemList = new ArrayList<Item>();
    }
}
