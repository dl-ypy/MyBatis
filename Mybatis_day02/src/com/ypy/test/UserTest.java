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
	 * ����һ��һ
	 * @throws IOException
	 */
	@Test
	public void testOne2One() throws IOException {
		//1.���������ļ�
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.��ȡSqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.��ȡsession
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapper.queryOne2One");
		for (UserModel userModel : list) {
			System.out.println(userModel.getUsername()+","+userModel.getDept().getDid()+","+userModel.getDept().getDname());
		}
		session.close();
	}
	
	/**
	 * ���Զ��һ
	 * @throws IOException
	 */
	@Test
	public void testOne2Many() throws IOException {
		//1.���������ļ�
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.��ȡSqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.��ȡsession
		SqlSession session = factory.openSession();
		List<DepartMentModel> list = session.selectList("com.ypy.model.DepartMentMapper.queryOne2Many");
		for (DepartMentModel dept : list) {
			System.out.println(dept.getDname()+","+dept.getList().size());
		}
		session.close();
	}
	
	/**
	 * �����ӳټ���
	 * @throws IOException
	 */
	@Test
	public void testLazy() throws IOException {
		//1.���������ļ�
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.��ȡSqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.��ȡsession
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
//			System.out.println(user.getDept().getDname());  ������������ŵ���Ϣʱ����Ӧ��sql���Ͳ���ִ�У�˵���������ӳټ���
		}
		session.close();
	}
	
	/**
	 * ���Ի���
	 * @throws IOException
	 */
	@Test
	public void testCache() throws IOException {
		//1.���������ļ�
		InputStream in = Resources.getResourceAsStream("MyBatis-config.xml");
		//2.��ȡSqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.��ȡsession
		SqlSession session = factory.openSession();
		List<UserModel> list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		
		System.out.println("--------------һ������--------------");
		list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		session.close();
		
		System.out.println("-----------------һ��������գ���������-----------------");
		session = factory.openSession();
		list = session.selectList("com.ypy.model.UserMapperLazy.queryOne");
		for (UserModel user : list) {
			System.out.println(user.getUsername());
		}
		session.close();
	}
}
