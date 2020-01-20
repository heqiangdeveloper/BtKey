package com.chinatsp.btkey.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chinatsp.btkey.BaseDialogFragment;
import com.chinatsp.btkey.BaseFragment;
import com.chinatsp.btkey.MainActivity;
import com.chinatsp.btkey.R;
import com.chinatsp.btkey.connect.ConnectFragment;
import com.chinatsp.btkey.utils.ActivityUtils;

/**
 * Created by Administrator on 2020/1/16.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    private ImageView closeIv;
    private ImageView openIv;
    private ImageView alarmIv;
    private ImageView lightIv;
    private ImageView userLogoIv;
    private BaseDialogFragment mFragment;
    private Button exitBt;
    private Context mContext;

    public static HomeFragment newInstance(String dataList, String answer) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("list", dataList);
        bundle.putString("data", answer);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        closeIv = (ImageView) view.findViewById(R.id.close_iv);
        openIv = (ImageView) view.findViewById(R.id.open_iv);
        alarmIv = (ImageView) view.findViewById(R.id.alarm_iv);
        lightIv = (ImageView) view.findViewById(R.id.light_iv);
        userLogoIv = (ImageView) view.findViewById(R.id.user_logo_iv);
        exitBt = (Button) view.findViewById(R.id.exit_bt);
        closeIv.setOnClickListener(this);
        openIv.setOnClickListener(this);
        alarmIv.setOnClickListener(this);
        lightIv.setOnClickListener(this);
        userLogoIv.setOnClickListener(this);
        exitBt.setOnClickListener(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.exit_bt){
            ((MainActivity)mContext).finish();
            //((MainActivity)(view.getContext())).finish();
            return;
        }
        switch (view.getId()){
            case R.id.close_iv:
                mFragment = HomeDialogFragment.newInstance(R.mipmap.close, "锁闭");
                break;
            case R.id.open_iv:
                mFragment = HomeDialogFragment.newInstance(R.mipmap.open, "解锁");
                break;
            case R.id.alarm_iv:
                mFragment = HomeDialogFragment.newInstance(R.mipmap.alarm, "鸣笛");
                break;
            case R.id.light_iv:
                mFragment = HomeDialogFragment.newInstance(R.mipmap.light, "大灯");
                break;
            case R.id.user_logo_iv:
                mFragment = HomeDialogFragment.newInstance(R.mipmap.warning, "钥匙失效");
                break;
        }
        mFragment.show(getFragmentManager(),"");
    }

}
