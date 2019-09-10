package Array;

public class QueueArray implements Queue{

    /**
     * 队列的默认大小
     */
    private static final int CAP=7;

    /**
     * 对象数组，队列最多存储a.length-1个对象
     */
    Object[] elements;

    /**
     * 数组的大小
     */
    private int capacity;

    /**
     * 队首下标
     */
    int front;
    /**
     * 队尾下标
     */
    int rear;

    public QueueArray() {
        this(CAP);
    }

    public QueueArray(int cap) {
        capacity = cap + 1;
        elements = new Object[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * 将一个对象追加到队列尾部
     */
    @Override
    public void enqueue(Object e) {
        if(getSize()==capacity-1){

        }
    }

    private void expandSpace(){
        Object[] a = new Object[elements.length*2];
        int i = front;int j = 0;
        while (i!=rear){
            a[j++] = elements[i];
            i = (i+1)%capacity;
        }
        elements = a;
        capacity = elements.length;
        front = 0;
        rear = j;
    }

    /**
     * 队列头部的第一个对象出队
     *
     * @return 出队的对象，队列空时返回null
     */
    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new RuntimeException("错误：队列为空！");
        }
        Object obj = elements[front];
        elements[front] = null;
        front = (front+1)%capacity;
        return obj;

    }

    /**
     * 获取队列元素数量
     * @return
     */
    @Override
    public int getSize() {
        return (rear-front+capacity)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new RuntimeException("错误：队列为空！");
        }
        return elements[front];
    }
}
