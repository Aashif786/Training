
public class SumOfRange {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] arr = {4,7,2,8,1,9,3};
        int n = arr.length;
        int low = 0 , high = n-1;
        SegmentTree tree = new SegmentTree(arr);
        tree.build(low, high, arr)
    }
    
    static int segmenttree(){
        return 0;
    }
}

class SegmentTree {

        private int [] tree;
        private int n;
        public SegmentTree(int arr[]){
            int n = arr.length;
            tree = new int[4*n];
            
        }
}