class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();
        if(s1.length() != t1.length())
        {
            return false;
        }

        int arr[] = new int[26];

        for(int i=0;i<s.length();i++)
        {
            arr[s1.charAt(i) - 'a']++;
            arr[t1.charAt(i) - 'a']--;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

}
