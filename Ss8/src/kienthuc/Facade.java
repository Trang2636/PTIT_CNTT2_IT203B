package kienthuc;

public class Facade { // phuc vu
    public static void main(String[] args) {
        FacadeRestaurant restaurant = new FacadeRestaurant();
        restaurant.order();
        restaurant.pay();
    }

}
class FacadeRestaurant{
    private Chef chef=new Chef();
    private Staff staff=new Staff();
    private Manager manager=new Manager();
    void order(){
        staff.order();
        chef.cook();
    }
    void pay(){
        staff.invoice();
        manager.feedback();
        manager.complainToChef();
    }
}

class Chef{
    public void cook(){
        System.out.println("Nhan order tu boi ban");
        System.out.println("Nau mono an");
        System.out.println("-----------------------");
    }
}

class Staff{
    public void order(){
        System.out.println("Order mon an cho khach");
    }
    public void invoice(){
        System.out.println("Gui hoa don cho khach");
    }
}

class Manager{
    public void feedback(){
        System.out.println("Hoi y kien khach ve trai nghiem mon an");
    }

    public void complainToChef(){
        System.out.println("Chui dau bep");
    }
}
