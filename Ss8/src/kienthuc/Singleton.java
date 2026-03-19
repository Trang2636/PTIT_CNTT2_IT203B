package kienthuc;

public class Singleton {
    public static void main(String[] args) {
        StudentMenu instance= StudentMenu.getInstance();
        instance.printMenu();
    }
}

class StudentMenu{
    private static StudentMenu instance=new StudentMenu(); // 1 thuoc tinh tinhx

    private StudentMenu(){ // 2 pthuc khoi tao phai la private
        // khoi tao cac tp va thuoc tinh
    }

    // khi nao goi thi moi khoi tao
    public static StudentMenu getInstance(){
        if(instance==null){
            instance=new StudentMenu();
        }
        return instance;
    }

    public void printMenu(){
        //in menu
    }
}
