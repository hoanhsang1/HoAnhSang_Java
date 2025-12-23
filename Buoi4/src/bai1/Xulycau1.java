package bai1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Xulycau1 {
	Scanner inform = new Scanner(System.in);
	public int inputINT() {
		int result;
		while (true) {
			try {
				result = inform.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số nguyên.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	public int[] inputList() {
		System.out.print("Nhập độ dài của danh sách: ");
		int lenList = inputINT();
		int[] result = new int[lenList];
		for (int i=0; i<lenList; i++) {
			System.out.print("Vui lòng nhập dữ liệu thứ: "+i);
			result[i] = inputINT();
		}
		return result;
	}
	
//	========================================================
//							Câu1
//	========================================================
	
	public int cau1(int n) {
		int result = 0;
		for(int i=0; i<=n; i++) {
			result += i*2;
		}
		return result;
	}
	
//	========================================================
//							Câu2
//	========================================================
	
	public void cau2() {
		System.out.print("Nhập giá trị của a: ");
		int a = inputINT();
		System.out.print("Nhập giá trị của b: ");
		int b = inputINT();
		if (a%2 ==0) {
			a++;
		}
		for (int i=a; i<=b; i=i+2) {
			System.out.print(i);
			System.out.print(' ');
		}
	}
	
	public void cau3() {
		System.out.print("Nhập giá trị của a: ");
		int a = inputINT();
		System.out.print("Nhập giá trị của b: ");
		int b = inputINT();
		System.out.print("Nhập giá trị của bội số: ");
		int boiso = inputINT();
		
		for (int i=a; i<=b; i++) {
			if (i%boiso==0) {
				System.out.print(i);
				System.out.print(' ');
			}
		}
	}
	
	public void cau4() {
		System.out.print("Nhập giá trị của a: ");
		int a = inputINT();
		System.out.print("Nhập giá trị của b: ");
		int b = inputINT();
		int result = 0;
		for (int i=a; i<=b; i++) {
			result +=i;
		}
		
		System.out.print("Tổng của các số trong khoảng từ "+a+" đến "+b+" là "+result);
	}
	
	public void cau5() {
		System.out.print("Nhập giá trị của n: ");
		int n = inputINT();
		int temp;
		int result = 0;
		if (n%2==0) {
			temp =2;
		} else {
			temp = 1;
		}
		for (int i=temp; i<=n; i=i+2) {
			result +=i;
		}
		
		System.out.print("Tổng của các số trong khoảng từ "+temp+" đến "+n+" là "+result);
	}
	
	public void cau6() {
		System.out.print("Nhập độ dai : ");
		int[] n = inputList();
		Integer max = null;
		Integer min = null;
		for (int i=0; i<n.length; i++) {
			if (max == null || max < n[i]) {
				max = n[i];
			}
			if (min == null || min > n[i]) {
				min = n[i];
			}
		}
		
		System.out.println("Số lớn nhất là: "+max);
		System.out.println("Số nhỏ nhất là: "+min);
	}
	
	public void cau7() {
		System.out.print("Nhập giá trị của a: ");
		float a = inputINT();
		System.out.print("Nhập giá trị của b: ");
		float b = inputINT();
		float result = 0;
		if(a!=0) {
			result = -b/a;
			System.out.println("x có giá trị là: "+result);
		} else if (a==0 && b==0){
			System.out.println("x có vô số nghiệm");
		} else if (a==0 && b!=0) {
			System.out.println("Phương trình vô nghiệm");
		}
	}
	
	public void cau8() {
		System.out.print("Nhập giá trị của n: ");
		int n = inputINT();
		if(n==0) {
			System.out.println("x là zero");
		} else if (n%2==0){
			System.out.println("x là số chắn");
		} else {
			System.out.println("x là số lẽ");
		}
	}
}
