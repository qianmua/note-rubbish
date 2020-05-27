package _算法与数据结构_._算法_;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/27  18:20
 * @description :
 */
public class Demo2 {

    /*
    *
    * 深度优先搜索
    *
    * 形如 栈特点
    * 全部搜索完毕
    *
    *
    * eg： 迷宫
    *
    * DFS 是图论算法
    *
    * */
    // 目的地
    int x1 = 8 , y1 = 10;
    boolean dfs(int[][] arr , int x , int y){
        Stack<Integer[]> stack = new Stack<>();

        stack.push( new Integer[]{y , x});
        arr[x][y] = -1;

        while ( !stack.empty()){
            Integer[] pop = stack.pop();
            x = pop[0] ;
            y = pop[1];
            if (x == x1 && y == y1){
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int i = x + 1 , j = y + 1;
                // 判断 安全
                if (1 == 1){
                    stack.push(new Integer[]{ i , j});
                    arr[i][j] = -1;
                }
            }
        }
        return false;
    }




    /*
    * 广度 优先搜索 BFS
    *
    * 广度 优先
    * 借助 的 数据结构是 队列
    *
    * 先进先出
    *
    *
    * 一层 一层 扫描
    *
    * 把 他所有 相邻 的 点 全部标记
    *
    * 直到找到 目标点
    *
    *
    *
    * */

    void bfs(int[][] arr ,int x , int y){
        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(new Integer[]{x , y});

        while ( !list.isEmpty()){
            Integer[] poll = list.poll();
            x = poll[0];
            y = poll[1];

            for (int i = 0; i < 4; i++) {
                // 四个方向
                int z = x + 1 , j = y + 1;
                if ( 1== 1){
                    arr[z][j] = arr[z][j] + 1;
                    list.add(new Integer[]{z, j});

                    if (z == x1 && j == y1) return;
                }

            }
        }

    }






}
