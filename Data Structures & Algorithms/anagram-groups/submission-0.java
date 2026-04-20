class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         // HashMap: key = chuỗi đã sort, value = danh sách các từ cùng nhóm
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Bước 1: Tạo "chữ ký" cho từ này
            // "cat" → ['c','a','t'] → sort → ['a','c','t'] → "act"
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Bước 2: Nếu key chưa có trong map → tạo list mới
            // Nếu key đã có → thêm từ vào list có sẵn
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Bước 3: Trả về tất cả các nhóm (values của map)
        return new ArrayList<>(map.values());
    
    }
}
