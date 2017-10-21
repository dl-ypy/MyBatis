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

import com.ypy.model.DepartMentModel;
import com.ypy.model.UserModel;

public class UserTest {

	/**
	 * 测试一对一
	 * @throws IOException
	 */
	@Test
	public void testOne2One() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapper.queryOne2One");
		for (UserModel userModel : list) {
			System.out.println(userModel.getUsername()+","+userModel.getDept().getDid()+","+userModel.getDept().getDname());
		}
		session.close();
	}
	
	/**
	 * 测试多对一
	 * @throws IOException
	 */
	@Test
	public void testOne2Many() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		List<DepartMentModel> list = session.selectList("com.ypy.model.DepartMentMapper.queryOne2Many");
		for (DepartMentModel dept : list) {
			System.out.println(dept.getDname()+","+dept.getList().size());
		}
		session.close();
	}
	
	/**
	 * 测试延迟加载
	 * @throws IOException
	 */
	@Test
	public void testLazy() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
//			System.out.println(user.getDept().getDname());  如果不搜索部门的信息时，对应的sql语句就不会执行，说明进行了延迟加载
		}
		session.close();
	}
	
	/**
	 * 测试缓存
	 * @throws IOException
	 */
	@Test
	public void testCache() throws IOException {
		//1.加载配置文件
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取session
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		
		System.out.println("--------------一级缓存--------------");
		list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		session.close();
		
		System.out.println("-----------------一级缓存清空，二级缓存-----------------");
		session = factory.openSession();
		list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		session.close();
	}
}
