package bai4;

public class XuLyBac2 {
    
    // Giải phương trình với hệ số cho trước
    public static void giaiPhuongTrinh(double a, double b, double c) {
        Bac2 pt = new Bac2(a, b, c);
        pt.giaiPhuongTrinh();
    }
    
    // Kiểm tra phương trình có phải bậc 2 không
    public static boolean laPhuongTrinhBac2(double a) {
        return a != 0;
    }
}
