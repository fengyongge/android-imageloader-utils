package com.fengyongge.imageloaderutilssample.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 朋友信息bean
 * 
 * @author fengyongge
 * 
 */
public class FriendBean implements Serializable{

	private int position;
	private String id;
	private String owner_id;
	private String location;
	private String message; 
	private String photo;
	private String favorite_total;
	private String comment_total;
	private String share_total;
	private String add_time;
	private String nick;
	private String is_favorite;
	private String is_follow;
	private String product_total;
	private String url;
	private String reprint_photo;
	private String reprint_owner_id;//搬运的id
	private String reprint_name;//搬运的名字
	private String is_mystory;//1是原创   0不是原创
	private Boolean isMoreLook = false;


	private List<PicBean> pic = new ArrayList<PicBean>();// 图片
	private List<ReplyBean> comment_list = new ArrayList<ReplyBean>();// 回复信息
	private List<GoodsBean> product_list = new ArrayList<GoodsBean>();// 商品
	private List<FavoriteBean> favorite_list = new ArrayList<FavoriteBean>();// 点赞
	private List<TagBean> tag = new ArrayList<TagBean>();// 标签
	private Share_info share_info;


	public Share_info getShare_info() {
		return share_info;
	}
	public void setShare_info(Share_info share_info) {
		this.share_info = share_info;
	}

	private String product_id;
	private String num;
	private String has_invoice;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getHas_invoice() {
		return has_invoice;
	}
	public void setHas_invoice(String has_invoice) {
		this.has_invoice = has_invoice;
	}

	public String getReprint_photo() {
		return reprint_photo;
	}
	public void setReprint_photo(String reprint_photo) {
		this.reprint_photo = reprint_photo;
	}
	
	public String getIs_mystory() {
		return is_mystory;
	}
	public void setIs_mystory(String is_mystory) {
		this.is_mystory = is_mystory;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getReprint_owner_id() {
		return reprint_owner_id;
	}
	public void setReprint_owner_id(String reprint_owner_id) {
		this.reprint_owner_id = reprint_owner_id;
	}
	public String getReprint_name() {
		return reprint_name;
	}
	public void setReprint_name(String reprint_name) {
		this.reprint_name = reprint_name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getFavorite_total() {
		return favorite_total;
	}
	public void setFavorite_total(String favorite_total) {
		this.favorite_total = favorite_total;
	}
	public String getComment_total() {
		return comment_total;
	}
	public void setComment_total(String comment_total) {
		this.comment_total = comment_total;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIs_follow() {
		return is_follow;
	}
	public void setIs_follow(String is_follow) {
		this.is_follow = is_follow;
	}
	public String getShare_total() {
		return share_total;
	}
	public void setShare_total(String share_total) {
		this.share_total = share_total;
	}
	public List<PicBean> getPic() {
		return pic;
	}
	public void setPic(List<PicBean> pic) {
		this.pic.clear();
		this.pic.addAll(pic);
	}
	
	
	public List<ReplyBean> getComment_list() {
		return comment_list;
	}
	public void setComment_list(List<ReplyBean> comment_list) {
		this.comment_list.clear();
		this.comment_list.addAll(comment_list);
	}
	public List<FavoriteBean> getFavorite_list() {
		return favorite_list;
	}
	public void setFavorite_list(List<FavoriteBean> favorite_list) {
		this.favorite_list.clear();
		this.favorite_list.addAll(favorite_list);
	}
	public List<TagBean> getTag() {
		return tag;
	}
	public void setTag(List<TagBean> tag) {
		this.tag.clear();
		this.tag.addAll(tag);
	}
	public String getProduct_total() {
		return product_total;
	}
	public void setProduct_total(String product_total) {
		this.product_total = product_total;
	}
	public List<GoodsBean> getProduct_list() {
		return product_list;
	}
	public void setProduct_list(List<GoodsBean> product_list) {
		this.product_list.clear();
		this.product_list.addAll(product_list);
	}
	public String getIs_favorite() {
		return is_favorite;
	}
	public void setIs_favorite(String is_favorite) {
		this.is_favorite = is_favorite;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getIsMoreLook() {
		return isMoreLook;
	}
	public void setIsMoreLook(Boolean isMoreLook) {
		this.isMoreLook = isMoreLook;
	}
	
	
}
