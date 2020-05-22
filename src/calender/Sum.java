package calender;
import java.util.Scanner;
public class Sum {
	public static void main(String[] args) {
		int a,b;
		Scanner scan = new Scanner(System.in);
		String s1,s2;
		System.out.println("두개의 숫자를 입력하세요.");
		s1 = scan.next();
		s2 = scan.next();
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
//		System.out.println(a + "," + b);
		
//		int c = a+ b;
//		System.out.print("두 수의 합은" + ( a + b ) + "입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다", a,b ,a+b );
		scan.close();
	}
}
