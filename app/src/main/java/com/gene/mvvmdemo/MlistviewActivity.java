package com.gene.mvvmdemo;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gene.mvvmdemo.views.AutoScrollListView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class MlistviewActivity extends AppCompatActivity {
    AutoScrollListView listView;
    Handler handler = new Handler();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlistview);
        listView = (AutoScrollListView) findViewById(R.id.lv);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        TimeCompare();
        listView.smoothScrollToPosition(5);
        // listView.setSelection(5);


       /* listView.post(new Runnable() {
            @Override
            public void run() {
                listView.requestPositionToScreen(5,false);
            }
        });*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            data.add("测试数据---------------->" + i);
        }
        return data;
    }


    private boolean TimeCompare() {
        //格式化时间
        boolean sta = false;
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        Log.e("TAG", "sta--00000000------>" + curDate.getTime());
        long date1 = 1483405200000L;           //"2017-01-27 19:00:00";
        long date2 = 1486083600000L;    //"2017-02-03 09:00:00";


        //判断是否大于两天
        if ((curDate.getTime() - date1) >= 0 && (curDate.getTime() - date2) < 0) {
            sta = true;
            Log.e("TAG", "curDate-------->" + curDate.getTime() + "------>" + (curDate.getTime() - date2));
        } else {
            sta = false;
            Log.e("TAG", "0000curDate-------->" + curDate.getTime() + "------>" + (curDate.getTime() - date2));
        }


        Log.e("TAG", "sta-------->" + curDate.getTime() + "------>" + sta);
        return sta;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Mlistview Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.gene.mvvmdemo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Mlistview Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.gene.mvvmdemo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
