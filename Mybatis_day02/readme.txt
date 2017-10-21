表关联

一对一：
	在UserMapper.xml中配置的员工对部门的关系
多对一：
	在DepartMentMapper.xml中配置部门对员工的关系
多对多：
	配置成双向的多对一


延迟加载
	需要先在MyBatis-confg.xml中配置：
	<settings>
		<!-- 开启延时加载 -->
		<setting name="lazyLoadingEnabled" value="true"/>
		<setting name="aggressiveLazyLoading" value="false"/>
	</settings>
	
	在UserMapperLazy.xml中配置
	
	
缓存
	一级缓存：session级别的
	二级缓存：
		先导入jar包：ehcache-1.2.3.jar、mybatis-ehcache-1.0.3.jar
		在对应的mapper.xml文件中配置cache标签
		注：在增删改做了commit操作后，缓存数据就会被清空。
