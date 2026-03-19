package baitap.ex5;

public class Fan implements Observer {
    private String speed = "Tat";
    public void low() {
        speed = "Thap";
        System.out.println("Quat: Chay toc do thap");
    }
    public void high() {
        speed = "Manh";
        System.out.println("Quat: Chay toc do manh");
    }
    @Override
    public void update(int temperature) {

        if (temperature > 30) {
            high();
        }
    }
}