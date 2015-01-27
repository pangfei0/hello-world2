package com.ree.intentaddr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminIntentAddrDict;




public class IntentAddrAdapter {

	/**
	 * list
	 */
	private static List<RepAdminIntentAddrDict> list = new ArrayList<RepAdminIntentAddrDict>();
	
	/**
	 * bean
	 */
	private RepAdminIntentAddrDict cBean = new RepAdminIntentAddrDict();
	
	/**
	 * dao
	 */
	private IntentAddrDao cDao = new IntentAddrDao();
	

	/*public List<RepAdminIntentAddrDict> GetAddr_By_father_id(int father_id){
		list = cDao.GetAddr_By_father_id(father_id);
		return list;
	}*/
//	public List<RepAdminIntentAddrDict> GetAddr_By_father_id(int father_id){
//		if(list.size()==0)
//			list = cDao.GetAddr_By_All();
//		List<RepAdminIntentAddrDict> result = new ArrayList<RepAdminIntentAddrDict>();
//		if(list!=null&&list.size()!=0){
//			for(RepAdminIntentAddrDict r : list){
//				if(r.getIntentFatherNo()==father_id&&r.getIntentAddrNo()!=0)
//					result.add(r);
//			}
//		}
//		return result;
//	}
//	public RepAdminIntentAddrDict GetAddr_By_id(int communityNo) throws SQLException{
//		return cDao.GetAddr_By_id(communityNo);
//	}
}

