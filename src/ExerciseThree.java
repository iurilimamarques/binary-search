public class ExerciseThree {

    /**
     *  The following algorithm recognizes how many times a circular array was rotated
     */
    public static void main(String[] args) {
        int[] a = {15, 21, 26, 32, 42, 52, 62, 3, 5, 7, 8, 10};
        int result = findTimesTheArrayIsRotatedIterative(a, a.length);
        System.out.println(result);

        int result2 = findTimesTheArrayIsRotatedRecursive(a, 0, a.length - 1);
        System.out.println(result2);
    }

    private static int findTimesTheArrayIsRotatedIterative(int[] a, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            if (a[low] <= a[high]) return low;

            int mid = (int) Math.floor((low + high) / 2);
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (a[mid] <= a[next] && a[mid] <= a[prev]) return mid;
            else if (a[mid] >= a[low]) low = mid + 1;
            else if (a[mid] <= a[high]) high = mid - 1;
        }
        return -1;
    }

    private static int findTimesTheArrayIsRotatedRecursive(int[] a, int low, int high) {
        int n = a.length - 1;

        if (a[low] <= a[high]) return low;

        int mid = (int) Math.floor((low + high) / 2);
        int prev = (mid + n - 1) % n;
        int next = (mid + 1) % n;

        if (a[mid] <= a[prev] && a[mid] <= a[next]) return mid;
        else if (a[mid] >= a[low]) return findTimesTheArrayIsRotatedRecursive(a, mid + 1, high);
        else if (a[mid] <= a[high]) return findTimesTheArrayIsRotatedRecursive(a, low, mid - 1);

        return -1;
    }
}
