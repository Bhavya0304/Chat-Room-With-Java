package Libraries.Models;

public class Command {
    public Integer Id;
    public String Type;
    public String Data;

    public static String SerializeObject(Command command){
        return "{Id:'" + command.Id.toString() + "',Type:'"+command.Type+"',Data:'"+command.Data.toString() + "'}";
    }

    public static Command DeserializeObject(String strObj){
        Command command = new Command();
        String Id = strObj.substring(strObj.indexOf("{Id:'") + 5,strObj.indexOf("',Type:'"));
        String Type = strObj.substring(strObj.indexOf("',Type:'") + 8,strObj.indexOf("',Data:'"));
        String Data = strObj.substring(strObj.indexOf("',Data:'") + 8,strObj.indexOf("'}"));
        command.Type = Type;
        command.Data = Data;
        command.Id = Integer.valueOf(Id);
        return command;
    }

}
