package Libraries.Socket.Client;

import Libraries.Models.Command;
import Libraries.Models.Prompt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Objects;

public class ClientCommandHandler {
    String command;
    Prompt prompt;
    Socket socket;

    public ClientCommandHandler(Socket socket){
        this.socket = socket;
    }

    public void handleCommand(String command, Prompt prompt) throws Exception {
        this.command = command;
        this.prompt = prompt;
        if(Objects.equals(prompt.promptType, "StandardType")){
            if(command.indexOf("Message") == 0){
                Command commandObj = new Command();
                commandObj.Id = 1;
                commandObj.Type = "MessageUserRequest";
                commandObj.Data = command.substring(8,command.length());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(Command.SerializeObject(commandObj));
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String Response = in.readUTF().toString();
                if(Objects.equals(Response,"FoundUser")){
                    prompt.id = 2;
                    prompt.promptType = "MessageSingle";
                    prompt.promptText = "To";
                    prompt.promptExtras = commandObj.Data;
                }
                else{
                    throw new Exception("No user with such name!");
                }
            }
        }
        else if(Objects.equals(prompt.promptType,"MessageSingle")){
            if(command == "/exit"){
                prompt.id = 1;
                prompt.promptType = "StandardType";
                prompt.promptText = "CJCR";
                prompt.promptExtras = "";
            }
            else{
                Command commandObj = new Command();
                commandObj.Id = 1;
                commandObj.Type = "MessageUser";
                commandObj.Data = "((TO:" + prompt.promptExtras +"))" + command;
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(Command.SerializeObject(commandObj));
            }

        }
        else{

        }
    }
}
