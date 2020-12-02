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

public class Test1 extends JFrame implements ActionListener{

	
	Container cp;
	JButton b = new JButton("노래 선택");
	
	SongSelect ss;

	public Test1(){
		b.addActionListener(this);
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b);	
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

		
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if (obj==b)	{

			ss = new SongSelect();
			
			
			
		}
	}

	public static void main(String[] args) throws IOException{
		new Test1();
	}
}