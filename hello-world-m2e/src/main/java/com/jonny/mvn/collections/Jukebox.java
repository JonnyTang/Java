package com.jonny.mvn.collections;

import java.util.*;
import java.io.*;

public class Jukebox {

	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Jukebox().go();
	}
	
	class ArtistCompare implements Comparator<Song> {
		public int compare(Song one, Song two) {
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList); // 排序(默认升序)
		System.out.println(songList);
		
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);
		
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);  // addAll()可以复制其他集合的元素，效果就跟一个个加进去一样
		System.out.println(songSet);
		
		// 增加排序的set
		TreeSet<Song> songTreeSet = new TreeSet<Song>();
		songTreeSet.addAll(songList);
		System.out.println(songTreeSet);
		
	}

	private void getSongs() {
		try {
			File file = new File("D:\\02_coding\\java_station\\hello-world-m2e\\src\\main\\java\\com\\jonny\\mvn\\collections\\SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
