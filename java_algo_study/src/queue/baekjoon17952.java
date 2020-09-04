package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * @Problem      과제는 끝나지 않아!(17592)
 * @Author       pbg0205
 * @Created by   08.28.20
 *
 */
public class baekjoon17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pointSum = 0;

        Stack<subject> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] subject = br.readLine().split(" ");
            int isSubject = Integer.parseInt(subject[0]);

            if (isSubject == 0) {
                if(stack.isEmpty()){
                    continue;
                }
                subject sub = stack.pop();
                sub.plusTimeCnt();
                stack.push(sub);
            }

            if (isSubject == 1) {
                int point = Integer.parseInt(subject[1]);
                int requiredTime = Integer.parseInt(subject[2]);

                subject newSubject = new subject(point, requiredTime, 1);
                stack.push(newSubject);
            }

            subject lasted_sub = stack.peek();
            if (lasted_sub.isFinished()) {
                pointSum += lasted_sub.point;
                stack.pop();
            }

        }
        System.out.println(pointSum);
    }
}

class subject{
    int point;
    int requiredTime;
    int timeCnt;

    subject(int point, int requiredTime, int timeCnt){
        this.point = point;
        this.requiredTime = requiredTime;
        this.timeCnt = timeCnt;
    }

    public void plusTimeCnt(){
        this.timeCnt++;
    }

    public boolean isFinished(){
        return requiredTime == timeCnt;
    }
}
