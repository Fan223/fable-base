package grey.fable.core.collection;

import java.util.Collection;

/**
 * {@link Collection} utility class
 *
 * @author Fable
 * @since 2024/5/16 14:23
 */
@SuppressWarnings("unused")
public class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * Check whether the {@link Collection} is empty
     *
     * @param collection {@link Collection}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 14:26
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * Check whether the {@link Collection} is not empty
     *
     * @param collection {@link Collection}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 14:26
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}