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
		
		bHiphopSong = new JButton("����");
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
			int answer= JOptionPane.showConfirmDialog(null, "������ �����մϱ�?","Question",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(answer==JOptionPane.YES_OPTION){		
				if(clip.isRunning()==false){
					clip.start();
				}
				if(clip.isRunning()==true){
					clip.stop();
				}
				dispose();
				//����ȭ�� �߾ӿ�..
			}
		
		/*
			���̾�α�"������ �����ϰڽ��ϱ�"?
			
			(1)y->	1)�˾� ����
				    2)���� ����  <1> ���� ȭ�� �߾� taQuestion�� [n+ "�� �� �뷡 ����!"]
						       <2> �뷡 ��� + ���� ���
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