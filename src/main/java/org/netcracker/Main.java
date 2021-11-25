package org.netcracker;

public class Main {

    /**
     * Input:
     */

    private static String[] CISCO_LOG_DATA = new String[] {
            "1637816605 - Catalyst 8300 - \"initialization started\"",
            "1637816673 - Catalyst 8300 - \"startup completed completed\"",
            "1637820439 - Catalyst 8300 - \"overload detected\"",
            "1637824048 - Catalyst 8300 - \"shutdown\""
    };

    private static String[] ZYXEL_LOG_DATA = new String[] {
            "1637822715/Catalyst 8300/\"startup\"",
            "1637837969/Catalyst 8300/\"started successfully\"",
            "1637875713/Catalyst 8300/\"suspended\"",
    };

    /**
     * Result:
     *
     * Map with the following structure
     * "day_1": [Sorted collection of string log entries by this date]
     * "day_2": [...]
     * ...
     *
     * Output: system default
     *
     * Tip:
     *  - use https://github.com/google/guava and http://shorturl.at/orOS4
     *  - you can use LogEntry class for help
     */

    public static void main(String[] args) {
        Object dateToLogsMultimap = convertData(CISCO_LOG_DATA, ZYXEL_LOG_DATA);
        System.out.println(dateToLogsMultimap);
    }

    private static Object convertData(...) {
        // code it yourself
        return null;
    }

}
