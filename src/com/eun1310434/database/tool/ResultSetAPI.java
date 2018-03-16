/*=====================================================================
�� Infomation
  �� Data : 15.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� ResultSet�� Ȱ���� ��� �� ���
  �� JDBC ���α׷� �ۼ� ���
      01) �ڹ��� JDBC API �������̽��� ������ ����̹� Ŭ������ ã�� ��ü�� �����Ѵ�.
      02) DBMS���� ������ �����ϴ� Connection ��ü�� �����Ѵ�.
      03) ���� �۾��� ó���ϴ� Statement, PreparedStatement, CallableStatement ��ü�� �����Ѵ�.
      04) ResultSet��ü�� ���� ���� ����� ȹ���ϰ� ó���Ѵ�.
      05) DBMS���� ������ �����Ѵ�.
    - URL
             �������� : ������������ : SID
      JDBC : MySQL : SID

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
package com.eun1310434.database.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetAPI {
	public static void main(String[] ar) {
		//01) �ڹ��� JDBC API �������̽��� ������ ����̹� Ŭ������ ã�� ��ü�� �����Ѵ�.
		try {
			//Class Ŭ������ ���� Referenced Libraries �� com.mysql.jdbc �� DriverŬ������ Ȯ��
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver Search Complete");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver Search Fail");
		}

		//Setting
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		//URL - �������� : ������������ : SID 
		//      jdbc  : mysql   : SID
		//MySQL�� default port�� 3306
		String url = "jdbc:mysql://localhost:3306/ssm_server";
		String user = "root";
		String password = "*******";
try {
	//02) DBMS���� ������ �����ϴ� Connection ��ü ����
	connection = DriverManager.getConnection(url, user, password);
	System.out.println("Connection Complete");
	
	//03) ���� �۾��� ó���ϴ� Statement, PreparedStatement, CallableStatement ��ü ����
	//Statement�� Static query�� �ۼ��ϴ� ������ ���
	statement = connection.createStatement();
	
	System.out.println("Create Statement");
	//Statement : static query
	
	String query = "select * from USER";
	resultSet = statement.executeQuery(query);

	//����� �ޱ�
	while(resultSet.next()) {
		String user_sn = resultSet.getString("user_sn");
		String user_password = resultSet.getString("user_password");
		String user_phone = resultSet.getString("user_phone");
		String user_gcmaddress = resultSet.getString("user_gcmaddress");
		String system_sn = resultSet.getString("system_sn");
		String user_type = resultSet.getString("user_type");
		String user_name = resultSet.getString("user_name");
		String user_profile = resultSet.getString("user_profile");

		System.out.println("===============================================================");
		System.out.println("user_sn = " + user_sn);
		System.out.println("user_password = " + user_password);
		System.out.println("user_phone = " + user_phone);
		System.out.println("user_gcmaddress = " + user_gcmaddress);
		System.out.println("system_sn = " + system_sn);
		System.out.println("user_type = " + user_type);
		System.out.println("user_name = " + user_name);
		System.out.println("user_profile = " + user_profile);
	}
	
	resultSet.close();
	statement.close();
	connection.close();
} catch (SQLException e) {
	e.printStackTrace();
}
	}
}
