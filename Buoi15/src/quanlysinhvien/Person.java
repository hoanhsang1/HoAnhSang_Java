package quanlysinhvien;

import java.util.Scanner;

public abstract class Person {
    protected String hoTen;
    protected Date ngaySinh;
    protected DiaChi diaChi;
    
    public Person() {
        diaChi = new DiaChi();
        ngaySinh = new Date();
    }
    
    // Getter - Setter
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public Date getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public DiaChi getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
    
    // Tính tuổi
    public int tinhTuoi() {
        return ngaySinh.tinhTuoi();
    }
    
    // Phương thức trừu tượng
    public abstract void nhapThongTin();
    public abstract void xuatThongTin();
    
    // Phương thức tiện ích
    protected String inputNonEmptyString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Không được để trống!");
        }
    }
    
    protected int inputPositiveInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                }
                System.out.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
    
    protected float inputFloatInRange(String prompt, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        float value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Float.parseFloat(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Giá trị phải từ " + min + " đến " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }
    
    protected int inputIntInRange(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Giá trị phải từ " + min + " đến " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
}