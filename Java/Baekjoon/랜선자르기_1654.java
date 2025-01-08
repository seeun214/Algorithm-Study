import java.util.Scanner;
	
public class 랜선자르기_1654 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt(); // 랜선의 개수
        int N = scan.nextInt(); // 필요한 랜선의 개수
        int arr[] = new int[K]; // 각 랜선의 길이
        long max = 0;

        for(int i = 0; i < K; i++){
            arr[i] = scan.nextInt();
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;

        while(left <= right){
            long mid = (right + left) / 2;
            long count = 0;
            
            for(int i = 0; i < K; i++){
                // 각 랜선의 길이를 mid로 나눠서 총 랜선의 개수 구함
            	count += arr[i] / mid;
            }
            
            if(count >= N){ // 랜선의 개수가 더 많으면 자르는 길이 늘리기
                left = mid + 1;
            }else{ // 랜선의 개수가 더 적으면 자르는 길이 줄이기
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}