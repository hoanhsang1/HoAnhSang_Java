package ThuVienSang;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    // Định dạng ngày tháng, dùng chung cho tất cả các hàm liên quan đến ngày
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Pattern cho email
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    
    // Pattern cho số điện thoại Việt Nam (10-11 số)
    private static final Pattern PHONE_PATTERN = Pattern.compile(
        "^(0|\\+84)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-9]|9[0-9])[0-9]{7}$"
    );

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
    
    // ========== CÁC HÀM MỚI ==========
    
    // 1. Hàm nhập số thực trong khoảng
    public static double inputDoubleInRange(String message, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                double number = Double.parseDouble(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("Lỗi: Vui lòng nhập số từ %.2f đến %.2f! Nhập lại.\n", min, max);
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số thực hợp lệ!");
            }
        }
    }
    
    // 2. Hàm nhập email với validate
    public static String inputEmail(String message) {
        while (true) {
            System.out.print(message);
            String email = sc.nextLine().trim();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            } else {
                System.out.println("Lỗi: Địa chỉ email không hợp lệ! (VD: example@gmail.com)");
            }
        }
    }
    
    // 3. Hàm nhập số điện thoại với validate
    public static String inputPhoneNumber(String message) {
        while (true) {
            System.out.print(message);
            String phone = sc.nextLine().trim();
            // Xóa khoảng trắng và dấu +84 để chuẩn hóa
            phone = phone.replaceAll("\\s+", "").replace("+84", "0");
            
            if (PHONE_PATTERN.matcher(phone).matches()) {
                return phone;
            } else {
                System.out.println("Lỗi: Số điện thoại không hợp lệ! (VD: 0912345678 hoặc +84912345678)");
            }
        }
    }
    
    // 4. Hàm nhập giới tính (Nam/Nữ)
    public static String inputGender(String message) {
        while (true) {
            System.out.print(message + " (Nam/Nữ): ");
            String gender = sc.nextLine().trim();
            if (gender.equalsIgnoreCase("Nam") || gender.equalsIgnoreCase("Nữ")) {
                return gender;
            } else {
                System.out.println("Lỗi: Giới tính phải là 'Nam' hoặc 'Nữ'!");
            }
        }
    }
    
    // 5. Hàm nhập ngày với kiểm tra tuổi tối thiểu
    public static LocalDate inputDateWithMinAge(String message, int minAge) {
        while (true) {
            LocalDate date = inputDate(message);
            LocalDate now = LocalDate.now();
            int age = date.until(now).getYears();
            
            if (age >= minAge) {
                return date;
            } else {
                System.out.printf("Lỗi: Phải đủ %d tuổi trở lên! (Tuổi hiện tại: %d)\n", minAge, age);
            }
        }
    }
    
    // 6. Hàm nhập ngày với kiểm tra không ở tương lai
    public static LocalDate inputDateNotFuture(String message) {
        while (true) {
            LocalDate date = inputDate(message);
            LocalDate now = LocalDate.now();
            
            if (!date.isAfter(now)) {
                return date;
            } else {
                System.out.println("Lỗi: Ngày không được ở tương lai!");
            }
        }
    }
    
    // 7. Hàm nhập lựa chọn Yes/No
    public static boolean inputYesNo(String message) {
        while (true) {
            System.out.print(message + " (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            if (choice.equals("Y") || choice.equals("YES")) {
                return true;
            } else if (choice.equals("N") || choice.equals("NO")) {
                return false;
            } else {
                System.out.println("Lỗi: Vui lòng nhập Y (Yes) hoặc N (No)!");
            }
        }
    }
    
    // 8. Hàm nhập password (ẩn input - mô phỏng)
    public static String inputPassword(String message) {
        while (true) {
            System.out.print(message);
            String password = sc.nextLine();
            if (password.length() >= 6) {
                return password;
            } else {
                System.out.println("Lỗi: Mật khẩu phải có ít nhất 6 ký tự!");
            }
        }
    }
    
    // 9. Hàm nhập mã với định dạng (VD: SV001, KH123)
    public static String inputCode(String message, String prefix) {
        while (true) {
            System.out.print(message + " (" + prefix + "xxx): ");
            String code = sc.nextLine().trim().toUpperCase();
            
            if (code.matches("^" + prefix + "\\d{3,}$")) {
                return code;
            } else {
                System.out.printf("Lỗi: Mã phải bắt đầu bằng '%s' và theo sau là số (VD: %s001)\n", 
                    prefix, prefix);
            }
        }
    }
    
    // 10. Hàm hiển thị menu và nhập lựa chọn
    public static int showMenu(String title, String[] options) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println(" " + title);
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s\n", i + 1, options[i]);
        }
        System.out.println("0. Thoát");
        System.out.println("═".repeat(50));
        
        return inputIntInRange("Chọn chức năng: ", 0, options.length);
    }
    
    // 11. Hàm format số tiền Việt Nam
    public static String formatCurrency(double amount) {
        return String.format("%,.0f VNĐ", amount);
    }
    
    // 12. Hàm nhập số tiền (không âm)
    public static double inputMoney(String message) {
        while (true) {
            try {
                System.out.print(message + " (VNĐ): ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount >= 0) {
                    return amount;
                } else {
                    System.out.println("Lỗi: Số tiền không được âm!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }
    
    // 13. Hàm nhập địa chỉ (có thể rỗng)
    public static String inputAddress(String message) {
        System.out.print(message + " (Enter để bỏ qua): ");
        String address = sc.nextLine().trim();
        return address.isEmpty() ? "Chưa cập nhật" : address;
    }
    
    // 14. Hàm nhập với giá trị mặc định
    public static String inputWithDefault(String message, String defaultValue) {
        System.out.print(message + " [" + defaultValue + "]: ");
        String input = sc.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }
    
    // 15. Hàm xác nhận hành động
    public static boolean confirmAction(String action) {
        System.out.println("\n⚠️ Bạn có chắc chắn muốn " + action + " không?");
        return inputYesNo("Xác nhận");
    }
}