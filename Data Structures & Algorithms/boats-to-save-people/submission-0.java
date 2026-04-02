class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        // [1,2,2,3,3] 3
        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) { 
            if (left == right) {
                return boats + 1;
            }
                // 0, 3
            if (people[left] + people[right] <= limit) { // 1 + 3 > 3 -> false
                left++;
            }
            right--;                                    // 2
            boats++;                                    // 2
        }

        return boats;
    }
}