public class BinarySearch {
    public static int binarySearch1(int[] a, int number) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (number < a[mid]) high = mid - 1;
            else if (number > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int binarySearch2(int[] a, int number, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (a[mid] == number) return mid;
        if (a[mid] > number) return binarySearch2(a, number, low, mid - 1);
        return binarySearch2(a, number, mid + 1, high);
    }

    public static void main(String []args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) a[i] = i;
        System.out.println(binarySearch1(a,7));
        System.out.println(binarySearch1(a,10));
        System.out.println(binarySearch2(a,4, 0, 9));
        System.out.println(binarySearch2(a,7, 1, 5));
    }

}
