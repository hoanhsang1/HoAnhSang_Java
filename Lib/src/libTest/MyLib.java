package libTest;

import java.util.InputMismatchException;
import java.util.*;

public class MyLib {
	
	static Scanner inform = new Scanner(System.in);
	// Nhập số
	public static int inputINT() {
		int result;
		while (true) {
			try {
				result = inform.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số nguyên.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	// Nhập nguyên số có khoảng
	public static float inputSoDK(int a, int b) {
		System.out.println("Vui lòng nhập điểm từ "+a+ "->"+ b);
		while(true) {
			float check = inputINT();
			if (check>=a && check<=b) {
				return check;
			} else {
				System.out.println("Vui lòng nhập lại: điểm hợp lệ từ "+a+ "->"+ b);
			}
		}
	}
	
	// Nhập double
	public static double inputDouble() {
		double result;
		while (true) {
			try {
				result = inform.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	
	// Nhập số thực
	public static float inputFLOAT() {
		float result;
		while (true) {
			try {
				result = inform.nextFloat();
				break;
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số thực.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	// Nhập số thực có khoảng
	public static float inputSoDK(float a, float b) {
		System.out.println("Vui lòng nhập số hợp lệ từ "+a+ "->"+ b);
		while(true) {
			float check = inputFLOAT();
			if (check>=a && check<=b) {
				return check;
			} else {
				System.out.println("Vui lòng nhập lại: số hợp lệ từ "+a+ "->"+ b);
			}
		}
	}
	
	// Nhập chuỗi
	
	// Nhập chuỗi có điều kiện
	
	// Nhập ngay
	
	// Xuất dữ liệu
	
	// Tự động sinh id khi nhập vào Array list
	
	// Xuất ds
	
	// Kiểm tra
}
