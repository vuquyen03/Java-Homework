package OtherProjects.hust.soict.dsai.lab01;
import java.util.Scanner;
public class PrintStar {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for (int j = 1; j<2*n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
