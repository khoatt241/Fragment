package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gọi lại thằng quản lý, trong activity chỉ có duy nhất 1 thằng quản lý, ko được getsupport ở thời điểm khác
        fragmentManager = getSupportFragmentManager();
        btnAddFragment = findViewById(R.id.buttonAddFragment);
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thực thi những yêu cầu từ Activity ví dụ như thêm, xóa, sửa
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //Khởi tạo Fragment
                AndroidFragment androidFragment = new AndroidFragment();
                //khi xử dụng replace tất cả fragment bên trong sẽ bị đẩy ra hết chỉ còn duy nhất thằng mới vào
                fragmentTransaction.replace(R.id.frameContain, androidFragment);
                fragmentTransaction.commit();
                //kiểm tra số lượng fragment được thêm vào
                Log.d("BBB", fragmentManager.getFragments().size() + "");
            }
        });
    }
}
