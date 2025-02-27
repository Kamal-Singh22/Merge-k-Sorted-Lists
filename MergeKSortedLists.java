import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // PriorityQueue to hold nodes. The node with the smallest value will be at the head.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each non-empty list to the minHeap.
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        // Dummy head to build the merged list.
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Merge nodes using the heap.
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        
        return dummy.next;
    }

    // Helper method to print the linked list.
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Create sample linked lists:
        // List 1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        // List 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // List 3: 2 -> 6
        ListNode l3 = new ListNode(2, new ListNode(6));
        
        ListNode[] lists = new ListNode[] { l1, l2, l3 };
        
        ListNode mergedHead = solution.mergeKLists(lists);
        System.out.print("Merged Sorted List: ");
        printList(mergedHead);
    }
}
