package common;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class InputConverter {

    public static int[][] to(String input) {
        List<List> twoDimensionList = JSON.parseArray(input, List.class);
        int y = twoDimensionList.size();
        int x = twoDimensionList.stream().mapToInt(e->e.size()).max().orElse(y);
        int[][] res = new int[y][x];
        for (int i = 0; i < y; i++) {
            res[i] = new int[x];
            for(int j = 0 ;j < x; j++) {
                res[i][j] = (Integer) twoDimensionList.get(i).get(j);
            }
        }
        return res;
    }
}
