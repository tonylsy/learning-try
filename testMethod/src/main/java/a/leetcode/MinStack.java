package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/min-stack/
 **/
public class MinStack {
    private int[] order;
    private int[] data;
    private int size;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.order = new int[10];
        this.data = new int[10];
        this.size = 0;
    }

    public void push(int x) {
        if (size == order.length) {
            order = extendData(order);
            data = extendData(data);
        }
        size++;
        data[size - 1] = x;
        order[size - 1] = x;
        for (int i = size - 2; i >=0 ; i--) {
            if(order[i] < order[i+1]){
                int temp = order[i+1];
                order[i+1] = order[i];
                order[i] = temp;
            }else{
                break;
            }
        }
    }

    public void pop() {
        if (size > 0) {
            int popData = data[size - 1];
            int index = 0;
            for (int i = 0; i < size; i++) {
                if(order[i] == popData){
                    index = i;
                }
            }
            for (int i = index; i < size; i++) {
                if(i < order.length - 1){
                    order[i] = order[i+1];
                }
            }
            size--;
        }
    }

    public int top() {
        if (size == 0) return 0;
        return data[size - 1];
    }

    public int getMin() {
        return order[size - 1];
    }

    private int[] extendData(int[] arr) {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin() == -3);
        s.pop();
        System.out.println(s.top() == 0);
        System.out.println(s.getMin() == -2);

        MinStack s2 = new MinStack();
        s2.push(-2);
        s2.push(0);
        s2.push(-1);
        System.out.println(s2.getMin() == -2);
        System.out.println(s2.top() == -1);
        s2.pop();
        System.out.println(s2.getMin() == -2);
    }
}
