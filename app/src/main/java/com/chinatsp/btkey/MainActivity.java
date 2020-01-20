package com.chinatsp.btkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chinatsp.btkey.authen.AuthenDialogFragment;
import com.chinatsp.btkey.authen.AuthenFragment;
import com.chinatsp.btkey.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {
    private BaseFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        //检查是否获得授权
        //checkAuthen();
    }

    public void initFragment(){
        mFragment = AuthenFragment.newInstance("", "");
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.framelayout_content);
    }

}
