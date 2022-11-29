package algorithm.linkedlist;

import java.util.PriorityQueue;

public class 合并K个升序链表 {

}

class Solution {
    public ListNode mergeKLists(ListNode[] headNodeList) {
        if (headNodeList == null || headNodeList.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> listNodes = new PriorityQueue<>((e1, e2) -> (e1.val - e2.val));
        for (ListNode listNode : headNodeList) {
            if (listNode != null) {
                listNodes.add(listNode);
            }
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (!listNodes.isEmpty()) {
            ListNode poll = listNodes.poll();
            p.next = poll;

            if (poll.next != null) {
                listNodes.add(poll.next);
            }

            p = p.next;
        }

        return dummy.next;
    }
}

// Definition for singly-linked list.
class ListNode {
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
