public class ExerciseOne {

    /**
     *   This implementation is always going to find the first occurrence of a number inside an array
     */

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 6, 10, 13, 19, 55, 360, 420, 860, 1200};

        int resultLoop = iterativeBinarySearch(a, a.length, 6);
        System.out.println(resultLoop);

        int resultRecursive = recursiveBinarySearch(a, 0,a.length - 1, 6);
        System.out.println(resultRecursive);
    }

    private static int iterativeBinarySearch(int[] a, int n, int target) {
        int min = 0;
        int max = n - 1;

        while(min <= max) {
            int mid = (int) Math.floor((min + max) / 2);
            if (a[mid] == target) return mid; //Found x, return
            else if (target < a[mid]) max = mid - 1; // X lies before middle element
            else min = mid + 1; // X lies after middle element
        }
        return -1; // Returns -1 when the target number was not found
    }

    public static int recursiveBinarySearch(int[] a, int min, int max, int target) {
        int mid = (int) Math.floor((min + max) / 2);

        if (min > max) return -1;
        if (a[mid] == target) return mid;
        else if (target < a[mid]) return recursiveBinarySearch(a, min, mid - 1, target);
        else return recursiveBinarySearch(a, mid + 1, max, target);
    }
}
