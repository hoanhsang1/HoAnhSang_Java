package quanlysinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import TaomoiTV.Test;

public class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSV;
    private ArrayList<Faculty> danhSachKhoa;
    private ArrayList<School> danhSachTruong;
    private School truongHienTai;
    
    // Set để kiểm tra mã duy nhất
    private Set<String> danhSachMaSV;
    private Set<String> danhSachMaKhoa;
    private Set<String> danhSachMaTruong;
    
    // Constructor
    public QuanLySinhVien() {
        danhSachSV = new ArrayList<>();
        danhSachKhoa = new ArrayList<>();
        danhSachTruong = new ArrayList<>();
        truongHienTai = null;
        danhSachMaSV = new HashSet<>();
        danhSachMaKhoa = new HashSet<>();
        danhSachMaTruong = new HashSet<>();
    }
    
    // Kiểm tra mã sinh viên đã tồn tại chưa
    private boolean maSVTonTai(String maSV) {
        return danhSachMaSV.contains(maSV);
    }
    
    // Thêm mã sinh viên vào danh sách
    private void themMaSV(String maSV) {
        danhSachMaSV.add(maSV);
    }
    
    // Kiểm tra mã khoa đã tồn tại chưa
    private boolean maKhoaTonTai(String maKhoa) {
        return danhSachMaKhoa.contains(maKhoa);
    }
    
    // Thêm mã khoa vào danh sách
    private void themMaKhoa(String maKhoa) {
        danhSachMaKhoa.add(maKhoa);
    }
    
    // Kiểm tra mã trường đã tồn tại chưa
    private boolean maTruongTonTai(String maTruong) {
        return danhSachMaTruong.contains(maTruong);
    }
    
    // Thêm mã trường vào danh sách
    private void themMaTruong(String maTruong) {
        danhSachMaTruong.add(maTruong);
    }
    
    // 1. Nhập thông tin trường
    public void nhapThongTinTruong() {
        System.out.println("\n=== NHẬP THÔNG TIN TRƯỜNG ===");
        
        School truong = new School();
        truong.nhapThongTin();
        
        // Kiểm tra mã trường duy nhất
        while (maTruongTonTai(truong.getMaTruong())) {
            System.out.println("Mã trường đã tồn tại! Vui lòng nhập mã khác.");
            System.out.print("Mã trường mới: ");
            truong.setMaTruong(new java.util.Scanner(System.in).nextLine().trim());
        }
        
        danhSachTruong.add(truong);
        themMaTruong(truong.getMaTruong());
        
        // Nếu chưa có trường hiện tại, đặt trường này làm trường hiện tại
        if (truongHienTai == null) {
            truongHienTai = truong;
        }
        
        System.out.println("✓ Đã thêm trường: " + truong.getTenTruong() + " (Mã: " + truong.getMaTruong() + ")");
    }
    
    // 2. Chọn trường hiện tại để làm việc
    public void chonTruongHienTai() {
        if (danhSachTruong.isEmpty()) {
            System.out.println("\nChưa có trường nào! Vui lòng nhập trường trước.");
            return;
        }
        
        System.out.println("\n=== CHỌN TRƯỜNG HIỆN TẠI ĐỂ LÀM VIỆC ===");
        for (int i = 0; i < danhSachTruong.size(); i++) {
            School truong = danhSachTruong.get(i);
            String selected = (truongHienTai != null && truong.getMaTruong().equals(truongHienTai.getMaTruong())) ? " ✓" : "";
            System.out.println((i + 1) + ". " + truong.getTenTruong() + " (Mã: " + truong.getMaTruong() + ")" + selected);
        }
        
        int chon = Test.inputIntInRange("Chọn trường (1-" + danhSachTruong.size() + "): ", 1, danhSachTruong.size());
        truongHienTai = danhSachTruong.get(chon - 1);
        System.out.println("✓ Đã chọn trường: " + truongHienTai.getTenTruong());
    }
    
    // 3. Xuất danh sách trường
    public void xuatDanhSachTruong() {
        if (danhSachTruong.isEmpty()) {
            System.out.println("\nDanh sách trường trống!");
            return;
        }
        
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                      DANH SÁCH TRƯỜNG");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-25s %-12s %-8s\n", "Mã trường", "Tên trường", "Ngày TL", "Số khoa");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────");
        
        int stt = 1;
        for (School truong : danhSachTruong) {
            System.out.printf("%-3d %-10s %-25s %-12s %-8d\n",
                stt++,
                truong.getMaTruong(),
                truong.getTenTruong(),
                truong.getNgayThanhLap().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                truong.getDanhSachKhoa().size());
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số trường: " + danhSachTruong.size());
        if (truongHienTai != null) {
            System.out.println("Trường hiện tại: " + truongHienTai.getTenTruong() + " (Mã: " + truongHienTai.getMaTruong() + ")");
        }
    }
    
    // 4. Nhập danh sách khoa (CHO PHÉP CHỌN TRƯỜNG)
    public void nhapDanhSachKhoa() {
        if (danhSachTruong.isEmpty()) {
            System.out.println("\n⚠️  Vui lòng nhập thông tin trường trước!");
            return;
        }
        
        System.out.println("\n=== NHẬP DANH SÁCH KHOA ===");
        
        int n = Test.inputPositiveInt("Nhập số lượng khoa: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Khoa thứ " + (i + 1) + " ---");
            
            Faculty khoa = new Faculty();
            
            // Hỏi xem khoa này thuộc trường nào
            System.out.println("\nChọn trường cho khoa này:");
            for (int j = 0; j < danhSachTruong.size(); j++) {
                School truong = danhSachTruong.get(j);
                System.out.println((j + 1) + ". " + truong.getTenTruong() + " (Mã: " + truong.getMaTruong() + ")");
            }
            
            int chonTruong = Test.inputIntInRange("Lựa chọn (1-" + danhSachTruong.size() + "): ", 1, danhSachTruong.size());
            School truongDuocChon = danhSachTruong.get(chonTruong - 1);
            
            khoa.nhapThongTin(truongDuocChon);
            
            // Kiểm tra mã khoa duy nhất
            while (maKhoaTonTai(khoa.getMaKhoa())) {
                System.out.println("Mã khoa đã tồn tại! Vui lòng nhập mã khác.");
                System.out.print("Mã khoa mới: ");
                khoa.setMaKhoa(new java.util.Scanner(System.in).nextLine().trim());
            }
            
            danhSachKhoa.add(khoa);
            truongDuocChon.themKhoa(khoa);
            themMaKhoa(khoa.getMaKhoa());
            System.out.println("✓ Đã thêm khoa: " + khoa.getTenKhoa() + " thuộc trường: " + truongDuocChon.getTenTruong());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + n + " khoa!");
    }
    
    // 5. Xuất danh sách khoa
    public void xuatDanhSachKhoa() {
        if (danhSachKhoa.isEmpty()) {
            System.out.println("\nDanh sách khoa trống!");
            return;
        }
        
        Faculty.xuatTieuDe();
        
        int stt = 1;
        for (Faculty khoa : danhSachKhoa) {
            System.out.printf("%-3d ", stt++);
            khoa.xuatThongTin();
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số khoa: " + danhSachKhoa.size());
    }
    
    // 6. Nhập thông tin sinh viên (SINH VIÊN KHÔNG CHỌN TRƯỜNG, chỉ chọn khoa)
    public void nhapThongTinSinhVien() {
        if (danhSachKhoa.isEmpty()) {
            System.out.println("\n⚠️  Vui lòng nhập danh sách khoa trước!");
            return;
        }
        
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ===");
        
        // Chọn hệ đào tạo
        System.out.println("Chọn hệ đào tạo:");
        System.out.println("1. Đại học (Tín chỉ)");
        System.out.println("2. Cao đẳng (Niên chế)");
        System.out.println("3. Trung cấp (Niên chế)");
        
        int choice = Test.inputIntInRange("Lựa chọn (1-3): ", 1, 3);
        
        SinhVien sv = null;
        
        switch (choice) {
            case 1:
                sv = new SinhVienTinhChi();
                break;
            case 2:
                sv = new CaoDang();
                break;
            case 3:
                sv = new TrungCap();
                break;
        }
        
        if (sv != null) {
            // Nhập mã sinh viên với kiểm tra duy nhất
            while (true) {
                String maSVInput = Test.inputNonEmptyString("Mã sinh viên: ");
                if (maSVTonTai(maSVInput)) {
                    System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập mã khác.");
                } else {
                    sv.setMaSV(maSVInput);
                    themMaSV(maSVInput);
                    break;
                }
            }
            
            // Nhập thông tin chung
            sv.nhapThongTin();
            
            // Chọn khoa (hiển thị cả trường của khoa)
            System.out.println("\n=== CHỌN KHOA ===");
            for (int i = 0; i < danhSachKhoa.size(); i++) {
                Faculty khoa = danhSachKhoa.get(i);
                System.out.println((i + 1) + ". " + khoa.getTenKhoa() + 
                    " (Mã: " + khoa.getMaKhoa() + 
                    ") - Trường: " + khoa.getTruong().getTenTruong());
            }
            int chonKhoa = Test.inputIntInRange("Chọn khoa (1-" + danhSachKhoa.size() + "): ", 1, danhSachKhoa.size());
            sv.setKhoa(danhSachKhoa.get(chonKhoa - 1));
            
            danhSachSV.add(sv);
            System.out.println("✓ Đã thêm sinh viên: " + sv.getHoTen() + 
                " - Mã: " + sv.getMaSV() + 
                " - Khoa: " + sv.getKhoa().getTenKhoa() +
                " - Trường: " + sv.getKhoa().getTruong().getTenTruong());
        }
    }
    
    // 7. Xuất danh sách sinh viên
    public void xuatDanhSachSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : danhSachSV) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
    }
    
    // 8. Sắp xếp theo mã (riêng từng hệ)
    public void sapXepTheoMa() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        // Tách danh sách theo hệ
        ArrayList<SinhVienTinhChi> dsTinhChi = new ArrayList<>();
        ArrayList<SinhVienNienChe> dsNienChe = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            // Sử dụng getClass().getName() để so sánh
            String className = sv.getClass().getName();
            if (className.equals("quanlysinhvien.SinhVienTinhChi")) {
                dsTinhChi.add((SinhVienTinhChi) sv);
            } else if (className.contains("SinhVienNienChe")) {
                dsNienChe.add((SinhVienNienChe) sv);
            }
        }
        
        // Sắp xếp từng hệ
        if (!dsTinhChi.isEmpty()) {
            Collections.sort(dsTinhChi, Comparator.comparing(SinhVienTinhChi::getMaSV));
        }
        if (!dsNienChe.isEmpty()) {
            Collections.sort(dsNienChe, Comparator.comparing(SinhVienNienChe::getMaSV));
        }
        
        // Gộp lại
        danhSachSV.clear();
        danhSachSV.addAll(dsTinhChi);
        danhSachSV.addAll(dsNienChe);
        
        System.out.println("\n✓ Đã sắp xếp sinh viên theo mã (riêng từng hệ)");
    }
    
    // 9. Tìm kiếm theo tên sinh viên
    public void timKiemTheoTen() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        String tenCanTim = Test.inputNonEmptyString("Nhập tên sinh viên cần tìm: ").toLowerCase();
        
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            if (sv.getHoTen().toLowerCase().contains(tenCanTim)) {
                ketQua.add(sv);
            }
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("\nKhông tìm thấy sinh viên có tên: " + tenCanTim);
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               KẾT QUẢ TÌM KIẾM: '" + tenCanTim + "' (" + ketQua.size() + " kết quả)");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : ketQua) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
    
    // 10. Thống kê tổng số sinh viên
    public void thongKeSoLuongSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        int countTinhChi = 0;
        int countCaoDang = 0;
        int countTrungCap = 0;
        
        for (SinhVien sv : danhSachSV) {
            // Sử dụng getClass().getName() để phân biệt
            String className = sv.getClass().getName();
            if (className.equals("quanlysinhvien.SinhVienTinhChi")) {
                countTinhChi++;
            } else if (className.equals("quanlysinhvien.CaoDang")) {
                countCaoDang++;
            } else if (className.equals("quanlysinhvien.TrungCap")) {
                countTrungCap++;
            }
        }
        
        System.out.println("\n=== THỐNG KÊ SỐ LƯỢNG SINH VIÊN ===");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
        System.out.println("Đại học (Tín chỉ): " + countTinhChi);
        System.out.println("Cao đẳng: " + countCaoDang);
        System.out.println("Trung cấp: " + countTrungCap);
        
        // Thống kê theo khoa và trường
        System.out.println("\n=== THỐNG KÊ THEO KHOA VÀ TRƯỜNG ===");
        for (Faculty khoa : danhSachKhoa) {
            int count = 0;
            for (SinhVien sv : danhSachSV) {
                if (sv.getKhoa() != null && sv.getKhoa().getMaKhoa().equals(khoa.getMaKhoa())) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(khoa.getTenKhoa() + " (" + 
                    (khoa.getTruong() != null ? khoa.getTruong().getTenTruong() : "Chưa có trường") + 
                    "): " + count + " sinh viên");
            }
        }
    }
    
    // 11. Danh sách sinh viên được khen thưởng
    public void danhSachSinhVienDuocKhenThuong() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        ArrayList<SinhVien> danhSachKhenThuong = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            if (sv.isDuocKhenThuong()) {
                danhSachKhenThuong.add(sv);
            }
        }
        
        if (danhSachKhenThuong.isEmpty()) {
            System.out.println("\nKhông có sinh viên nào được khen thưởng!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               DANH SÁCH SINH VIÊN ĐƯỢC KHEN THƯỞNG CUỐI KHÓA");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : danhSachKhenThuong) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số: " + danhSachKhenThuong.size() + " sinh viên được khen thưởng");
    }
    
    // 12. Thống kê kết quả học tập
    public void thongKeKetQuaHocTap() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        // Thống kê cho hệ tín chỉ
        int countA = 0, countB = 0, countC = 0, countD = 0;
        // Thống kê cho hệ niên chế
        int countGioi = 0, countKha = 0, countTB = 0, countYeu = 0;
        
        for (SinhVien sv : danhSachSV) {
            String xepLoai = sv.getXepLoai();
            
            String className = sv.getClass().getName();
            if (className.equals("quanlysinhvien.SinhVienTinhChi")) {
                switch (xepLoai) {
                    case "A": countA++; break;
                    case "B": countB++; break;
                    case "C": countC++; break;
                    case "D": countD++; break;
                }
            } else if (className.contains("SinhVienNienChe")) {
                switch (xepLoai) {
                    case "Giỏi": countGioi++; break;
                    case "Khá": countKha++; break;
                    case "Trung bình": countTB++; break;
                    case "Yếu": countYeu++; break;
                }
            }
        }
        
        System.out.println("\n=== THỐNG KÊ KẾT QUẢ HỌC TẬP ===");
        System.out.println("\nHệ Đại học (Tín chỉ):");
        System.out.println("A: " + countA + " sinh viên");
        System.out.println("B: " + countB + " sinh viên");
        System.out.println("C: " + countC + " sinh viên");
        System.out.println("D: " + countD + " sinh viên");
        
        System.out.println("\nHệ Niên chế (Cao đẳng/Trung cấp):");
        System.out.println("Giỏi: " + countGioi + " sinh viên");
        System.out.println("Khá: " + countKha + " sinh viên");
        System.out.println("Trung bình: " + countTB + " sinh viên");
        System.out.println("Yếu: " + countYeu + " sinh viên");
        
        System.out.println("\nTổng số sinh viên đã tốt nghiệp: " + demSoSinhVienTotNghiep());
    }
    
    // 13. Thống kê theo trường
    public void thongKeTheoTruong() {
        if (danhSachTruong.isEmpty()) {
            System.out.println("\nChưa có thông tin trường!");
            return;
        }
        
        System.out.println("\n=== THỐNG KÊ THEO TRƯỜNG ===");
        
        for (School truong : danhSachTruong) {
            System.out.println("\nTrường: " + truong.getTenTruong() + " (Mã: " + truong.getMaTruong() + ")");
            System.out.println("Số khoa: " + truong.getDanhSachKhoa().size());
            
            // Đếm số sinh viên của trường này
            int countSV = 0;
            for (SinhVien sv : danhSachSV) {
                if (sv.getKhoa() != null && sv.getKhoa().getTruong() != null && 
                    sv.getKhoa().getTruong().getMaTruong().equals(truong.getMaTruong())) {
                    countSV++;
                }
            }
            System.out.println("Số sinh viên: " + countSV);
            
            // Thống kê chi tiết theo khoa
            if (countSV > 0) {
                System.out.println("\n  Chi tiết theo khoa:");
                for (Faculty khoa : truong.getDanhSachKhoa()) {
                    int countKhoa = 0;
                    for (SinhVien sv : danhSachSV) {
                        if (sv.getKhoa() != null && sv.getKhoa().getMaKhoa().equals(khoa.getMaKhoa())) {
                            countKhoa++;
                        }
                    }
                    if (countKhoa > 0) {
                        System.out.println("  - " + khoa.getTenKhoa() + ": " + countKhoa + " sinh viên");
                    }
                }
            }
        }
        
        if (truongHienTai != null) {
            System.out.println("\n══════════════════════════════════════════════");
            System.out.println("TRƯỜNG HIỆN TẠI: " + truongHienTai.getTenTruong());
            System.out.println("══════════════════════════════════════════════");
        }
    }
    
    // Đếm số sinh viên đã tốt nghiệp
    private int demSoSinhVienTotNghiep() {
        int count = 0;
        for (SinhVien sv : danhSachSV) {
            if (sv.isTotNghiep()) {
                count++;
            }
        }
        return count;
    }
    
    // Getter
    public int getSoLuongSinhVien() {
        return danhSachSV.size();
    }
    
    public int getSoLuongKhoa() {
        return danhSachKhoa.size();
    }
    
    public int getSoLuongTruong() {
        return danhSachTruong.size();
    }
}