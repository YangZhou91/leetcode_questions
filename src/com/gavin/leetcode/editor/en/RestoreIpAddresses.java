package com.gavin.leetcode.editor.en;
/*2023-08-03 10:29:06*/

import java.util.ArrayList;
import java.util.List;

/**
A valid IP address consists of exactly four integers separated by single dots. 
Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 

 
 For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.2
55.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
 

 Given a string s containing only digits, return all possible valid IP 
addresses that can be formed by inserting dots into s. You are not allowed to reorder or 
remove any digits in s. You may return the valid IP addresses in any order. 

 
 Example 1: 

 
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
 

 Example 2: 

 
Input: s = "0000"
Output: ["0.0.0.0"]
 

 Example 3: 

 
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

 
 Constraints: 

 
 1 <= s.length <= 20 
 s consists of digits only. 
 

 Related Topics String Backtracking 👍 4826 👎 757

*/

public class RestoreIpAddresses{
    public static void main(String[] args){
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        // Backtracking
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s)
    {
        if (k == 4 || s.length() == 0)
        {
            if (k == 4 && s.length() == 0)
            {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0)
                {
                    part = "." + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}