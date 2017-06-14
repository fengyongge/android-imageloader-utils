package com.fengyongge.friendscircle.bean;

import java.io.Serializable;

public class GoodsBean implements Serializable{

	private static final long serialVersionUID = 1391252858477862390L;

	private String name;
	private String des;
	private String oldm;
	private String newm;
	private String picUrl;
	private String photo;
	private String background;
	private String nick;
	private String motto;
	private String sex;
	private String fans_total;
	private String follow_total;
	private String story_total;
	private String user_id;
	private String merchant_id;
	private String is_follow;
	private String url;
	private String shop_url;
	private String shop_logo;
	private String shop_desc;
	private String shop_name;
	private String product_pic;
	private String selling_price;
	private String market_price;
	private String sp_discount_tpl_product_id;
	private String product_id;
	private String product_name;
	private String product_price;
	private String product_img;
	private String product_url;
	private String num;
	
	
	//添加属性为了客户的订单里面product使用
	private String pic_path;
	private String id;
	private String sku_id;
	private String product_type;
	private String is_auto_card;
	private String guarantee_period;
	private String brand_id;
	private String price;
	private String stock_num;
	private String full_msg;
	private String pic_url;
	private int width;
	

	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}

	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	public String getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(String selling_price) {
		this.selling_price = selling_price;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getSp_discount_tpl_product_id() {
		return sp_discount_tpl_product_id;
	}
	public void setSp_discount_tpl_product_id(String sp_discount_tpl_product_id) {
		this.sp_discount_tpl_product_id = sp_discount_tpl_product_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	
	

    
	public String getShop_logo() {
		return shop_logo;
	}

	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_desc() {
		return shop_desc;
	}

	public void setShop_desc(String shop_desc) {
		this.shop_desc = shop_desc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFans_total() {
		return fans_total;
	}

	public void setFans_total(String fans_total) {
		this.fans_total = fans_total;
	}

	public String getFollow_total() {
		return follow_total;
	}

	public void setFollow_total(String follow_total) {
		this.follow_total = follow_total;
	}

	public String getStory_total() {
		return story_total;
	}

	public void setStory_total(String story_total) {
		this.story_total = story_total;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getIs_follow() {
		return is_follow;
	}

	public void setIs_follow(String is_follow) {
		this.is_follow = is_follow;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShop_url() {
		return shop_url;
	}

	public void setShop_url(String shop_url) {
		this.shop_url = shop_url;
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getOldm() {
		return oldm;
	}
	public void setOldm(String oldm) {
		this.oldm = oldm;
	}
	public String getNewm() {
		return newm;
	}
	public void setNewm(String newm) {
		this.newm = newm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku_id() {
		return sku_id;
	}
	public void setSku_id(String sku_id) {
		this.sku_id = sku_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getIs_auto_card() {
		return is_auto_card;
	}
	public void setIs_auto_card(String is_auto_card) {
		this.is_auto_card = is_auto_card;
	}
	public String getGuarantee_period() {
		return guarantee_period;
	}
	public void setGuarantee_period(String guarantee_period) {
		this.guarantee_period = guarantee_period;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock_num() {
		return stock_num;
	}
	public void setStock_num(String stock_num) {
		this.stock_num = stock_num;
	}
	public String getFull_msg() {
		return full_msg;
	}
	public void setFull_msg(String full_msg) {
		this.full_msg = full_msg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
	
	
	
	
}
