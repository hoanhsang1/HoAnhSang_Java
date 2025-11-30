package phamvi;
import java.util.*;

public class Xuly {
	Scanner inform = new Scanner(System.in);
	public int inputINT() {
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
	
//	public phanso
	
}
