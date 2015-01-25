/**   
 * @Title: newslistJSONAction.java 
 * @Package com.reh.news 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator - 李丁
 * @date 2015年1月12日 下午2:54:26 
 * @version  
 */
package com.reh.news;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminList;
import com.ree.list.ListDao;

/**
 * @ClassName: newslistJSONAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2015年1月12日 下午2:54:26
 * 
 */
public class newslistJSONAction extends ActionSupport {
    /**
     * 输入
     */
    private int listNo;

    /**
     * 输出
     */
    private String listName;
    private HashMap<String, String> r = new LinkedHashMap<String, String>();
    /*
     * listdao
     */
    private ListDao lDao;
    private List<RepAdminList> list;
    public String execute() {
	lDao = new ListDao();
	list = lDao.GetList_By_All();
	listName = "null";
	for(RepAdminList l : list){
	    if(l.getListNo() == listNo)
		listName = l.getListName();
	}
	r.put("key", listName);
	return SUCCESS;
    }

    public int getListNo() {
        return listNo;
    }

    public void setListNo(int listNo) {
        this.listNo = listNo;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public HashMap<String, String> getR() {
        return r;
    }

    public void setR(HashMap<String, String> r) {
        this.r = r;
    }
}
