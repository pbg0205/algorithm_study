package programmers.src.level3.shared_taxi;

class Solution {
    final int INF = 20_000_000;
    int[][] distance = new int[200][200];

    public int solution(int n, int s, int a, int b, int[][] fares) {
        initDistance(n);

        for (int[] edge : fares) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        floydWashall(n);

        int answer = INF;
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, distance[s][k] + distance[k][a] + distance[k][b]);
        }

        return answer;
    }

    private void initDistance(int n) {
        for (int from = 0; from <= n; from++) {
            for (int to = 0; to <= n; to++) {
                if(from == to) {
                    distance[from][to] = 0;
                } else {
                    distance[from][to] = INF;
                }
            }
        }
    }

    private void floydWashall(int n) {
        for (int stopOver = 1; stopOver <= n; ++stopOver) {// 경유지 노드
            for (int start = 1; start <= n; ++start) {// 출발 노드
                for (int end = 1; end <= n; ++end) {// 도착 노드
                    if(distance[start][stopOver] + distance[stopOver][end] < distance[start][end]) {
                        distance[start][end] = distance[start][stopOver] + distance[stopOver][end];
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
