class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr1) s.add(i);
        Set<Integer> s2 = new HashSet<>();
        for (int i : arr2) if (s.contains(i)) s2.add(i);
        List<Integer> res = new ArrayList<>();
        for (int i : arr3) if (s2.contains(i)) res.add(i);
        return res;
    }
}