package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneDao phoneDao;
	
	public List<PersonVo> getPersonList(){
		return phoneDao.getPersonList();
	}
	
	public int personInsert(PersonVo personVo) {
		return phoneDao.personInsert(personVo);
	}
	
	public int personInsert2() {
		System.out.println("PhoneService>personInsert2");
		
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "상하이조");
		pMap.put("hp", "010-2293-0874");
		pMap.put("company", "02-093-0827");
		
		int count = phoneDao.personInsert2(pMap);
		return count;
	}
	
	public int personDelete(int personId) {
		return phoneDao.personDelete(personId);
	}
	
	public PersonVo getPerson(int personId) {
		return phoneDao.getPerson(personId);
	}
	
	public Map<String, Object> getPerson2(int personId) {
		return phoneDao.getPerson2(personId);
	}
	
	public int personUpdate(PersonVo personVo) {
		return phoneDao.personUpdate(personVo);
	}
	
	
	
	
	
}