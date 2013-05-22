/**
 * 问题描述：
 * 给定包含4 300 000 000个32位整数的顺序文件，
 * 如何找出一个至少出现两次的整数
 */
public class FindTwice {
    
    /**
     * 由于4 300 000 000 >2^32,所以必然存在重复的整数
     * 考虑到内存的问题，可以先读取一部分，然后查找
     * 这里假设一次读取10个
     */
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,11,12,12,13,14,15};
        int iCount=0;
        int increase=arr[0];
        for(;iCount<arr.length;iCount++){
            if(arr[iCount]>iCount+increase){
                increase+=(arr[iCount]-iCount-increase);
                continue;
            }
            if(arr[iCount]<iCount+increase){
                System.out.println("重复的数字是:"+arr[iCount]);
                break;
            }
        }
    }
}