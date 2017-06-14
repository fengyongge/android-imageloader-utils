package com.fengyongge.friendscircle.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;

/**
 * 图片实体类
 * 
 * @author jiangyue
 * 
 */
public class PicBean implements Serializable {

	private  String pic_path;
	private  ContentResolver contentResolve;
	private  String  photoID;
	private  String  thumbnails;
	private  String  img = "";
	private  String  img_thumb = "";
	
	
	//新个人主页
//	  private String img;
//	  private String img_thumb;
	
	//个人主页
	private  String  id;
	private  String  path;
	private  String  path_thumb;
	
	
	private int position;
	private int widthOffset;
	
	
	private List<PicBean> paths = new ArrayList<PicBean>();
	
	

	public String getPic_path() {
		return pic_path;
	}

	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}

	public ContentResolver getContentResolve() {
		return contentResolve;
	}

	public void setContentResolve(ContentResolver contentResolve) {
		this.contentResolve = contentResolve;
	}

	public String getPhotoID() {
		return photoID;
	}

	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg_thumb() {
		return img_thumb;
	}

	public void setImg_thumb(String img_thumb) {
		this.img_thumb = img_thumb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath_thumb() {
		return path_thumb;
	}

	public void setPath_thumb(String path_thumb) {
		this.path_thumb = path_thumb;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<PicBean> getPaths() {
		return paths;
	}

	public void setPaths(List<PicBean> paths) {
		this.paths.clear();
		this.paths = paths;
	}

	public int getWidthOffset() {
		return widthOffset;
	}

	public void setWidthOffset(int widthOffset) {
		this.widthOffset = widthOffset;
	}
	
	

	
	

	
	
}
