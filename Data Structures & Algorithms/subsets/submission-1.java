class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (int num: nums) {
            int size = allSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(allSubsets.get(i));
                subset.add(num);
                allSubsets.add(subset);
            }
        }
        
        return allSubsets;
    }
}
