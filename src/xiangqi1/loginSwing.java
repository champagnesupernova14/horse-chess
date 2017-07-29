package xiangqi1;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;  
import javax.swing.JTextField;

public class loginSwing {
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginSwing window = new loginSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public loginSwing() {
		initialize();//相当于构造函数
	}
	private void initialize() {
		frame = new JFrame("登录/登出");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.getContentPane().add(panel);
        panel.setLayout(null);//布局
        
        JLabel userLabel = new JLabel("UserName:");//用户名
        userLabel.setBounds(37,32,80,35);
        panel.add(userLabel);
        userLabel.addMouseListener(new MouseAdapter(){
       	 public void mouseEntered(MouseEvent e2){
       		 userLabel.setToolTipText("用户名");
       	 } 
       });
       
        JTextField userText = new JTextField("Please input the username");//用户名框
        userText.setBounds(141,32,245,35);
        panel.add(userText);
        
        JLabel passwordLabel = new JLabel("Password:");//密码
        passwordLabel.setBounds(37,85,80,38);
        panel.add(passwordLabel);
        passwordLabel.addMouseListener(new MouseAdapter(){    	
       	 public void mouseEntered(MouseEvent e){
       		passwordLabel.setToolTipText("密码");
       	 }
       });
        
        JPasswordField passwordText = new JPasswordField("Please match your password");//密码框
        passwordText.setBounds(141,85,245,38);
        panel.add(passwordText);
        
        JButton btnNewButton = new JButton("Exit");//取消按钮
        btnNewButton.setBounds(288, 175, 98, 41);
        btnNewButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e1){
        		 int nnn = JOptionPane.showConfirmDialog(null, "      您确定要登出吗？", "温馨提示",JOptionPane.YES_NO_OPTION); //返回值为0或1
      		   if(nnn==0){
      		   System.exit(0);}
      		   else{
      		   
      		   }
        	}
        });
        panel.add(btnNewButton);
      

        JButton loginButton = new JButton("login");//登录按钮 
        loginButton.setBounds(37, 175, 95, 44);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2) {
				String username=userText.getText();
				String password=passwordText.getText();//don't give a shit
				 LoginCheck loginCheck = new LoginCheck(username,password); 
					if (loginCheck.confirm()) {  
					JOptionPane.showMessageDialog(null, "欢迎！！");
					int nn = JOptionPane.showConfirmDialog(null, "   胖友，想进入游戏吗?", "温馨提示",JOptionPane.YES_NO_OPTION); //返回值为0或1
					if(nn==0){
						test.main(null);
					    frame.dispose();
					}
					else{}	
                    }
					else {  
                    	JOptionPane.showMessageDialog(null, "账号或者密码错误！");
                    	
                    }  
	       	     }
	           }
            ); 
        
        frame.setVisible(true);	
	}
}

class LoginCheck{
	private String userName;
	private String passWord;
     LoginCheck(String username1,String password1){
         userName=username1;
         passWord=password1;
}
    public boolean confirm()
    {
    	if((userName.equals("yyz"))&&(passWord.equals("123"))){return true;}
    	else {return false;}
    }
}
