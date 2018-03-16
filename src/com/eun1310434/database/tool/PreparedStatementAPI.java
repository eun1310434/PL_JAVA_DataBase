/*=====================================================================
□ Infomation
  ○ Data : 15.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ 동적으로 쿼리를 작성으로 결과 출력
	- PreparedStatement preparedStatement3 = null;
    - PreparedStatement : dynamical query

□ Study      
  ○ DataBase
    - 데이터를 관리하기 위해 만들어진 프로그램 (Oracle, MS-AQL, MySAL, Postgres 등)
    - 데이터를 잘 관리(입력, 수정, 삭제, 검색 등) 하려고 만든 서버 프로그램
    - 질의문(Query) : 데이터베이스에서 데이터를 관리 할 때 사용하는 명령문
    - 데이터베이스 생성
       01) 데이터베이스 접속
       02) show databases
       03) create database 데이터베이스명
       04) drop database 데이터베이스명
       05) use 데이터베이스명
    - 테이블 생성
       01) create table 테이블명(필드1 자료형, 필드2 자료형, 필드3 자료형,...)
            : 자바와 반대의 순서로 필드 선언
       02) show tables
       03) desc 테이블명
    - 자바 자료형 / MySql 자료형
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
    - 질의문
      01) 입력 질의문 
            : insert into 테이블이름 values (데이터1, 데이터2, 데이터3, 데이터4, ...)
      02) 출력(검색) 질의문
            : select * from 테이블이름
      03) 수정 질의문
            : update 테이블이름 set 타이틀1 = 값1, 타이틀2 = 값2, ...
      04) 삭제 질의문
            : delete from 테이블이름

  ○ JDBC
    - Java DataBase Connectivity
    - 자바와 데이터베이스를 연결하여 데이터의 저장, 수정, 삭제, 검색등의 작업을 지원

  ○ JDBC Driver
    - 자바와 데이터베이스를 연결하기 위한 드라이버 프로그램
    - JAVA MySQL Setting
      01) mysql-connector-java 다운받기
      02) C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext에 파일 붙여넣기

  ○ JDBC 프로그램 작성 방법
      01) 자바의 JDBC API 인터페이스를 구현한 드라이버 클래스를 찾아 객체를 생성한다.
      02) DBMS와의 연결을 관리하는 Connection 객체를 생성한다.
      03) 질의 작업을 처리하는 Statement, PreparedStatement, CallableStatement 객체를 생성한다.
      04) ResultSet객체를 통해 질의 결과를 획득하고 처리한다.
      05) DBMS와의 연결을 종료한다.
    - URL
             프로토콜 : 서브프로토콜 : SID
      JDBC : MySQL : SID

  ○ 커넥션 팩토리
      - Client가 요청시 Connection을 각각에 맞춰 생성 후 종료
      - JDBC 프로그램을 작성하면서 반복적으로 코드를 작성해야 하는 블록을 모듈화하여 동일한 코드를 찍어 낼 수 있도록 사용하는 패턴(Pattern)

  ○ 커넥션 풀
      - Client가 요청시 기존 사용중인 Connection을 재사용
      - DBC와의 커넥션을 생성할 때 발생하는 부하를 줄이고자 한번 사용한 커넥션 객체를 삭제하지 않고 적절한 수준으로 특정 영역에 연결객체를 관리하는 모듈.

  ○ 라운드 마무리
      - JDBC란?
      - 데이터베이스란?
      - JDBC 프로그램을 작성하는 순서는?
      - 커넥션 팩토리와 커넥션 풀의 용도는?
=====================================================================*/
package com.eun1310434.database.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class PreparedStatementAPI {
	public static void main(String[] ar) {
		

		//01) 자바의 JDBC API 인터페이스를 구현한 드라이버 클래스를 찾아 객체를 생성한다.
		try {
			//Class 클래스를 통해 Referenced Libraries → com.mysql.jdbc → Driver클래스를 확인
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
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		//PreparedStatement : dynamical query
		
		ResultSet resultSet = null;
		int result2 = 0;
		ResultSet resultSet3 = null;

		//URL - 프로토콜 : 서브프로토콜 : SID 
		//      jdbc  : mysql   : SID
		//MySQL의 default port는 3306
		String url = "jdbc:mysql://localhost:3306/ssm_server";
		//String url = "jdbc:mysql://localhost:3306/ssm_server?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "********";		
		try {
			//02) DBMS와의 연결을 관리하는 Connection 객체 생성
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Complete");
			
			//03) 질의 작업을 처리하는 Statement, PreparedStatement, CallableStatement 객체 생성
			preparedStatement = connection.prepareStatement("select * from USER");

			//INSERT INTO SSM_SERVER.USER VALUE('정은택','abcd1234','010-7444-8705','-','1.1.2','manager','정은택','담당자');
			preparedStatement2 = connection.prepareStatement("update USER set system_sn='1.1.3' where user_sn='정은택'");

			//동적으로 쿼리를 작성할 수 있음
			//PreparedStatement : dynamical query
			//String query3 = "select * from USER where user_sn like ?";
			String query3 = "select * from USER where user_sn = ?";
			preparedStatement3 = connection.prepareStatement(query3); 
			
			System.out.print("Insert User SN : ");
			Scanner in = new Scanner(System.in);
			String search = in.nextLine();
			
			//첫번째(1) 물음표 자리에 "%" + search + "%" 를 입력하여 검색한다.
			//preparedStatement3.setString(1, "%" + search + "%");
			preparedStatement3.setString(1, search);
			
			
			//04) ResultSet객체를 통해 질의 결과를 획득하고 처리
			resultSet = preparedStatement.executeQuery();
			result2 = preparedStatement2.executeUpdate();
			resultSet3 = preparedStatement3.executeQuery();

			//결과문 받기
			while(resultSet3.next()) {
				String user_sn = resultSet3.getString("user_sn");
				String user_password = resultSet3.getString("user_password");
				String user_phone = resultSet3.getString("user_phone");
				String user_gcmaddress = resultSet3.getString("user_gcmaddress");
				String system_sn = resultSet3.getString("system_sn");
				String user_type = resultSet3.getString("user_type");
				String user_name = resultSet3.getString("user_name");
				String user_profile = resultSet3.getString("user_profile");

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
			//result2 종료는 없음
			resultSet3.close();

			preparedStatement.close();
			preparedStatement2.close();
			preparedStatement3.close();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
