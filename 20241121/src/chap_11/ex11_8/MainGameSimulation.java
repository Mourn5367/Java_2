package chap_11.ex11_8;

public class MainGameSimulation
{
    public static void main(String[] args) {

        Knight atomic = new Knight("아토믹");
        Knight uther = new HolyKnight("우서");
        Knight genji = new MagicKnight("겐지");

        atomic.slash();
        uther.slash();
        genji.slash();

        Healer healer1 = (HolyKnight) uther;
        Healer healer2 = new HolyKnight("안두인");
        // 전직을 하면 그 전 직업의 기술을 못쓰게 할 경우 이런 방식을 써야함.
        
        healer1.heal();
        healer1.recovery();
        // healer1.slash();
        // Healer 인터페이스의 참조 변수라서 Healer 인터페이스를 통해 구현된 메소드만 호출할 수 있다.

        Magician magician1 = (MagicKnight) genji;

        magician1.magicShield();
        magician1.teleport();

        MagicKnight magicKnight = new MagicKnight("한조");

        magicKnight.slash();
        magicKnight.teleport();
        magicKnight.magicShield();

    }
}
