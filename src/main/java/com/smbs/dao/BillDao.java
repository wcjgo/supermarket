package com.smbs.dao;

import com.smbs.pojo.SuperBill;
import com.smbs.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WCJ
 * @Description
 **/
public class BillDao {
    /**
     * 添加账单
     * @param b
     * @return
     */
    public Boolean addBill(SuperBill b) {
        boolean flag = true;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "insert into superbill(productName,productDesc," +
                    "productcount,totalprice,isPayment,providerid,creator,createtime) values(?,?,?,?,?,?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setString(1,b.getProductName());
            ps.setString(2,b.getProductDesc());
            ps.setInt(3,b.getProductCount());
            ps.setDouble(4,b.getTotalPrice());
            ps.setInt(5,b.getIsPayment());
            ps.setInt(6,b.getProviderId());
            ps.setString(7,b.getCreator());
            ps.setString(8,b.getCreateTime());
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
     * 根据id查询订单
     * @param bid
     * @return
     */
    public SuperBill selectById(int bid) {
        SuperBill bill = new SuperBill();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superbill where  billid = ?";
            ps =conn.prepareStatement(sql);
            ps.setInt(1,bid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                bill.setBillId(bid);
                bill.setProductName(resultSet.getString("productname"));
                bill.setProductCount(resultSet.getInt("productcount"));
                bill.setProductDesc(resultSet.getString("productdesc"));
                bill.setProviderId(resultSet.getInt("providerid"));
                bill.setIsPayment(resultSet.getInt("ispayment"));
                bill.setTotalPrice(resultSet.getDouble("totalprice"));
                bill.setCreator(resultSet.getString("creator"));
                bill.setCreateTime(resultSet.getString("createtime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return bill;
    }

    /**
     * 查询所有订单
     * @return
     */
    public List<SuperBill> selectAllBill() {
        List<SuperBill> billList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superbill order by billid";
            ps =conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperBill sb = new SuperBill();
                sb.setProductName(resultSet.getString("productName"));
                sb.setBillId(resultSet.getInt("billid"));
                sb.setProductDesc(resultSet.getString("ProductDesc"));
                sb.setProductCount(resultSet.getInt("ProductCount"));
                sb.setTotalPrice(resultSet.getDouble("totalPrice"));
                sb.setIsPayment(resultSet.getInt("isPayment"));
                sb.setProviderId(resultSet.getInt("providerId"));
                sb.setCreator(resultSet.getString("creator"));
                sb.setCreateTime(resultSet.getString("createTime"));
                billList.add(sb);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return billList;
    }


    /**
     * 模糊查询所有订单
     * @return
     */
    public List<SuperBill> selectLike(String name,int pay) {
        List<SuperBill> billList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from superbill where productName like ? and isPayment= ? order by billid";
            ps =conn.prepareStatement(sql);
            ps.setString(1,"%" + name + "%");
            ps.setInt(2,pay);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SuperBill sb = new SuperBill();
                sb.setProductName(resultSet.getString("productName"));
                sb.setProductDesc(resultSet.getString("ProductDesc"));
                sb.setProductCount(resultSet.getInt("ProductCount"));
                sb.setTotalPrice(resultSet.getDouble("totalPrice"));
                sb.setIsPayment(resultSet.getInt("isPayment"));
                sb.setProviderId(resultSet.getInt("providerId"));
                sb.setCreator(resultSet.getString("creator"));
                sb.setCreateTime(resultSet.getString("createTime"));
                billList.add(sb);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return billList;
    }


    /**
     * 修改订单信息
     * @param b
     */
    public void updateBill(SuperBill b) {
        Connection conn = null;
        PreparedStatement ps = null;
        //获取连接
        try{
            conn = JdbcUtil.getConnection();
            String sql = "update superbill set productName=?,ProductDesc=?,ProductCount=?,totalPrice=? ,isPayment=?,providerId=? where billid=?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,b.getProductName());
            ps.setString(2,b.getProductDesc());
            ps.setInt(3,b.getProductCount());
            ps.setDouble(4,b.getTotalPrice());
            ps.setInt(5,b.getIsPayment());
            ps.setInt(6,b.getProviderId());
            ps.setInt(7,b.getBillId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }

    /**
     * 根据id删除供应商
     * @param bid
     */
    public void deleteBill(String bid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from superbill where billid = ?";
            ps =conn.prepareStatement(sql);
            ps.setString(1,bid);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
    }
}
