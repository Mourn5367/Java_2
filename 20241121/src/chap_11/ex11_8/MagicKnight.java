package chap_11.ex11_8;

public class MagicKnight extends Knight implements Magician
{

    public int mp = 100;

    public MagicKnight(String name) {
        super(name);
    }

    @Override
    public void magicShield()
    {
        System.out.printf("[%s]이(가) 모든 공격을 보호합니다.\n",name);
    }

    @Override
    public void teleport() {
        System.out.printf("[%s]이(가) 순간이동을합니다.\n",name);
    }

    @Override
    public void slash() {
        System.out.printf("[%s]의 마력 베기.\n",name);
    }
}
