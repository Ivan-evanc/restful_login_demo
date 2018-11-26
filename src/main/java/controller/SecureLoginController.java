package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import config.JsonFormatter;
import model.User;
import repository.LoginRepository;
import service.CustomLoginService;

@RestController
public class SecureLoginController {
	
	@Autowired
	private CustomLoginService userService;
	@Autowired
	private LoginRepository userRepository;
	
	@RequestMapping(value="/api/signin", method=RequestMethod.POST)
	public String loginUser(@RequestBody User user) {
		String message="";
		if(userService.isValidated(user)) {
			String token = userService.updateUserToken(user);
			Optional<User> userInf = userRepository.findById(user.getPhonenumber());
			
			String phone = user.getPhonenumber();
			String name = userInf.get().getFirstname()+" "+userInf.get().getLastname();
			String country = userInf.get().getCountryservicecode();
			JsonFormatter formatterValid=new JsonFormatter(200,token,phone,name,country);
			ObjectMapper mappervalid=new ObjectMapper();
			try {
				message=mappervalid.writeValueAsString(formatterValid);
			} catch (JsonProcessingException e) {
			
				e.printStackTrace();
			}
		}else {
			JsonFormatter formatter=new JsonFormatter(201,null,null,null,null);
			ObjectMapper mapper=new ObjectMapper();
			try {
				message=mapper.writeValueAsString(formatter);
			} catch (JsonProcessingException e) {
			
				e.printStackTrace();
			}
			
		}
		return message;
			
		
		
	}

}
