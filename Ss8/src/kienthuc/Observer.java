package kienthuc;

import java.util.ArrayList;
import java.util.List;

public class Observer {

}

// nguoi nhan la ai
interface ReceiverObserver{
    void update(String news);
}

// Nguon tin tuc
class SourceNews{
    private List<ReceiverObserver> observers=new ArrayList<>();
    public void addObserver(ReceiverObserver receiver){
        observers.add(receiver);
    }

    public void sendNews(String news){
        String content= "alooooooo";
        observers.forEach(ob->ob.update(content));
        }
    }

    // Nguoi nhan chi tiet
class ConcreateReceiver implements ReceiverObserver{
    private String name;
    public ConcreateReceiver(String name){
        this.name=name;
    }

        @Override
        public void update(String news) {

        }
    }

