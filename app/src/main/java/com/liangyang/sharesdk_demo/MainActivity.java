package com.liangyang.sharesdk_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * ShareSDK开发代码
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void share(View view) {
        showShare();
    }

    /**
     * 在代码中调用此方法，即可打开一键分享功能进行分享
     */
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("ShareSDK_Demo—我的GitHub博客");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("https://github.com/JerryAlexLiang");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("生活是一杯不加糖的espresso.");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.webshare.mob.com/dimgs/1c950a7b02087bf41bc56f07f7d3572c11dfcf36.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("https://github.com/JerryAlexLiang");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("GitHub");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("https://github.com/JerryAlexLiang");

        // 启动分享GUI
        oks.show(this);
    }
}
