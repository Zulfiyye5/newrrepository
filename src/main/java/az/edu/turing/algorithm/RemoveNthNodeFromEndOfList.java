package az.edu.turing.algorithm;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.SortedMap;

public class RemoveNthNodeFromEndOfList {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0,head);
        ListNode left = start;
        ListNode right = start;

        for(int i=0;i<=n;i++){
            left= left.next;
        }
        while(left!=null){
            left =left.next;
            right = right.next;
        }

        right.next = right.next.next;

        return  start.next;




    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,9};
        ListNode listNode= new ListNode(arr[0]);
        ListNode top= listNode;
        for(int i=1;i<arr.length;i++){
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
        ListNode res =   removeNthFromEnd(top,2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }


    }
}
