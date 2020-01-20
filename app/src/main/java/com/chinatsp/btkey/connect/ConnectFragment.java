package com.chinatsp.btkey.connect;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chinatsp.btkey.BaseFragment;
import com.chinatsp.btkey.R;
import com.chinatsp.btkey.authen.AuthenDialogFragment;
import com.chinatsp.btkey.home.HomeFragment;
import com.chinatsp.btkey.utils.ActivityUtils;

/**
 * Created by Administrator on 2020/1/16.
 */

public class ConnectFragment extends BaseFragment implements View.OnClickListener{
    private BaseFragment mFragment;
    public AnimationDrawable animationDrawable;
    private ImageView btConnectIv;

    public static ConnectFragment newInstance(String dataList, String answer) {
        ConnectFragment fragment = new ConnectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("list", dataList);
        bundle.putString("data", answer);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1000:
                    //跳转至主页
                    mFragment = HomeFragment.newInstance("", "");
                    ActivityUtils.replaceFragmentToActivity(getFragmentManager(), mFragment, R.id.framelayout_content);
                    break;
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Message msg = new Message();
        msg.what = 1000;
        mHandler.sendMessageDelayed(msg,7000);
    }

    @Override
    protected void initData() {
        initAnimationResource();
    }

    @Override
    protected void initView(View view) {
        btConnectIv = (ImageView) view.findViewById(R.id.bt_connect_iv);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_connect;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    public void initAnimationResource(){
        btConnectIv.setImageResource(R.drawable.bt_connect_animation);
        animationDrawable = (AnimationDrawable) btConnectIv.getDrawable();
        animationDrawable.start();
    }

}
