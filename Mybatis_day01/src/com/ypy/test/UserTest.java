package com.ypy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ypy.model.UserModel;

public class UserTest {

	@Test
	public void testQuery() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		user.setUsername("%改");
		user.setPassword("111");
		List<UserModel> list = session.selectList("com.ypy.model.UserModel.query", user);
		for (UserModel userModel : list) {
			System.out.println(userModel);
		}
		session.close();
	}
	
	/**
	 * 有优先级的查询
	 * @throws IOException
	 */
	@Test
	public void testQuery1() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		user.setUsername("%改");
		user.setPassword("111");
		List<UserModel> list = session.selectList("com.ypy.model.UserModel.query1", user);
		for (UserModel userModel : list) {
			System.out.println(userModel);
		}
		session.close();
	}
	
	/**
	 * in条件查询
	 * @throws IOException
	 */
	@Test
	public void testQuery2() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(24);
		idList.add(25);
		idList.add(26);
		user.setIdList(idList);
		List<UserModel> list = session.selectList("com.ypy.model.UserModel.query2", user);
		for (UserModel userModel : list) {
			System.out.println(userModel);
		}
		session.close();
	}
	
	/**
	 * 查询别名，用resultMap
	 * @throws IOException
	 */
	@Test
	public void testQuery3() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		List<UserModel> list = session.selectList("com.ypy.model.UserModel.query3", user);
		for (UserModel userModel : list) {
			System.out.println(userModel);
		}
		session.close();
	}
	
	@Test
	public void queryById() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = session.selectOne("com.ypy.model.UserModel.queryById", 1);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void save() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		user.setUsername("哈哈哈");
		user.setPassword("111");
		//添加事务
		try {
			session.insert("com.ypy.model.UserModel.save",user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void update() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		UserModel user = new UserModel();
		user.setUserid(25);
		user.setUsername("修改");
		user.setPassword("111");
		//添加事务
		try {
			session.update("com.ypy.model.UserModel.update",user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void delete() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		//添加事务
		try {
			session.delete("com.ypy.model.UserModel.delete", 23);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

}
