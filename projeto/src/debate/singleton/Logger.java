package debate.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {

    private static Logger instance;
    private final String filePath = "debate.log";
    private final List<String> logs = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void registerLog(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String entry = "[" + timestamp + "] " + message;
        logs.add(entry);
        System.out.println("  [LOG] " + entry);
    }

    public List<String> getAllLogs() {
        return Collections.unmodifiableList(logs);
    }
}
