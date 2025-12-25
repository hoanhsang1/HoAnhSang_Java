package ThuVienSang;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println(item.toString()); 
        }
    }
    
    // ========== CÁC HÀM MỚI ==========
    
    // 1. Sắp xếp List giảm dần
    public static <T extends Comparable<T>> void sapXepGiamDan(List<T> list) {
        Collections.sort(list, Collections.reverseOrder());
    }
    
    // 2. Tính tổng các phần tử trong mảng số nguyên
    public static int sumArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }
    
    // 3. Tính trung bình cộng của mảng số nguyên
    public static double averageArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return (double) sumArray(arr) / arr.length;
    }
    
    // 4. Tìm kiếm phần tử trong mảng (trả về chỉ số, -1 nếu không tìm thấy)
    public static int findIndex(int[] arr, int value) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    // 5. Đảo ngược mảng
    public static void reverseArray(int[] arr) {
        if (arr == null) return;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    // 6. Sao chép mảng
    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        return Arrays.copyOf(arr, arr.length);
    }
    
    // 7. Đếm số phần tử thỏa mãn điều kiện
    public static int countIf(int[] arr, Condition condition) {
        if (arr == null) return 0;
        int count = 0;
        for (int x : arr) {
            if (condition.test(x)) {
                count++;
            }
        }
        return count;
    }
    
    // 8. Lọc các phần tử thỏa mãn điều kiện
    public static List<Integer> filter(int[] arr, Condition condition) {
        List<Integer> result = new ArrayList<>();
        if (arr != null) {
            for (int x : arr) {
                if (condition.test(x)) {
                    result.add(x);
                }
            }
        }
        return result;
    }
    
    // 9. Tìm phần tử lớn thứ 2 trong mảng
    public static int findSecondMax(int[] arr) {
        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;
        
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for (int x : arr) {
            if (x > max) {
                secondMax = max;
                max = x;
            } else if (x > secondMax && x < max) {
                secondMax = x;
            }
        }
        return secondMax;
    }
    
    // 10. Kiểm tra mảng có đối xứng không
    public static boolean isSymmetric(int[] arr) {
        if (arr == null) return false;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // 11. Hiển thị mảng dạng bảng
    public static void displayAsTable(List<?> list, int columns) {
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-20s", list.get(i));
            if ((i + 1) % columns == 0) {
                System.out.println();
            }
        }
        if (list.size() % columns != 0) {
            System.out.println();
        }
    }
    
    // 12. Chuyển List sang mảng
    public static <T> T[] listToArray(List<T> list, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
        return list.toArray(array);
    }
    
    // 13. Tìm các phần tử trùng lặp trong mảng
    public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        if (arr == null || arr.length < 2) return duplicates;
        
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1] && !duplicates.contains(arr[i])) {
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }
    
    // 14. Xóa phần tử tại vị trí index khỏi List
    public static <T> boolean removeAtIndex(List<T> list, int index) {
        if (list == null || index < 0 || index >= list.size()) {
            return false;
        }
        list.remove(index);
        return true;
    }
    
    // 15. Gộp 2 mảng
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;
        
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }
    
    // Interface điều kiện (functional interface)
    @FunctionalInterface
    public interface Condition {
        boolean test(int value);
    }
}