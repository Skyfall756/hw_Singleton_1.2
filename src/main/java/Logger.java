import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;

    private static Logger logger = null;

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
        Date date = new Date();
        System.out.println("[" + formatter.format(date) + " " + num++ + "] " + msg);
    }

}
