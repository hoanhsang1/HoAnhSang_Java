package TaomoiTV;

import java.util.List;
import java.util.Collections;

public class Mang {
    
    // Tìm phần tử lớn nhất trong mảng số nguyên
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
        int max = arr[0];
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }
    
    // Tìm phần tử nhỏ nhất trong mảng số nguyên
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MAX_VALUE;
        int min = arr[0];
        for (int x : arr) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
    
    // Sắp xếp một List các đối tượng tăng dần (Yêu cầu T phải implements Comparable)
    public static <T extends Comparable<T>> void sapXepTangDan(List<T> list) {
        Collections.sort(list);
    }
    
    // Hiển thị tất cả phần tử của List
    public static <T> void hienThiDanhSach(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (T item : list) {
            // Sử dụng toString() của đối tượng
            System.out.println(item.toString()); 
        }
    }
}