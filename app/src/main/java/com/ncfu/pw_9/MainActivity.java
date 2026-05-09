package com.ncfu.pw_9;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvMenuText;

    private int topMargin = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMenuText = findViewById(R.id.tvMenuText);

        registerForContextMenu(tvMenuText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_small_text) {
            tvMenuText.setTextSize(18);
            Toast.makeText(this, "Выбран маленький размер текста", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_medium_text) {
            tvMenuText.setTextSize(24);
            Toast.makeText(this, "Выбран средний размер текста", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_large_text) {
            tvMenuText.setTextSize(32);
            Toast.makeText(this, "Выбран большой размер текста", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.tvMenuText) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
            menu.setHeaderTitle("Действия с текстом");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.context_move_up) {
            moveTextUp();
            Toast.makeText(this, "Текст перемещён выше", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.context_move_down) {
            moveTextDown();
            Toast.makeText(this, "Текст перемещён ниже", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    private void moveTextUp() {
        topMargin -= 50;

        if (topMargin < 0) {
            topMargin = 0;
        }

        updateTextMargin();
    }

    private void moveTextDown() {
        topMargin += 50;

        if (topMargin > 600) {
            topMargin = 600;
        }

        updateTextMargin();
    }

    private void updateTextMargin() {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) tvMenuText.getLayoutParams();
        params.topMargin = topMargin;
        tvMenuText.setLayoutParams(params);
    }
}