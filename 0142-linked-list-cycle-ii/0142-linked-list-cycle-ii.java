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
class Solution{
    public ListNode detectCycle(ListNode head){
        ListNode slowpointer=head;
        ListNode fastpointer=head;
        while(fastpointer!=null&&fastpointer.next!=null){
            slowpointer=slowpointer.next;
            fastpointer=fastpointer.next.next;
            if(slowpointer==fastpointer){
                ListNode sp=head;
                while(slowpointer!=sp){
                    slowpointer=slowpointer.next;
                    sp=sp.next;
                }
                return sp;
            }
        }
        return null;
    }
}