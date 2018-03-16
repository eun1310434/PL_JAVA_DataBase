/*=====================================================================
�� Infomation
  �� Data : 15.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� ������ ����� ���� ��ɾ� ����
  
�� Study      
  �� DataBase
    - �����͸� �����ϱ� ���� ������� ���α׷� (Oracle, MS-AQL, MySAL, Postgres ��)
    - �����͸� �� ����(�Է�, ����, ����, �˻� ��) �Ϸ��� ���� ���� ���α׷�
    - ���ǹ�(Query) : �����ͺ��̽����� �����͸� ���� �� �� ����ϴ� ��ɹ�
    - �����ͺ��̽� ����
       01) �����ͺ��̽� ����
       02) show databases
       03) create database �����ͺ��̽���
       04) drop database �����ͺ��̽���
       05) use �����ͺ��̽���
    - ���̺� ����
       01) create table ���̺��(�ʵ�1 �ڷ���, �ʵ�2 �ڷ���, �ʵ�3 �ڷ���,...)
            : �ڹٿ� �ݴ��� ������ �ʵ� ����
       02) show tables
       03) desc ���̺��
    - �ڹ� �ڷ��� / MySql �ڷ���
       01) boolean / tinyint
       02) byte / tinyint
       03) char / char, varchar
       04) short / smallint
       05) int / int, integer
       06) long / bigint
       07) float / float
       08) double / double
       09) String / char(n), varchar(n), BLOB, text
       10) Date / date
       11) DateTime / datetime
       12) Timestamp / timestamp
       13) Time / time
    - ���ǹ�
      01) �Է� ���ǹ� 
            : insert into ���̺��̸� values (������1, ������2, ������3, ������4, ...)
      02) ���(�˻�) ���ǹ�
            : select * from ���̺��̸�
      03) ���� ���ǹ�
            : update ���̺��̸� set Ÿ��Ʋ1 = ��1, Ÿ��Ʋ2 = ��2, ...
      04) ���� ���ǹ�
            : delete from ���̺��̸�

  �� JDBC
    - Java DataBase Connectivity
    - �ڹٿ� �����ͺ��̽��� �����Ͽ� �������� ����, ����, ����, �˻����� �۾��� ����

  �� JDBC Driver
    - �ڹٿ� �����ͺ��̽��� �����ϱ� ���� ����̹� ���α׷�
    - JAVA MySQL Setting
      01) mysql-connector-java �ٿ�ޱ�
      02) C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext�� ���� �ٿ��ֱ�

  �� JDBC ���α׷� �ۼ� ���
      01) �ڹ��� JDBC API �������̽��� ������ ����̹� Ŭ������ ã�� ��ü�� �����Ѵ�.
      02) DBMS���� ������ �����ϴ� Connection ��ü�� �����Ѵ�.
      03) ���� �۾��� ó���ϴ� Statement, PreparedStatement, CallableStatement ��ü�� �����Ѵ�.
      04) ResultSet��ü�� ���� ���� ����� ȹ���ϰ� ó���Ѵ�.
      05) DBMS���� ������ �����Ѵ�.
    - URL
             �������� : ������������ : SID
      JDBC : MySQL : SID

  �� Ŀ�ؼ� ���丮
      - Client�� ��û�� Connection�� ������ ���� ���� �� ����
      - JDBC ���α׷��� �ۼ��ϸ鼭 �ݺ������� �ڵ带 �ۼ��ؾ� �ϴ� ����� ���ȭ�Ͽ� ������ �ڵ带 ��� �� �� �ֵ��� ����ϴ� ����(Pattern)

  �� Ŀ�ؼ� Ǯ
      - Client�� ��û�� ���� ������� Connection�� ����
      - DBC���� Ŀ�ؼ��� ������ �� �߻��ϴ� ���ϸ� ���̰��� �ѹ� ����� Ŀ�ؼ� ��ü�� �������� �ʰ� ������ �������� Ư�� ������ ���ᰴü�� �����ϴ� ���.

  �� ���� ������
      - JDBC��?
      - �����ͺ��̽���?
      - JDBC ���α׷��� �ۼ��ϴ� ������?
      - Ŀ�ؼ� ���丮�� Ŀ�ؼ� Ǯ�� �뵵��?
=====================================================================*/
package com.eun1310434.database.connectionfactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBGetData {
	
	public void getUserInfo(Connection connection, String user_sn){
		//01) �ڹ��� JDBC API �������̽��� ������ ����̹� Ŭ������ ã�� ��ü�� �����Ѵ�. �� DBConnectionFactory���� ó��
		//02) DBMS���� ������ �����ϴ� Connection ��ü ���� �� DBConnectionFactory���� ó��
		
		//Setting
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//03) ���� �۾��� ó���ϴ� Statement, PreparedStatement, CallableStatement ��ü ����
			String query = "select * from USER where user_sn = ?";
			preparedStatement = connection.prepareStatement(query); 
			preparedStatement.setString(1, user_sn);
			
			//04) ResultSet��ü�� ���� ���� ����� ȹ���ϰ� ó��
			resultSet = preparedStatement.executeQuery();

			//����� �ޱ�
			resultSet.next();
			String user_password = resultSet.getString("user_password");
			String user_phone = resultSet.getString("user_phone");
			String user_gcmaddress = resultSet.getString("user_gcmaddress");
			String system_sn = resultSet.getString("system_sn");
			String user_type = resultSet.getString("user_type");
			String user_name = resultSet.getString("user_name");
			String user_profile = resultSet.getString("user_profile");
			
			System.out.println("connection = " + connection);
			System.out.println("user_sn = " + user_sn);
			System.out.println("user_password = " + user_password);
			System.out.println("user_phone = " + user_phone);
			System.out.println("user_gcmaddress = " + user_gcmaddress);
			System.out.println("system_sn = " + system_sn);
			System.out.println("user_type = " + user_type);
			System.out.println("user_name = " + user_name);
			System.out.println("user_profile = " + user_profile);
			

			resultSet.close();

			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
