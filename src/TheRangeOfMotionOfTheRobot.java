//机器人的运动范围
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，
// 下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，
// 机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
// 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
public class TheRangeOfMotionOfTheRobot {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag=new int[rows][cols];
      return   canarrive(flag,0,0,rows,cols,threshold);
    }

    private int canarrive(int[][] flag, int i, int j, int rows,
                          int cols, int threshold) {
        if(i<0||j<0||i>=rows||j>=cols||sum(i,j,threshold)||flag[i][j]==1){
            return 0;
        }
        flag[i][j]=1;
        return canarrive(flag,i+1,j,rows,cols,threshold)+
                canarrive(flag,i,j+1,rows,cols,threshold)+
                canarrive(flag,i-1,j,rows,cols,threshold)+
                canarrive(flag,i,j-1,rows,cols,threshold)+1;
    }

    private boolean sum(int i, int j, int threshold) {
        int num=0;
        while(i>0){
            num+=i%10;
            i=i/10;
        }
        while(j>0){
            num+=j%10;
            j=j/10;
        }
        return num>threshold;
    }
}
