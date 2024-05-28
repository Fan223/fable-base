package grey.fable.core.utils;

import grey.fable.core.PID;
import grey.fable.core.Snowflake;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * ID utility class
 *
 * @author Fable
 * @since 2024/5/16 14:54
 */
@SuppressWarnings("unused")
public class IdUtil {

    private IdUtil() {
    }

    private static final Snowflake SNOWFLAKE = new Snowflake();

    /**
     * Retrieve data center ID. Data center ID depends on the local host hardware (MAC) address array.
     *
     * @param maxDataCenterId MaxDataCenterId
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 14:55
     */
    public static long getDataCenterId(long maxDataCenterId) {
        if (Long.MAX_VALUE == maxDataCenterId) {
            maxDataCenterId -= 1;
        }

        byte[] mac = null;
        try {
            mac = NetUtil.getLocalHardwareAddress();
        } catch (UnknownHostException | SocketException ignore) {
            // ignore
        }

        long id = 1L;
        if (maxDataCenterId > 0 && null != mac) {
            id = ((0xFF & (long) mac[mac.length - 2]) | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDataCenterId + 1);
        }

        return id;
    }

    /**
     * Retrieve machine ID, generate with data center ID and process ID.
     *
     * @param dataCenterId DataCenterId
     * @param maxWorkerId  MaxWorkerId
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 14:55
     */
    public static long getWorkerId(long dataCenterId, long maxWorkerId) {
        String workerId = String.valueOf(dataCenterId) + getProcessId();
        // MAC + PID 的 hashcode 获取 16 个低位
        return (workerId.hashCode() & 0xFFFF) % (maxWorkerId + 1);
    }

    /**
     * Retrieve process ID
     *
     * @return {@link int}
     * @author Fable
     * @since 2024/5/16 15:16
     */
    public static int getProcessId() {
        return PID.PROCESS_ID;
    }

    /**
     * Retrieve Snowflake ID
     *
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 15:16
     */
    public static long getSnowflakeId() {
        return SNOWFLAKE.nextId();
    }

    /**
     * Retrieve Snowflake ID {@link String}
     *
     * @return {@link String}
     * @author Fable
     * @since 2024/5/16 15:18
     */
    public static String getSnowflakeIdStr() {
        return String.valueOf(getSnowflakeId());
    }
}