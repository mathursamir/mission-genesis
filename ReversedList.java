    import java.util.*;

    class ReversedList {
        public static LinkedList reverseLinkedList(LinkedList head) {
            // Write your code here.
            LinkedList prev=null;

            while (head != null){
                LinkedList temp = head.next;
                head.next = prev;
                prev=head;
                head= temp;

            }
            return prev;
        }

        static class LinkedList {
            int value;
            LinkedList next = null;

            public LinkedList(int value) {
                this.value = value;
            }
        }


    }


