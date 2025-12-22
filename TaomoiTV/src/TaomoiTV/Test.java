package TaomoiTV;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    // Định dạng ngày tháng, dùng chung cho tất cả các hàm liên quan đến ngày
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Hàm nhập số nguyên với kiểm tra lỗi
    public static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên! Nhập lại.");
            }
        }
    }
    
    // Hàm nhập số nguyên dương
    public static int inputPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Lỗi: Vui lòng nhập số nguyên dương! Nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên! Nhập lại.");
            }
        }
    }
    
    // Hàm nhập số trong khoảng
    public static int inputIntInRange(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Lỗi: Vui lòng nhập số từ " + min + " đến " + max + "! Nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên! Nhập lại.");
            }
        }
    }

    // --- CÁC HÀM MỚI ---

    // Hàm nhập số thực
    public static double inputDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số thực! Nhập lại.");
            }
        }
    }
    
    // Hàm nhập String không rỗng
    public static String inputNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Lỗi: Giá trị không được để trống! Nhập lại.");
            }
        }
    }

    // Hàm nhập Ngày tháng hợp lệ
    public static LocalDate inputDate(String message) {
        while (true) {
            System.out.print(message + " (dd/MM/yyyy): ");
            String dateString = sc.nextLine();
            try {
                return LocalDate.parse(dateString, DATE_FORMAT);
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
    
    
    
 

 // Thêm phương thức này vào lớp Test
 public static double inputPositiveDouble(String message) {
     double number;
     while (true) {
         try {
             System.out.print(message);
             // Giả định Scanner là static và được khởi tạo
             number = Double.parseDouble(sc.nextLine()); 
             if (number > 0) {
                 return number;
             }
             System.out.println("Lỗi: Vui lòng nhập số thực dương.");
         } catch (NumberFormatException e) {
             System.out.println("Lỗi: Vui lòng nhập một số thực hợp lệ.");
         }
     }
 }
}