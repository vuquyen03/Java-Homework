import java.util.Scanner;

public class SortArray {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size - 1; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i<size;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}