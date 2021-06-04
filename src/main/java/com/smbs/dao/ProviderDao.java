package com.smbs.dao;

import com.smbs.pojo.SuperProvider;
import com.smbs.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WCJ
 * @Description 供应商
 **/
public class ProviderDao {
    /**
     * 添加供应商
     * @param p
     * @return
     */
    public Boolean addProvider(SuperProvider p) {
        boolean flag = true;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "insert into superproviders(providername,providerdesc,providertel," +
                    "provideraddress,creator,createtime) values(?,?,?,?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setString(1,p.getProviderName());
            ps.setString(2,p.getProviderDesc());
            ps.setString(3,p.getProviderTel());
            ps.setString(4,p.getProviderAddress());
            ps.setString(5,p.getCreator());
            ps.setString(6,p.getCreateTime());
            ps.executeUpdate()
            ;
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }finally {
            JdbcUtil.close(ps,conn);
        }

        return flag;
    }

    /**
     * 根据id查询供应商
     * @param pid
     * @return
     */
    public SuperProvider selectById(String pid) {
        SuperProvider p = new SuperProvider();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superproviders where  providerid = ?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,pid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                p.setProviderId(Integer.parseInt(pid));
                p.setProviderName(resultSet.getString("providername"));
                p.setProviderDesc(resultSet.getString("providerdesc"));
                p.setProviderTel(resultSet.getString("providertel"));
                p.setProviderAddress(resultSet.getString("provideraddress"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return p;
    }

    /**
     * 查询所有供应商
     * @return
     */
    public List<SuperProvider> selectAllProvider() {
        List<SuperProvider> providerList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superproviders order by providerid";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperProvider sp = new SuperProvider();
                sp.setProviderId(resultSet.getInt("providerid"));
                sp.setProviderName(resultSet.getString("providername"));
                sp.setProviderDesc(resultSet.getString("providerdesc"));
                sp.setProviderAddress(resultSet.getString("provideraddress"));
                sp.setProviderTel(resultSet.getString("providertel"));
                sp.setCreator(resultSet.getString("creator"));
                sp.setCreateTime(resultSet.getString("createtime"));
                providerList.add(sp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return providerList;
    }


    /**
     * 模糊查询所有供应商
     * @return
     */
    public List<SuperProvider> selectLike(String name,String desc) {
        List<SuperProvider> providerList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superproviders where providername like ? and providerdesc like ? order by providerid";
            ps =conn.prepareStatement(sql);
            ps.setString(1,"%" + name + "%");
            ps.setString(2,"%" + desc + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperProvider sp = new SuperProvider();
                sp.setProviderId(resultSet.getInt("providerid"));
                sp.setProviderName(resultSet.getString("providername"));
                sp.setProviderDesc(resultSet.getString("providerdesc"));
                sp.setProviderAddress(resultSet.getString("provideraddress"));
                sp.setProviderTel(resultSet.getString("providertel"));
                sp.setCreator(resultSet.getString("creator"));
                sp.setCreateTime(resultSet.getString("createtime"));
                providerList.add(sp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return providerList;
    }

    /**
     * 修改供应商信息
     * @param p
     */
    public void updateProvider(SuperProvider p) {
        Connection conn = null;
        PreparedStatement ps = null;

        //获取连接
        try{
            conn = JdbcUtil.getConnection();
            String sql = "update superproviders set providername = ? ,providerdesc=?,providertel=?,provideraddress=? where providerid=?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,p.getProviderName());
            ps.setString(2,p.getProviderDesc());
            ps.setString(3,p.getProviderTel());
            ps.setString(4,p.getProviderAddress());
            ps.setInt(5,p.getProviderId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }

    /**
     * 根据id删除供应商
     * @param pid
     */
    public void deleteProvider(String pid) {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from superproviders where providerid = ?";
            ps =conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(pid));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }
}
