package com.fengyongge.friendscircle.bean;

import java.io.Serializable;

/**
 * 回复bean
 * @author fengyongge
 */
public class ReplyBean implements Serializable{
	
	
	private String id;
	private String user_id;
	private String story_id;
	private String type;//评论人
	private String comment_id;// 被评论人  为空则评论话题.
	private String new_reply_id;// 被评论人  为空则评论话题.
	private String comment;// 回复内容
	private String add_time;// 评论时间
	private String comment_nick;// 评论人名称

	private String comment_at_nick;// 被评论人名称
	private String comment_at_user_id;
	private String portrait;
	private String del_type;
	private String comment_photo;// 评论人头像
	private String user_nick;// 评论人头像
	private String user_photo;// 评论人头像
	private int position;
	private int index;

	
	 
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getComment_nick() {
		return comment_nick;
	}
	public void setComment_nick(String comment_nick) {
		this.comment_nick = comment_nick;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getComment_photo() {
		return comment_photo;
	}
	public void setComment_photo(String comment_photo) {
		this.comment_photo = comment_photo;
	}
	
	public String getNew_reply_id() {
		return new_reply_id;
	}
	public void setNew_reply_id(String new_reply_id) {
		this.new_reply_id = new_reply_id;
	}
	public String getComment_at_nick() {
		return comment_at_nick;
	}
	public void setComment_at_nick(String comment_at_nick) {
		this.comment_at_nick = comment_at_nick;
	}
	public String getComment_at_user_id() {
		return comment_at_user_id;
	}
	public void setComment_at_user_id(String comment_at_user_id) {
		this.comment_at_user_id = comment_at_user_id;
	}
	public String getStory_id() {
		return story_id;
	}
	public void setStory_id(String story_id) {
		this.story_id = story_id;
	}
	public String getDel_type() {
		return del_type;
	}
	public void setDel_type(String del_type) {
		this.del_type = del_type;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	


}
