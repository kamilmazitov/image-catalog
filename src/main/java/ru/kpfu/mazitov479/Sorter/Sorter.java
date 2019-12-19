package Sorter;

import java.util.Comparator;
import java.util.List;

public class Sorter implements Comparator<Integer> {

        public int compare(Integer a, Integer b) {

            int c;
            if (a > b) c = a;
            else c = b;
            return c;
        }

    public static void main(String[] args) {

    }
}
