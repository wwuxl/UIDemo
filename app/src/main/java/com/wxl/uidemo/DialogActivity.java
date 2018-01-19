package com.wxl.uidemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wxl.uidemo.databinding.ActivityDialogBinding;

/**
 * @author wuxiulin
 * @date Creation time 2018/1/19 10:41
 * @description 自定义dialog界面
 */
public class DialogActivity extends AppCompatActivity {

    private ActivityDialogBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dialog);
        mBinding.setPresenter(new Presenter());


    }

    /**
     * 系统弹窗
     */
    private void systemDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("标题")
                .setMessage("系统弹窗")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 自定义View 弹窗
     */
    private void customDialog1() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.view_custom_dialog);
        Button btnCancel = (Button) window.findViewById(R.id.btn_cancel);
        Button btnOk = (Button) window.findViewById(R.id.btn_ok);
        TextView tvDetails = (TextView) window.findViewById(R.id.tv_details);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

    }

    //底部透明对话框
    private void bottomDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.view_bottom_dialog, null);
        //自定义背景主题
        Dialog dialog = new Dialog(this, R.style.BottomDialog);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        //对话框的View设置为全透明
        //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置对话框在底部(此处不需要)
        window.setGravity(Gravity.BOTTOM);
        //设置宽度填满屏幕
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.width = getResources().getDisplayMetrics().widthPixels; // 宽度
        window.setAttributes(params);

        dialog.setCanceledOnTouchOutside(true);
        //外部点击不关闭
        //dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }

    public class Presenter {
        public void dialog1(View view) {
            systemDialog();
        }

        public void dialog2(View view) {
            customDialog1();
        }

        public void dialog3(View view) {
            bottomDialog();
        }

        public void dialog4(View view) {

        }

    }
}
