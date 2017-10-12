package com.lsw.demo.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RightFragment mRightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
//        mRightFragment = new RightFragment();
//        replaceFragment(mRightFragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                //1.如果mRightFragment是动态加载，replace后在回到fragment,在文本框输入的内容，在用户Back的时候不见了
                //2.如果mRightFragment是静态加载，replace后在回到fragment,在文本框输入的内容，在用户Back的时候内容可以看见
                replaceFragment(new AnotherRightFragment());
//                hideFragment(mRightFragment,new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 替换Fragment
     * @param replaceFragment
     */
    private void replaceFragment(Fragment replaceFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, replaceFragment);
        transaction.addToBackStack(null);//加入回退栈只会销毁View组件，不会销毁fragment
        transaction.commit();
    }

    /**
     * 隐藏添加Fragment
     * @param hidefragment
     * @param addFragment
     */
    public void hideFragment(Fragment hidefragment,Fragment addFragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(hidefragment);
        transaction.add(R.id.right_layout, addFragment);
        transaction.addToBackStack(null);//加入回退栈只会销毁View组件，不会销毁fragment
        transaction.commit();
    }

}
