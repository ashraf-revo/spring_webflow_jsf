package org.revo.flow.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Controller;

@Controller("rtou")
public class ConTrop {

	public UserDev create(UserDev userDev) {
		if (!"".equals(userDev.getEmail().trim())
				&& !"".equals(userDev.getPassword().trim())) {
			if (!userDev.getEmail().endsWith("@revo.com")) {
				userDev.setEmail(userDev.getEmail() + "@revo.com");
			}
			userDev.setName(userDev.getEmail().replaceAll("@revo.com", ""));
			userDev.setRole(1);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "succesfuly",
							"" + "your email is " + userDev.getEmail()
									+ " and your password is "
									+ userDev.getPassword()));

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"sorry you should fill the filds", ""));
		}

		return userDev;
	}
}
