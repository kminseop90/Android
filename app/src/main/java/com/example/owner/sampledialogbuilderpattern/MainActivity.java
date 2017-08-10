package com.example.owner.sampledialogbuilderpattern;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private DialogCommon dialogCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        dialogCommon = new DialogCommon.Builder(MainActivity.this, DialogCommon.ButtonType.TWO_BTN).title("title").message("message")
                .positiveButton("positive", new DialogCommon.DialogListener() {
                    @Override
                    public void onClickListener(DialogCommon dialogCommon) {
                        showToast("Positive");
                    }
                })
                .negativeButton("negative", new DialogCommon.DialogListener() {
                    @Override
                    public void onClickListener(DialogCommon dialogCommon) {
                        showToast("Negative");
                    }
                }).build();
        dialogCommon.show();
    }

    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
