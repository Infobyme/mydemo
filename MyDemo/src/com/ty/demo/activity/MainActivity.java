package com.ty.demo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ty.demo.R;
import com.ty.demo.utils.CommonUtil;

public class MainActivity extends Activity {


    private List<String> demoList;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        initData();
        initView();

        String deid = getDeviceInfo(this);
        Log.v("TAG", deid + "");
    }

    private void initData() {
        // TODO Auto-generated method stub

        demoList = new ArrayList<String>();
        demoList.add("FragmentTagHost");
        demoList.add("SortCity");
        demoList.add("CustomView");
        demoList.add("Barrage");
        demoList.add("AsyncTaskError");
        demoList.add("IntentService");
        demoList.add("PractiveService");
        demoList.add("ProgressBar");
        demoList.add("PropertyAnimation");
        demoList.add("RecyclerViewActivity");
        demoList.add("AidlActivity");
        demoList.add("SingleInstanceActivity");
        demoList.add("SqliteActivity");

    }

    private void initView() {
        // TODO Auto-generated method stub
        mListView = (ListView) findViewById(R.id.main_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_item_text, demoList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String type = demoList.get(position);
                if (type.equals("FragmentTagHost")) {
                    CommonUtil.toClazz(MainActivity.this, FramentTagHostActivity.class);
                } else if (type.equals("SortCity")) {
                    CommonUtil.toClazz(MainActivity.this, CitySeleorActivity.class);
                } else if (type.equals("CustomView")) {
                    CommonUtil.toClazz(MainActivity.this, CustomViewActivity.class);
                } else if (type.equals("Barrage")) {
                    CommonUtil.toClazz(MainActivity.this, BarrageActivity.class);
                } else if (type.equals("AsyncTaskError")) {
                    CommonUtil.toClazz(MainActivity.this, AnsyTaskActivity.class);
                } else if (type.equals("IntentService")) {
                    CommonUtil.toClazz(MainActivity.this, IntnetServerActivity.class);
                } else if (type.equals("PractiveService")) {
                    CommonUtil.toClazz(MainActivity.this, PracticeServiceActivity.class);
                } else if (type.equals("ProgressBar")) {
                    CommonUtil.toClazz(MainActivity.this, ProgressBarActivity.class);
                } else if (type.equals("PropertyAnimation")) {
                    CommonUtil.toClazz(MainActivity.this, PropertyAnimationActivity.class);
                } else if (type.equals("RecyclerViewActivity")) {
                    CommonUtil.toClazz(MainActivity.this, RecyclerViewActivity.class);
                } else if (type.equals("AidlActivity")) {
                    CommonUtil.toClazz(MainActivity.this, AidlActivity.class);
                } else if (type.equals("SingleInstanceActivity")) {
                    CommonUtil.toClazz(MainActivity.this, SingleInstanceActivity.class);
                } else if (type.equals("SqliteActivity")) {
                    CommonUtil.toClazz(MainActivity.this, SqliteActivity.class);
                }

            }
        });
    }


    public static String getDeviceInfo(Context context) {
        try {
            org.json.JSONObject json = new org.json.JSONObject();
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            String device_id = tm.getDeviceId();

            Log.v("TAG", device_id);
            android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);

            String mac = wifi.getConnectionInfo().getMacAddress();
            json.put("mac", mac);

            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }

            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            }

            json.put("device_id", device_id);

            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
