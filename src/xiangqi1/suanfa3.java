package xiangqi1;
import java.util.Random;
class dian{//点，x和y分别为坐标，number为这个点上可以往下走的点数（8>=number>=0）
	int x;
	int y;
	int number;
}
public class suanfa3{
	public static int [][] direction={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};//每一个点可以走的方向，存到一个数组中
    public static final int MAX = 8;
    public static int[][] chessboard = new int[MAX][MAX]; //棋盘
    public static int[][] map=new int[64][2];//转换用的数组

    static int way(dian p){//根据direction找到当前点的八个儿子点中满足要求的点数（都没有返回9）
        int count = 0,i;
        dian pp=new dian();
        if(p.x<0 || p.x>7 || p.y<0 ||p.y>7 || chessboard[p.x][p.y]!=0){
            return 9;
        }
        for(i=0; i<MAX; i++){
            pp.x = p.x+direction[i][0];
            pp.y = p.y+direction[i][1];
            if(pp.x>-1 && pp.x<8 && pp.y>-1 && pp.y<8 && chessboard[pp.x][pp.y]==0)
                count++;//如果棋子的下个出路满足要求，则出路数自加一次
        }
        return count;
    }

    static void sort(dian[] next){//排序方法 按照从小到大排列next
        int i, j, index;
        dian temp = new dian();
        for(i=0; i<MAX; i++){
            index = i;
            for(j=i+1; j<MAX; j++){
                if(next[index].number > next[j].number)
                    index = j;
            }
            if(i != index){
                temp = next[i];
                next[i] = next[index];
                next[index] = temp;
            }
        }
    }


    static boolean Move(dian p, int step){//启动
            int ii,yy,iii;
            dian ppp=new dian();
            boolean flag =false;
            chessboard[p.x][p.y]=step;
            if(step == MAX*MAX){//如果路径能覆盖棋盘则return true
                for(ii=0; ii<MAX; ii++){
                    for(yy=0; yy<MAX; yy++){
                        //System.out.print(chessboard[ii][jj]);
                    }
                    //System.out.println();
                }
                return true;
            }

            dian[] next = new dian[MAX];
            for(ii=0; ii<MAX; ii++){//得到next，算每一个儿子的满足要求（判断孙子）的情况，写到next中
            	dian pp = new dian();
                pp.x = p.x+direction[ii][0];
                pp.y = p.y+direction[ii][1];
                next[ii] = pp;
                
                next[ii].number = way(pp);
            }

            sort(next);//调用排序方法

            for( iii=0; iii<MAX&&next[0].number!=9;iii++){
                //如果走的通，则一直走下去
            	flag=false;
                ppp.x = next[iii].x;
               ppp.y = next[iii].y;
                Move(ppp, step+1);
                return false;
            }
          //如果走不通，则回溯
            if(next[0].number==9){
                chessboard[next[iii].x][next[iii].y] = 0;
                return false;
            }


        return flag;
    }

    public static void main(String[] args) {
        int i, j;
        //初始化棋盘
        for(i=0; i<MAX; i++){
            for(j=0; j<MAX; j++){
                chessboard[i][j] = 0;
            }
        }
        dian start=new dian();
        Random rand=new Random();
        start.x = rand.nextInt(8);
        start.y = rand.nextInt(8);
       // System.out.print();
        Move(start, 1);
        //数组转换，map用来与test.java对接
        for(int zz=0;zz<=64;zz++){
        for(int ii=0;ii<MAX;ii++){
        	for(int jj=0;jj<MAX;jj++){
        		if(zz+1==chessboard[ii][jj]){
        			map[zz][0]=ii;
        			map[zz][1]=jj;
        		}
        	}
        }
       }
    }
}
