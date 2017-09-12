package cn.itcast.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.dao.UserDao2;
import cn.itcast.pojo.User;

public class MyBatisTest {
	@Test
	public void test1() throws Exception {
		SqlSession sqlsession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlsession = sqlSessionFactory.openSession();
			//System.out.println(sqlsession);测试
			//===========================查询=========================================
			//User userInfo = sqlsession.selectOne("user.selectUserById", 1002);//一条记录
			//List<User> list = sqlsession.selectList("user.selectUserByUsername", "小");//多条记录
			//int count = sqlsession.selectOne("user.countUserRecord");
			//===========================插入=========================================
//            User user = new User();
//            user.setName("奶茶妹");
//            user.setAge(18);
//            user.setSex("女");
//            user.setMobile("15910796136");
//            user.setAddress("北京市朝阳区");
//            int insert = sqlsession.insert("user.insertUser",user);
//			  System.out.println(insert);
//			  sqlsession.commit();
			//===========================修改=========================================
//			  User user = new User();
//			  user.setUserId(1011);
//			  user.setName("悠悠妹");
//			  user.setAge(17);
//			  user.setSex("女");
//			  user.setMobile("18787879898");
//			  user.setAddress("深圳");
//			  int update = sqlsession.update("user.updateUser", user);
//			  System.out.println(update);
//			  sqlsession.commit();
			//===========================删除=========================================
			  int delete = sqlsession.delete("user.deleteUser",1011);
			  System.out.println(delete);
			  sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.rollback();
		} finally {
			sqlsession.close();
		}
	}
	//===========================动态代理=========================================
			@Test
			public void test2() throws Exception{
				//读取配置文件
				InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
				//根据配置文件创建会话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//根据回话工厂创建会话对象
				SqlSession sqlsession = sqlSessionFactory.openSession();
				//用getmapper自动取得接口的实现类
				UserDao2 userDao2 = sqlsession.getMapper(UserDao2.class);
				//根据id查询 
				//User userinfo = userDao2.selectUserById(1010);
				//根据姓名查询
				List<User> info = userDao2.selectUserByUsername("春");
				System.out.println(info);
				sqlsession.close();
			}
}
