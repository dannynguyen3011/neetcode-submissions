class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // Bước 1: Đếm tần suất từng số
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // freq = {1→1, 2→2, 3→3}

        // Bước 2: Lấy tất cả số ra, sort theo tần suất giảm dần
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> freq.get(b) - freq.get(a));
        // keys = [3, 2, 1]  (sort theo freq giảm dần)

        // Bước 3: Lấy k phần tử đầu
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }
        return result;
    
    }
}
