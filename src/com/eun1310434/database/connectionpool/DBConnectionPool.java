/*=====================================================================
□ Infomation
  ○ Data : 15.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ 접속하는 Client를 위해 미리 만든 Connection객체를 사용하지 않는 것을 파악한뒤 재사용하여 실행
  
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
package com.eun1310434.database.connectionpool;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPool {
	private static final List<Connection> stayPool = new ArrayList<>();
	private static final List<Connection> runningPool = new ArrayList<>();
	private static final int poolSize = 20; //최대 가용 범위
	
	private int retry = 0;
	
	public void initialize() {
		for(int i = 0; i < stayPool.size(); ++i) {
			try {
				if(stayPool.get(i) != null && !stayPool.get(i).isClosed()) {
					stayPool.get(i).close();
				}
			}catch(Exception e) {
			}finally {
				stayPool.remove(i);
			}
		}
		
		for(int i = 0; i < runningPool.size(); ++i) {
			try {
				if(runningPool.get(i) != null && !runningPool.get(i).isClosed()) {
					runningPool.get(i).close();
				}
			}catch(Exception e) {
			}finally {
				runningPool.remove(i);
			}
		}
	}

	//Connection 대기(stayPool) → Connection 재사용
	public synchronized Connection getConnection() {
		if(stayPool.size() > 0) {
			Connection connection = stayPool.get(0);
			stayPool.remove(0);
			runningPool.add(connection);
			return connection;
			
		} else {
			
			if(stayPool.size() + runningPool.size() < poolSize) {
				Connection connection = DBGetInstance.getInstance();
				runningPool.add(connection);
				retry = 0;
				return connection;
				
			} else {
				retry++;
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				if(retry == 5) {
					retry = 0;
					return null;
				}
				return getConnection();
			}
		}
	}
	
	

	//Connection 해제(runningPool제거) →  Connection 대기(stayPool)
	public synchronized void release(Connection connection) {
		for(int i = 0; i < runningPool.size(); ++i) {
			Connection conn = runningPool.get(i);
			if(conn.equals(connection)) {
				runningPool.remove(i);
				stayPool.add(connection);
				break;
			}
		}
		
		System.out.println("stayPool = " + stayPool.size());
		System.out.println("runningPool = " + runningPool.size());
	}
}
