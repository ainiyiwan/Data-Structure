package zy.com.datastructure;

/**
 * ================================================
 * 作    者：Luffy（张阳）
 * 版    本：1.0
 * 创建日期：2018/5/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class User {

    public String time;
    public String name;

    public User(String time, String name) {
        this.time = time;
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
