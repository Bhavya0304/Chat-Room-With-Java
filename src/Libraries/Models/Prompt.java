package Libraries.Models;

public class Prompt {
    public Integer id;
    public String promptType;
    public String promptText;
    public String promptExtras;

    public String To;
    public Prompt(Integer id, String promptType, String promptText, String promptExtras) {
        this.id = id;
        this.promptType = promptType;
        this.promptText = promptText;
        this.promptExtras = promptExtras;
    }

    @Override
    public String toString() {
        return promptText + "(" + promptExtras + ") > ";
    }
}
