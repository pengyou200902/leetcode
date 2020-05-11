package com.leetcode.String.p1436;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public String destCity(List<List<String>> paths) {
        String start, end;
        HashMap<String, String> routes = new HashMap<>();
        for (List<String> strings : paths) {
            routes.put(strings.get(0), strings.get(1));
        }

        for (List<String> path : paths) {
            end = getDes(routes, path.get(1));
            if (end != null) {
                return end;
            }
        }
        return null;
    }

    public String getDes(HashMap<String, String> m, String start) {
        if (m.get(start) != null) {
            return getDes(m, m.get(start));
        }
        return start;
    }

    public static void main(String[] args) {
    }
}
