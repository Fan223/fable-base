package grey.fable.core.collection;

import grey.fable.core.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link List} utility class
 *
 * @author Fable
 * @since 2024/5/16 14:27
 */
@SuppressWarnings("unused")
public class ListUtil {

    private ListUtil() {
    }

    /**
     * Create a new {@link ArrayList}
     *
     * @return {@link List<T>}
     * @author Fable
     * @since 2024/5/16 14:28
     */
    public static <T> List<T> list() {
        return list(false);
    }

    /**
     * Create a new {@link LinkedList}/{@link ArrayList}
     *
     * @param isLinked IsLinked
     * @return {@link List<T>}
     * @author Fable
     * @since 2024/5/16 14:28
     */
    public static <T> List<T> list(boolean isLinked) {
        return isLinked ? new LinkedList<>() : new ArrayList<>();
    }

    /**
     * Create a new {@link ArrayList} by values
     *
     * @param values Values
     * @return {@link List<T>}
     * @author Fable
     * @since 2024/5/16 14:32
     */
    @SafeVarargs
    public static <T> List<T> of(T... values) {
        return of(false, values);
    }

    /**
     * Create a new {@link LinkedList}/{@link ArrayList} by values
     *
     * @param isLinked IsLinked
     * @param values   Values
     * @return {@link List<T>}
     * @author Fable
     * @since 2024/5/16 14:29
     */
    @SafeVarargs
    public static <T> List<T> of(boolean isLinked, T... values) {
        if (ArrayUtil.isEmpty(values)) {
            return list(isLinked);
        }

        final List<T> list = isLinked ? new LinkedList<>() : new ArrayList<>(values.length);
        Collections.addAll(list, values);
        return list;
    }
}