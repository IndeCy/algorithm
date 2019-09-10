package StackDemo;

import Node.SLNode;

public class StackSLinked implements Stack {

    private SLNode top;

    private int size;

    public StackSLinked(){
        top = null;
        size = 0;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object e) {
        SLNode q = new SLNode(e,top);
        top = q;
        size++;
    }

    @Override
    public Object pop(){
        if(size == 0){
            throw new RuntimeException("堆栈为空！");
        }
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    @Override
    public Object peek() {
        if(size == 0){
            throw new RuntimeException("堆栈为空！");
        }
        return top.getData();
    }
}
