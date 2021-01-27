package kangeroo;

 /*
  * @Problem    kangeroo
  * @url        https://www.hackerrank.com/challenges/kangaroo/problem
  * @author     pbg0205
  * @created by 2021.01.27
  */
public class Solution {
     static String kangaroo(int x1, int v1, int x2, int v2) {
         int distance = x1 - x2;
         int velocityDifference = v2 - v1;

         if(velocityDifference == 0){
             return "NO";
         } else if((distance % velocityDifference == 0) && (distance / velocityDifference > 0)) {
             return "YES";
         } else {
             return "NO";
         }
     }
}
