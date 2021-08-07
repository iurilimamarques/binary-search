public class ExerciseTwo {

    /**
     *  The following algorithm finds the first and the last indexes of the target number
     *  and based on that we can find the number of occurrences of the target number.
     */

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 5, 5, 6, 10, 13, 19, 55, 55, 360, 420, 860, 1200, 1200, 1200, 1200};
        int numberOfOccurrences = countTargetElementIterative(a, 1200);
        System.out.println(numberOfOccurrences);

        int result2 = countTargetElementRecursive(a, 55);
        System.out.println(result2);
    }

    private static int countTargetElementIterative(int[] a, int target) {
        int firstOccurrence = findOccurrencePositionIterative(a, a.length, target, true);
        int lastOccurrence = findOccurrencePositionIterative(a, a.length, target, false);
        return ((lastOccurrence + 1) - firstOccurrence);
    }

    private static int findOccurrencePositionIterative(int[] a, int n, int target, boolean firstOccurrence) {
        int min = 0;
        int max = n - 1;
        int result = -1;

        while (min <= max) {
            int mid = (int) Math.floor((max + min) / 2);
            if (a[mid] == target) {
                result = mid;

                if (firstOccurrence)
                    max = mid - 1; //Go on searching towards left (lower indices)
                else
                    min = mid + 1; //Go on searching towards right (higher indices)
            }
            else if (target < a[mid]) max = mid - 1;
            else min = mid + 1;
        }
        return result;
    }

    private static int countTargetElementRecursive(int[] a, int target) {
        int firstOccurrence = findOccurrencePositionRecursive(a, 0, a.length - 1, target, true, -1);
        int lastOccurrence = findOccurrencePositionRecursive(a, 0, a.length - 1, target, false, -1);
        return ((lastOccurrence + 1) - firstOccurrence);
    }

    private static int findOccurrencePositionRecursive(int[] a, int min, int max, int target, boolean firstOccurrence, int result) {
        if (max < min) return  result;
        int mid = (int) Math.floor((min + max) / 2);

        if (a[mid] == target) {
            result = mid;

            if (firstOccurrence)
                return findOccurrencePositionRecursive(a, min, mid - 1, target, firstOccurrence, result);
            else
                return findOccurrencePositionRecursive(a, mid + 1, max, target, firstOccurrence, result);
        }
        else if(target < a[mid]) return findOccurrencePositionRecursive(a, min, mid - 1, target, firstOccurrence, result);
        else return findOccurrencePositionRecursive(a, mid + 1, max, target, firstOccurrence, result);
    }
}
