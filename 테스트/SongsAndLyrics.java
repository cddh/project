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

class SongsAndLyrics{

	LinkedHashMap<String,File> SongsAndLyricsList = new LinkedHashMap<String, File>();
	Songs songs;
	Lyrics lyrics;
	
	

	SongsAndLyrics(){
		songs = new Songs();
		lyrics = new Lyrics();	
		
		for(int i=0;i<SongsAndLyricsList.size();i++){
			SongsAndLyricsList.put(lyrics.LyricList.get(i),songs.SongList[i]);
		}

		for(Map.Entry<String, File> entry : SongsAndLyricsList.entrySet()){
			System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
		}
		
	}	
	public static void main(String[] args) {
		new SongsAndLyrics();		
		
	}
}


class Lyrics{
	String line;
	LinkedList<String> LyricList = new LinkedList<String>();
	Lyrics(){
		try{ 
			int i =0;
			 File file = new File("src/quiz.txt");
			 FileReader filereader = new FileReader(file);
			 BufferedReader br = new BufferedReader(filereader);
			 while((line=br.readLine()) != null){
				 LyricList.add(line);
				 //System.out.println("LyricList에 가사 저장 완료");
				 //System.out.println(LyricList.get(i));
			 }
			 br.close();	
		}catch (FileNotFoundException e) {
		}catch(IOException e){
			System.out.println(e);
		}
	}
	/*public static void main(String[] args){
		new Lyrics();
	}*/
}

class Songs{

	int r,i;
	Clip clip;
	File folder = new File("src/music/");
	File SongList[] = folder.listFiles();

	
	Songs(){
		 //폴더 경로 객체 
		 //폴더의 파일 목록을 배열에 담음
		r= ((int)Math.random()*SongList.length);//랜덤재생위한 랜덤숫자 r 만들기 
		for(int i=0;i<SongList.length;i++);{
			//System.out.println(SongList[i].getName());
		}
		try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(SongList[r]));
        }catch(LineUnavailableException ne){
		}catch (Exception e) {}
	}
	/*public static void main(String[] args){
		new Songs();
		
	}*/
}