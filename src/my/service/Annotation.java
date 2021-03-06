package my.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import my.beans.User;

/**
 * 注解
 * @author smile
 * @date 2013-2-19 下午4:00:09
 */
public class Annotation {

	/**
	 * 只允许使用POST方式执行的Action
	 */
	@Target({ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface PostMethod {

	}
	
	/**
	 * 若在类上注解，则该类下所有方法必须是登录用户才能执行 <br>
	 * 若在方法上注解，则该方法必须是登录用户才能执行 <br>
	 * (role=User.role) 限定user类型
	 */
	@Target({ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface UserRequired {
		public int role() default User.ROLE_USER ;
	}
}
