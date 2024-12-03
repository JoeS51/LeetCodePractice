class Solution {
    public String customSortString(String order, String s) {
        Character[] newS = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            newS[i] = s.charAt(i);
        }
        Arrays.sort(newS, (a, b) -> order.indexOf(a) - order.indexOf(b));
        StringBuilder result = new StringBuilder();
        for (char c : newS) {
            result.append(c);
        }

        return result.toString();
    }
}