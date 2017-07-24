import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    /** Log file path */
    private static final String LOG_FILE = "./exec.log";

    /** Upper bounds for random numbers */
    private static final Integer COMMIT_NUM_BOUND = 5;

    /** Minutes per day */
    private static final Integer ONE_DAY_MINUTES = 24 * 60;

    /** Inspection interval */
    private static final Integer INSPECTION_INTERVAL = 10 * 60 * 1000;

    public static void main(String[] args) {

        while (true) {
            if (isExpired()) {

                Random random = new Random();
                int commitNum = random.nextInt(COMMIT_NUM_BOUND);

                if (commitNum <= 0) {
                    commitNum = 1;
                }
                while (commitNum > 0) {
                    commit();
                    commitNum--;
                }
            }
            try {
                Thread.sleep(INSPECTION_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Do a commit
     */
    public static void commit() {
        List<String> commands = new ArrayList<>();

        commands.add("date \"+%Y-%m-%d %H:%M:%S\" >> exe_history");
        commands.add("git add .");
        commands.add("git commit -m \"impl ApnsPooledConnection.java\"");
        commands.add("git push origin dev_crazyacking");

        List<String> result = exec(commands.toArray(new String[0]));

        log(LOG_FILE, result.toArray(new String[0]));
    }

    /**
     * Execute the shell commands
     *
     * @param args The shell commands
     * @return Output result
     */
    private static List<String> exec(String... args) {
        List<String> result = new ArrayList<>();
        try {
            for (String arg : args) {
                Process process = Runtime.getRuntime().exec(arg);
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.add(line);
                }

                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void log(String logFile, String... args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(logFile));
            for (String arg : args) {
                out.write(arg);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Date getLastExecDate() {

        List<String> res = exec("tail -n 1 exe_history");

        if (res == null || res.size() == 0) {
            exec("touch exe_history");
            exec("date \"+%Y-%m-%d %H:%M:%S\" >> exe_history");
        }

        res = exec("tail -n 1 exe_history");
        String strDate = res.get(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Boolean isExpired() {
        Date lastExecDate = getLastExecDate();
        Date now = new Date();
        assert lastExecDate != null;
        long diff = now.getTime() - lastExecDate.getTime();

        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

        return minutes > ONE_DAY_MINUTES;
    }
}
