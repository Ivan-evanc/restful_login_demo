package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import model.User;
import repository.LoginRepository;

@Service
public class CustomLoginService {
	 private final BCryptPasswordEncoder bCryptPasswordEncoder;
	 private final LoginRepository userRepository;
	 private boolean isValid;
	 private String generatedPasswordMD5;
	
	 @Autowired
	private CustomLoginService(BCryptPasswordEncoder bCryptPasswordEncoder,LoginRepository userRepository) {
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
		this.userRepository=userRepository;
	}
	

	public boolean isValidated(User user) {
		Optional<User> isUserPresent=userRepository.findById(user.getPhonenumber());
		if(isUserPresent.isPresent()) {
			String pass=isUserPresent.get().getPassword();
			if(bCryptPasswordEncoder.matches(user.getPassword(), pass)) {
				isValid=true;
			}else {
				isValid=false;
			}
		}else {
			isValid=false;
		}
		
		return isValid;
	}
	
	public String updateUserToken(User user) {
		Random Rand=new Random();
		int code=Rand.nextInt(99999999)+11111;
		String codegenerated = String.valueOf(code);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String phone = user.getPhonenumber();
		String tobeMd5 = phone +codegenerated + timeStamp+phone+codegenerated+"ABCDEFGCIJKLMNOPQRSTUVWXYZ";
		 try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(tobeMd5.getBytes());
			byte[] bytes = md.digest();
			 StringBuilder sb = new StringBuilder();
			 for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
			  generatedPasswordMD5 = sb.toString();
			 if(userRepository.findById(user.getPhonenumber()).isPresent()) {
				 User userToUpdate = userRepository.getOne(user.getPhonenumber());
				 userToUpdate.setAuthtoken(generatedPasswordMD5);
				 userRepository.save(userToUpdate);
			 }
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPasswordMD5;
		
		
		
	}
	 
	

}
