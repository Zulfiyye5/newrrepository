package az.edu.turing.module03.algorithm;


import java.util.List;

public class MergeTwoLists {
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


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode start = new ListNode();
        ListNode temp = start;
        while(list1!=null && list2!=null){
            if(list1.val< list2.val){
                temp.next = list1;
                list1 = list1.next;

            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }

            temp =temp.next;
        }
        if(list1!=null){
            temp.next =list1;
        }

        if(list2!=null){
            temp.next =list2;
        }

        return  start.next;


    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);

        list1.next = new ListNode(2);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(9);

        ListNode merged = mergeTwoLists(list1,list2);

        while(merged!=null){
            System.out.println(merged.val);
            merged = merged.next;
        }



    }
}
