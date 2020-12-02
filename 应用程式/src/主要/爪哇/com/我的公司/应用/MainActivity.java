package com.mycompany.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	Button btn;
	ImageView image ; 
	@Override
	public void onClick(View p1) {
		switch(p1.getId()){
		//实现弹弹弹的自定义动画
			case R.id.button:
				image=findViewById(R.id.image);

				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
																   R.anim.bounce);
                image.startAnimation(animation);
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle(" 标题🌹")
					.setIcon(R.drawable.a)
					.setMessage("*❤️❤️ -> ")
					.setCancelable(false)
					.setPositiveButton("确定", null);
				AlertDialog alertDialog=builder.create();
				//获取Diloag所在的Window
				Window window = alertDialog.getWindow();
				//为Window设置动画
				//设置Dialog透明度
                                //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				window.setWindowAnimations(R.style.mDialog);
				/*
				wml设置弹窗透明度等，因为dialog是window实现
				*/
				WindowManager.LayoutParams wml=window.getAttributes();
				wml.alpha=0.9f;
				wml.mayUseInputMethod(wml.SOFT_INPUT_ADJUST_NOTHING);
				//显示Dialog
				alertDialog.show();
		}
	}

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar=findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
        btn=findViewById(R.id.button);
		btn.setOnClickListener(this);
		
    }
    
}
