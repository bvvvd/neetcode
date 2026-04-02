class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        backtrack(1, n, k, new LinkedList<>(), allCombinations);
        return allCombinations;
    }

    private void backtrack(int start, int end, int size, LinkedList<Integer> combination, List<List<Integer>> allCombinations) {
        if (combination.size() == size) {
            allCombinations.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i <= end; i++) {
                combination.add(i);
                backtrack(i + 1, end, size, combination, allCombinations);
                combination.removeLast();
            }
        }
    }
}