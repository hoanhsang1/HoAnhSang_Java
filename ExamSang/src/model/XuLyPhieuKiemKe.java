package model;
import ThuVienSang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class XuLyPhieuKiemKe {
    private List<PhongBan> danhSachPhongBan;
    private List<NhanVien> danhSachNhanVien;
    private List<PhieuKiemKe> danhSachPhieu;
    private List<TaiSan> danhSachTaiSan; // Danh sách tài sản riêng
    
    public XuLyPhieuKiemKe() {
        this.danhSachPhongBan = new ArrayList<>();
        this.danhSachNhanVien = new ArrayList<>();
        this.danhSachPhieu = new ArrayList<>();
        this.danhSachTaiSan = new ArrayList<>();
        khoiTaoDuLieuMau();
    }
    
    private void khoiTaoDuLieuMau() {
        try {
            // Tạo phòng ban mẫu
            themPhongBanMau("PTC", "Tổ chức hành chính", "Hoàng Bích Hảo");
            themPhongBanMau("PKD", "Kinh doanh", "Nguyễn Văn A");
            themPhongBanMau("PNS", "Nhân sự", "Trần Thị B");
            
            // Tạo tài sản mẫu
            themTaiSanMau("TS001", "Máy vi tính", 5, "Tốt");
            themTaiSanMau("TS002", "Máy in", 2, "Tốt");
            themTaiSanMau("TS003", "Bàn làm việc", 10, "Tốt");
            themTaiSanMau("TS004", "Ghế văn phòng", 15, "Tốt");
            themTaiSanMau("TS005", "Tủ tài liệu", 3, "Khá");
            
            // Tạo nhân viên mẫu
            themNhanVienMau("NV01", "Kiều Thị Thanh", "Kế toán viên", "PTC", Quyen.NHAN_VIEN_KK);
            themNhanVienMau("NV02", "Nguyễn Văn Bình", "Kế toán trưởng", "PTC", Quyen.QUAN_LY);
            themNhanVienMau("TP01", "Hoàng Bích Hảo", "Trưởng phòng", "PTC", Quyen.TRUONG_PHONG);
            themNhanVienMau("ADMIN01", "Admin System", "Quản trị viên", "PTC", Quyen.ADMIN);
            themNhanVienMau("NV03", "Trần Minh Châu", "Nhân viên", "PKD", Quyen.NHAN_VIEN_KK);
            themNhanVienMau("TP02", "Nguyễn Văn A", "Trưởng phòng", "PKD", Quyen.TRUONG_PHONG);
            
            // Tạo phiếu kiểm kê mẫu từ đề bài
            taoPhieuKiemKeMau();
            
            System.out.println("✅ Đã khởi tạo dữ liệu mẫu thành công!");
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi khởi tạo dữ liệu: " + e.getMessage());
        }
    }
    
    private void themPhongBanMau(String maPhong, String tenPhong, String truongPhong) {
        try {
            PhongBan pb = new PhongBan(maPhong, tenPhong, truongPhong);
            danhSachPhongBan.add(pb);
        } catch (Exception e) {
            System.out.println("Lỗi thêm phòng " + maPhong + ": " + e.getMessage());
        }
    }
    
    private void themTaiSanMau(String maTS, String tenTS, int soLuong, String tinhTrang) {
        try {
            TaiSan ts = new TaiSan(maTS, tenTS, soLuong, tinhTrang);
            danhSachTaiSan.add(ts);
        } catch (Exception e) {
            System.out.println("Lỗi thêm tài sản " + maTS + ": " + e.getMessage());
        }
    }
    
    private void themNhanVienMau(String maNV, String tenNV, String chucVu, String maPhong, Quyen quyen) {
        try {
            PhongBan pb = timPhongBanTheoMa(maPhong);
            if (pb != null) {
                NhanVien nv = new NhanVien(maNV, tenNV, chucVu, pb, quyen);
                danhSachNhanVien.add(nv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi thêm nhân viên " + maNV + ": " + e.getMessage());
        }
    }
    
    private void taoPhieuKiemKeMau() {
        try {
            NhanVien nv = timNhanVienTheoMa("NV01");
            PhongBan pb = timPhongBanTheoMa("PTC");
            
            if (nv != null && pb != null) {
                PhieuKiemKe phieu = new PhieuKiemKe("PH01", 
                    LocalDate.of(2007, 1, 1), nv, pb);
                
                phieu.themTaiSan(new TaiSan("TS001", "Máy vi tính", 5, "Tốt"));
                phieu.themTaiSan(new TaiSan("TS002", "Máy vi tính", 3, "Hết khấu hao - hỏng"));
                phieu.themTaiSan(new TaiSan("TS003", "Bàn làm việc", 6, "Tốt"));
                
                danhSachPhieu.add(phieu);
            }
        } catch (Exception e) {
            System.out.println("Lỗi tạo phiếu mẫu: " + e.getMessage());
        }
    }
    
    // ========== THÊM PHÒNG BAN ==========

	public void themPhongBan() {
	    System.out.println("\n════════════ THÊM PHÒNG BAN MỚI ════════════");
	    
	    try {
	        // Nhập mã phòng
	        String maPhong;
	        while (true) {
	            maPhong = Test.inputNonEmptyString("Nhập mã phòng (P__): ");
	            if (!maPhong.matches("P[A-Z]{2}")) {
	                System.out.println("⚠ Mã phòng phải có dạng P + 2 chữ cái (VD: PTC, PKD)");
	                continue;
	            }
	            
	            if (timPhongBanTheoMa(maPhong) != null) {
	                System.out.println("⚠ Mã phòng đã tồn tại!");
	            } else {
	                break;
	            }
	        }
	        
	        // Nhập tên phòng
	        String tenPhong = Test.inputNonEmptyString("Nhập tên phòng: ");
	        
	        // CHỌN TRƯỞNG PHÒNG TỪ DANH SÁCH NHÂN VIÊN (SỬA Ở ĐÂY)
	        String truongPhong;
	        
	        if (danhSachNhanVien.isEmpty()) {
	            // Nếu chưa có nhân viên, nhập tên trực tiếp
	            truongPhong = Test.inputNonEmptyString("Nhập tên trưởng phòng (chưa có nhân viên): ");
	        } else {
	            System.out.println("\n─── CHỌN TRƯỞNG PHÒNG TỪ DANH SÁCH NHÂN VIÊN ───");
	            
	            // Hiển thị danh sách nhân viên
	            List<String> dsNhanVien = new ArrayList<>();
	            for (int i = 0; i < danhSachNhanVien.size(); i++) {
	                NhanVien nv = danhSachNhanVien.get(i);
	                String info = String.format("%d. %s - %s (%s)", 
	                    i + 1, nv.getMaNV(), nv.getTenNV(), nv.getChucVu());
	                dsNhanVien.add(info);
	            }
	            
	            // Hiển thị dạng bảng
	            Mang.displayAsTable(dsNhanVien, 1); // 1 cột để dễ đọc
	            
	            // Tùy chọn
	            System.out.println("\n0. Nhập tên trưởng phòng mới");
	            System.out.println("1-" + danhSachNhanVien.size() + ". Chọn nhân viên làm trưởng phòng");
	            
	            int choiceTP = Test.inputInt("Lựa chọn (0-" + danhSachNhanVien.size() + "): ");
	            
	            if (choiceTP == 0) {
	                // Nhập tên mới
	                truongPhong = Test.inputNonEmptyString("Nhập tên trưởng phòng: ");
	            } else if (choiceTP >= 1 && choiceTP <= danhSachNhanVien.size()) {
	                // Chọn từ danh sách
	                NhanVien nvChon = danhSachNhanVien.get(choiceTP - 1);
	                truongPhong = nvChon.getTenNV();
	                
	                // Cập nhật quyền cho nhân viên thành TRƯỞNG PHÒNG nếu chưa phải
	                if (!nvChon.laTruongPhong()) {
	                    nvChon.setQuyen(Quyen.TRUONG_PHONG);
	                    System.out.println("✅ Đã cập nhật " + nvChon.getTenNV() + " thành Trưởng phòng");
	                }
	            } else {
	                System.out.println("Lựa chọn không hợp lệ!");
	                return;
	            }
	        }
	        
	        // Tạo và thêm phòng ban
	        PhongBan pb = new PhongBan(maPhong, tenPhong, truongPhong);
	        danhSachPhongBan.add(pb);
	        
	        System.out.println("\n✅ ĐÃ THÊM PHÒNG BAN THÀNH CÔNG!");
	        System.out.println("Mã phòng: " + maPhong);
	        System.out.println("Tên phòng: " + tenPhong);
	        System.out.println("Trưởng phòng: " + truongPhong);
	        
	    } catch (Exception e) {
	        System.out.println("❌ Lỗi: " + e.getMessage());
	    }
	}
	// ========== THÊM TÀI SẢN ==========
    public void themTaiSan() {
        System.out.println("\n════════════ THÊM TÀI SẢN MỚI ════════════");
        
        try {
            // Nhập mã tài sản
            String maTS;
            while (true) {
                maTS = Test.inputNonEmptyString("Nhập mã tài sản (TS___): ");
                if (!maTS.matches("TS\\d{3}")) {
                    System.out.println("⚠ Mã tài sản phải có dạng TS + 3 số (VD: TS001)");
                    continue;
                }
                
                if (timTaiSanTheoMa(maTS) != null) {
                    System.out.println("⚠ Mã tài sản đã tồn tại!");
                } else {
                    break;
                }
            }
            
            // Nhập tên tài sản
            String tenTS = Test.inputNonEmptyString("Nhập tên tài sản: ");
            
            // Nhập số lượng
            int soLuong = Test.inputPositiveInt("Nhập số lượng: ");
            
            // Nhập tình trạng với menu lựa chọn
            System.out.println("\nChọn tình trạng:");
            System.out.println("1. Tốt");
            System.out.println("2. Khá");
            System.out.println("3. Hỏng");
            System.out.println("4. Hết khấu hao");
            System.out.println("5. Khác");
            
            int choiceTT = Test.inputInt("Lựa chọn (1-5): ");
            String tinhTrang;
            
            switch (choiceTT) {
                case 1: tinhTrang = "Tốt"; break;
                case 2: tinhTrang = "Khá"; break;
                case 3: tinhTrang = "Hỏng"; break;
                case 4: tinhTrang = "Hết khấu hao"; break;
                default: tinhTrang = Test.inputNonEmptyString("Nhập tình trạng: ");
            }
            
            // Tạo và thêm tài sản
            TaiSan ts = new TaiSan(maTS, tenTS, soLuong, tinhTrang);
            danhSachTaiSan.add(ts);
            
            System.out.println("\n✅ ĐÃ THÊM TÀI SẢN THÀNH CÔNG!");
            System.out.println("Mã TS: " + maTS);
            System.out.println("Tên TS: " + tenTS);
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Tình trạng: " + tinhTrang);
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
    
    // ========== THÊM NHÂN VIÊN ==========
// ========== THÊM NHÂN VIÊN ==========
	public void themNhanVien() {
	    System.out.println("\n════════════ THÊM NHÂN VIÊN MỚI ════════════");
	    
	    try {
	        // Nhập mã nhân viên
	        String maNV;
	        while (true) {
	            maNV = Test.inputNonEmptyString("Nhập mã nhân viên (NV/TP/ADMIN + số): ");
	            if (!maNV.matches("(NV|TP|ADMIN)\\d+")) {
	                System.out.println("⚠ Mã NV phải bắt đầu bằng NV, TP hoặc ADMIN");
	                continue;
	            }
	            
	            if (timNhanVienTheoMa(maNV) != null) {
	                System.out.println("⚠ Mã nhân viên đã tồn tại!");
	            } else {
	                break;
	            }
	        }
	        
	        String tenNV = Test.inputNonEmptyString("Nhập tên nhân viên: ");
	        String chucVu = Test.inputNonEmptyString("Nhập chức vụ: ");
	        
	        // CHỌN PHÒNG BAN
	        System.out.println("\n─── CHỌN PHÒNG BAN ───");
	        if (danhSachPhongBan.isEmpty()) {
	            System.out.println("Chưa có phòng ban nào!");
	            return;
	        }
	        
	        // Hiển thị danh sách phòng ban
	        List<String> dsPhong = new ArrayList<>();
	        for (int i = 0; i < danhSachPhongBan.size(); i++) {
	            PhongBan pb = danhSachPhongBan.get(i);
	            dsPhong.add((i + 1) + ". " + pb.getMaPhong() + " - " + pb.getTenPhong());
	        }
	        Mang.displayAsTable(dsPhong, 2);
	        
	        int choicePB = Test.inputInt("Chọn phòng (1-" + danhSachPhongBan.size() + "): ");
	        if (choicePB < 1 || choicePB > danhSachPhongBan.size()) {
	            System.out.println("Lựa chọn không hợp lệ!");
	            return;
	        }
	        PhongBan phongBan = danhSachPhongBan.get(choicePB - 1);
	        
	        // CHỌN QUYỀN - THÔNG MINH HƠN
	        Quyen quyen;
	        
	        // Tự động gán quyền dựa trên chức vụ
	        if (chucVu.toLowerCase().contains("trưởng phòng")) {
	            quyen = Quyen.TRUONG_PHONG;
	            System.out.println("⚠ Tự động gán quyền: TRUONG_PHONG (vì chức vụ là Trưởng phòng)");
	            
	            // Cập nhật tên trưởng phòng trong phòng ban
	            phongBan.setTruongPhong(tenNV);
	            System.out.println("✅ Đã cập nhật " + tenNV + " làm trưởng phòng của " + 
	                phongBan.getTenPhong());
	        } else if (chucVu.toLowerCase().contains("quản lý") || 
	                   chucVu.toLowerCase().contains("quản lý")) {
	            quyen = Quyen.QUAN_LY;
	            System.out.println("⚠ Tự động gán quyền: QUAN_LY (vì chức vụ là Quản lý)");
	        } else if (chucVu.toLowerCase().contains("admin") || 
	                   chucVu.toLowerCase().contains("quản trị")) {
	            quyen = Quyen.ADMIN;
	            System.out.println("⚠ Tự động gán quyền: ADMIN (vì chức vụ là Admin)");
	        } else {
	            // Hiển thị menu chọn quyền cho nhân viên thường
	            String[] menuQuyen = {
	                "NHAN_VIEN_KK - Nhân viên kiểm kê",
	                "XEM_BAO_CAO - Chỉ xem báo cáo"
	            };
	            
	            System.out.println("\n─── CHỌN QUYỀN CHO NHÂN VIÊN ───");
	            int choiceQuyen = Test.showMenu("CHỌN QUYỀN", menuQuyen);
	            
	            switch (choiceQuyen) {
	                case 1: quyen = Quyen.NHAN_VIEN_KK; break;
	                case 2: quyen = Quyen.XEM_BAO_CAO; break;
	                default: quyen = Quyen.NHAN_VIEN_KK;
	            }
	        }
	        
	        // Tạo và thêm nhân viên
	        NhanVien nv = new NhanVien(maNV, tenNV, chucVu, phongBan, quyen);
	        danhSachNhanVien.add(nv);
	        
	        System.out.println("\n✅ ĐÃ THÊM NHÂN VIÊN THÀNH CÔNG!");
	        System.out.println("Mã NV: " + maNV);
	        System.out.println("Tên NV: " + tenNV);
	        System.out.println("Chức vụ: " + chucVu);
	        System.out.println("Phòng: " + phongBan.getTenPhong() + " (" + phongBan.getMaPhong() + ")");
	        System.out.println("Quyền: " + quyen.getTenQuyen());
	        System.out.println("Trưởng phòng phòng: " + phongBan.getTruongPhong());
	        
	    } catch (Exception e) {
	        System.out.println("❌ Lỗi: " + e.getMessage());
	    }
	}
	    
// ========== HIỂN THỊ DANH SÁCH ==========
    public void hienThiDanhSachPhongBan() {
        System.out.println("\n════════════ DANH SÁCH PHÒNG BAN ════════════");
        
        if (danhSachPhongBan.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (PhongBan pb : danhSachPhongBan) {
            String info = String.format("%s - %s | TP: %s", 
                pb.getMaPhong(), pb.getTenPhong(), pb.getTruongPhong());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        System.out.println("Tổng cộng: " + danhSachPhongBan.size() + " phòng ban");
    }
    
    public void hienThiDanhSachTaiSan() {
        System.out.println("\n════════════ DANH SÁCH TÀI SẢN ════════════");
        
        if (danhSachTaiSan.isEmpty()) {
            System.out.println("Chưa có tài sản nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (TaiSan ts : danhSachTaiSan) {
            String info = String.format("%s: %s x%d - %s", 
                ts.getMaTS(), ts.getTenTS(), ts.getSoLuong(), ts.getTinhTrang());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        
        // Thống kê
        int tongSoLuong = 0;
        for (TaiSan ts : danhSachTaiSan) {
            tongSoLuong += ts.getSoLuong();
        }
        
        System.out.println("\n📊 Thống kê:");
        System.out.println("• Tổng số loại tài sản: " + danhSachTaiSan.size());
        System.out.println("• Tổng số lượng: " + tongSoLuong);
        
        // Phân loại theo tình trạng
        Map<String, Integer> thongKeTT = new HashMap<>();
        for (TaiSan ts : danhSachTaiSan) {
            String tt = ts.getTinhTrang();
            thongKeTT.put(tt, thongKeTT.getOrDefault(tt, 0) + 1);
        }
        
        System.out.println("• Phân loại theo tình trạng:");
        for (Map.Entry<String, Integer> entry : thongKeTT.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " loại");
        }
    }
    
    public void hienThiDanhSachNhanVien() {
        System.out.println("\n════════════ DANH SÁCH NHÂN VIÊN ════════════");
        
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (NhanVien nv : danhSachNhanVien) {
            String info = String.format("%s: %s - %s | %s | %s", 
                nv.getMaNV(), nv.getTenNV(), nv.getChucVu(),
                nv.getPhongBan().getTenPhong(), nv.getQuyen().getTenQuyen());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        
        // Thống kê
        System.out.println("\n📊 Thống kê:");
        System.out.println("• Tổng số nhân viên: " + danhSachNhanVien.size());
        
        Map<Quyen, Integer> thongKeQuyen = new HashMap<>();
        Map<String, Integer> thongKePhong = new HashMap<>();
        
        for (NhanVien nv : danhSachNhanVien) {
            Quyen q = nv.getQuyen();
            thongKeQuyen.put(q, thongKeQuyen.getOrDefault(q, 0) + 1);
            
            String phong = nv.getPhongBan().getTenPhong();
            thongKePhong.put(phong, thongKePhong.getOrDefault(phong, 0) + 1);
        }
        
        System.out.println("• Phân bố theo quyền:");
        for (Map.Entry<Quyen, Integer> entry : thongKeQuyen.entrySet()) {
            System.out.println("  - " + entry.getKey().getTenQuyen() + ": " + entry.getValue() + " người");
        }
        
        System.out.println("• Phân bố theo phòng:");
        for (Map.Entry<String, Integer> entry : thongKePhong.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " người");
        }
    }
    
    // ========== TÌM KIẾM ==========
    private PhongBan timPhongBanTheoMa(String maPhong) {
        for (PhongBan pb : danhSachPhongBan) {
            if (pb.getMaPhong().equalsIgnoreCase(maPhong)) {
                return pb;
            }
        }
        return null;
    }
    
    private TaiSan timTaiSanTheoMa(String maTS) {
        for (TaiSan ts : danhSachTaiSan) {
            if (ts.getMaTS().equalsIgnoreCase(maTS)) {
                return ts;
            }
        }
        return null;
    }
    
    private NhanVien timNhanVienTheoMa(String maNV) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return nv;
            }
        }
        return null;
    }
    
    // ========== CÁC HÀM CŨ (GIỮ NGUYÊN) ==========
    public void nhapPhieuKiemKeTuBanPhim() {
        // Giữ nguyên như cũ
        // ... (code từ trước)
    }
    
    public void xuatBaoCaoTheoMaPhieu() {
        // Giữ nguyên như cũ
        // ... (code từ trước)
    }
    
    public void xuatTatCaBaoCao() {
        // Giữ nguyên như cũ
        // ... (code từ trước)
    }
    
    private boolean kiemTraQuyenKiemKe(NhanVien nv, PhongBan phong) {
        // Giữ nguyên như cũ
        // ... (code từ trước)
        return false;
    }
    
    // ========== CẬP NHẬT MENU ==========
    public void hienThiMenu() {
        String[] menuChinh = {
            "Thêm phiếu kiểm kê mới",
            "Xuất báo cáo theo mã phiếu",
            "Xem tất cả phiếu kiểm kê",
            "--- QUẢN LÝ DANH MỤC ---",
            "Thêm phòng ban mới",
            "Thêm tài sản mới",
            "Thêm nhân viên mới",
            "Xem danh sách phòng ban",
            "Xem danh sách tài sản",
            "Xem danh sách nhân viên",
            "Thoát"
        };
        
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        
        while (running) {
            System.out.println("\n" + "★".repeat(70));
            System.out.println("           HỆ THỐNG QUẢN LÝ KIỂM KÊ TÀI SẢN - THU VIEN SANG");
            System.out.println("★".repeat(70));
            
            // Hiển thị thống kê tổng quan
            System.out.println("📊 THỐNG KÊ HỆ THỐNG:");
            System.out.println("   • Phòng ban: " + danhSachPhongBan.size());
            System.out.println("   • Nhân viên: " + danhSachNhanVien.size());
            System.out.println("   • Tài sản: " + danhSachTaiSan.size() + " loại");
            System.out.println("   • Phiếu kiểm kê: " + danhSachPhieu.size());
            System.out.println("★".repeat(70));
            
            int choice = Test.showMenu("MENU CHÍNH", menuChinh);
            
            switch (choice) {
                case 1:
                    nhapPhieuKiemKeTuBanPhim();
                    break;
                case 2:
                    xuatBaoCaoTheoMaPhieu();
                    break;
                case 3:
                    xuatTatCaBaoCao();
                    break;
                case 4: // Phân cách
                    break;
                case 5:
                    themPhongBan();
                    break;
                case 6:
                    themTaiSan();
                    break;
                case 7:
                    themNhanVien();
                    break;
                case 8:
                    hienThiDanhSachPhongBan();
                    break;
                case 9:
                    hienThiDanhSachTaiSan();
                    break;
                case 10:
                    hienThiDanhSachNhanVien();
                    break;
                case 11:
                    if (Test.confirmAction("Bạn có chắc muốn thoát?")) {
                        running = false;
                        System.out.println("\n👋 Cảm ơn đã sử dụng hệ thống!");
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("⚠ Lựa chọn không hợp lệ!");
            }
            
            if (choice != 0 && running) {
                System.out.println("\n↵ Nhấn Enter để tiếp tục...");
                sc.nextLine();
            }
        }
    }
}