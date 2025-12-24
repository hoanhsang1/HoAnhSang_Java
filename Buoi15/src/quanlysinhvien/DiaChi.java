package quanlysinhvien;

import java.util.Scanner;

public class DiaChi {
    private String soNha;
    private String duong;
    private String phuongXa;
    private String quanHuyen;
    private String tinhThanh;
    
    public DiaChi() {
    }
    
    public DiaChi(String soNha, String duong, String phuongXa, String quanHuyen, String tinhThanh) {
        this.soNha = soNha;
        this.duong = duong;
        this.phuongXa = phuongXa;
        this.quanHuyen = quanHuyen;
        this.tinhThanh = tinhThanh;
    }
    
    // Getter - Setter
    public String getSoNha() {
        return soNha;
    }
    
    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    
    public String getDuong() {
        return duong;
    }
    
    public void setDuong(String duong) {
        this.duong = duong;
    }
    
    public String getPhuongXa() {
        return phuongXa;
    }
    
    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }
    
    public String getQuanHuyen() {
        return quanHuyen;
    }
    
    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }
    
    public String getTinhThanh() {
        return tinhThanh;
    }
    
    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
    
    // Nhập thông tin
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- NHẬP THÔNG TIN ĐỊA CHỈ ---");
        System.out.print("Số nhà: ");
        this.soNha = scanner.nextLine().trim();
        System.out.print("Đường: ");
        this.duong = scanner.nextLine().trim();
        System.out.print("Phường/Xã: ");
        this.phuongXa = scanner.nextLine().trim();
        System.out.print("Quận/Huyện: ");
        this.quanHuyen = scanner.nextLine().trim();
        System.out.print("Tỉnh/Thành phố: ");
        this.tinhThanh = scanner.nextLine().trim();
    }
    
    // Cập nhật địa chỉ
    public void capNhatDiaChi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== CẬP NHẬT ĐỊA CHỈ ===");
        System.out.print("Số nhà mới (Enter để giữ nguyên): ");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) this.soNha = input;
        
        System.out.print("Đường mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) this.duong = input;
        
        System.out.print("Phường/Xã mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) this.phuongXa = input;
        
        System.out.print("Quận/Huyện mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) this.quanHuyen = input;
        
        System.out.print("Tỉnh/Thành phố mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) this.tinhThanh = input;
        
        System.out.println("✓ Đã cập nhật địa chỉ!");
    }
    
    @Override
    public String toString() {
        return soNha + " " + duong + ", " + phuongXa + ", " + quanHuyen + ", " + tinhThanh;
    }
    
    public String toStringShort() {
        return soNha + " " + duong + ", " + quanHuyen + ", " + tinhThanh;
    }
}