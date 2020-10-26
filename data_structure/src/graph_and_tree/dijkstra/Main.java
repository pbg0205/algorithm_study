package graph_and_tree.dijkstra;
/*
 * @subject     그래프를 이용한 다익스트라 알고리즘
 * @author      pbg0205
 * @created by  10.26.20
 */

class Main {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.input(1, 2, 3);
        g.input(1, 5, 4);
        g.input(1, 4, 4);
        g.input(2, 3, 2);
        g.input(3, 4, 1);
        g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);

        g.dijkstra(1);
    }
}

class Graph{
    private int size;
    private int map[][];

    public Graph(int size){
        this.size = size;
        this.map = new int[size + 1][size + 1];
    }

    public void input(int start, int end, int weight){
        map[start][end] = weight;
        map[end][start] = weight;
    }

    public void dijkstra(int start){
        int distance[] = new int[size+ 1];
        boolean[] visited = new boolean[size + 1];

        for (int i = 1; i < size + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        visited[start] = true;

        for (int destination = 1; destination < size + 1; destination++) {
            if(!visited[destination] && map[start][destination] != 0){
                distance[destination] = map[start][destination];
            }
        }

        for (int i = 0; i < size - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 1; j < size + 1; j++) {
                if(!visited[j] && distance[j] != Integer.MAX_VALUE){
                    if(distance[j] < min){
                        min = distance[j];
                        minIndex = j;
                    }
                }
            }

            visited[minIndex] = true;
            for (int j = 1; j < size + 1; j++) {
                if(!visited[j] && map[minIndex][j] != 0){
                    if(distance[j] > distance[minIndex] + map[minIndex][j]){
                        distance[j] = distance[minIndex] + map[minIndex][j];
                    }
                }
            }
        }

        for (int i = 1; i < size + 1; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }
}
