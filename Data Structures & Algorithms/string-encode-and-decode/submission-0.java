class Solution {

    // ENCODE: List<String> → String
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            // Thêm: "độ_dài # nội_dung"
            // Ví dụ: "Hello" → "5#Hello"
            sb.append(s.length()); // độ dài
            sb.append('#');        // dấu phân cách
            sb.append(s);          // nội dung thật
        }

        return sb.toString();
    }

    // DECODE: String → List<String>
   public List<String> decode(String s) {
    List<String> result = new ArrayList<>();

    int i = 0;  // i luôn trỏ vào ĐẦU của một "gói" mới
                // Gói = [số độ dài] + '#' + [nội dung]

    while (i < s.length()) {

        // ── GIAI ĐOẠN 1: Tìm dấu '#' ──────────────────────
        // j bắt đầu tại i, tiến dần cho đến khi gặp '#'
        // Mục đích: xác định số độ dài nằm ở đâu
        int j = i;
        while (s.charAt(j) != '#') {
            j++;
        }
        // Sau vòng này: s[i..j-1] = chuỗi số, s[j] = '#'

        // ── GIAI ĐOẠN 2: Đọc số độ dài ────────────────────
        // substring(i, j) lấy từ index i đến j-1 (không bao gồm j)
        // Ví dụ: s = "12#abcdefghijkl..."
        //        i=0, j=2  →  substring(0,2) = "12"  →  len = 12
        int len = Integer.parseInt(s.substring(i, j));

        // ── GIAI ĐOẠN 3: Đọc nội dung ─────────────────────
        // j+1 : vị trí ký tự đầu tiên của nội dung (bỏ qua '#')
        // j+1+len : vị trí KẾT THÚC (không bao gồm)
        String word = s.substring(j + 1, j + 1 + len);
        result.add(word);

        // ── GIAI ĐOẠN 4: Nhảy con trỏ ─────────────────────
        // i nhảy tới đầu "gói" tiếp theo
        // = vị trí '#' + 1 (bỏ '#') + len (bỏ nội dung)
        i = j + 1 + len;
    }

    return result;
}
}
