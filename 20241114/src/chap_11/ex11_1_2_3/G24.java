package chap_11.ex11_1_2_3;

public class G24 implements Phone, Message, Alarm
{


    @Override
    public void playMusic(String musicTitle) {
        System.out.println(musicTitle + " 음악을 재생한다.");
    }

    @Override
    public void beep() {
        System.out.println("삐비비비빕");
    }

    @Override
    public void sendMessage(String content) {
        System.out.println(content + " 메세지를 전송한다.");
    }

    @Override
    public void receiveMessage(String content) {
        System.out.println(content + " 메세지를 받았습니다.");
    }

    @Override
    public void callPhone(String phoneNumber) {
        System.out.println(phoneNumber + "번호로 전화를 겁니다.");
    }

    @Override
    public void receivePhone(String phoneNumber) {
        System.out.println(phoneNumber + "번호의 전화를 받는다.");
    }
}
