# Merge-k-Sorted-Lists
Given an array of k sorted linked lists, merge them into one sorted linked list and return it.
Explanation:
PriorityQueue (Min Heap):

We use a priority queue to always retrieve the node with the smallest value among the current nodes of the lists.
Initialization:

Insert the head of each non-null linked list into the priority queue.
Merging Process:

Repeatedly extract the smallest node from the queue.
Append it to the merged linked list.
If the extracted node has a next node, insert that next node into the queue.
Result:

The merged list is built starting from a dummy node, and finally, the merged sorted linked list is returned.
