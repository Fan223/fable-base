package grey.fable.core.text;

/**
 * Char utility class
 *
 * @author Fable
 * @since 2024/5/16 15:13
 */
public class CharUtil {

    private CharUtil() {
    }

    /**
     * Check whether the char is blank
     *
     * @param ch int
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:14
     */
    public static boolean isBlank(int ch) {
        return Character.isWhitespace(ch)
                || Character.isSpaceChar(ch)
                || ch == '⠀'
                || ch == 'ㅤ'
                || ch == '\ufeff'
                || ch == '\u202a'
                || ch == '\u0000'
                || ch == '\u180e';
    }

    /**
     * Check whether the char is not blank
     *
     * @param ch int
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 15:14
     */
    public static boolean isNotBlank(int ch) {
        return !isBlank(ch);
    }
}