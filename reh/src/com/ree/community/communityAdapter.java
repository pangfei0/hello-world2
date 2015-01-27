package com.ree.community;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminIntentAddrDict;
import com.ree.intentaddr.IntentAddrDao;




public class communityAdapter {

	/**
	 * list
	 */
	private static List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
	private static List<RepAdminIntentAddrDict> ilist = new ArrayList<RepAdminIntentAddrDict>();
	
	/**
	 * bean
	 */
	private RepAdminCommunityInfo cBean = new RepAdminCommunityInfo();
	
	/**
	 * dao
	 */
	private communityDao cDao = new communityDao();
	private IntentAddrDao iDao = new IntentAddrDao();
	
	/**
	 * 
	* <p>Title: GetCommunities_By_father_id<／p>
	* <p>Description:通过father_id获得Communities <／p>
	* <p>Return:List<RepAdminCommunityInfo></p>
	* @param father_id
	* @return
	 */
	public communityAdapter(){
		super();
		this.GetCommunities_By_All();
		this.GetIntentAddr_By_All();
	}
	public communityAdapter(Boolean CorI){
		super();
		if(CorI)
			this.GetCommunities_By_All();
		else
			this.GetIntentAddr_By_All();
	}
//	public List<RepAdminCommunityInfo> GetCommunities_By_father_id(int father_id){
//		list = cDao.GetCommunities_By_father_id(father_id);
//		return list;
//	}
	public List<RepAdminCommunityInfo> GetCommunities_By_father_id(int father_id){
		if(list.size()==0)
			list = cDao.GetCommunities_By_All();
		List<RepAdminCommunityInfo> result = new ArrayList<RepAdminCommunityInfo>();
		if(list!=null&&list.size()!=0){
			for(RepAdminCommunityInfo r : list){
				if(r.getCommunityFatherNo()==father_id&&r.getCommunityNo()!=0)
					result.add(r);
			}
		}
		return result;
	}
	
	public List<RepAdminIntentAddrDict> GetAddr_By_father_id(int father_id){
		if(ilist.size()==0)
			ilist = iDao.GetAddr_By_All();
		List<RepAdminIntentAddrDict> result = new ArrayList<RepAdminIntentAddrDict>();
		if(ilist!=null&&ilist.size()!=0){
			for(RepAdminIntentAddrDict r : ilist){
				if(r.getIntentFatherNo()==father_id&&r.getIntentAddrNo()!=0)
					result.add(r);
			}
		}
		return result;
	}
	public RepAdminCommunityInfo GetCommunityBean_By_id(int communityNo) throws SQLException{
		return cDao.GetCommunityBean_By_id(communityNo);
	}
	public List<RepAdminCommunityInfo> GetCommunities_By_All(){
		//if(list.size()==0)
			list = cDao.GetCommunities_By_All();
		return list;
	}
	public List<RepAdminIntentAddrDict> GetIntentAddr_By_All(){
		//if(ilist.size()==0)
			ilist = cDao.GetIntentAddr_By_All();
		return ilist;
	}
	public RepAdminIntentAddrDict GetIntentAddr_By_No(int intentAddrNo){
		return (RepAdminIntentAddrDict)cDao.getBean(RepAdminIntentAddrDict.class, intentAddrNo);
	}
	public String GetIntentAddrName_By_No(int no){
		String result = "";
		if(ilist.size()==0)
			ilist = this.GetIntentAddr_By_All();
		if(ilist!=null&&no!=0){
			for(RepAdminIntentAddrDict r : ilist){
				if(r.getIntentAddrNo()==no)
					result = r.getIntentAddrName();
			}
		}
		return result;
		
	}
}

