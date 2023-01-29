import java.util.List;
import java.util.stream.Collectors;

public class SomeUtil {
    public <T extends Comparable<T>> T binSearch(T[] arr, T elem) {
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

    public <T> String prettyPrint(List<T> listToPrint) {
        return listToPrint.stream()
                .filter(item -> !item.toString().isBlank())
                .map(item -> "Item: " + item)
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
