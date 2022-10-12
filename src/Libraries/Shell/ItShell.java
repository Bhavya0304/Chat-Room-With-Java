package Libraries.Shell;

import Libraries.Models.Prompt;
import Libraries.Socket.Client.ClientCommandHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ItShell {
    Prompt prompt;

    public ItShell(Integer id,String promptText){
        this.prompt = new Prompt(1,"StandardType",promptText,"");
    }


    public void InitPrompt(Socket socket) throws IOException {
        while(true){
            System.out.print(prompt.toString());
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            ClientCommandHandler handler = new ClientCommandHandler(socket);
            try {
                handler.handleCommand(input.toString(),prompt);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }


}
