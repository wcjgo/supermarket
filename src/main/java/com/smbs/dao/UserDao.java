package com.smbs.dao;

import com.smbs.pojo.SuperUser;
import com.smbs.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WCJ
 * @Description
 **/
public class UserDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<SuperUser> selectAllUser() {
        List<SuperUser> UserList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from SuperUsers order by Userid";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperUser u = new SuperUser();
                u.setUserId(resultSet.getString("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setAddress(resultSet.getString("address"));
                u.setPhone(resultSet.getString("phone"));
                u.setRole(resultSet.getInt("role"));
                u.setuBirthday(resultSet.getDate("ubirthday"));
                UserList.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return UserList;
    }

    /**
     * 根据id查询用户
     * @param userid
     * @return
     */
    public SuperUser selectById(String userid) {
        SuperUser u = new SuperUser();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superusers where  userid = ?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,userid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                u.setPhone(resultSet.getString("phone"));
                u.setUsername(resultSet.getString("username"));
                u.setUserId(userid);
                u.setPassword(resultSet.getString("password"));
                u.setAddress(resultSet.getString("address"));
                u.setRole(resultSet.getInt("role"));
                u.setuBirthday(resultSet.getDate("ubirthday"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return u;
    }

    /**
     * 根据用户名模糊查询用户
     * @param username
     * @return
     */
    public List<SuperUser> selectLike(String username) {
        List<SuperUser> UserList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superusers where  username like ?";
            ps =conn.prepareStatement(sql);
            ps.setString(1, "%" + username + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperUser u = new SuperUser();
                u.setUserId(resultSet.getString("userid"));
                u.setUsername(resultSet.getString("username"));
                u.setAddress(resultSet.getString("address"));
                u.setPhone(resultSet.getString("phone"));
                u.setRole(resultSet.getInt("role"));
                u.setuBirthday(resultSet.getDate("ubirthday"));
                UserList.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return UserList;
    }

    /**
     * 添加用户
     * @param u
     * @return
     */
    public Boolean addUser(SuperUser u) {
        boolean flag = true;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "insert into superusers(userid,username,password,phone,address,ubirthday,role) values(?,?,?,?,?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setString(1,u.getUserId());
            ps.setString(2,u.getUsername());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getPhone());
            ps.setString(5,u.getAddress());
            ps.setDate(6,new Date(u.getuBirthday().getTime()));
            ps.setInt(7,u.getRole());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return flag;
    }


    /**
     * 修改用户信息
     * @param u
     */
    public void updateUser(SuperUser u) {
        Connection conn = null;
        PreparedStatement ps = null;
        //获取连接
        try{
            conn = JdbcUtil.getConnection();
            String sql = "update superusers set  username=?,phone=?,address=? ,ubirthday=?,role=? where userid=?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPhone());
            ps.setString(3,u.getAddress());
            ps.setDate(4,new Date(u.getuBirthday().getTime()));
            ps.setInt(5,u.getRole());
            ps.setString(6,u.getUserId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }

    /**
     * 根据id删除用户
     * @param uid
     */
    public void deleteUser(String uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from superUsers where Userid = ?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,uid);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }
}
