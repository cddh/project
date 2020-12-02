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


class A
{
	File music,folder;

	void makeMusic(){
	  try{
		 File songs[] = folder.listFiles();
		 for(int i=0;i<2;i++){
			  System.out.println(songs[i].listFiles());
		 }
         music = songs[0];
		 folder = new File("/src/"+music);
		 System.out.println(music);
		 //music = new File("src/music/a.wav");
        // Clip clip = AudioSystem.getClip();
         //clip.open(AudioSystem.getAudioInputStream(music));
      }catch(Exception ee){
      }
   }
	public static void main(String[] args) 
	{
		A a = new A();
		a.makeMusic();
	}
}
