package algorithm.DynamicProgramming.p787;

import java.util.*;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-15 15:12
 * @Reference https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights.length < 1) {
            return -1;
        }

        int[][] routes = new int[n][n];
        int[] dis = new int[n];
        int[] currentStops = new int[n];
//        Arrays.fill(currentStops, 0x7fffffff);
        Arrays.fill(dis, 0x7fffffff);
        dis[src] = 0;
//        currentStops[src] = 0;

        for (int[] f: flights) {
            routes[f[0]][f[1]] = f[2];
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        pq.add(new Integer[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            Integer[] top = pq.poll();
            Integer cost = top[0];
            Integer nowAt = top[1];
            Integer remainStops = top[2];
            if (nowAt == dst) {
                return cost;
            }
            else if (remainStops < 1)   {continue;}
            else if (remainStops > 0) {
                for (int i = 0; i < routes.length; i++) {
                    if (routes[nowAt][i] > 0) {
                        if (dis[i] > cost + routes[nowAt][i]) {
                            dis[i] = cost + routes[nowAt][i];
                            pq.offer(new Integer[]{dis[i], i, remainStops - 1});
                        }
                        else if (remainStops - 1 >= currentStops[i]) {
                            pq.offer(new Integer[]{cost + routes[nowAt][i], i, remainStops - 1});
                            currentStops[i] = remainStops;
                        }
                    }
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1: dis[dst];
    }

//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Map<Integer, Map<Integer, Integer>> routes = new HashMap<>();
//            for (int[] f: flights) {
//            if (!routes.containsKey(f[0])) {
//                routes.put(f[0], new HashMap<>());
//            }
//            routes.get(f[0]).put(f[1], f[2]);
//        }
//        /* 相当于(x, y) -> Integer.compare(x[0], y[0]); */
//        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
//            pq.add(new int[]{0, src, k + 1});
//            while (!pq.isEmpty()) {
//            int[] top = pq.poll();
//            int price = top[0];
//            int nowAt = top[1];
//            int remainStops = top[2];
//            if (nowAt == dst) {
//                return price;
//            }
//            else if (remainStops > 0) {
//                /* Map<Integer, Integer> route = routes.getOrDefault(city, new HashMap<>()); */
//                Map<Integer, Integer> adjacent = routes.get(nowAt);
//                if (adjacent != null) {
//                    for (int des: adjacent.keySet()) {
//                        pq.add(new int[]{price + adjacent.get(des), des, remainStops - 1});
//                    }
//                }
//            }
//        }
//            return -1;
//    }
}
