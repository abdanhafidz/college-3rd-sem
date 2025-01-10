package id.its.pbo.sorting;

import java.util.Arrays;

public class Sorter {
    public static Sortable[] sortItems(Sortable[] items) {
        Arrays.sort(items, (a, b) -> a.compare(b));
        return items;
    }
}
