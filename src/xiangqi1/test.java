package xiangqi1;
import java.awt.Color;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.*;
public class test extends JPanel
{
	 static String[][] shuzuname=new String[8][8];
	 static boolean[][] shuzustate=new boolean[8][8];
	 static JLabel[][]shuzu=new JLabel[8][8];
	 static String[] trip=new String[10000];
	 JLabel a = new JLabel("233333");	
	 static int nowi=0;
     static int nowj=0;
     static int count=0;
     static int time=1;
     public static int flag1=0;
     public static int flag2=0;
     public static int flag3=0;
     public static JFrame f=new JFrame();
public test()//构造函数
 {
 	 super(null);	
  for(int i=0; i<8; i++)
  {
   for(int j=0; j<8; j++)
   { 
	 JLabel l = new JLabel(i+","+j);//生成标签实例
    shuzustate[i][j]=true;//存放到shuzustate数组中
    shuzuname[i][j]=l.getText();//存放到shuzuname数组中
    shuzu[i][j]=l;//数组控件存在shuzu
    l.setHorizontalAlignment(SwingConstants.CENTER);
    l.setSize(80,80);
    l.setLocation(j*80,i*80);
    if((i+j)%2==0)
    {     //当小方格的坐标和刚好是偶数时，
     l.setBackground(Color.black);   
     l.setOpaque(true);  
    }
    if((i+j)%2!=0)
    {     
     l.setBackground(Color.white);   
     l.setOpaque(true);   
    } 
      l.setBorder(BorderFactory.createLineBorder(Color.black));  
      add(l);
   }
   }
  JButton start=new JButton("Start");
  start.setSize(128, 128);
  start.setLocation(640,0);
  start.setVisible(true);
  add(start);
  start.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e3){
		  if(flag1==0||flag3==1) {
			  ImageIcon icon=new ImageIcon(test.class.getResource("/chess1.png"));
			   suanfa3.main(null);
			   shuzu[suanfa3.map[0][0]][suanfa3.map[0][1]].setIcon(icon);
				shuzustate[0][0]=false;
			     add(shuzu[suanfa3.map[0][0]][suanfa3.map[0][1]]);
			     flag1=1;
			     flag3=0;
			     System.out.println("作者:袁彦哲");
				 System.out.println("班级:计算机科学与技术1503");
				 System.out.println("学号:1507010309");
                 System.out.println("Here is the track:"); 
					// for(int i=0;i<64;i++){
				          //  for(int j=0;j<2;j++){
				                //System.out.print(suanfa3.map[i][j]);
				            	//map[i][j]
				              //  if(j==0){
				               // System.out.print(",");}
				           // }
				           // System.out.println();
						//}
					// System.out.println("------------------------------------");
				 
			  //shuzu[0][0].setVisible(true);
		  }
		  
		  else{ 
			  JOptionPane.showMessageDialog(null, "已经随机选择了起点，请点击move按钮开始您的旅程！", "温馨警告",JOptionPane.ERROR_MESSAGE);
		  }
	  }
	  }); 

  JButton move=new JButton("move");
  move.setSize(128,128);
  move.setLocation(640,128);
  move.setVisible(true);
  add(move);
  move.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e4){
		   //if(shuzustate[nowi+2][nowj+1]==false){
		   //JOptionPane.showMessageDialog(null, "Fail to enter！Please check again!");}
			 if(time>64)  
			{JOptionPane.showMessageDialog(null, "恭喜！已经走完全部路程！", "温馨提示",JOptionPane.WARNING_MESSAGE);  }
			 if(time==64){JOptionPane.showMessageDialog(null, "          已经走完全部棋盘！！", "温馨提示",JOptionPane.WARNING_MESSAGE); }
			 if(flag3==1){flag3=0;
				 JOptionPane.showMessageDialog(null, "          请先选择start生成起点！！", "温馨提示",JOptionPane.WARNING_MESSAGE); }
			 else{
				 //shuzu[nowi][nowj]=new JLabel(nowi+","+nowj);
				 //shuzu[nowi][nowj].setHorizontalAlignment(SwingConstants.CENTER);
				 //shuzu[nowi][nowj].setSize(80,80);
				 //shuzu[nowi][nowj].setLocation(nowi*80,nowj*80);
			     shuzu[suanfa3.map[time][0]][suanfa3.map[time][1]].setIcon(new ImageIcon(test.class.getResource("/chess1.png")));
			     time++;
			    
			 }
	   }   
  });
  
  JButton OnceMore=new JButton("OnceMore");//ShowTrack按钮，可以显示一共需要的走过的坐标顺序
  OnceMore.setSize(128,128);
  OnceMore.setLocation(640,256);
  OnceMore.setVisible(true);
  add(OnceMore);
  OnceMore.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent e5){
		// System.out.println("Here is the track:"); 
		 for(int i=0;i<64;i++){
	            //for(int j=0;j<2;j++){
	            	shuzu[suanfa3.map[i][0]][suanfa3.map[i][1]].setIcon(null);
	            	flag1=0;
	            	flag3=1;
	            	time=1;
	           //}
	            //System.out.println();
			}
		// System.out.println("------------------------------------");
	 }
	 });
  
  JButton back=new JButton("back");//back按钮，可后退一步
  back.setSize(128,128);
  back.setLocation(640,384);
  back.setVisible(true);
  add(back);
  back.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e4){
				 //shuzu[nowi][nowj]=new JLabel(nowi+","+nowj);
				 //shuzu[nowi][nowj].setHorizontalAlignment(SwingConstants.CENTER);
				 //shuzu[nowi][nowj].setSize(80,80);
				 //shuzu[nowi][nowj].setLocation(nowi*80,nowj*80);
		         time--;
		         if(time==0){JOptionPane.showMessageDialog(null, "           已经不能再后退啦！！", "温馨提示",JOptionPane.WARNING_MESSAGE); }
			//for(int qq=0;qq<64;qq++){
		      	shuzu[suanfa3.map[time][0]][suanfa3.map[time][1]].setIcon(null);
	   }
			//}     
		   
	  // }   
  });
  
  JButton exit=new JButton("exit");//back按钮，可后退一步
  exit.setSize(128,128);
  exit.setLocation(640,512);
  exit.setVisible(true);
  add(exit);
  exit.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e4){
		   //怎么设置字体//?、
		   //Font f=new Font("宋体",Font.PLAIN,12);
		   //UIManager.put("Label.font",f);
		   //UIManager.put("JOptionPane.font",f);
		   int n = JOptionPane.showConfirmDialog(null, "      您确定要退出程序吗？", "温馨提示",JOptionPane.YES_NO_OPTION); //返回值为0或1
		   if(n==0){
		   System.exit(0);}
		   else{
		   
		   }
	   }   
  });
 }

public static void main(String[] args)
 {
  JFrame f = new JFrame();
  f.setSize(768,690);   //边框的长和宽
  f.setLocationRelativeTo(null);   //设置窗口相对于指定组件的位置
  f.add(new test());
  f.setVisible(true);
 /* for(int a=0;a<8;a++){
	  for(int b=0;b<8;b++)
	  {
		  System.out.println(shuzuname[a][b]);
	  }
  }
  for(int a=0;a<8;a++){
	  for(int b=0;b<8;b++)
	  {
		  System.out.println(shuzustate[a][b]);
	  }
  }*/
  
  
 }
}