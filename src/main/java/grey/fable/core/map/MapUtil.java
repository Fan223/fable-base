package grey.fable.core.map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link Map} utility class
 *
 * @author Fable
 * @since 2024/5/15 17:28
 */
@SuppressWarnings("unused")
public class MapUtil {

    private MapUtil() {
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * Check whether the {@link Map} is empty
     *
     * @param map {@link Map}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 11:24
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * Check whether the {@link Map} is not empty
     *
     * @param map {@link Map}
     * @return {@link boolean}
     * @author Fable
     * @since 2024/5/16 11:24
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * Create a {@link HashMap} with the default initial capacity
     *
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 11:25
     */
    public static <K, V> Map<K, V> hashMap() {
        return hashMap(false, DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Create a {@link LinkedHashMap}/{@link HashMap} with the default initial capacity
     *
     * @param isLinked IsLinked
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 13:58
     */
    public static <K, V> Map<K, V> hashMap(boolean isLinked) {
        return hashMap(isLinked, DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Create a {@link HashMap} with a specified capacity
     *
     * @param size Capacity
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 13:59
     */
    public static <K, V> Map<K, V> hashMap(int size) {
        return hashMap(false, size);
    }

    /**
     * Create a {@link LinkedHashMap}/{@link HashMap} with a specified capacity
     *
     * @param isLinked IsLinked
     * @param size     Capacity
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 13:59
     */
    public static <K, V> Map<K, V> hashMap(boolean isLinked, int size) {
        final int initCapacity = size > 0 ? size : DEFAULT_INITIAL_CAPACITY;
        return isLinked ? new LinkedHashMap<>(initCapacity) : new HashMap<>(initCapacity);
    }

    /**
     * Create a {@link ConcurrentHashMap} with the default initial capacity
     *
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:00
     */
    public static <K, V> Map<K, V> concurrentHashMap() {
        return concurrentHashMap(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Create a {@link ConcurrentHashMap} with a specified capacity
     *
     * @param size Capacity
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:00
     */
    public static <K, V> Map<K, V> concurrentHashMap(int size) {
        return new ConcurrentHashMap<>(size > 0 ? size : DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Create a {@link HashMap} based on key-value pairs
     *
     * @param key   Key
     * @param value Value
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:01
     */
    public static <K, V> Map<K, V> of(K key, V value) {
        return of(false, key, value);
    }

    /**
     * Create a {@link LinkedHashMap}/{@link HashMap} based on key-value pairs
     *
     * @param isLinked IsLinked
     * @param key      Key
     * @param value    Value
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:01
     */
    public static <K, V> Map<K, V> of(boolean isLinked, K key, V value) {
        final Map<K, V> map = hashMap(isLinked);
        map.put(key, value);
        return map;
    }

    /**
     * Create a {@link HashMap} based on {@link Map.Entry}
     *
     * @param entries {@link Map.Entry}
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:06
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(Map.Entry<K, V>... entries) {
        return ofEntries(false, entries);
    }

    /**
     * Create a {@link LinkedHashMap}/{@link HashMap} based on {@link Map.Entry}
     *
     * @param isLinked IsLinked
     * @param entries  {@link Map.Entry}
     * @return {@link Map}
     * @author Fable
     * @since 2024/5/16 14:04
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(boolean isLinked, Map.Entry<K, V>... entries) {
        final Map<K, V> map = hashMap(isLinked, entries.length);

        for (Map.Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * Convert key-value pairs into {@link AbstractMap.SimpleImmutableEntry}, which is immutable.
     *
     * @param key   Key
     * @param value Value
     * @return {@link Map.Entry}
     * @author Fable
     * @since 2024/5/16 14:04
     */
    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return entry(true, key, value);
    }

    /**
     * Convert key-value pairs into {@link AbstractMap.SimpleImmutableEntry}/{@link AbstractMap.SimpleEntry},
     * which is immutable or mutable.
     *
     * @param isImmutable IsImmutable
     * @param key         Key
     * @param value       Value
     * @return {@link Map.Entry}
     * @author Fable
     * @since 2024/5/16 14:03
     */
    public static <K, V> Map.Entry<K, V> entry(boolean isImmutable, K key, V value) {
        return isImmutable ?
                new AbstractMap.SimpleImmutableEntry<>(key, value) :
                new AbstractMap.SimpleEntry<>(key, value);
    }

    /**
     * Create a {@link MapBuilder} with the default initial capacity
     *
     * @return {@link MapBuilder}
     * @author Fable
     * @since 2024/5/16 14:17
     */
    public static <K, V> MapBuilder<K, V> builder() {
        return builder(hashMap(DEFAULT_INITIAL_CAPACITY));
    }

    /**
     * Create a {@link MapBuilder} with the key-value pairs
     *
     * @param key   Key
     * @param value Value
     * @return {@link MapBuilder}
     * @author Fable
     * @since 2024/5/16 14:17
     */
    public static <K, V> MapBuilder<K, V> builder(K key, V value) {
        return builder(of(key, value));
    }

    /**
     * Create a {@link MapBuilder} with the {@link Map}
     *
     * @param map {@link Map}
     * @return {@link MapBuilder}
     * @author Fable
     * @since 2024/5/16 14:17
     */
    public static <K, V> MapBuilder<K, V> builder(Map<K, V> map) {
        return new MapBuilder<>(map);
    }
}