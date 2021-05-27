package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private final UserService userService;

	@Autowired
	public UsersController(final UserService userService) {
		this.userService = userService;
	}

}
