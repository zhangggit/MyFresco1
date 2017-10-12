package com.example.zhanggang.myfresco1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.simpleDraweeview)
    SimpleDraweeView simpleDraweeview;
    private String url = "http://img3.imgtn.bdimg.com/it/u=2633101039,1831028060&fm=214&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        /**
         * 两种方式
         * 第一种是  通过 RoundingParams 设置所需要的属性  用setRoundingParams(params)设置params属性
         * 第二种是  直接通过GenericDraweeHierarchyBuilder.set来设置所需要的属性
         */

        RoundingParams params = new RoundingParams();
//        params.setRoundAsCircle(true); //设置圆形图
//        params.setCornersRadius(30); //设置圆角图
//        params.setCornersRadii(new float[]{10,20,30,40,50,60,75,90});

        GenericDraweeHierarchy hierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources())
                .setFadeDuration(5000) //设置淡入淡出
//                .setRoundingParams(params)  //设置属性
//                .setRoundingParams(RoundingParams.asCircle())  //设置圆形图
//                .setRoundingParams(RoundingParams.fromCornersRadius(40))  //设置圆角图的度数
//                .setRoundingParams(RoundingParams.fromCornersRadii(20,20,30,30))  //设置圆角图及各个角的度数
                .setRoundingParams(RoundingParams.fromCornersRadii(new float[]{10,20,30,45,50,60,75,90}))  //设置一个数组 共有8个值
                .build();
        simpleDraweeview.setHierarchy(hierarchyBuilder);


        Uri uri = Uri.parse(url);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)  //访问图片路径
                .setTapToRetryEnabled(true)   //开启点击重试
                .setOldController(simpleDraweeview.getController())  //设置旧的Controller
                .build();

        simpleDraweeview.setController(draweeController);

    }


}
