package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 메소드 - 일반
	public List<PersonVo> getPersonList() {
		List<PersonVo> pList = sqlSession.selectList("phonebook.selectlist");
		return pList;
	}
	
	
	/*
	// 사람 등록(insert) 메소드
	public int personinsert(PersonVo personVo) {

		int count = 0;

		getConnection();

		try {
			// 3.SQL문 시작
			String query = "";
			query += " insert into person";
			query += " values (seq_person_id.nextval, ?, ?, ?)";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());

			// 실행
			// 성공 횟수 리턴
			count = pstmt.executeUpdate();

			// 4. 결과처리
			System.out.println(count + "건이 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();

		return count;

	}

	// 사람 수정(update) 메소드
	public int personUpdate(PersonVo personVo) {
		int count = 0;

		getConnection();

		try {
			///// 3. SQL문 준비 / 바인딩 / 실행 /////
			// SQL문 준비
			String query = "";
			query += " update person ";
			query += " set name = ?, ";
			query += "     hp = ?, ";
			query += "     company = ? ";
			query += " where person_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());

			// 실행
			count = pstmt.executeUpdate();

			///// 4.결과처리 /////
			System.out.println(count + "건 수정 되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

		return count;

	}

	// 사람 삭제(delete) 메소드
	public int persondelete(int personId) {
		int count = -1;

		getConnection();

		try {
			// SQL문 준비
			String query = "";
			query += " delete from person ";
			query += " where person_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, personId);

			// 실행
			count = pstmt.executeUpdate();

			// 출력
			System.out.println(count + "건이 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		close();

		return count;

	}

	public int personSearch(String search) {

		int count = 0;
		getConnection();
		try {
			// SQL문 준비
			String query = "";
			query += " select * ";
			query += " from person ";
			query += " where name Like ? ";
			query += " or hp like ? ";
			query += " or company like ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			search = "%" + search + "%";
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);

			// 실행
			// resultSet 가져오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				PersonVo personVo = new PersonVo(personId, name, hp, company);
				personVo.showList();
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

		return count;

	}

	// 사람 가져오기
	public PersonVo getPerson(int personId) {
		PersonVo personVo = null;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from person ";
			query += " where person_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, personId);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {

				int id = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				personVo = new PersonVo(id, name, hp, company);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return personVo;
	}
*/
}
