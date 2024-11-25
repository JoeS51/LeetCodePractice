class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] range = new int[2];
        range[0] = Integer.MAX_VALUE;
        range[1] = Integer.MAX_VALUE;
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pqMin = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pqMax = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (int i = 0; i < nums.size(); i++) {
            Pair<Integer, Pair<Integer, Integer>> element = new Pair<>(nums.get(i).get(0), new Pair<>(i, 0));
            pqMin.add(element);
            pqMax.add(element);
        }
        
        boolean notLastElement = true;
        while (notLastElement) {
            Pair<Integer, Pair<Integer, Integer>> firstElement = pqMin.poll();
            Pair<Integer, Pair<Integer, Integer>> lastElement = pqMax.poll();
            int a = firstElement.getKey();
            int b = lastElement.getKey();
            if (b - a < range[1] - range[0] || range[1] == Integer.MAX_VALUE) {
                range[0] = a;
                range[1] = b;
            }
            int listIndex = firstElement.getValue().getValue();
            int numsIndex = firstElement.getValue().getKey();
            
            if (listIndex == nums.get(numsIndex).size() - 1) break;
            System.out.println(numsIndex + \ \ + listIndex);
            int newValue = nums.get(numsIndex).get(listIndex+1);
            Pair<Integer, Pair<Integer, Integer>> newElement = new Pair<>(newValue, new Pair<>(numsIndex, listIndex+1));
            pqMax.add(lastElement);
            pqMax.add(newElement);
            pqMin.add(newElement);
        }

        return range;
    }
}