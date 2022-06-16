package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	public List<PersonVo> getPersonList() {
		List<PersonVo> pList = sqlSession.selectList("phonebook.selectList");
		System.out.println(pList);
		return pList;
	}
	
	public int personInsert(PersonVo personVo) {
		int count = -1;
		count = sqlSession.insert("phonebook.personInsert", personVo);
		System.out.println(count + "건 등록되었습니다.");
		return count;
	}
	
	public int personDelete(int personId) {
		int count = -1;
		count = sqlSession.delete("phonebook.personDelete", personId);
		System.out.println(count + "건 삭제되었습니다.");
		return count;
	}
	
	public PersonVo getPerson(int personId) {
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", personId);
		System.out.println(personVo);
		return personVo;
	}
	
	
	public int personUpdate(PersonVo personVo) {
		int count = sqlSession.update("phonebook.personUpdate", personVo);
		return count;
	}
	/*
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

	
*/
}
