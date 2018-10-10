package com.bluespace.tech.hrms.security.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public enum RoleConstants {
	
	NONE("none", "NONE"), ACCESS_DASHBOARD("access_dashboard", "UI_ACCESS_DASHBOARD"),
	ACCESS_CONTACTS("access_contacts", "UI_ACCESS_CONTACTS"), CREATE_CONTACTS("create_contacts", "UI_CREATE_CONTACTS"),
	UPDATE_CONTACTS("update_contacts", "UI_UPDATE_CONTACTS"), DELETE_CONTACTS("delete_contacts", "UI_DELETE_CONTACTS"),
	ACCESS_USER_ROLES("access_user_roles", "UI_USER_ROLES_ACCESS"),
	CREATE_USER_ROLES("create_user_roles", "UI_USER_ROLES_CREATE"),
	UPDATE_USER_ROLES("update_user_roles", "UI_USER_ROLES_UPDATE"),
	DELETE_USER_ROLES("delete_user_roles", "UI_USER_ROLES_DELETE"),
	ACCESS_USER_GROUPS("access_user_groups", "UI_USER_GROUPS_ACCESS"),
	CREATE_USER_GROUPS("create_user_groups", "UI_USER_GROUPS_CREATE"),
	UPDATE_USER_GROUPS("update_user_groups", "UI_USER_GROUPS_UPDATE"),
	DELETE_USER_GROUPS("delete_user_groups", "UI_USER_GROUPS_DELETE"), ACCESS_USERS("access_users", "UI_USERS_ACCESS"),
	CREATE_USERS("create_users", "UI_USERS_CREATE"), UPDATE_USERS("update_users", "UI_USERS_UPDATE"),
	DELETE_USERS("delete_users", "UI_USERS_DELETE"), ACCOUNT_APPROVAL("account_approval", "UI_ACCESS_ACCOUNT_APPROVAL"),
	BULK_UPLOAD("bulk_upload", "UI_ACCESS_BULK_UPLOAD");

	@Getter @Setter private String role;
	@Getter @Setter private String permissionType;
	
	private RoleConstants(String role, String permissionType) {
		this.role = role;
		this.permissionType = permissionType;
	}

	public static Map<String, String> getRoles() {
		Map<String, String> roles = new HashMap<String, String>();
		for (RoleConstants roleConstants : values()) {
			roles.put(roleConstants.getRole().toUpperCase(), roleConstants.getPermissionType().toUpperCase());
		}
		return roles;
	}
	
}