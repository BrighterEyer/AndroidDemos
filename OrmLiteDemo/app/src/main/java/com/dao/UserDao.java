package com.dao;

import android.content.Context;

import com.bean.User;
import com.j256.ormlite.dao.Dao;
import com.utils.DatabaseHelper;

import java.sql.SQLException;

/**
 * Created by bluedragon on 18-1-31.
 */

public class UserDao {
    private Context context;
    private Dao<User, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加一个用户
     *
     * @param user
     */
    public void add(User user) {
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User get(int id) {
        try {
            return userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
