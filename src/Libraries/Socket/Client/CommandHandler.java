package Libraries.Socket.Client;

import java.util.Objects;

public class CommandHandler {
    String command;
    String promptType;
    public CommandHandler(String command,String promptType){
        this.command = command;
        this.promptType = promptType;
    }

    public void initCommandHandler(){
        if(Objects.equals(promptType, "StandardType")){

        }
        else{

        }
    }
}
