package xiangqi1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class suanfa{
	private static int MAX=8;
	//private static int MAXSIZE=64;
	 public static int [][] direction={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	 public static int [][]map=new int[MAX][MAX];
	 public static int step;
	 public static int c=0;
	 //public static int y2,x2;
		public static int array[][]=new int[100][2];//array数组用来存储最终遍历获得的每一步的坐标c为步数【c】【j=0,1】
public static void main(String[] args)//主函数
	 {
		//Queue<String> queue = new LinkedList<String>();
        //int m,n;
        //int step;
        //int [][]map=new int[MAX][MAX];
        //int [][] direction={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        //System.out.println(queue);
	
		for(int a=0;a<MAX;a++){//初始化数组为0.
			for(int b=0;b<MAX;b++){
				map[a][b]=0;
			}
         }
		for(int i=0;i<64;i++){
            for(int j=0;j<1;j++){
               array[i][j]=0;
                }
		}
		step=1;
		point start=new point();
		//start.heng=0;
		//start.zong=4;
		Random rand=new Random();
		start.heng=rand.nextInt(8);
		//start.heng=x2;
		start.zong=rand.nextInt(8);
		//start.zong=y2;
		step=bianli(start);
		for(int i=0;i<MAX;i++){
            for(int j=0;j<MAX;j++){
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
		/*for(int i=0;i<64;i++){
            for(int j=0;j<2;j++){
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
		}*/
		//System.out.println(step);
		
	 }
	
	//求出该位置的马所能走的步数，产生的count表示这个位置能往下走的步数，x，y为传递的参数
	public static int _step(int x,int y){
		int i,xi,yi;
		int count=0;
		for(i=0;i<8;i++){
			xi=x+direction[i][0];
			yi=y+direction[i][1];
			if(xi>0&&xi<=MAX-1&&yi>0&&yi<=MAX-1&&(map[xi][yi]==0)){
				count++;//count表示在x，y这个位置能往下走的点数
			}
		}
		return count;
	}

	//遍历算法，while+for求出路径，x，y
	static int bianli(point p){//p为起始位置
		int i=0,x,y;
		//int c=0;
		//int array[][]=new int[100][2];
		Queue<point> queue = new LinkedList<point>();//创建队列，用来存储坐标数据
		queue.offer(p);//进入队列
		point pp=new point();//pp为队列中取出的元素
		int flag=0;
		
		while(!queue.isEmpty()){
		    pp=queue.poll();//pp为队列中取出的元素
		    //array[c][0]=pp.heng;
		    //array[c][1]=pp.zong;
		    //c++;
		    map[pp.heng][pp.zong]=step++;//说明该位置已经被走过，map最后可以记录走的第几步，step步数
		    array[c][0]=pp.heng;
		    array[c][1]=pp.zong;
		    c++;
		    //System.out.println(pp.heng+","+pp.zong);//路径的坐标
		    int minstep=10;
		     flag=0;
		    //向direction的方向进行搜索
		    for(i=0;i<8;i++){
		    x=pp.heng+direction[i][0];
		    y=pp.zong+direction[i][1];
		    if((x>=0)&&(x<=MAX-1)&&(y>=0)&&(y<=MAX-1)&&(map[x][y]==0)){
		    if(_step(x,y)<minstep){
		    	minstep=_step(x,y);
		    	//xx=;
		    	//if(_step(x,y)==minstep){
		    		
		    //	}
		    	point ppp = new point();
		    	point pppp =new point();
		    	ppp.heng=x;ppp.zong=y;
		    	if(flag==1){pppp=queue.poll();}
		    	queue.offer(ppp);
		    	flag=1;
		     }
		    }
		  }
		   
		    //System.out.println(minstep);
	  }
		return step-1;
		 }
	}
		
	

 class point{
	int heng;
	int zong;
	point(){}
}


