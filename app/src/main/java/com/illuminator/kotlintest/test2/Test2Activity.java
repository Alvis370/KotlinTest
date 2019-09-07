package com.illuminator.kotlintest.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.illuminator.kotlintest.R;
import com.illuminator.kotlintest.test2.adapter.TestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class Test2Activity extends AppCompatActivity {

    private List<String> mImageUrls = new ArrayList<>();
    private List<String> mNames = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Timber.plant(new Timber.DebugTree());

        initNotification();

        initList();

        initRecyclerView();
    }

    private void initNotification(){
        // 获取系统 通知管理 服务
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 构建 Notification
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("ContentTitle")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Content Text Here");

        // 兼容  API 26，Android 8.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // 第三个参数表示通知的重要程度，默认则只在通知栏闪烁一下
            NotificationChannel notificationChannel = new NotificationChannel("AppTestNotificationId", "AppTestNotificationName", NotificationManager.IMPORTANCE_DEFAULT);
            // 注册通道，注册后除非卸载再安装否则不改变
            notificationManager.createNotificationChannel(notificationChannel);
            builder.setChannelId("AppTestNotificationId");
        }
        // 发出通知
        notificationManager.notify(1, builder.build());
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview_test);
        TestRecyclerViewAdapter adapter = new TestRecyclerViewAdapter(this, mImageUrls, mNames, descriptions);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initList(){
        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");
        descriptions.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");
        descriptions.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");
        descriptions.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");
        descriptions.add("Rocky Mountain National Park");

        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");
        descriptions.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");
        descriptions.add("Frozen Lake");

        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");
        descriptions.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");
        descriptions.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");
        descriptions.add("Washington");
    }
}
