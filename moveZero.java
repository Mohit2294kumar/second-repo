public class moveZero{
    public static void moveZeroesCounting(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[count++] = num;
            }
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroesCounting(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
