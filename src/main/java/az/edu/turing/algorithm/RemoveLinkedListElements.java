package az.edu.turing.algorithm;

public class RemoveLinkedListElements {
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
    public static ListNode removeElements(ListNode head, int val) {
        ListNode start =new ListNode(0);
        ListNode temp = start;

        while(head!=null){
            if(head.val!=val){
                temp.next = head;
                temp = temp.next;

            }

            head=head.next;

        }
        temp.next = null;
        return  start.next;


    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode listNode= new ListNode(arr[0]);
        ListNode head= listNode;
        for(int i=1;i<arr.length;i++){
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
       ListNode res = removeElements(head,6);
        while(res!=null){
            System.out.println(res.val);
            res= res.next;
        }

    }

}
