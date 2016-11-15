package pack1;


@SuppressWarnings("WeakerAccess")
public class Mainfile {

    public static void main(String[] args) {
        new Logger();
        Logger.logCodeMessage("Init, setting up window...");

        new FroggerFrame();

    }

}
