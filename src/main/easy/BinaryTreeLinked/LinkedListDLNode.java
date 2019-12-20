package main.BinaryTreeLinked;

import main.List.Iterator;
import main.List.LinkedList;
import main.List.LinkedListIterator;
import easy.Node.DLNode;
import easy.Node.Node;


public class LinkedListDLNode implements LinkedList {
    private int size;
    private DLNode head;
    private DLNode tail;
    public LinkedListDLNode(){
        size = 0;
        head = new DLNode();
        tail = new DLNode();
        head.setNext(tail);
        tail.setPre(head);
    }
    private DLNode checkPosition(Node p) throws Exception{
        if(p==null){
            throw new Exception("错误：p为空");
        }
        if(p==head){
            throw new Exception("错误：p指向头节点，非法");
        }
        if(p==tail){
            throw new Exception("错误：p指向尾节点，非法");
        }
        DLNode node = (DLNode)p;
        return node;
    }
    @Override
    public int getSize(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public Node first(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("错误：链表为空");
        }
        return head.getNext();
    }
    @Override
    public Node last() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("错误：链表为空");
        }
        return tail.getPre();
    }
    @Override
    public Node getNext(Node p)throws Exception{
        DLNode node = checkPosition(p);
        node = node.getNext();
        if (node==tail) {
            throw new IndexOutOfBoundsException("错误：已经是链接表尾端。");
        }
        return node;
    }
    @Override
    public Node getPre(Node p) throws Exception {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if (node==head) {
            throw new IndexOutOfBoundsException("错误：已经是链接表前端。");
        }
        return node;
    }
    @Override
    public Node insertFirst(Object e){
        DLNode node = new DLNode(e,head,head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size++;
        return node;
    }
    @Override
    public Node insertLast(Object e){
        DLNode node = new DLNode(e,tail.getPre(),tail);
        tail.getPre().setNext(node);
        tail.setPre(node);
        size++;
        return node;
    }
    @Override
    public Node insertAfter(Node p, Object e) throws Exception{
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e,node,node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }
    @Override
    public Node insertBefore(Node p, Object e) throws Exception{
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e,node.getPre(),node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        size++;
        return newNode;
    }
    @Override
    public Object remove(Node p) throws Exception{
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
        return obj;
    }
    @Override
    public Object removeFirst() throws Exception{
        return remove(head.getNext());
    }
    @Override
    public Object removeLast() throws Exception{
        return remove(tail.getPre());
    }
    @Override
    public Object replace(Node p, Object obj) throws Exception{
        Object object = p.getData();
        p.setData(obj);
        return object;
    }
    @Override
    public Iterator elements(){
        return new LinkedListIterator(this);
    }


}
