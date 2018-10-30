package com.bluespace.tech.hrms.security.service;

import java.util.List;

import com.bluespace.tech.hrms.security.domain.UserRole;

public interface UserRoleService {

	public abstract UserRole findUserRoleByRoleName(String paramString);

	public abstract List<UserRole> findByRoleNameLike(String paramString);

	public abstract List<UserRole> getAllUserRoles();
	
/*	public abstract List<UserRole> findByDescriptionLike(String paramString);

	public abstract UserRole getUserRoleById(Long paramLong);

	public abstract List<UserRole> getUserRoleByIds(List<Long> paramList);
	public abstract UserRole createUserRole(UserRole paramUserRole) throws BusinessException;

	public abstract UserRole updateUserRole(UserRole paramUserRole) throws BusinessException;

	public abstract void deleteUserRole(Long paramLong);
 */

}
