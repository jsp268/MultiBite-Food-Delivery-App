package com.multibite.service;

import com.multibite.exception.AdminException;
import com.multibite.model.Admin;

public interface AdminService {

	public String createNewAdmin() throws AdminException;

}
