�����

һ��һ��
	��UserMapper.xml�����õ�Ա���Բ��ŵĹ�ϵ
���һ��
	��DepartMentMapper.xml�����ò��Ŷ�Ա���Ĺ�ϵ
��Զࣺ
	���ó�˫��Ķ��һ


�ӳټ���
	��Ҫ����MyBatis-confg.xml�����ã�
	<settings>
		<!-- ������ʱ���� -->
		<setting name="lazyLoadingEnabled" value="true"/>
		<setting name="aggressiveLazyLoading" value="false"/>
	</settings>
	
	��UserMapperLazy.xml������
	
	
����
	һ�����棺session�����
	�������棺
		�ȵ���jar����ehcache-1.2.3.jar��mybatis-ehcache-1.0.3.jar
		�ڶ�Ӧ��mapper.xml�ļ�������cache��ǩ
		ע������ɾ������commit�����󣬻������ݾͻᱻ��ա�
