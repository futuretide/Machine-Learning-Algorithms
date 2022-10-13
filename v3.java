class Solution {
    private Set<List<Integer>> result;
    
    private void swap(int[] nums, int x, int y) {
        if(x == y) return;
        int swap = nums[x];
        nums[x] = nums[y];
        nums[y] = swap;
    }
    
    private void backtrack(int[] nums, int level) {
        if(level == nums.length) {
            List<Integer> res = new ArrayList<>(nums.length);
            for(int i : nums) {
                res.add(i);
            }
            result.add(res);
            return;
        }
        
        for(int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            backtrack(nums, level+1);
            swap(nums, level, i);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new HashSet<>();
        backtrack(nums, 0);
        return new ArrayList(result);
    }
}
        
        
