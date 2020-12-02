import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.sound.sampled.*;

class SongSelect extends JFrame implements ActionListener{
	
	JButton bHiphopSong,bIdolSong,bTrotSong,bRandomSong;
	Container cp;
	Clip clip;
	File file,folder;
	int i,r;

	SongSelect(){
		
		bHiphopSong = new JButton("힙합");
		bIdolSong = new JButton("idol");
		bTrotSong = new JButton("trot");
		bRandomSong = new JButton("random");
		
		cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		cp.add(bHiphopSong);
		bHiphopSong.addActionListener(this);
		cp.add(bIdolSong);
		cp.add(bTrotSong);
		cp.add(bRandomSong);
		setUI();
	}

	void setUI(){
		setSize(300,300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==bHiphopSong){
			int answer= JOptionPane.showConfirmDialog(null, "힙합을 선택합니까?","Question",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(answer==JOptionPane.YES_OPTION){		
				if(clip.isRunning()==false){
					clip.start();
				}
				if(clip.isRunning()==true){
					clip.stop();
				}
				dispose();
				//메인화면 중앙에..
			}
		
		/*
			다이얼로그"힙합을 선택하겠습니까"?
			
			(1)y->	1)팝업 꺼짐
				    2)게임 시작  <1> 메인 화면 중앙 taQuestion에 [n+ "초 뒤 노래 시작!"]
						       <2> 노래 재생 + 가사 출력
			(2)n-> cancel
		}
		
		else if(obj ==bIdolSong){

		}
		
		else if(obj ==bTrotSong){
		
		}
		
		else if(obj==bRandomSong){
		
		}
		*/
		}
	
	}
}