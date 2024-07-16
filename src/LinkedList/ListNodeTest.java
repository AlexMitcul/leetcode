package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void serializeEmptyList() {
        ListNode head = null;

        String result = ListNode.serialize(head);
        assertEquals("", result);
    }

    @Test
    void serializeOneElement() {
        ListNode head = new ListNode(1);

        String result = ListNode.serialize(head);
        assertEquals("1", result);
    }

    @Test
    void serializeTwoElements() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        String result = ListNode.serialize(head);
        assertEquals("1,2", result);
    }

    @Test
    void serializeHundredElements() {
        ListNode head = new ListNode(1);
        ListNode curr = head;

        for (int i = 2; i <= 100; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        String result = ListNode.serialize(head);
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= 100; i++) {
            sb.append(",").append(i);
        }

        assertEquals(sb.toString(), result);
    }


    @Test
    void deserializeEmptyList() {
        assertNull(ListNode.deserialize(""));
        assertNull(ListNode.deserialize(null));
    }

    @Test
    void deserializeOneElement() {
        ListNode head = ListNode.deserialize("1");

        assertEquals(1, head.val);
        assertNull(head.next);
    }

    @Test
    void deserializeTwoElements() {
        ListNode head = ListNode.deserialize("1,2");

        assertEquals(1, head.val);
        assertNotNull(head.next);
        assertEquals(2, head.next.val);
        assertNull(head.next.next);
    }

    @Test
    void deserializeHundredElements() {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= 100; i++) {
            sb.append(",").append(i);
        }
        ListNode head = ListNode.deserialize(sb.toString());

        assertEquals(1, head.val);
        assertNotNull(head.next);
        for (int i = 1; i < 100; i++) {
            head = head.next;
        }
        assertEquals(100, head.val);
        assertNull(head.next);
    }
}