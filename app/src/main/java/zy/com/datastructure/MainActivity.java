package zy.com.datastructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sort)
    Button sort;
    @BindView(R.id.insert)
    Button insert;
    private List<User> list = new ArrayList<>();

    private String TAG1 = "TAG1";
    private String TAG2 = "TAG2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        long startTime = System.currentTimeMillis();   //获取开始时间
//        long endTime = System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： " + (startTime - endTime) + "ms");
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10000; i++) {
            String time = String.valueOf(System.currentTimeMillis());
            String name = "张" + i;
            list.add(new User(time, name));
        }
    }

    @OnClick(R.id.sort)
    public void onSortClicked() {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Collections.sort(list, new TimeComparator()); // 根据时间排序
        long endTime = System.currentTimeMillis(); //获取结束时间
        Log.i(TAG1, "Sort程序运行时间： " + (startTime - endTime) + "ms");
        System.out.println("按时间排序:");
//        myprint(list);
    }

    // 自定义方法：分行打印输出list中的元素
    public void myprint(List<User> list) {
        Iterator it = list.iterator(); // 得到迭代器，用于遍历list中的所有元素
        while (it.hasNext()) {// 如果迭代器中有元素，则返回true
            System.out.println("\t" + it.next());// 显示该元素
        }
    }

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        long startTime = System.currentTimeMillis();   //获取开始时间
        list.add(new User(String.valueOf(System.currentTimeMillis()), "李四"));
        Collections.sort(list, new TimeComparator()); // 根据时间排序
        long endTime = System.currentTimeMillis(); //获取结束时间
        Log.i(TAG1, "Insert And Sort程序运行时间： " + (startTime - endTime) + "ms");
        System.out.println("按时间排序:");
        myprint(list);
    }

    // 自定义比较器：按书的价格排序
    static class PriceComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            User p1 = (User) object1; // 强制转换
            User p2 = (User) object2;
            return Long.valueOf(p1.time).compareTo(Long.valueOf(p1.time));
        }
    }

    // 自定义比较器：按书的价格排序
    static class TimeComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            User p1 = (User) object1; // 强制转换
            User p2 = (User) object2;
            return (p1.time).compareTo(p1.time);
        }
    }


    // 自定义比较器：按书的价格排序
    static class NameComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            User p1 = (User) object1; // 强制转换
            User p2 = (User) object2;
            return p1.name.compareTo(p2.name);
        }
    }
}
