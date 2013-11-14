package my.action;

import java.io.IOException;

import my.beans.User;
import my.service.Annotation;
import my.service.RequestContext;

/**
 * 超级管理员执行的action
 * @author smile
 *
 */
@Annotation.PostMethod
@Annotation.UserRequired(role=User.ROLE_ADMIN)
public class AdminAction {
	/**
	 * 更换user的角色
	 * @param ctx
	 * @throws IOException
	 */
	public void changeRole(RequestContext ctx) throws IOException {
		long id = ctx.id();
		int role = ctx.param("role", 1);
		User user = User.INSTANCE.Get(id);
		if(user==null)
			throw ctx.error("form_empty");
		user.UpdateField("role", role);
		ctx.output_json(new String[]{"id","role"},new Object[]{id,User.roleName(role)});
	}
	
	/**
	 * 重置密码
	 * @param ctx
	 * @throws IOException
	 */
	public void resetPwd(RequestContext ctx) throws IOException {
		//TODO: 实现
	}
	/**
	 * 删除用户
	 * @param ctx
	 * @throws IOException 
	 */
	public void delete(RequestContext ctx) throws IOException {
		//TODO 删除用户的所有资料
	}
}
