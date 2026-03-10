package stream;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // Tạo list 1000 số nguyên ngẫu nhiên từ -200 đến 200
        List<Integer> list = new Random()
                .ints(1000, -200, 201)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Danh sach ban dau:");
        System.out.println(list);

        // 1. Lọc và in các số nguyên dương
        System.out.println("\nSo nguyen duong:");
        list.stream()
                .filter(n -> n > 0)
                .forEach(System.out::println);

        // 2. Loại bỏ các số trùng lặp
        List<Integer> uniqueList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nDanh sach khong trung lap:");
        System.out.println(uniqueList);

        // 3. Sắp xếp từ lớn đến bé
        List<Integer> sortedDesc = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("\nSap xep tu lon den be:");
        System.out.println(sortedDesc);

        // 4. Tìm min, max
        Optional<Integer> min = list.stream().min(Integer::compare);
        Optional<Integer> max = list.stream().max(Integer::compare);

        System.out.println("\nMin: " + min.orElse(null));
        System.out.println("Max: " + max.orElse(null));

        // 5. Tính tổng
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("\nTong: " + sum);

        // 6. Kiểm tra số n có tồn tại không
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap so n: ");
        int n = sc.nextInt();

        boolean exists = list.stream()
                .anyMatch(x -> x == n);

        if (exists) {
            System.out.println("So " + n + " ton tai trong danh sach");
        } else {
            System.out.println("So " + n + " khong ton tai trong danh sach");
        }

        // 7. Chuyển các số âm thành số đối của nó
        List<Integer> convertNegative = list.stream()
                .map(x -> x < 0 ? -x : x)
                .collect(Collectors.toList());

        System.out.println("\nDanh sach sau khi chuyen so am thanh so doi:");
        System.out.println(convertNegative);
    }
}