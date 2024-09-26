package Prac;

public class Monster
{
    private String name;
    private int hp;
    private static int maxHp = 30;
    private static int dmg = 10;

    public Monster(String name) {
        this.hp = maxHp;
        this.name = name;
    }

    public void attack(Monster enemy)
    {
        enemy.hp -= dmg;
    }

    public static void battle(Monster a, Monster b)
    {
        while(a.hp > 0 && b.hp > 0)
        {
            Monster attacker = (Math.random() < 0.5) ? a : b;
            Monster defender = (attacker == a) ? b : a;
            attacker.attack(defender);
            System.out.printf("[%s]의 공격 -> [%s]의 체력: %d/%d\n",
                    attacker.name,defender.name,defender.hp,Monster.maxHp);
        }
    }

}
