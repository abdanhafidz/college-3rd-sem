package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import id.its.pbo.sorting.Buku;
import id.its.pbo.sorting.Sepatu;
import id.its.pbo.sorting.Sortable;
import id.its.pbo.sorting.Sorter;

public class SortingTest {

    @Test
    public void testBukuCompare() {
        Buku buku1 = new Buku("Buku A", 100);
        Buku buku2 = new Buku("Buku B", 150);
        assertTrue(buku1.compare(buku2) < 0);
    }

    @Test
    public void testSepatuCompare() {
        Sepatu sepatu1 = new Sepatu("Sepatu A", 42);
        Sepatu sepatu2 = new Sepatu("Sepatu B", 40);
        assertTrue(sepatu1.compare(sepatu2) > 0);
    }

    @Test
    public void testSortItems() {
        Buku buku1 = new Buku("Buku A", 100);
        Buku buku2 = new Buku("Buku B", 150);
        Sepatu sepatu1 = new Sepatu("Sepatu A", 42);
        Sepatu sepatu2 = new Sepatu("Sepatu B", 40);

        Sortable[] items = {buku2, buku1, sepatu2, sepatu1};
        Sortable[] sortedItems = Sorter.sortItems(items);

        assertEquals(buku1, sortedItems[0]);
        assertEquals(buku2, sortedItems[1]);
        assertEquals(sepatu2, sortedItems[2]);
        assertEquals(sepatu1, sortedItems[3]);
    }
}
