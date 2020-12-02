import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.border.*;
import javax.sound.sampled.*;
import java.util.*;


class login1 extends JFrame implements ActionListener {
   Container cp;   
   JLabel label_id;
   JButton jready,jexit,charbar,myscore,quiz,chat,answer,bPlaySong;
   Panel pn;
   JTextArea taQuiz,taChat,taPlayerInput;
   JTextField tfChatInput;
   JScrollPane spChat;
   File music,folder;
   //Clip clip;
   //String ClientChat;//사용자가 입력한 채팅. 

   login1(){
	  
	  
      cp = getContentPane();
      cp.setLayout(null);
      pn = new Panel();
      pn.setLayout(null);
      pn.setBounds(0,0,1200,825);
      
      label_id = new JLabel();
      label_id.setIcon(new ImageIcon("imgs//bg.png"));//배경
      
      jready = new JButton(new ImageIcon("imgs//ready(300x93).png"));//버튼
      jready.setBorderPainted(false);
      jready.setOpaque(false);
        jready.setFocusPainted(false);
      jready.addActionListener(this);
      
      jexit = new JButton(new ImageIcon("imgs//exit.png"));//버튼
      jexit.setBorderPainted(false);
      jexit.setOpaque(false);
        jexit.setFocusPainted(false);
      jexit.addActionListener(this);
      
      charbar = new JButton(new ImageIcon("imgs//charBar.png"));//버튼
      charbar.setBorderPainted(false);
      charbar.setOpaque(false);
        charbar.setFocusPainted(false);
      charbar.addActionListener(this);
     
      myscore = new JButton(new ImageIcon("imgs//myscore.png"));//버튼
      myscore.setBorderPainted(false);
      myscore.setOpaque(false);
        myscore.setFocusPainted(false);
      myscore.addActionListener(this);
      
      quiz = new JButton(new ImageIcon("imgs//quiz.png"));//버튼
      quiz.setBorderPainted(false);
      quiz.setOpaque(false);
        quiz.setFocusPainted(false);
      quiz.addActionListener(this);
      
      chat = new JButton(new ImageIcon("imgs//chat.png"));//버튼
      chat.setBorderPainted(false);
      chat.setOpaque(false);
        chat.setFocusPainted(false);
      chat.addActionListener(this);
      
      answer = new JButton(new ImageIcon("imgs//answer.png"));//버튼
      answer.setBorderPainted(false);
      answer.setOpaque(false);
       answer.setFocusPainted(false);
      answer.addActionListener(this);

	  bPlaySong = new JButton("재생");
	  bPlaySong.addActionListener(this);

      
	  tfChatInput = new JTextField();
	  tfChatInput.setBounds(60,700,170,30);
	  tfChatInput.setText("");
	  tfChatInput.addActionListener(this);

	  taChat = new JTextArea();
	  taChat.setFont(new Font("serif",Font.PLAIN,12));

	  spChat = new JScrollPane(taChat,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		  JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	  spChat.setBounds(70,458,155,222);
	  spChat.setOpaque(false);
	  

	  //taChat.setEditable(false);

	  taPlayerInput = new JTextArea();
	  
	  taQuiz = new JTextArea();
	  taQuiz.setBounds(350, 200, 320, 160);
	  taQuiz.setOpaque(false);
	  taQuiz.setFont(new Font("serif",Font.BOLD,30));
	  taQuiz.setForeground(Color.WHITE);
	  taQuiz.setText("가사");

      loginit();
	  
	  pn.add(bPlaySong);
	  pn.add(taQuiz);
	  pn.add(spChat);
	  pn.add(tfChatInput);
	  pn.add(taPlayerInput);
	  pn.add(taQuiz);
      pn.add(jready);
      pn.add(jexit);
      pn.add(charbar);
      pn.add(myscore);
      pn.add(quiz);
      pn.add(chat);
      pn.add(answer);
	 
      pn.add(label_id);
	  
      cp.add(pn);
      loginit();
	  makeMusic();
	       
   }

   void loginit(){
   
      label_id.setBounds(0, 0, 1200, 825);//배경
      jready.setBounds(700, 50, 220, 90);//ready버튼
      jexit.setBounds(900, 50, 220, 90);//exit버튼
      charbar.setBounds(60, 50, 4, 316);//charbar버튼
      myscore.setBounds(850, 450, 180, 230);//myscore버튼
      quiz.setBounds(300, 150, 520, 330);//quiz버튼
      chat.setBounds(60, 450, 170, 240);//chat버튼
      answer.setBounds(300, 800, 500, 84);//티비 다이 ..
	  bPlaySong.setBounds(50,50,100,50);//노래재생 버튼

      setUI();
    
   }

   void setUI(){
       
       //jpcen.setBounds(300,100,1200,825); //아주큰창
       setTitle("Drop the Beat");
       setSize(1200,825);
       setVisible(true);
       setResizable(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   void makeMusic(){
	  try{
		 //folder = new File("/src/"+music);	
		 //File []songs = File[2]; 
		 File songs[] = folder.listFiles();
		 System.out.println(songs);
         music = songs[0];
		 folder = new File("/src/"+music);
		 System.out.println(music);
		 //music = new File("src/music/a.wav");
        // Clip clip = AudioSystem.getClip();
         //clip.open(AudioSystem.getAudioInputStream(music));
      }catch(LineUnavailableException le){
         JOptionPane.showMessageDialog(null,"스피커 연결 확인");
      }catch(Exception ee){
      }
   }

   public void actionPerformed(ActionEvent e){
     Object obj = e.getSource();
     
	 if(obj == jexit){
		  int answer= JOptionPane.showConfirmDialog(null, "정말 종료 하시겠습니까?", "종료창",
		  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      
		 if (answer == JOptionPane.YES_OPTION) {
		  System.exit(0);
		 }
     }
	else if(obj == tfChatInput){
		 // ClientChat = tfChatInput.getText();
		  taChat.append("Client님: "+ClientChat+"\n");
		  taChat.setCaretPosition(taChat.getDocument().getLength());
		  tfChatInput.setText("");
	}

	else if(obj == bPlaySong){
		if(clip.isRunning()==true){
			clip.stop();
		}else if(clip.isRunning()==false){
			clip.start();
		}
	}

   }
     
   public static void main(String[] args) {

          login1 g = new login1();
	}
}

/*
class SongData{

	LinkedList<File> songlist = new LinkedList<File>();
	

}
*/