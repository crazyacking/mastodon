import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author shanbiao.jsb
 * @date 2017/07/27
 */
public class AutoLogger {

    /** Log file path */
    private static final String LOG_FILE = "/home/admin/ams-beacon/logs/ams-mac-api.log";

    private static final String TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss";

    private static final String SEP = "||";

    private static final String DOT = ".";

    private static final Integer INTERVAL_TIME = 1000 * 10;

    public static void main(String[] args)
        throws ParseException, InterruptedException, IOException {
        while (true) {

            writeFile(getOneLog());
            Thread.sleep(INTERVAL_TIME);
        }
    }

    private static void writeFile(String content) throws IOException {
        FileWriter writer = new FileWriter(LOG_FILE, true);
        writer.write(content);
        writer.close();
    }

    private static String getOneLog() {
        return getTime() + SEP +
            getTimeStamp() + SEP +
            getAppKey() + SEP +
            getAppVer() + SEP +
            getDeviceId() + SEP +
            getOsType() + SEP +
            getOsVer() + SEP +
            getClientIp() + SEP +
            getRegion() + SEP +
            getRegion2() + SEP +
            getOperator() + SEP +
            getTimeUsed() + SEP +
            getRequestMethod() + SEP +
            getHttpCode() + SEP +
            getResponseSize() + SEP +
            getProtocol() + SEP +
            getHost() + SEP +
            getUrl() + SEP +
            getUserAgent() + SEP +
            getLogSource() + "\n";
    }

    private static String getTime() {
        DateFormat format = new SimpleDateFormat(
            TIME_FORMAT, Locale.ENGLISH);

        return format.format(new Date());
    }

    private static String getTimeStamp() {
        return ((Long)System.nanoTime()).toString();
    }

    private static String getAppKey() {
        List<String> appKeys = new ArrayList<>();
        appKeys.add("23743413");
        appKeys.add("23743414");
        appKeys.add("23743415");
        appKeys.add("23743416");
        appKeys.add("23743417");
        appKeys.add("23743418");
        appKeys.add("23743419");
        appKeys.add("23743420");
        appKeys.add("23743421");
        appKeys.add("23743422");
        appKeys.add("23743423");
        appKeys.add("23743424");
        appKeys.add("23743425");
        appKeys.add("23743426");
        appKeys.add("23743427");
        appKeys.add("23743428");
        appKeys.add("23743429");
        appKeys.add("23743430");
        appKeys.add("23743431");
        appKeys.add("23743432");
        appKeys.add("23743433");
        appKeys.add("23743434");
        appKeys.add("23743435");

        Random random = new Random();
        return appKeys.get(random.nextInt(appKeys.size()));
    }

    private static String getAppVer() {
        Random random = new Random();

        int a = random.nextInt(10);
        if (a <= 0) {
            a = 1;
        }
        int b = random.nextInt(10);
        int c = random.nextInt(10);

        return String.valueOf(a) + DOT + String.valueOf(b) + DOT + String.valueOf(c);
    }

    private static String getOsType() {
        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            return "IOS";
        }
        return "Android";

    }

    private static String getDeviceId() {
        return "23839492021343";
    }

    private static String getOsVer() {
        return getAppVer();
    }

    private static String getClientIp() {
        int[][] range = {{607649792, 608174079},//36.56.0.0-36.63.255.255
            {1038614528, 1039007743},//61.232.0.0-61.237.255.255
            {1783627776, 1784676351},//106.80.0.0-106.95.255.255
            {2035023872, 2035154943},//121.76.0.0-121.77.255.255
            {2078801920, 2079064063},//123.232.0.0-123.235.255.255
            {-1950089216, -1948778497},//139.196.0.0-139.215.255.255
            {-1425539072, -1425014785},//171.8.0.0-171.15.255.255
            {-1236271104, -1235419137},//182.80.0.0-182.92.255.255
            {-770113536, -768606209},//210.25.0.0-210.47.255.255
            {-569376768, -564133889}, //222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        return num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
    }

    private static String num2ip(int ip) {
        int[] b = new int[4];
        String x;

        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer
            .toString(b[3]);

        return x;
    }

    private static String getRegion() {
        return "cn.huadong.zhejiang.hangzhou";
    }

    private static String getRegion2() {
        return "cn.huadong";
    }

    private static String getOperator() {
        List<String> ops = new ArrayList<>();
        ops.add("chinamobile");
        ops.add("chinaunicom");
        ops.add("chinanetcom");
        ops.add("chinatelecom");
        Random random = new Random();
        return ops.get(random.nextInt(ops.size()));
    }

    private static String getTimeUsed() {
        Random random = new Random();
        return String.valueOf(random.nextInt(128));
    }

    private static String getRequestMethod() {
        Random random = new Random();
        if (random.nextInt(5) < 4) {
            return "GET";
        }
        return "POST";
    }

    private static String getHttpCode() {
        return "200";
    }

    private static String getResponseSize() {
        return getTimeUsed();
    }

    private static String getProtocol() {
        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            return "http";
        }
        return "https";
    }

    private static String getHost() {

        List<String> hosts = new ArrayList<>();
        hosts.add("www.alibaba.com");
        hosts.add("www.aliyun.com");
        hosts.add("www.baidu.com");
        hosts.add("www.google.com");

        Random random = new Random();
        return hosts.get(random.nextInt(hosts.size()));
    }

    private static String getUrl() {
        String host = getHost();
        return host + "/beacon/fetch/config/byappkey";
    }

    private static String getUserAgent() {
        return "Chrome/51.0.2704.103";
    }

    private static String getLogSource() {
        return "ams-beacon011193074173.em14";

    }

}
