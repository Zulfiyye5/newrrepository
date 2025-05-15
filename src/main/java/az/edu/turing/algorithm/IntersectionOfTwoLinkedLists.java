package az.edu.turing.algorithm;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoLinkedLists {
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
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //4 1 8 4 5
        //5 6 1 8 4 5

        //4 1 8 4 5
        //6 1 8 4 5

        int lenA = length(headA);
        int lenB = length(headB);

        if(lenA>lenB){
            while(lenA-lenB!=0){
                lenA--;
                headA = headA.next;

            }
        }
        else{
            while(lenB-lenA!=0){
                lenB--;
                headB = headB.next;

            }
        }

      while(headA!=headB){

          headA=headA.next;
          headB = headB.next;
      }
        return headB;
    }


    public static  int length(ListNode head){
        int length=0;
        while(head!=null){
            length+=1;
            head= head.next;
        }
        return  length;
    }

    public static void main(String[] args) {
        ListNode listA1 = new ListNode(4);
        ListNode listA2 = new ListNode(1);

        ListNode listC1 = new ListNode(8);
        ListNode listC2 = new ListNode(4);
        ListNode listC3 = new ListNode(5);

        ListNode listB1 = new ListNode(5);
        ListNode listB2 = new ListNode(6);
        ListNode listB3 = new ListNode(1);


        listA1.next = listA2;
        listA2.next = listC1;

        listB1.next = listB2;
        listB2.next =listB3;
        listB3.next =listC1;

        listC1.next = listC2;
        listC2.next =listC3;

        System.out.println(getIntersectionNode(listA1,listB1).val);


    }
}
