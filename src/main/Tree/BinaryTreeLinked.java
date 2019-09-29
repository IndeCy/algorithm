package Tree;

import main.Array.QueueArray;
import main.BinaryTreeLinked.LinkedListDLNode;
import main.List.Iterator;
import main.List.LinkedList;
import Node.BinTreeNode;
import StackDemo.Stack;
import StackDemo.StackSLinked;
import Strategy.DefaultStrategy;
import Strategy.Strategy;

import main.Array.Queue;

public class BinaryTreeLinked implements BinTree {
    protected BinTreeNode root;
    protected Strategy strategy;
    public BinaryTreeLinked(BinTreeNode root,Strategy strategy){
        this.root = root;
        this.strategy = strategy;
    }
    public BinaryTreeLinked(BinTreeNode root){
        this(root,new DefaultStrategy());
    }
    public BinaryTreeLinked(){
        this(null);
    }
    @Override
    public int getSize() {
        return root==null?0:root.getSize();
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public BinTreeNode getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return isEmpty()?-1:root.getHeight();
    }

    @Override
    public BinTreeNode find(Object e) {
        return searchE(root,e);
    }

    private BinTreeNode searchE(BinTreeNode rt,Object e){
        if(rt == null) {return null;}
        if(strategy.equal(rt.getData(),e)){
            return rt;
        }
        BinTreeNode v= searchE(rt.getlChild(),e);
        if(v==null){
            v= searchE(rt.getrChild(),e);
        }
        return v;
    }

    @Override
    public Iterator preOrder() {
        LinkedList list = new LinkedListDLNode();
        preOrderRecursion(this.root,list);
        return list.elements();
    }

    /**
     * 先序遍历的递归算法
     * @param rt
     * @param list
     */
    private void preOrderRecursion(BinTreeNode rt, LinkedList list){
        if(rt==null){
            return;
        }
        list.insertLast(rt);
        preOrderRecursion(rt.getlChild(),list);
        preOrderRecursion(rt.getrChild(),list);
    }

    /**
     * 先序遍历的非递归算法
     * @param rt
     * @param list
     */
    private void preOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while(p!=null){
            while (p!=null){
                list.insertLast(p);
                if(p.hasRChild()){
                    s.push(p.getrChild());
                    p = p.getlChild();
                }
            }
            if(!s.isEmpty()){
                p = (BinTreeNode)s.pop();
            }
        }
    }

    @Override
    public Iterator inOrder() {
        LinkedList list = new LinkedListDLNode();
        inOrderRecursion(this.root,list);
        return list.elements();
    }

    /**
     * 中序遍历的递归算法
     * @param rt
     * @param list
     */
    private void inOrderRecursion(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        inOrderRecursion(rt.getlChild(),list);
        list.insertLast(rt);
        inOrderRecursion(rt.getrChild(),list);
    }

    /**
     * 中序遍历的非递归算法
     * @param rt
     * @param list
     */
    private void inOrderTraverse(BinTreeNode rt, LinkedList list){
        if (rt==null) {return;}
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while (p!=null||!s.isEmpty()){
            //一直向左走
            while (p!=null){
                //将根结点入栈
                s.push(p);
                p = p.getlChild();
            }
            if (!s.isEmpty()){
                //取出栈顶根结点访问之
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
                //转向根的右子树进行遍历
                p = p.getrChild();
            }
        }
    }

    private void inOrderTraverseV2(BinTreeNode rt, LinkedList list){
        if(rt==null){
            return;
        }
        BinTreeNode p = rt;
        StackSLinked s = new StackSLinked();
        while(p!=null||!s.isEmpty()){
            while(p!=null){
                s.push(p);
                //向左走到底
                p=p.getlChild();
            }
            if(!s.isEmpty()){
                p = (BinTreeNode) s.pop();
                list.insertLast(p);
                p = p.getrChild();
            }
        }
    }

    @Override
    public Iterator postOrder() {
        LinkedList list = new LinkedListDLNode();
        postOrderRecursion(this.root,list);
        return list.elements();
    }

    private void postOrderRecursion(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        postOrderRecursion(rt.getlChild(),list);
        postOrderRecursion(rt.getrChild(),list);
        list.insertLast(rt);

    }

    /**
     * 后序遍历的非递归算法
     * @param rt
     * @param list
     */
    private void postOrderTraverse(BinTreeNode rt, LinkedList list){
        if (rt==null) {return;}
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while(p!=null||!s.isEmpty()){
            //先左后右不断深入
            while (p!=null){
                //将根节点入栈
                s.push(p);
                if (p.hasLChild()){
                    p = p.getlChild();
                }
                else {
                    p = p.getrChild();
                }
            }
            if (!s.isEmpty()){
                //取出栈顶根结点访问之
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
            }
            //满足条件时，说明栈顶根节点右子树已访问，应出栈访问之
            while (!s.isEmpty()&&((BinTreeNode)s.peek()).getrChild()==p){
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
            }
            //转向栈顶根结点的右子树继续后序遍历
            if (!s.isEmpty()) {
                p = ((BinTreeNode)s.peek()).getrChild();
            }
            else {
                p = null;
            }
        }
    }

    private void postOrderTraverseV2(BinTreeNode rt, LinkedList list){
        if(rt==null){
            return;
        }
        BinTreeNode p = rt;
        StackSLinked s = new StackSLinked();
        while(p!=null||!s.isEmpty()){
            while(p!=null){
                s.push(p);
                p = p.getlChild();
            }
            if(!s.isEmpty()){
                p = (BinTreeNode)s.pop();
                if(!p.hasRChild()) {
                    list.insertLast(p);
                }
                p = p.getrChild();
            }
        }
    }

    @Override
    public Iterator levelOrder() {
        LinkedList list = new LinkedListDLNode();
        levelOrderTraverse(this.root,list);
        return list.elements();
    }

    private void levelOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        Queue q = new QueueArray();
        q.enqueue(rt);
        while(!q.isEmpty()){
            BinTreeNode p = (BinTreeNode)q.dequeue();
            list.insertLast(p);
            if(p.hasLChild()){
                q.enqueue(p.getlChild());
            }
            if(p.hasRChild()){
                q.enqueue(p.getrChild());
            }
        }

    }


}
