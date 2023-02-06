import java.util.Collection;
import java.util.stream.Collectors;

/**
 * This class provides some util for searching a generic array for an element and
 * a way to pretty print a generic collection.
 */
public class SomeUtil {
    /**
     * This method searches through an array using the binary search algorithm.
     * @param arr array to be searched
     * @param elem element to be searched
     * @return <code>null</code> if the element is not found, the searched element otherwise
     * @param <T> generic type of the array, needs to implement {@link java.lang.Comparable<T>}
     */
    public <T extends Comparable<T>> T binSearch(T[] arr, T elem) {
        if (arr == null || elem == null) return null;
        int start = 0;
        int middle;
        int end = arr.length - 1;
        while(start <= end) {
            middle = (start + end) / 2;
            if (arr[middle].compareTo(elem) < 0) {
                start = middle + 1;
            } else if(arr[middle].compareTo(elem) > 0) {
                end = middle - 1;
            } else {
                return arr[middle];
            }
        }
        return null;
    }

    /**
     * This method pretty prints a collection of objects.
     * Syntax:
     * <p>
     *     Item: itemToPrint,
     *     Item: anotherItem,
     *     ..
     * </p>
     *
     * @param listToPrint {@link Collection} which should be printed
     * @throws IllegalArgumentException if the collection is null
     * @return {@link String} Representation of the {@link Collection}
     * @param <T> generic parameter of the {@link Collection}
     */
    public <T> String prettyPrint(Collection<T> listToPrint) {
        if (listToPrint == null) throw new IllegalArgumentException("list should not be empty");
        return listToPrint.stream()
                .filter(item -> item == null || !item.toString().isBlank())
                .map(item -> "Item: " + item)
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
