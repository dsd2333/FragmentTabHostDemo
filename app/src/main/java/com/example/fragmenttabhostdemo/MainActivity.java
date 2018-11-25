package com.example.fragmenttabhostdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.fragmenttabhostdemo.base.Tab;
import com.example.fragmenttabhostdemo.fragment.CartFragment;
import com.example.fragmenttabhostdemo.fragment.DiscoverFragment;
import com.example.fragmenttabhostdemo.fragment.HomeFragment;
import com.example.fragmenttabhostdemo.fragment.HotFragment;
import com.example.fragmenttabhostdemo.fragment.MineFragment;
import com.example.fragmenttabhostdemo.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//AppCompatActivity继承自FragmentActivity，因此直接继承自AppCompatActivity即可。
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;//读取布局所必须的。
    private List<Tab> mTabs = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }
    private void initTab(){
        Tab home = new Tab(R.drawable.selector_icon_home,R.string.home,HomeFragment.class);
        Tab hot = new Tab(R.drawable.selector_icon_hot,R.string.hot,HotFragment.class);
        Tab discover = new Tab(R.drawable.selector_icon_discover,R.string.discover,DiscoverFragment.class);
        Tab cart = new Tab(R.drawable.selector_icon_cart,R.string.cart,CartFragment.class);
        Tab mine = new Tab(R.drawable.selector_icon_mine,R.string.mine,MineFragment.class);
        mTabs.add(home);
        mTabs.add(hot);
        mTabs.add(discover);
        mTabs.add(cart);
        mTabs.add(mine);

        //初始化系统控件
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        mInflater = LayoutInflater.from(this);

        for (Tab tab : mTabs){
            /**由于tab.getTxt_indicator()返回的是一个int类型的id，在这里我们通过getString将其转
            换成字符串*/
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTxt_indicator()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec,tab.getFragment(),null);
        }
        //去掉分隔线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //默认在第一个
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab){

        View view = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView icon_tab = (ImageView) view.findViewById(R.id.icon_tab);
        TextView txt_indicator = (TextView) view.findViewById(R.id.txt_indicator);

        icon_tab.setBackgroundResource(tab.getIcon_tab());
        txt_indicator.setText(tab.getTxt_indicator());

        return view;
    }
}
