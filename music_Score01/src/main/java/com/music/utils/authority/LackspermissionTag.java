package com.music.utils.authority;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.music.utils.Constant;

public class LackspermissionTag extends SimpleTagSupport {
	
	private String name;

	@SuppressWarnings("unchecked")
	@Override
	public void doTag() throws JspException, IOException {
			Set<String> authoritys = (Set<String>) ((PageContext)this.getJspContext()).getSession().getAttribute(Constant.SESSION_USER_Authoritys);
			if(!authoritys.contains(getName())){
				getJspBody().invoke(null);
			}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
