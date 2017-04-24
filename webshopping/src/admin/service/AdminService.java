package admin.service;

import admin.dao.AdminDao;
import admin.daomain.Admin;

public class AdminService {
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	public Admin login(Admin admin){
		return adminDao.login(admin);
	}

}
