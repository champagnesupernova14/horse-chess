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
		public static int array[][]=new int[100][2];//array���������洢���ձ�����õ�ÿһ��������cΪ������c����j=0,1��
public static void main(String[] args)//������
	 {
		//Queue<String> queue = new LinkedList<String>();
        //int m,n;
        //int step;
        //int [][]map=new int[MAX][MAX];
        //int [][] direction={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        //System.out.println(queue);
	
		for(int a=0;a<MAX;a++){//��ʼ������Ϊ0.
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
	
	//�����λ�õ��������ߵĲ�����������count��ʾ���λ���������ߵĲ�����x��yΪ���ݵĲ���
	public static int _step(int x,int y){
		int i,xi,yi;
		int count=0;
		for(i=0;i<8;i++){
			xi=x+direction[i][0];
			yi=y+direction[i][1];
			if(xi>0&&xi<=MAX-1&&yi>0&&yi<=MAX-1&&(map[xi][yi]==0)){
				count++;//count��ʾ��x��y���λ���������ߵĵ���
			}
		}
		return count;
	}

	//�����㷨��while+for���·����x��y
	static int bianli(point p){//pΪ��ʼλ��
		int i=0,x,y;
		//int c=0;
		//int array[][]=new int[100][2];
		Queue<point> queue = new LinkedList<point>();//�������У������洢��������
		queue.offer(p);//�������
		point pp=new point();//ppΪ������ȡ����Ԫ��
		int flag=0;
		
		while(!queue.isEmpty()){
		    pp=queue.poll();//ppΪ������ȡ����Ԫ��
		    //array[c][0]=pp.heng;
		    //array[c][1]=pp.zong;
		    //c++;
		    map[pp.heng][pp.zong]=step++;//˵����λ���Ѿ����߹���map�����Լ�¼�ߵĵڼ�����step����
		    array[c][0]=pp.heng;
		    array[c][1]=pp.zong;
		    c++;
		    //System.out.println(pp.heng+","+pp.zong);//·��������
		    int minstep=10;
		     flag=0;
		    //��direction�ķ����������
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


