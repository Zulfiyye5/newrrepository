package az.edu.turing.algorithm;

public class PalindromeLinkedList234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static int length(ListNode head){
        int length= 0;
        while(head!=null){
            length++;
            head= head.next;
        }
        return length;
    }
    public static boolean isPalindrome(ListNode head) {
        int length = length(head);
        int half = length / 2;
        int index = 0;



        ListNode secondHalfHead = new ListNode(0);
        ListNode secondHalf = secondHalfHead;

        ListNode temp = head;

        while (index < half && temp != null) {
            index++;
            temp = temp.next;
        }

        while (temp != null) {

            secondHalf.next = new ListNode(temp.val);
            secondHalf = secondHalf.next;
            temp = temp.next;
        }
        if(length%2==1){
            secondHalfHead = secondHalfHead.next.next;
        }
        else{
            secondHalfHead = secondHalfHead.next;
        }
       ListNode reverse =reverseList(secondHalfHead);
        int x=0;
        while(x<half){
            if(head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse =reverse.next;
            x++;
        }
        return  true;



    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        ListNode listNode= new ListNode(arr[0]);
        ListNode head= listNode;
        for(int i=1;i<arr.length;i++){
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
        System.out.println(isPalindrome(head));
    }


}
