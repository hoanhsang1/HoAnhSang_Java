package quanlysinhvien;

import java.util.Scanner;

public class SinhVienTinhChi extends SinhVien {
    private int tinChi;
    private String tenDeTai;
    private float diemDG;
    private String xepLoai;
    
    public SinhVienTinhChi() {
        super();
    }
    
    // Getter - Setter
    public int getTinChi() {
        return tinChi;
    }
    
    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }
    
    public String getTenDeTai() {
        return tenDeTai;
    }
    
    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }
    
    public float getDiemDG() {
        return diemDG;
    }
    
    public void setDiemDG(float diemDG) {
        this.diemDG = diemDG;
        tinhXepLoai();
    }
    
    @Override
    public String getXepLoai() {
        return xepLoai;
    }
    
    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    
    // Tính xếp loại
    private void tinhXepLoai() {
        if (diemDG >= 4.5) xepLoai = "A";
        else if (diemDG >= 3.5) xepLoai = "B";
        else if (diemDG >= 2.5) xepLoai = "C";
        else xepLoai = "D";
    }
    
    // Kiểm tra tốt nghiệp
    @Override
    public boolean isTotNghiep() {
        return tinChi >= 120 && diemDG >= 2.5;
    }
    
    // Được khen thưởng
    @Override
    public boolean isDuocKhenThuong() {
        return xepLoai.equals("A");
    }
    
    @Override
    public float getDiem() {
        return diemDG;
    }
    
    @Override
    public String getHeDaoTao() {
        return "Đại học (Tín chỉ)";
    }
    
    @Override
    public void nhapThongTin(String maSV) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ĐẠI HỌC ===");
        
        // Nhập thông tin cá nhân từ lớp cha
        super.nhapThongTin(maSV);
        
        // VALIDATE TUỔI ĐẠI HỌC (>= 18)
        while (tinhTuoi() < 18) {
            System.out.println("\n⚠️ LỖI: Sinh viên đại học phải đủ 18 tuổi!");
            System.out.println("Tuổi hiện tại: " + tinhTuoi() + " tuổi");
            System.out.print("Nhập lại ngày sinh");
            this.ngaySinh = Date.nhapNgay("", 0);
        }
        
        System.out.println("\n--- THÔNG TIN HỌC TẬP ---");
        
        // Nhập số tín chỉ
        while (true) {
            System.out.print("Số tín chỉ: ");
            try {
                this.tinChi = Integer.parseInt(scanner.nextLine());
                if (this.tinChi > 0) {
                    break;
                }
                System.out.println("Số tín chỉ phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        
        // Nhập tên đề tài
        this.tenDeTai = inputNonEmptyString("Tên đề tài tốt nghiệp: ");
        
        // Nhập điểm đánh giá
        while (true) {
            System.out.print("Điểm đánh giá (0-5): ");
            try {
                this.diemDG = Float.parseFloat(scanner.nextLine());
                if (diemDG >= 0 && diemDG <= 5) {
                    tinhXepLoai();
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 5!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        
        System.out.println("✓ Đã nhập xong thông tin sinh viên đại học!");
    }
    
    @Override
    public void capNhatDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== CẬP NHẬT ĐIỂM SINH VIÊN TÍN CHỈ ===");
        
        System.out.print("Số tín chỉ mới (Enter để giữ nguyên): ");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            try {
                this.tinChi = Integer.parseInt(input);
                if (this.tinChi <= 0) {
                    System.out.println("Số tín chỉ phải lớn hơn 0!");
                    this.tinChi = 0; // Reset về 0 nếu không hợp lệ
                }
            } catch (NumberFormatException e) {
                System.out.println("Số tín chỉ không hợp lệ!");
            }
        }
        
        System.out.print("Tên đề tài mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            this.tenDeTai = input;
        }
        
        // Validate điểm khi cập nhật
        while (true) {
            System.out.print("Điểm đánh giá mới (0-5, Enter để giữ nguyên): ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break; // Giữ nguyên nếu không nhập
            }
            try {
                float diemMoi = Float.parseFloat(input);
                if (diemMoi >= 0 && diemMoi <= 5) {
                    this.diemDG = diemMoi;
                    tinhXepLoai();
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 5!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        
        System.out.println("✓ Đã cập nhật điểm!");
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-15s %-12s %-15s %-10s %-10s\n",
            "Đại học (TC)", (khoa != null ? khoa.getTenKhoa() : "Chưa có"),
            "TC: " + tinChi, String.format("%.2f", diemDG),
            xepLoai + (isTotNghiep() ? " ✓TN" : ""));
    }
}