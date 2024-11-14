package chap_11.ex11_5;

public class MainVehicle
{
    public static void main(String[] args) {
        Vehicle vehicle = new Bicycle();
        //원래는 vehicle의 메소드만 사용할 수 있지만
        //업캐스팅한 클래스(Bicycle)가 Vehicle의 메소드를 오버라이딩한 경우 사용가능하다.
        //그런데 Vehicle의 내용을 오버라이딩 안하면 Bicycle에 Vegicle을 적용못함
        //그러니 일관성을 보장한다?는 말

        vehicle.horn();
        vehicle.move("용산역","이태원");


        Bicycle bicycle = new Bicycle();
        bicycle.horn();
        bicycle.move("서울정수폴리텍","잠수교");//Vehicle의 default 메소드 호출
        Bicycle.stop("맥심프랜트");

        Vehicle vehicle1 = new Train();
        vehicle1.horn();
        vehicle1.move("서울","용산"); // Train의 오버라이딩 메소드 호출
        Vehicle.stop("대전");
    }
}
