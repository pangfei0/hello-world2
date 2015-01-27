package com.ree.plug;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.opensymphony.xwork2.ActionContext;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminProIntentionDict;

public class GetProDao extends SessionHelper {
	private List<RepAdminProIntentionDict> list = null;
	private String query_statement = null;
	private SessionHelper s = new SessionHelper();
	public GetProDao() {
		super();
	}

	public List<RepAdminProIntentionDict> Get_Projob_by_all() {
		query_statement = "from com.ree.hibernate.RepAdminProIntentionDict";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}	
		return list;
	}

	public List<RepAdminProIntentionDict> Get_Projob_by_Id(int id) {
		// TODO Auto-generated method stub
		query_statement = "from com.ree.hibernate.RepAdminProIntentionDict where jobIntentionDictFatherId=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, id);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}	
		return list;
	}

}
