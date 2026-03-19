package baitap.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoteControl {

    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Da gan command cho nut " + button);
    }

    public void pressButton(int button) {

        Command command = buttons.get(button);

        if (command != null) {
            command.execute();
            history.push(command);
        } else {
            System.out.println("Nut chua duoc gan");
        }
    }

    public void undo() {

        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        } else {
            System.out.println("Khong co gi de undo");
        }
    }
}
