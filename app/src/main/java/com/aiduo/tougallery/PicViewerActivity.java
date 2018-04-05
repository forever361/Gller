package com.aiduo.tougallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**Simple TouchGallery demo based on ViewPager and Photoview.
 * Created by Trojx on 2016/1/3.
 */
public class PicViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_indicator;
    private ArrayList<String> urlList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/////////////////////隐藏标题栏和状态栏////////////////////
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        Window window = getWindow();
        window.setFlags(flag, flag);
/////////////////////隐藏标题栏和状态栏////////////////////
        setContentView(R.layout.activity_pic_viewer);


        String [] urls={"http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_0.jpg",
                "http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_1.jpg",
                "http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_2.jpg",
                "http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_3.jpg",
                "http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_4.jpg",
                "http://7xla0x.com1.z0.glb.clouddn.com/picJarvanIV_5.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/0.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/1.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/2.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/3.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/4.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/5.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/6.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/7.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/8.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/9.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/10.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/11.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/playboy/314/12.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/0.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/1.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/2.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/3.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/4.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/5.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/6.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/7.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/8.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/9.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/10.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/11.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/12.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/13.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/14.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/15.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/16.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/17.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/18.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/19.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/20.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/21.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/22.jpg",
                "http://tuigirl-1254818389.cosbj.myqcloud.com/picture/aiss/195/23.jpg",
        };

        urlList = new ArrayList<>();
        Collections.addAll(urlList, urls);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_indicator = (TextView) findViewById(R.id.tv_indicator);

        viewPager.setAdapter(new PictureSlidePagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                tv_indicator.setText(String.valueOf(position+1)+"/"+urlList.size());
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private  class PictureSlidePagerAdapter extends FragmentStatePagerAdapter{

        public PictureSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PictureSlideFragment.newInstance(urlList.get(position));
        }

        @Override
        public int getCount() {
            return urlList.size();
        }
    }
}
