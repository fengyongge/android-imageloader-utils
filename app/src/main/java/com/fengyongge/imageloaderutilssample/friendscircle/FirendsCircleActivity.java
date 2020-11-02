package com.fengyongge.imageloaderutilssample.friendscircle;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.fengyongge.imageloaderutilssample.R;
import com.fengyongge.imageloaderutilssample.bean.FriendBean;
import com.fengyongge.imageloaderutilssample.bean.PicBean;
import com.fengyongge.imageloaderutilssample.bean.ReplyBean;
import com.fengyongge.imageloaderutilssample.friendscircle.view.CustomImageView;
import com.fengyongge.imageloaderutilssample.friendscircle.view.NineGridlayout;
import com.zzti.fengyongge.imagepicker.PhotoPreviewActivity;
import com.zzti.fengyongge.imagepicker.model.PhotoModel;
import com.zzti.fengyongge.imagepicker.util.CommonUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FirendsCircleActivity extends AppCompatActivity {

    private EditText replyEdit;// 回复框
    private View sendBtn;// 发送按钮
    private View editView;
    private View stick_TV;
    PopupWindow editWindow;
    private InputMethodManager manager;
    private ReplyBean discuss_reply;
    private Boolean is_item = false;
    private ReplyBean item_reply;
    //
    private String userName;
    private FriendBean discuss_friend;
    private String owner_id;
    private List<FriendBean> list = new ArrayList<FriendBean>();

    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.topLayout)
    LinearLayout topLayout;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firends_circle);
        ButterKnife.bind(this);
        initeView();

        initPopWindow();
        adapter = new Adapter();
        lv.setAdapter(adapter);
        laodMore();
    }

    public void initeView(){
        userName = "张三";
    }

    public void laodMore(){
        FriendBean friendBean = new FriendBean();
        friendBean.setNick("张三");
        friendBean.setAdd_time("2016.09.08");
        List<PicBean> pic = new ArrayList<PicBean>();// 图片
        PicBean picBean = new PicBean();
        picBean.setImg_thumb("https://ws1.sinaimg.cn/large/610dc034ly1fgj7jho031j20u011itci.jpg?imageView2/0/w/100");
        pic.add(picBean);
        friendBean.setPic(pic);
        list.add(friendBean);


        FriendBean friendBean1 = new FriendBean();
        List<PicBean> pic1 = new ArrayList<PicBean>();// 图片
        for (int i = 0; i <2; i++) {
            PicBean picBean1 = new PicBean();
            picBean1.setImg_thumb("https://ws1.sinaimg.cn/large/610dc034ly1fga6auw8ycj20u00u00uw.jpg");
            pic1.add(picBean1);
        }
        friendBean1.setPic(pic1);
        list.add(friendBean1);


        FriendBean friendBean2 = new FriendBean();
        List<PicBean> pic2 = new ArrayList<PicBean>();
        for (int i = 0; i <2; i++) {
            PicBean picBean2 = new PicBean();
            picBean2.setImg_thumb("https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg");
            pic2.add(picBean2);
        }
        for (int i = 0; i <2; i++) {
            PicBean picBean3 = new PicBean();
            picBean3.setImg_thumb("https://ws1.sinaimg.cn/large/610dc034ly1fgi3vd6irmj20u011i439.jpg");
            pic2.add(picBean3);
        }
        friendBean2.setPic(pic2);
        list.add(friendBean2);


        FriendBean friendBean3 = new FriendBean();
        List<PicBean> pic3 = new ArrayList<PicBean>();
        for (int i = 0; i <9 ; i++) {
            PicBean picBean0 = new PicBean();
            picBean0.setImg_thumb("https://ws1.sinaimg.cn/large/d23c7564ly1fg7ow5jtl9j20pb0pb4gw.jpg");
            pic3.add(picBean0);
        }
        friendBean3.setPic(pic3);
        list.add(friendBean3);

        adapter.notifyDataSetChanged();
    }


    public class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int postion) {
            return list.get(postion);
        }

        @Override
        public long getItemId(int postion) {
            return postion;
        }

        @Override
        public View getView(final int positon, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(FirendsCircleActivity.this).inflate(R.layout.activity_firends_circle_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }


            if (listIsEmpty(list.get(positon).getPic())) {
                holder.ivNgridLayout.setVisibility(View.GONE);
                holder.ivOneimage.setVisibility(View.GONE);
            } else {

                if (list.get(positon).getPic().size() == 1) {

                    holder.ivOneimage.setTag(list.get(positon).getPic());
                    holder.ivOneimage.setVisibility(View.VISIBLE);
                    holder.ivNgridLayout.setVisibility(View.GONE);
                    holder.ivOneimage.setImageUrl(list.get(positon).getPic().get(0).getImg_thumb());

                    holder.ivOneimage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub

                            List<PhotoModel> single_photos = new ArrayList<PhotoModel>();
                            for (int i = 0; i < list.get(positon).getPic().size(); i++) {
                                PhotoModel photoModel = new PhotoModel();
                                photoModel.setOriginalPath(list.get(positon).getPic().get(0).getImg_thumb());
                                single_photos.add(photoModel);
                            }

                            Bundle bundle = new Bundle();
                            bundle.putSerializable("photos",(Serializable)single_photos);
                            bundle.putInt("position", 0);//position预览图片地址
                            bundle.putBoolean("isSave",true);//isSave表示是否可以保存预览图片，建议只有预览网络图片时设置true
                            CommonUtils.launchActivity(FirendsCircleActivity.this, PhotoPreviewActivity.class, bundle);

                        }
                    });
                } else {
                    holder.ivOneimage.setVisibility(View.GONE);
                    holder.ivNgridLayout.setVisibility(View.VISIBLE);
                    final ArrayList<PicBean> list1 = (ArrayList<PicBean>) list.get(positon).getPic();


                    List<PhotoModel> single_photos = new ArrayList<PhotoModel>();
                    for (int i = 0; i <list.get(positon).getPic().size() ; i++) {
                        PhotoModel photoModel = new PhotoModel();
                        photoModel.setOriginalPath(list.get(positon).getPic().get(i).getImg_thumb());
                        single_photos.add(photoModel);
                    }

                    holder.ivNgridLayout.setImagesData(single_photos, FirendsCircleActivity.this);
                }
            }

            holder.discussLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    is_item = false;

                    discuss_friend = list.get(positon);
