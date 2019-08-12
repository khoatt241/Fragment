package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddFragmentAndroid, btnAddFragmentPhp;
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gọi lại thằng quản lý, trong activity chỉ có duy nhất 1 thằng quản lý, ko được getsupport ở thời điểm khác
        //fragmentManager = getSupportFragmentManager();
        btnAddFragmentAndroid = findViewById(R.id.buttonAddFragmentAndroid);
        btnAddFragmentPhp = findViewById(R.id.buttonAddFragmentPhp);
//        btnAddFragmentAndroid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //thực thi những yêu cầu từ Activity ví dụ như thêm, xóa, sửa
//                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                //Khởi tạo Fragment
//                AndroidFragment androidFragment = new AndroidFragment();
//                //khi xử dụng replace tất cả fragment bên trong sẽ bị đẩy ra hết chỉ còn duy nhất thằng mới vào
//                //fragmentTransaction.replace(R.id.frameContain, androidFragment);
//                fragmentTransaction.add(R.id.frameContain, androidFragment);
//                fragmentTransaction.commit();
//                //kiểm tra số lượng fragment được thêm vào
//                Log.d("BBB", fragmentManager.getFragments().size() + "");
//            }
//        });
//
//        btnAddFragmentPhp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PhpFragment phpFragment = new PhpFragment();
//                fragmentTransaction.add(R.id.frameContain, phpFragment);
//                fragmentTransaction.commit();
//            }
//        });
        btnAddFragmentAndroid.setOnClickListener(this);
        btnAddFragmentPhp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.buttonAddFragmentAndroid:
                fragment = new AndroidFragment();
                //Chỉ làm trong trường hợp fragment chưa tồn tại lần nào trong Activity
                Bundle bundle = new Bundle();
                bundle.putString("text", "Hello Khoa");
                fragment.setArguments(bundle);
                break;
            case R.id.buttonAddFragmentPhp:
                fragment = new PhpFragment();
                break;
        }
        fragmentTransaction.add(R.id.frameContain, fragment);
        fragmentTransaction.commit();
    }
}
