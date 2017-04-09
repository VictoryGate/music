package com.music.utils.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authority{
	/**
	 * 访问需要的权限
	 * @return
	 */
	public String value();
	/**
	 * 权限不足跳转的url
	 * @return
	 */
	public String url() default "";
}
