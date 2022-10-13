/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* middleNode(struct ListNode* head){
	int	len = 0;
	struct ListNode* p = head;

	while (p)
	{
		len += 1;
		p = p->next;
	}
	len = len / 2;
    p = head;
	while (len > 0)
	{
		p = p->next;
		len -= 1;
	}
	return (p);
}
