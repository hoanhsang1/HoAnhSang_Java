package bai1;

public class GiaoVien extends Nguoi {
    // Thuộc tính riêng
    private String maGV;
    private double diemThiDua;
    
    // Constructor
    public GiaoVien() {
        super();
    }
    
    // Getter - Setter
    public String getMaGV() {
        return maGV;
    }
    
    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }
    
    public double getDiemThiDua() {
        return diemThiDua;
    }
    
    public void setDiemThiDua(double diemThiDua) {
        // Kiểm tra điểm từ 0-100
        if (diemThiDua < 0) {
            this.diemThiDua = 0;
        } else if (diemThiDua > 100) {
            this.diemThiDua = 100;
        } else {
            this.diemThiDua = diemThiDua;
        }
    }
    
    // Phương thức xếp loại thi đua
    public String xepLoaiThiDua() {
        if (diemThiDua >= 90) return "A";
        else if (diemThiDua >= 80) return "B";
        else if (diemThiDua >= 65) return "C";
        else return "D";
    }
    
    // Phương thức nhập thông tin giáo viên
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN GIÁO VIÊN ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Nhập mã giáo viên
        System.out.print("Mã giáo viên: ");
        this.maGV = sc.nextLine().trim();
        
        // Nhập điểm thi đua
        while (true) {
            try {
                System.out.print("Điểm thi đua (0-100): ");
                this.diemThiDua = Double.parseDouble(sc.nextLine());
                if (this.diemThiDua >= 0 && this.diemThiDua <= 100) {
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 100!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    
    // Phương thức xuất thông tin giáo viên
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf(" %-15s %-8.2f %-5s\n",
            maGV,
            diemThiDua,
            xepLoaiThiDua());
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                    DANH SÁCH GIÁO VIÊN");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-25s %-12s %-20s %-15s %-15s %-8s %-5s\n",
            "Họ tên", "Ngày sinh", "Địa chỉ", "CCCD", "Mã GV", "Điểm TD", "Loại");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}