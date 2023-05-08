package model;

import java.io.Serializable;

public class MusicBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String artist;
	public MusicBean(String name,String artist) {
		this.name = name;
		this.artist = artist;
	}

	public String toString() {
		return name + " "+ artist;
	}
}
