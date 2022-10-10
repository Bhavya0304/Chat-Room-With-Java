package Libraries.Shell;

import Libraries.Models.Prompt;

import java.util.Scanner;

public class ItShell {
    Prompt prompt;

    public ItShell(Integer id,String promptText){
        prompt.id = id;
        prompt.promptText = promptText;
    }


    public void InitPrompt(){
        while(true){
            System.out.println(prompt.toString());
            Scanner userInput = new Scanner(System.in);

        }

    }


}
