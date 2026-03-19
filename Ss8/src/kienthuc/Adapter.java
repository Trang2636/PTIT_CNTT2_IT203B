package kienthuc;

public class Adapter {

}

class YoungHuman{
    void move2foot(){
        System.out.println("dang di bang 2 chan");
    }
}

interface OldHuman{
    void move3foot();
}

class HumanAdapter implements OldHuman{
    private YoungHuman old;
    public HumanAdapter(YoungHuman old){
        this.old=old;
    }

    @Override
    public void move3foot() {
        // mo rong
        System.out.println("Chuyen sang di bang 2 chan");
    }
}
