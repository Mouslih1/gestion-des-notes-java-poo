import Menu.MenuSwitch;
import Service.ServiceSaveInTxt;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        {
            ServiceSaveInTxt.saveInTxt();
        }

        MenuSwitch.menuSwitch();
    }
}