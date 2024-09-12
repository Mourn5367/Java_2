package ch08.ex8_4;

public class Avenger
{
    private String name;
    private int hp;

    Avenger(String name, int hp)
    {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    void punch(Avenger enemy)
    {
        System.out.printf("[%s]의 PUNCH!",name);
        enemy.setHp(enemy.getHp()-10);

        System.out.printf("-> %s의 체력이 %d으로 감소했다.\n", enemy.getName(),enemy.getHp());
    }

    @Override
    public String toString() {
        return "Avenger{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
