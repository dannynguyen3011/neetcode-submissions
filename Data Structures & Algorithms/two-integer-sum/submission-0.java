class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap lưu: số đã thấy → chỉ số của nó
        // Key   = giá trị phần tử
        // Value = vị trí (index) của phần tử đó
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Tính số cần tìm (complement)
            int complement = target - nums[i];

            // Kiểm tra xem complement đã xuất hiện trước đó chưa
            if (map.containsKey(complement)) {
                // Tìm thấy! Trả về index của complement và index hiện tại
                return new int[]{map.get(complement), i};
            }

            // Chưa tìm thấy → lưu số hiện tại vào map để dùng sau
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
