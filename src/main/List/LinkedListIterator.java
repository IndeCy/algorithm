package main.List;


import Node.Node;



public class LinkedListIterator implements Iterator {
    private LinkedList list;
    private Node current;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
        if(list.isEmpty()){
            current = null;
        }
        else {
            current = list.first();
        }
    }
    @Override
    public void first() throws Exception{
        if(list.isEmpty()){
            current = null;
        }
        else {
            current = list.first();
        }
    }

    @Override
    public void next() throws Exception{
        if (isDone())
            throw new Exception("错误：已经没有元素。");
        if (current==list.last()) current = null;
        else current = list.getNext(current);
    }

    @Override
    public boolean isDone() {
        return current==null;
    }

    @Override
    public Object currentItem() {
        if (isDone())
            throw new IndexOutOfBoundsException("错误：已经没有元素。");
        return current.getData();
    }
}