//                    index = discuss_friend.getPosition();
                    discuss_reply = new ReplyBean();
                    showDiscuss("评论");
                }
            });

            holder.shareLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(FirendsCircleActivity.this,"去分享", Toast.LENGTH_SHORT).show();
                }
            });

            holder.carryLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            holder.likeLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


            return convertView;
        }


         class ViewHolder {
            @BindView(R.id.discuss_LL)
            LinearLayout discussLL;
             @BindView(R.id.share_LL)
             LinearLayout shareLL;
             @BindView(R.id.carry_LL)
             LinearLayout carryLL;
             @BindView(R.id.favuor_LL)
             LinearLayout favuorLL;
             @BindView(R.id.like_LL)
             LinearLayout likeLL;
             //
            @BindView(R.id.photo)
            CircleImageView photo;
            @BindView(R.id.iv_ngrid_layout)
            NineGridlayout ivNgridLayout;
            @BindView(R.id.iv_oneimage)
            CustomImageView ivOneimage;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }

    }


    private boolean listIsEmpty(List list) {
        if (list != null && list.size() > 0)
            return false;
        return true;

    }


    /**
     * 初始化popWindow
     */
    private void initPopWindow() {

        editView = LayoutInflater.from(FirendsCircleActivity.this).inflate(R.layout.friend__replay_input, null);
        editWindow = new PopupWindow(editView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        editWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        editWindow.setOutsideTouchable(true);

        replyEdit = (EditText) editView.findViewById(R.id.reply_ET);
        sendBtn = editView.findViewById(R.id.send_msg);
        stick_TV = editView.findViewById(R.id.stick_TV);

        sendBtn.setOnClickListener(new View.OnClickListener() {

            private FriendBean remove;
            @Override
            public void onClick(View arg0) {
                if (!TextUtils.isEmpty(replyEdit.getText().toString()
                        .trim())
                        && discuss_reply != null) {
                    String content = replyEdit.getText().toString().trim();
                    if (is_item) {
                        discuss_reply.setComment(content);

                        remove = list.remove(item_reply.getIndex());
                        remove.getComment_list().add(0, discuss_reply);
                        list.add(item_reply.getIndex(), remove);

                    } else {
                        discuss_reply.setComment(content);
                        discuss_reply.setComment_nick(userName);
                        discuss_reply.setType("0");
                        discuss_reply.setStory_id(discuss_friend.getId());
                        discuss_reply.setUser_id(owner_id);
                        remove = list.remove(discuss_friend.getPosition());
                        remove.getComment_list().add(0, discuss_reply);
                        if (!TextUtils.isEmpty(remove.getComment_total())) {
                            remove.setComment_total((Integer.parseInt(remove.getComment_total()) + 1) + "");
                        } else {
                            remove.setComment_total("1");
                        }
                        list.add(discuss_friend.getPosition(), remove);

                    }
//                    adpter.setData(list);
                    adapter.notifyDataSetChanged();
                    replyEdit.setText("");
                    editWindow.dismiss();
//                    addReply(discuss_reply);  //接口添加评论
                }
            }
        });



        replyEdit.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
//				stickWindow.showAtLocation(editView, Gravity.TOP, 0, 0);
                stick_TV.setVisibility(View.VISIBLE);
                return false;
            }
        });



        stick_TV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                stick_TV.setVisibility(View.GONE);
                try {
                    ClipboardManager clipboardManager = (ClipboardManager)FirendsCircleActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
//					clipboardManager.setPrimaryClip(ClipData.newPlainText(null, "内容"));
                    if (clipboardManager.hasPrimaryClip()){
                        CharSequence text = clipboardManager.getPrimaryClip().getItemAt(0).getText();
                        replyEdit.setText(text);
                        replyEdit.setSelection(text.length());
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
    }

    /**
     * 显示回复评论框
     * @param hint
     */
    @SuppressLint("WrongConstant")
    private void showDiscuss(String hint) {
        replyEdit.setFocusable(true);
        replyEdit.requestFocus();
        replyEdit.setHint(hint);
        // 设置焦点，不然无法弹出输入法
        editWindow.setFocusable(true);
        replyEdit.setSelectAllOnFocus(true);
        // 以下两句不能颠倒
        editWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        editWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        editWindow.showAtLocation(topLayout, Gravity.BOTTOM, 0, 0);
        // 显示键盘
        manager = (InputMethodManager) FirendsCircleActivity.this.getSystemService(
                FirendsCircleActivity.this.INPUT_METHOD_SERVICE);
        manager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        editWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                stick_TV.setVisibility(View.GONE);
                manager.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
            }
        });

    }




    }
