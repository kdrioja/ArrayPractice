import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 5, 7, 9, 10, 11, 6, 4, 1};
        System.out.println("1: " + isTriangleSorted(array));

        int[] array2 = null;
        System.out.println("2: " + isTriangleSorted(array2));

        int[] array3 = {};
        System.out.println("3: " + isTriangleSorted(array3));

        int[] array4 = {1};
        System.out.println("4: " + isTriangleSorted(array4));

        int[] array5 = {9, 7, 1};
        System.out.println("5: " + isTriangleSorted(array5));
    }

    public static boolean isTriangleSorted(int[] array) {
        if (array == null || array.length < 2) {
            return false;
        }

        boolean flagDes = false, flagAsc = false;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < array.length - 1; i++) {
            if (seen.contains(array[i])) {
                return false;
            }

            if (flagDes) { //descending
                if (!(array[i] > array[i + 1])) {
                    return false;
                }
            }
            else { //ascending
                if (!(array[i] < array[i + 1])) {
                    flagDes = true;
                }
                else {
                    flagAsc = true;
                }
            }
            seen.add(array[i]);
        }

        if (seen.contains(array[array.length - 1])) {
            return false;
        }

        return flagAsc == flagDes;
    }
}