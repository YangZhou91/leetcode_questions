package com.gavin.leetcode.editor.en;
/*2023-07-25 14:21:40*/
/**
Given head, the head of a linked list, determine if the linked list has a cycle 
in it. 

 There is a cycle in a linked list if there is some node in the list that can 
be reached again by continuously following the next pointer. Internally, pos is 
used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter. 

 Return true if there is a cycle in the linked list. Otherwise, return false. 

 
 Example 1: 
 
 
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to 
the 1st node (0-indexed).
 

 Example 2: 
 
 
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to 
the 0th node.
 

 Example 3: 
 
 
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

 
 Constraints: 

 
 The number of the nodes in the list is in the range [0, 10⁴]. 
 -10⁵ <= Node.val <= 10⁵ 
 pos is -1 or a valid index in the linked-list. 
 

 
 Follow up: Can you solve it using O(1) (i.e. constant) memory? 

 Related Topics Hash Table Linked List Two Pointers 👍 12967 👎 1070

*/

public class LinkedListCycle{
    public static void main(String[] args){
        Solution solution = new LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
        {
            return false;
        }
        ListNode listNode1 = head;
        ListNode listNode2 = head.next;
        while(listNode1 != null && listNode2 != null && listNode2.next != null){
            if (listNode1 == listNode2){
                return true;
            }
            listNode1 = listNode1.next;
            // move twice
            listNode2 = listNode2.next.next;

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}