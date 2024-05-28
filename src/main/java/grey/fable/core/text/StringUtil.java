package grey.fable.core.text;

/**
 * {@link String} utility class
 *
 * @author Fable
 * @since 2024/5/16 15:11
 */
@SuppressWarnings("unused")
public class StringUtil {

    private StringUtil() {
    }

    /**
     * Check whether the {@link CharSequence} is empty
     *
     * @param cs {@link CharSequence}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:12
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * Check whether the {@link CharSequence} is not empty
     *
     * @param cs {@link CharSequence}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:12
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * Check whether the {@link CharSequence} is blank
     *
     * @param cs {@link CharSequence}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:13
     */
    public static boolean isBlank(CharSequence cs) {
        final int length;
        if (null == cs || 0 == (length = cs.length())) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (CharUtil.isNotBlank(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether the {@link CharSequence} is not blank
     *
     * @param cs {@link CharSequence}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:13
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}