import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @subject 703.heap - 第K大的元素
 * @link    https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * @level   Easy
 * @desc    设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * 2,3,4,5,8 -> 4
 * 2,3,4,5,5,8 -> 5
 * 2,3,4,5,5,5,8 -> 5
 * 2,3,4,5,5,5,8,10 -> 5
 * 2,3,4,5,5,5,8,9,10 -> 8
 * 2,3,4,4,5,5,5,8,9,10 -> 8
 *
 * @solution PriorityQueue 本身是小顶堆，重写compare方法变成大顶堆
 *           关键字，第K大，用小顶堆，第K小，用大顶堆
 */
public class KthLargest {

    private Queue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap  = new PriorityQueue<>(k);
        this.k   = k;
        for (int i : nums)
            add(i);
    }

    public int add(int val) {
        if(minHeap.size() < this.k){
            minHeap.add(val);
        }else{
            if(val > minHeap.peek()){
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
