package kienthuc;

public class Command { //giao lenh
    public static void main(String[] args) {
        Light light = new Light();
        LightCommand on=new TurnOnLight(light);
        LightCommand off=new TurnOffLight(light);

        RemoteLight remoteLight=new RemoteLight();
        remoteLight.setLightCommand(on);
        remoteLight.pressPowerButton();
        remoteLight.pressUndoButton();
    }
}

class Light{
    public void tunOn(){
        System.out.println("Den da bat: Bling Bling");
    }

    public void tunOff(){
        System.out.println("Den da tat: .......");
    }
}

// lenh
interface LightCommand{
    void execute(); // thuc thi
    void undo(); // hoan tac
}
class TurnOnLight implements LightCommand{
    private Light light;
    public TurnOnLight(Light light){
        this.light = light;
    }

    @Override
    public void undo() {
        light.tunOff();
    }

    @Override
    public void execute() {
        light.tunOn();
    }
}

class TurnOffLight implements LightCommand{
    private Light light;
    public TurnOffLight(Light light){
        this.light = light;
    }

    @Override
    public void undo() {
        light.tunOn();
    }

    @Override
    public void execute() {
        light.tunOff();
    }
}

class RemoteLight{
    private LightCommand lightCommand;
    void setLightCommand(LightCommand lightCommand){
        this.lightCommand = lightCommand;
    }

    public void pressPowerButton(){
        lightCommand.execute();
    }

    public void pressUndoButton(){
        lightCommand.undo();
    }
}
