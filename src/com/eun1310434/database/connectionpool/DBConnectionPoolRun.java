/*=====================================================================
�� Infomation
  �� Data : 15.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� �ý����� ����κ�
  �� �����ϴ� Client �׽�Ʈ
  
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
package com.eun1310434.database.connectionpool;

public class DBConnectionPoolRun {
	public static void main(String[] ar) {
		DBConnectionPool pool = new DBConnectionPool();
		for(int i = 0; i < 10; ++i) {
			new RandomClient(pool,i).start();
		}
	}
}
