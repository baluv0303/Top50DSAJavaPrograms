package TopSDETInterviewQuestions.src.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18},{17,19}, {9,12}};

        int[][] merged = mergeBrute(intervals);

        System.out.println("Merged Intervals:");
        for (int[] arr : merged) {
            System.out.println(arr[0] + " " + arr[1]);
        }

        int[][] merged2 = megreSortAndGreedy(intervals);

        System.out.println("Merged Intervals:");
        for (int[] arr : merged2) {
            System.out.println(arr[0] + " " + arr[1]);
        }


    }

    public static int[][] megreSortAndGreedy(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for(int[] curr : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < curr[0]){
                result.add(curr);
            }

            else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size() - 1)[1], curr[1]);
            }
        }
        return result.toArray(new int[result.size()][]);

//        Time : O(n long n )
//        Space: O(n)
    }

    public static int[][] mergeBrute(int[][] intervals){
        int n = intervals.length;
        boolean[] visited = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for(int i= 0; i< n; i++){
            if(visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            for(int j= i+1; j<n; j++){
                if(visited[j]) continue;

                if(intervals[j][0] <= end && intervals[j][1] >= start){
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);
                    visited[j] = true;
                }

            }
            visited[i] = true;
            result.add(new int[] {start, end});
        }

        return result.toArray(new int[result.size()][]);

//        Time : O(n²)
//        Space: O(n)

    }

}
