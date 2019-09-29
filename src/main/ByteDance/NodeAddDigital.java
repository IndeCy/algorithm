package main.ByteDance;

public class NodeAddDigital {

    class Node{
        private int val;
        Node(int val){
            this.val = val;
        }
        private Node next;

    }

    public static void main(String[] args) {

    }

    public static Node solution(Node node){
        if(node.next != null){
            return solution(node.next);
        }
        return node;
    }

    public static Node solution(Node head1,Node head2){
        if(solution(head1).val + solution(head2).val >= 10){
//            return new Node()
        }
        return null;
    }
}
