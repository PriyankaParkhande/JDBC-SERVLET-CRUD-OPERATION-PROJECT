package org.productRepository;

import java.sql.*;
import java.util.List;

import java.util.*;

import org.productApp.ProductDataAdd;

public class Repository {
	private Connection conn;
	private List list;
	private PreparedStatement stmt;
	private ResultSet rs;

	public Repository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priya", "root", "Priya@3010");

		} catch (Exception ex) {
			System.out.println("error is: " + ex);
		}
	}

	public boolean isAddProduct(ProductDataAdd p) throws SQLException {
		try {
			stmt = conn.prepareStatement("insert into product values('0',?,?,?)");
			stmt.setString(1, p.getPname());
			stmt.setInt(2, p.getPprice());
			stmt.setString(3, p.getCname());

			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("error is: " + ex);
			return false;
		}

	}

	public List<ProductDataAdd> getAllProducts() {
		try {
			list = new ArrayList<ProductDataAdd>();
			stmt = conn.prepareStatement("select *from product");
			rs = stmt.executeQuery();
			while (rs.next()) {
				ProductDataAdd p = new ProductDataAdd();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getInt("pprice"));
				p.setCname(rs.getString("cname"));
				list.add(p);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("error is:" + ex);
			return null;
		}

	}

	public boolean isDeleteProduct(int prodid) {
		try {
			stmt = conn.prepareStatement("delete from product where pid=?");
			stmt.setInt(1, prodid);
			int value = stmt.executeUpdate();
			if (value < 0) {
				return true;
			} else {
				return false;

			}
		} catch (Exception ex) {
			System.out.println("error is: " + ex);
			return false;
		}

	}

	public boolean isFinalUpdate(ProductDataAdd p) {

		try {

			stmt = conn.prepareStatement("update product SET pname=? , pprice=?,cname=? WHERE pid=?");
			stmt.setString(1, p.getPname());
			stmt.setInt(2, p.getPprice());
			stmt.setString(3, p.getCname());
			stmt.setInt(4, p.getPid());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("error is:" + ex);
			return false;
		}

	}
}
