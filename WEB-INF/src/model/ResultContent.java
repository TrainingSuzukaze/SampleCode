package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultContent implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int MAX_CONTENT = 4;

	private final int MAX_PAGE;
	private int page;
	private List<MusicBean> musicBeans;

	public ResultContent() {
		page = 0;
		MAX_PAGE = 0;
	}
	public ResultContent(List<MusicBean> musicBeans) {
		page = 0;
		this.musicBeans = musicBeans;
		MAX_PAGE = (int) Math.ceil(((double)musicBeans.size() / MAX_CONTENT)-1);
	}

	public List<MusicBean> getViewMusicBeans(){
		List<MusicBean> beans = new ArrayList<MusicBean>();
		for(int i = 0;i<MAX_CONTENT;i++) {
			if(musicBeans.size()-1 < page*MAX_CONTENT+i) {
				break;
			}
			beans.add(musicBeans.get(page*MAX_CONTENT+i));
		}
		return beans;
	}

	public void nextPage() {
		page++;
		if(page > MAX_PAGE) {
			page = MAX_PAGE;
		}
	}

	public void prevPage() {
		page--;
		if(page < 0) {
			page = 0;
		}
	}

	public int getPage() {
		return page;
	}
}
