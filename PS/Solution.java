import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static ArrayList<String> result;
    private static Cell[][] map;

    private static class Cell {
        String value = "";
        int mergeID = 0;
    }

    private static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static Map<Integer, List<Point>> mergeDic;
    private static int newID;

    private static void update(String value1, String value2) {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j].value.equals(value1)) {
                    map[i][j].value = value2;
                }
            }
        }
    }

    private static void update(Point point, String value) {
        Cell cell = map[point.r][point.c];
        cell.value = value;
        List<Point> merges = mergeDic.get(cell.mergeID);
        if (merges != null) {
            for (Point p : merges) {
                map[p.r][p.c].value = value;
            }
        }
    }

    private static void merge(Point point1, Point point2) {
        if (point1.equals(point2)) {
            return;
        }

        Cell cell1 = map[point1.r][point1.c];
        Cell cell2 = map[point2.r][point2.c];

        String newValue = cell1.value.isEmpty() ? cell2.value : cell1.value;
        int newMergeID = ++newID;

        mergeDic.put(newMergeID, new ArrayList<>());
        mergeDic.get(newMergeID).add(point1);
        mergeDic.get(newMergeID).add(point2);

        List<Point> merges1 = mergeDic.get(cell1.mergeID);
        if (merges1 != null) {
            mergeDic.get(newMergeID).addAll(merges1);
        }

        List<Point> merges2 = mergeDic.get(cell2.mergeID);
        if (merges2 != null) {
            mergeDic.get(newMergeID).addAll(merges2);
        }

        List<Point> newMerges = mergeDic.get(newMergeID);
        if (newMerges != null) {
            for (Point p : newMerges) {
                map[p.r][p.c].value = newValue;
                map[p.r][p.c].mergeID = newMergeID;
            }
        }
    }

    private static void unmerge(Point point) {
        String value = map[point.r][point.c].value;
        int mergeID = map[point.r][point.c].mergeID;

        List<Point> merges = mergeDic.get(mergeID);
        if (merges != null) {
            for (Point p : merges) {
                map[p.r][p.c].value = "";
                map[p.r][p.c].mergeID = 0;
            }
        }
        map[point.r][point.c].value = value;
    }

    private static void printing(Point point) {
        String value = map[point.r][point.c].value;
        result.add(value.isEmpty() ? "EMPTY" : value);
    }

    public static String[] solution(String[] commands) {
        result = new ArrayList<>();
        map = new Cell[51][51];
        mergeDic = new HashMap<>();
        newID = 0;

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                map[i][j] = new Cell();
            }
        }

        for (String command : commands) {
            String[] elements = command.split(" ");
            String action = elements[0];

            switch (action) {
                case "UPDATE":
                    if (elements.length == 3) {
                        update(elements[1], elements[2]);
                    } else {
                        Point point = new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
                        update(point, elements[3]);
                    }
                    break;

                case "MERGE":
                    Point point1 = new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
                    Point point2 = new Point(Integer.parseInt(elements[3]), Integer.parseInt(elements[4]));
                    merge(point1, point2);
                    break;

                case "UNMERGE":
                    Point point = new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
                    unmerge(point);
                    break;

                case "PRINT":
                    Point printPoint = new Point(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
                    printing(printPoint);
                    break;

                default:
                    break;
            }
        }

        return result.toArray(new String[0]);
    }
}