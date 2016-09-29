package com.lqs.fast.gamestore;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

            // 这里content的设置采用了布局文件中的view


        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);

        tabHost.addTab(tabHost.newTabSpec("tab1")
                    .setIndicator("tab1 indicator").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab2")
                    .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3")
                    .setContent(R.id.view3));

        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(null,drawable)
                .setContent(R.id.view2));




    }

}
