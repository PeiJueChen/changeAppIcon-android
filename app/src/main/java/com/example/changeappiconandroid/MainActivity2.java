package com.example.changeappiconandroid;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.changeappiconandroid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //获取button按钮
        Button rrBtn = (Button) findViewById(R.id.rr_btn);
        //为button 按钮添加监听事件
        rrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switchRR();
            }
        });

        //获取button按钮
        Button txBtn = (Button) findViewById(R.id.tx_btn);
        //为button 按钮添加监听事件
        txBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switchTx();
            }
        });

        //获取button按钮
        Button mainBtn = (Button) findViewById(R.id.main_btn);
        //为button 按钮添加监听事件
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switchMain();
            }
        });
    }

//   可以的話, 可考慮 kill 瞬間再 switch
    private void switchRR() {
        Log.wtf("TEST", getComponentName().getClassName());

        ComponentName main = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.MainActivity2");
        ComponentName tx = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsTexasActivity");
        ComponentName rr = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsRRActivity");

        disableComponent(tx);
        disableComponent(main);
        enableComponent(rr);
    }

    //   可以的話, 可考慮 kill 瞬間再 switch
    private void switchTx() {
        Log.wtf("TEST", getComponentName().getClassName());

        ComponentName main = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.MainActivity2");
        ComponentName tx = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsTexasActivity");
        ComponentName rr = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsRRActivity");

        disableComponent(main);
        disableComponent(rr);
        enableComponent(tx);

    }

    //   可以的話, 可考慮 kill 瞬間再 switch
    private void switchMain() {
        Log.wtf("TEST", getComponentName().getClassName());

        ComponentName main = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.MainActivity2");
        ComponentName tx = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsTexasActivity");
        ComponentName rr = new ComponentName(getBaseContext(), "com.example.changeappiconandroid.newsRRActivity");

        disableComponent(tx);
        disableComponent(rr);
        enableComponent(main);
    }

    //启用组件
    public void enableComponent(ComponentName componentName){
        PackageManager mPackageManager = getPackageManager();
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
    }

    //隐藏组件
    public void disableComponent(ComponentName componentName){
        PackageManager mPackageManager = getPackageManager();
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}