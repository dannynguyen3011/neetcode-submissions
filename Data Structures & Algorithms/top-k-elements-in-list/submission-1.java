class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // Bước 1: Đếm tần suất từng số
        // Bước 1: Đếm tần suất
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Bước 2: Dùng min-heap kích thước k
        // So sánh theo tần suất: phần tử có freq THẤP nhất nằm trên đỉnh
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)  // min-heap theo freq
        );

        // Bước 3: Duyệt từng số, đẩy vào heap
        for (int num : freq.keySet()) {
            heap.offer(num);

            // Nếu heap vượt quá k phần tử → bỏ phần tử có freq THẤP nhất
            if (heap.size() > k) {
                heap.poll(); // xóa đỉnh (freq nhỏ nhất)
            }
        }

        // Bước 4: Lấy kết quả từ heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
