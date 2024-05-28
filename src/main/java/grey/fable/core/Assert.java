package grey.fable.core;

import java.util.function.Supplier;

/**
 * Assert utility class. Assert whether certain objects or values conform to specifications,
 * otherwise throw an exception. Used for variable validation.
 *
 * @author Fable
 * @since 2024/5/16 15:23
 */
@SuppressWarnings("unused")
public class Assert {

    private Assert() {
    }

    /**
     * Check whether the given expression is true. If not, throw a default exception with the default message.
     * <pre>
     *     Assert.isTrue(i > 0);
     * </pre>
     *
     * @param expression Expression
     * @author Fable
     * @since 2024/5/16 15:24
     */
    public static void isTrue(boolean expression) throws IllegalArgumentException {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * Check whether the given expression is true. If not, throw a default exception with the specified message.
     * <pre>
     *     Assert.isTrue(i > 0, "The value must be greater than zero");
     * </pre>
     *
     * @param expression       Expression
     * @param errorMsgTemplate Error message template
     * @param params           Params
     * @author Fable
     * @since 2024/5/16 15:25
     */
    public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        isTrue(expression, () -> new IllegalArgumentException(String.format(errorMsgTemplate, params)));
    }

    /**
     * Check whether the given expression is true. If not, throw a specified exception.
     * <pre>
     *     Assert.isTrue(i > 0, IllegalArgumentException::new);
     * </pre>
     *
     * @param expression    Expression
     * @param errorSupplier ErrorSupplier
     * @author Fable
     * @since 2024/5/16 15:25
     */
    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> errorSupplier) throws X {
        if (!expression) {
            throw errorSupplier.get();
        }
    }

    /**
     * Check whether the value is within the specified range. If not, throw a default exception with the specified message.
     *
     * @param value Check value
     * @param min   Minimum value
     * @param max   Maximum value
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 15:26
     */
    public static long checkBetween(long value, long min, long max) {
        return checkBetween(value, min, max, "The value must be between %d and %d.");
    }

    /**
     * Check whether the value is within the specified range. If not, throw a default exception with the specified message.
     *
     * @param value            Check value
     * @param min              Minimum value
     * @param max              Maximum value
     * @param errorMsgTemplate Error message template
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 15:27
     */
    public static long checkBetween(long value, long min, long max, String errorMsgTemplate) {
        return checkBetween(value, min, max, () -> new IllegalArgumentException(String.format(errorMsgTemplate, min, max)));
    }

    /**
     * Check whether the value is within the specified range. If not, throw a specified exception.
     *
     * @param value         Check value
     * @param min           Minimum value
     * @param max           Maximum value
     * @param errorSupplier ErrorSupplier
     * @return {@link long}
     * @author Fable
     * @since 2024/5/16 15:27
     */
    public static <X extends Throwable> long checkBetween(long value, long min, long max, Supplier<? extends X> errorSupplier) throws X {
        if (value < min || value > max) {
            throw errorSupplier.get();
        }

        return value;
    }
}