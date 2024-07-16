package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
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

    /**
     * Serialize the linked list of nodes into a String
     * @param head is a reference to the first node in the list
     * @return String represents the serialized list in following format: "1,2,3,42,81"
     */
    public static String serialize(ListNode head) {
        if (head == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val).append(",");
            head = head.next;
        }

        // remove the trailing comma `,`
        result.setLength(result.length() - 1);

        return result.toString();
    }

    /**
     * Deserialize it to the linked list of nodes
     * @param data is a String represents the serialized list in following format: "1,2,3,42,81"
     * @return reference to the head node (1 in this case)
     */
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        for (var value : data.split(",")) {
            curr.next = new ListNode(Integer.parseInt(value));
            curr = curr.next;
        }
        curr = head.next;
        head.next = null;
        return curr;
    }
}
