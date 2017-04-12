package io.coodoo.framework.showcase.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.TimeZone;

public final class TimeUtil {

    /**
     * ZoneId Object for LocalDateTime instance creation.
     */
    public static final ZoneId LOCAL_DATE_TIME_ZONE_ID_UTC = ZoneId.of("UTC");

    /**
     * TimeZone Object for LocalDateTime instance creation.
     */
    public static final TimeZone TIME_ZONE_UTC = TimeZone.getTimeZone(LOCAL_DATE_TIME_ZONE_ID_UTC);

    /**
     * UTC (Coordinated Universal Time) pattern by ISO 8601 for interchanging data.
     */
    public static final String UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static LocalDateTime now() {
        return LocalDateTime.now(LOCAL_DATE_TIME_ZONE_ID_UTC);
    }

    public static String toString(TemporalAccessor time, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(time);
    }

    public static SimpleDateFormat simpleDateFormat(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TIME_ZONE_UTC);
        return simpleDateFormat;
    }

}
