//public class IslandCount {
//    public static int dfs(int[][] island,int[][] isvisit) {
//        int count = 0;
//        for (int i = 0; i < island.length; i++) {
//            for (int j = 0; j < island[0].length; j++) {
//                if(isvisit[i][j]!=1) {
//                    if(island[i][j]==1) {//表示是第一个1，进行加一
//                        count++;
//                    }
//                    //进行深度优先搜索
//                    dfsVisit(island,isvisit,i,j);
//                    System.out.println("---------------");
//                }
//            }
//        }
//        return count;
//    }
//    public static void dfsVisit(int[][] island,int[][] isvisit,int i,int j) {
//        if(i<0 ||j<0 || i>island.length-1 || j>island[0].length-1) {
//            //表示已经数组越界了
//            return;
//        }
//        if(island[i][j]==0) {
//            //表示不是岛屿
//            return;
//        }
//        if(isvisit[i][j]==1) {
//            //已经遍历过了，
//            return;
//        }else {
//            //表示没有遍历过
//            isvisit[i][j]=1;
//            System.out.println("i="+i+" j="+j);
//            dfsVisit(island,isvisit,i-1,j);//上
//            dfsVisit(island,isvisit,i+1,j);//下
//            dfsVisit(island,isvisit,i,j-1);//左
//            dfsVisit(island,isvisit,i,j+1);//右
//        }
//
//    }
//
//    public static void main(String[] args) {
//        //岛屿的数量
//        int[][] island = {{1,1,0,1,1},
//                {1,1,0,0,0},
//                {0,0,1,0,0},
//                {1,0,0,1,1}};
//        //isvisit表示是否遍历过
//        int[][] isvisit =new int[island.length][island[0].length];
//        System.out.println(dfs(island,isvisit));
//    }
//}
//—