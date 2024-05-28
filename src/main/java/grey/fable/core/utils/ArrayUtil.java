package grey.fable.core.utils;

/**
 * Array utility class
 *
 * @author Fable
 * @since 2024/5/16 14:42
 */
@SuppressWarnings("unused")
public class ArrayUtil {

    private ArrayUtil() {
    }

    /**
     * Check whether the array is empty
     *
     * @param array Array
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 14:42
     */
    public static <T> boolean isEmpty(T[] array) {
        return null == array || 0 == array.length;
    }

    /**
     * Check whether the array is not empty
     *
     * @param array Array
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 14:43
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * Create an array by values
     *
     * @param values Values
     * @return {@link T[]}
     * @author Fable
     * @since 2024/5/16 14:43
     */
    @SafeVarargs
    public static <T> T[] array(T... values) {
        return values;
    }
}