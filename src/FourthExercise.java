public class FourthExercise {

    /**
     *  The following algorithm finds a target number in a circular array
     */
    public static void main(String[] args) {
        int[] a = {15, 21, 26, 32, 42, 52, 62, 3, 5, 7, 8, 10};
        int result = findValueInRotatedArrayIterative(a, a.length, 5);
        System.out.println(result);

        int result2 = findValueInRotatedArrayRecursive(a, 0, a.length - 1, 62);
        System.out.println(result2);
    }

    private static int findValueInRotatedArrayIterative(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (int) Math.floor((low + high) / 2);
            if (a[mid] == target) return mid; // Case 1: Found target
            if (a[mid] <= a[high]) { //Case 2: right hald is sorted
                if (target <= a[high] && target > a[mid])
                    low = mid + 1; // go searching in the right sorted half
                else high = mid - 1; // go searching towards left
            } else { // Case 3: left half is sorted
                if (target >= a[low] && target < a[mid]) // go searching in the left sorted half
                    high = mid - 1;
                else
                    low = mid + 1; // go searching right
            }
        }
        return -1;
    }

    private static int findValueInRotatedArrayRecursive(int[] a, int low, int high, int target) {
        if (high < low) return -1;
        int mid = (int) Math.floor((low + high) / 2);
        if (a[mid] == target) return mid;

        if (a[mid] <= a[high]) {
            if (target > a[mid] && target <= a[high])
                return findValueInRotatedArrayRecursive(a, mid + 1, high, target);
            else return findValueInRotatedArrayRecursive(a, low, mid - 1, target);
        } else {
            if (target >= a[low] && target < a[mid])
                return findValueInRotatedArrayRecursive(a, low, mid - 1, target);
            else return findValueInRotatedArrayRecursive(a, mid + 1, high, target);
        }
    }

}
