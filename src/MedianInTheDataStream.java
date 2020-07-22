import java.util.Comparator;
import java.util.PriorityQueue;

//数据流中的中位数
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之
// 后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
// 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class MedianInTheDataStream {
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(20, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;//降序排序
        }
    });
    private int index=0;
    public void Insert(Integer num) {
        if(index%2==0){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        index++;
    }

    public Double GetMedian() {
        if(index%2==0){
            return new Double((minHeap.poll()+maxHeap.poll())/2);
        }else{
            return new Double(minHeap.poll());
        }
    }
}
