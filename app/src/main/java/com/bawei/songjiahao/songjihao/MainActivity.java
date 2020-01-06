package com.bawei.songjiahao.songjihao;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjihao.base.BaseActivity;
import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.entity.RightEntity;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;
import com.bawei.songjiahao.songjihao.model.Model;
import com.bawei.songjiahao.songjihao.presenter.Presenter;
import com.bawei.songjiahao.songjihao.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements INewsContract.IView {

    @BindView(R.id.rv_left)
    RecyclerView rvLeft;
    @BindView(R.id.rv_right)
    RecyclerView rvRight;
    private Presenter presenter;


    protected void initView() {
        presenter = new Presenter(this);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        rvLeft.setLayoutManager(new LinearLayoutManager(this));
        rvRight.setLayoutManager(new GridLayoutManager(this,2));

        if (RetrofitUtils.getInstance().HasNet(this)){
            presenter.getShop();
        }
        else{
            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }




    protected void initData() {

    }


    @Override
    public void success(Object obj) {
        if (obj instanceof ShopEntity){
            List<String> category = ((ShopEntity) obj).getCategory();
            LeftAdapter leftAdapter = new LeftAdapter(this, category);
            rvLeft.setAdapter(leftAdapter);
            leftAdapter.setLeftCallBack(new LeftAdapter.LeftCallBack() {
                @Override
                public void getLeft(String name) {
                    EventBus.getDefault().post(name);
                }
            });
        }else if (obj instanceof RightEntity){
            List<RightEntity.DataBean> data = ((RightEntity) obj).getData();
            RightAdapter rightAdapter = new RightAdapter(this, data);
            rvRight.setAdapter(rightAdapter);
        }
    }

    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getname(String name){
        HashMap<String, String> params = new HashMap<>();
        params.put("category",name);
        presenter.getRight(params);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

}
