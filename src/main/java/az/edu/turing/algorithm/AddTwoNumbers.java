package az.edu.turing.algorithm;

public class AddTwoNumbers {
  public  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode temp = start;
        int extra=0;
        while (l1!=null || l2!=null ){
            int sum=0;
            if(l1 != null){
                sum+=l1.val;
            }
            if(l2 != null){
                sum+=l2.val;
            }
            sum+=extra;
            extra =sum/10;
            temp.next = new ListNode(sum%10);
            temp=temp.next;


            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }




        }

        if(l1==null && l2 ==null && extra==1){
           temp.next =new ListNode(1);
        }
        return  start.next;


    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode();


        ListNode result = addTwoNumbers(listNode1, listNode2);


        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
