package playground.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-23
 */
@Slf4j
public class BasicReverseList {
    @AllArgsConstructor
    @Data
    static class Node {
         private int value;
         private Node next;
    }

    static Node reverseRecursive(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    static Node reverse(Node head) {
        Node currentNode = head.getNext();  // the node right after the head

        Node newHead = new Node(-10, null);

        Node toAttachNode = new Node(-20, null);
        Node tmpNode;

        while (true) {
            tmpNode = currentNode.getNext();
            currentNode.setNext(toAttachNode);
            toAttachNode = currentNode;

            // tmpNode reach the end
            if (tmpNode.getNext() == null) {
                break;
            }
            currentNode = tmpNode;
        }

        // attach the head to the new list
        newHead.setNext(currentNode);
        return newHead;
    }

    static Node findTailNode(Node head) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    static void printList(Node head) {
        if (head == null) {
            return;
        }

        Node currentNode = head;
        log.info("HEAD: {}", currentNode.getValue());
        currentNode = head.getNext();
        while (currentNode.getNext() != null) {
            log.info("{}", currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        log.info("TAIL: {}", currentNode.getValue());
    }

    public static void main(String[] args) {
        Node tail = new Node(-2, null);
        Node node1 = new Node(99, tail);
        Node node2 = new Node(98, node1);
        Node node3 = new Node(97, node2);
        Node node4 = new Node(96, node3);
        Node head = new Node(-1, node4);
        printList(head);

        log.info("\n\nthe reversed list: \n");

//        Node newHead = reverse(head);
//        printList(newHead);

        Node newHead2 = reverseRecursive(head);
        printList(newHead2);
    }
}
