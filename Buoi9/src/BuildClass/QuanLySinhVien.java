package BuildClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien {
    private ArrayList<Student> danhSachSV;
    private Scanner sc;
    
    // Constructor
    public QuanLySinhVien() {
        danhSachSV = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    // Kiểm tra mã sinh viên có tồn tại chưa
    private boolean maSVTonTai(String maSV) {
        for (Student sv : danhSachSV) {
            if (sv.getId().equalsIgnoreCase(maSV)) {
                return true;
            }
        }
        return false;
    }
    
    // 1. Nhập danh sách sinh viên
    public void nhapDanhSach() {
        System.out.println("\n=== NHẬP DANH SÁCH SINH VIÊN ===");
        
        int n = nhapSoNguyen("Nhập số lượng sinh viên: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sinh viên thứ " + (i + 1) + " ---");
            Student sv = nhapSinhVien();
            if (sv != null) {
                danhSachSV.add(sv);
                System.out.println("✓ Đã thêm: " + sv.getTen());
            } else {
                System.out.println("✗ Thêm sinh viên thất bại!");
                i--; // Giảm i để nhập lại sinh viên này
            }
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachSV.size() + " sinh viên!");
    }
    
    // Nhập thông tin 1 sinh viên
    private Student nhapSinhVien() {
        Student sv = new Student();
        
        // Nhập ID (phải duy nhất)
        String maSV;
        while (true) {
            System.out.print("Mã sinh viên: ");
            maSV = sc.nextLine().trim();
            
            if (maSV.isEmpty()) {
                System.out.println("Mã sinh viên không được để trống!");
                continue;
            }
            
            if (maSVTonTai(maSV)) {
                System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                sv.setId(maSV);
                break;
            }
        }
        
        // Nhập tên
        System.out.print("Họ tên: ");
        sv.setTen(sc.nextLine());
        
        // Nhập điểm TB
        double diem;
        while (true) {
            try {
                System.out.print("Điểm trung bình (0-10): ");
                diem = Double.parseDouble(sc.nextLine());
                if (diem >= 0 && diem <= 10) {
                    sv.setDiemTB(diem);
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 10!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
        
        return sv;
    }
    
    // 2. Xem danh sách sinh viên
    public void xemDanhSach() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                          DANH SÁCH SINH VIÊN                         │");
        System.out.println("├──────────┬─────────────────────────┬──────────┬──────────────────────┤");
        System.out.println("│ Mã SV    │ Họ tên                  │ Điểm TB  │ Xếp loại             │");
        System.out.println("├──────────┼─────────────────────────┼──────────┼──────────────────────┤");
        
        for (Student sv : danhSachSV) {
            System.out.println(sv.toString());
        }
        
        System.out.println("├──────────┴─────────────────────────┴──────────┴──────────────────────┤");
        System.out.printf("│ Tổng số sinh viên: %-45d │\n", danhSachSV.size());
        System.out.println("└─────────────────────────────────────────────────────────────────────┘");
    }
    
    // Xem danh sách đơn giản
    public void xemDanhSachDonGian() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        System.out.println("\n========================================================================");
        System.out.println("                      DANH SÁCH SINH VIÊN (" + danhSachSV.size() + " SV)");
        System.out.println("==========================================================================");
        System.out.println("Mã SV      Họ tên                     Điểm TB   Xếp loại");
        System.out.println("--------------------------------------------------------------------------");
        
        for (Student sv : danhSachSV) {
            System.out.println(sv.toStringNgan());
        }
        
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Tổng số: " + danhSachSV.size() + " sinh viên");
        System.out.println("==========================================================================\n");
    }
    
    // 3. Sắp xếp và hiển thị theo điểm TB tăng dần (BẢNG ĐƠN GIẢN HƠN)
    public void sapXepTheoDiemTB() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        // Tạo bản sao để sắp xếp
        ArrayList<Student> danhSachSapXep = new ArrayList<>(danhSachSV);
        
        // Sắp xếp sử dụng Comparator
        Collections.sort(danhSachSapXep, new SortByDiemTB());
        
        // Hiển thị bảng đơn giản hơn
        System.out.println("\n══════════════════════════════════════════════════════════════════");
        System.out.println("        DANH SÁCH SINH VIÊN SẮP XẾP THEO ĐIỂM TB (TĂNG DẦN)");
        System.out.println("══════════════════════════════════════════════════════════════════");
        System.out.println("STT  Mã SV      Họ tên                     Điểm TB   Xếp loại");
        System.out.println("──────────────────────────────────────────────────────────────────");
        
        int stt = 1;
        for (Student sv : danhSachSapXep) {
            System.out.printf("%-4d %-10s %-25s %8.2f %12s\n",
                stt++, sv.getId(), sv.getTen(), sv.getDiemTB(), sv.xepLoai());
        }
        
        System.out.println("──────────────────────────────────────────────────────────────────");
        System.out.printf("Tổng số: %d sinh viên | Điểm cao nhất: %.2f | Điểm thấp nhất: %.2f | TB: %.2f\n",
            danhSachSapXep.size(), timDiemCaoNhat(), timDiemThapNhat(), tinhDiemTrungBinh());
        System.out.println("══════════════════════════════════════════════════════════════════\n");
    }
    
    // 4. Tìm kiếm sinh viên theo tên
    public void timKiemTheoTen() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String tenCanTim = sc.nextLine().trim().toLowerCase();
        
        ArrayList<Student> ketQua = new ArrayList<>();
        
        for (Student sv : danhSachSV) {
            if (sv.getTen().toLowerCase().contains(tenCanTim)) {
                ketQua.add(sv);
            }
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("\nKhông tìm thấy sinh viên có tên: " + tenCanTim);
            return;
        }
        
        System.out.println("\n══════════════════════════════════════════════════════════════════");
        System.out.printf("        KẾT QUẢ TÌM KIẾM: '%s' (%d kết quả)\n", tenCanTim, ketQua.size());
        System.out.println("══════════════════════════════════════════════════════════════════");
        System.out.println("Mã SV      Họ tên                     Điểm TB   Xếp loại");
        System.out.println("──────────────────────────────────────────────────────────────────");
        
        for (Student sv : ketQua) {
            System.out.println(sv.toStringNgan());
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════\n");
    }
    
    // 5. Thêm 1 sinh viên mới (KIỂM TRA MÃ DUY NHẤT)
    public void themSinhVien() {
        System.out.println("\n=== THÊM SINH VIÊN MỚI ===");
        Student sv = new Student();
        
        // Nhập ID (phải duy nhất)
        String maSV;
        while (true) {
            System.out.print("Mã sinh viên: ");
            maSV = sc.nextLine().trim();
            
            if (maSV.isEmpty()) {
                System.out.println("Mã sinh viên không được để trống!");
                continue;
            }
            
            if (maSVTonTai(maSV)) {
                System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                sv.setId(maSV);
                break;
            }
        }
        
        // Nhập tên
        System.out.print("Họ tên: ");
        sv.setTen(sc.nextLine());
        
        // Nhập điểm TB
        double diem;
        while (true) {
            try {
                System.out.print("Điểm trung bình (0-10): ");
                diem = Double.parseDouble(sc.nextLine());
                if (diem >= 0 && diem <= 10) {
                    sv.setDiemTB(diem);
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 10!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
        
        danhSachSV.add(sv);
        System.out.println("✓ Đã thêm sinh viên: " + sv.getTen());
    }
    
    // 6. Tính điểm trung bình của tất cả sinh viên
    public double tinhDiemTrungBinh() {
        if (danhSachSV.isEmpty()) return 0;
        
        double tong = 0;
        for (Student sv : danhSachSV) {
            tong += sv.getDiemTB();
        }
        return tong / danhSachSV.size();
    }
    
    // 7. Tìm điểm cao nhất
    public double timDiemCaoNhat() {
        if (danhSachSV.isEmpty()) return 0;
        
        double max = danhSachSV.get(0).getDiemTB();
        for (Student sv : danhSachSV) {
            if (sv.getDiemTB() > max) {
                max = sv.getDiemTB();
            }
        }
        return max;
    }
    
    // 8. Tìm điểm thấp nhất
    public double timDiemThapNhat() {
        if (danhSachSV.isEmpty()) return 0;
        
        double min = danhSachSV.get(0).getDiemTB();
        for (Student sv : danhSachSV) {
            if (sv.getDiemTB() < min) {
                min = sv.getDiemTB();
            }
        }
        return min;
    }
    
    // 9. Thống kê xếp loại
    public void thongKeXepLoai() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        
        for (Student sv : danhSachSV) {
            String xepLoai = sv.xepLoai();
            switch (xepLoai) {
                case "Giỏi": gioi++; break;
                case "Khá": kha++; break;
                case "Trung bình": tb++; break;
                case "Yếu": yeu++; break;
            }
        }
        
        System.out.println("\n=== THỐNG KÊ XẾP LOẠI ===");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
        System.out.println("Giỏi: " + gioi + " sinh viên (" + String.format("%.1f", (gioi*100.0/danhSachSV.size())) + "%)");
        System.out.println("Khá: " + kha + " sinh viên (" + String.format("%.1f", (kha*100.0/danhSachSV.size())) + "%)");
        System.out.println("Trung bình: " + tb + " sinh viên (" + String.format("%.1f", (tb*100.0/danhSachSV.size())) + "%)");
        System.out.println("Yếu: " + yeu + " sinh viên (" + String.format("%.1f", (yeu*100.0/danhSachSV.size())) + "%)");
        System.out.printf("Điểm TB toàn trường: %.2f\n", tinhDiemTrungBinh());
    }
    
    // Phương thức nhập số nguyên
    private int nhapSoNguyen(String message) {
        while (true) {
            try {
                System.out.print(message);
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) return n;
                System.out.println("Số lượng phải > 0!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }
    
    // Getter danh sách
    public ArrayList<Student> getDanhSachSV() {
        return danhSachSV;
    }
    
    // Getter số lượng
    public int getSoLuong() {
        return danhSachSV.size();
    }
}