class MedianFinder {
    public  PriorityQueue<Integer> maxHeap;
    public  PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap =new PriorityQueue<>(Comparator.reverseOrder());
         minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);             
        } else {
            minHeap.offer(num);
        }
        rebalance();
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return (maxHeap.size() > minHeap.size())
                ? maxHeap.peek()                      
                : minHeap.peek();
    }

    private void rebalance() {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
