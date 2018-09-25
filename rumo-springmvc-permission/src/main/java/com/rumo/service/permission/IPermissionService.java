/**
 * TODO濡沫系统平台<br/>
 * com.rumo.service.permission<br/>
 * PermissionServerImpl.java<br/>
 *  创建人:mofeng <br/>
 * 时间：2018年9月20日-下午3:59:08 <br/>
 * 2018濡沫公司-版权所有<br/>
 */
package com.rumo.service.permission;

import com.rumo.pojo.Permission;
import com.rumo.vo.ServerResponse;

/**
 * 
 * PermissionServerImpl<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月20日-下午3:59:08 <br/>
 * @version 1.0.0<br/>
 * 
 */
public interface IPermissionService {

	public ServerResponse save(Permission permission);

	/**
	 * 
	 * 查询用户对应的角色的所有权限
	 * 方法名：findRoleUserPersmission<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月24日-下午10:03:37 <br/>
	 * 手机:1564545646464<br/>
	 * @param userId
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse findRoleUserPersmission(Integer userId);
}
