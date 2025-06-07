package lab6;

class UniqueSubstrings {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[] maxLengths = new int[26];
        int currentLength = 1;

        maxLengths[s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);

            if ((curr - prev == 1) || (prev == 'z' && curr == 'a')) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            int index = curr - 'a';
            maxLengths[index] = Math.max(maxLengths[index], currentLength);
        }

        int result = 0;
        for (int length : maxLengths) {
            result += length;
        }

        return result;
    }
}