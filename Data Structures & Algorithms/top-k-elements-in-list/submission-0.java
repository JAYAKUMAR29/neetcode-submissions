
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>();
        for (int key : countMap.keySet()) {
            uniqueNums.add(key);
        }

        
        int[] keys = new int[uniqueNums.size()];
        for (int i = 0; i < uniqueNums.size(); i++) {
            keys[i] = uniqueNums.get(i);
        }

  
        Integer[] boxedKeys = new Integer[keys.length];
        for (int i = 0; i < keys.length; i++) {
            boxedKeys[i] = keys[i];
        }
        
        Arrays.sort(boxedKeys, (a, b) -> countMap.get(b) - countMap.get(a));

        int[] result = new int[k];
        int left = 0;
        int right = k - 1;

        while (left <= right && left < boxedKeys.length) {
            result[left] = boxedKeys[left];
            if (left != right && right < boxedKeys.length) {
                result[right] = boxedKeys[right];
            }
            left++;
            right--;
        }

        return result;
    }
}