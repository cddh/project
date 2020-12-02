import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.JFrame;



class GameFrame extends JFrame implements ActionListener,Runnable{

   Container cp;
   JLabel lBg;
   JPanel gp; 
   JButton bPlaySong, bInput, bNextSong, bPrevSong, bVolumeUp,bVolumeDown;
   JTextField tf1,tf2;
   ImageIcon wall;
   Clip clip;
   File music;
   FloatControl VolumeControl;
   BooleanControl muteControl;


   public GameFrame(){

      
      cp = getContentPane();
      cp.setLayout(null);
      
      lBg = new JLabel();
      wall = new ImageIcon(getClass().getResource("src/wall.jpg"));
      lBg.setIcon(wall);

      bPlaySong = new JButton("노래 재생");//노래버튼
      bInput = new JButton("입력");
      bVolumeUp = new JButton("볼륨 업");
      bVolumeDown = new JButton("볼륨 다운");

      tf1 = new JTextField(10);
      tf2 = new JTextField(10);

      gp = new JPanel();// 패널
      gp.setLayout(null);
      
      gp.add(bPlaySong);
      gp.add(bVolumeUp);
      gp.add(bVolumeDown);
      gp.add(bInput);

      gp.add(tf1);
      gp.add(tf2);
      gp.add(lBg);

      cp.add(gp);
      
      lBg.setBounds(0,0,1024,768);
      bPlaySong.setBounds(50,50,100,50);
      bVolumeUp.setBounds(150,50,100,50);
      bVolumeDown.setBounds(250,50,100,50);
      bInput.setBounds(350,50,100,50);
      tf1.setBounds(50,150,200,30);
      tf2.setBounds(50,200,200,30);

      gp.setBounds(0,0,1024,768);
      bPlaySong.addActionListener(this);
      bInput.addActionListener(this);
      bVolumeUp.addActionListener(this);
      bVolumeDown.addActionListener(this);

      setSize(1024,768);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   
   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      try{
         File a = new File("src\\a.wav");
         clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(a));
         VolumeControl =  (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
          muteControl= (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
      }catch(LineUnavailableException le){
         JOptionPane.showMessageDialog(null,"스피커 연결 확인");
      }catch(Exception ee){
      }   

      if(obj == bPlaySong){
            new Thread(this).start();
      }
         
      if(obj == bVolumeUp){
         System.out.println("볼륨업!");
         VolumeControl.setValue(3.0f);
      }
         
      if(obj == bVolumeDown){   
         System.out.println("볼륨 다운!");
         VolumeControl.setValue(-3.0f);
         }
            
      if(obj == bInput){
         tf2.setText(tf1.getText());
      }
   }

   public void run(){
      clip.start();
   }

   public static void main(String[] args) {
      new GameFrame();
   }
   
}
