package com.tms.restController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.config.JwtUtil;
import com.tms.models.User;
import com.tms.models.reponse.LoginResponseDto;
import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.CreateUserRequestDto;
import com.tms.models.request.LoginRequestDto;
import com.tms.repositories.UserRepository;
import com.tms.services.CustomUserDetailService;
import com.tms.services.LoginService;
import com.tms.services.UserService;
import com.tms.utils.StatusResponse;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private MerchantService merchantService;

	@PostMapping("/signin")
	public @ResponseBody ResponseDto authenticateUser(@RequestBody LoginRequestDto request) {
		ResponseDto response = new ResponseDto();
		LoginResponseDto loginResponse = new LoginResponseDto();
		String token = null;
		try {
			User user = userRepository.findByUsernameOrEmail(request.getUsername(), request.getUsername());
			if (user.getAtemptCount() < 6) {
				user.setAtemptCount(user.getAtemptCount() + 1);
				if (user.getAtemptCount() > 5) {
					user.setUnlocking(false);
				}
				userService.save(user);
			}

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(request.getUsername());
			token = this.jwtUtil.generateToken(userDetails);
			List<String> roles = loginService.findRoleByUserName(userDetails.getUsername());

			// reseting user atempts
			user.setAtemptCount(0);
			user.setUnlocking(true);
			user.setLastUsed(LocalDateTime.now());
			userService.save(user);

//			Merchant merchant=merchantService.findByUser(user);
//			if(merchant != null) {
//				loginResponse.setmId(String.valueOf(merchant.getId()));
//			}
			loginResponse.setToken(token);
			loginResponse.setRoles(roles);
			loginResponse.setUserName(userDetails.getUsername());
			response.setData(loginResponse);
			response.setMessage("Logged In");
			response.setStatus(StatusResponse.Success);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(StatusResponse.Failed);
		}
		return response;
	}

	@PostMapping("/createUser")
	public @ResponseBody ResponseDto registerUser(@RequestBody CreateUserRequestDto request) {
		ResponseDto response = new ResponseDto();
		try {

			if (userService.existsByUsername(request.getUserName())) {
				response.setMessage("Username is already taken!");
				response.setStatus(StatusResponse.Failed);
				return response;
			}
			if (userService.existsByEmail(request.getEmail())) {
				response.setMessage("Email is already in use!");
				response.setStatus(StatusResponse.Failed);
				return response;
			}
			if (userService.existsByMobile(request.getMobile())) {
				response.setMessage("Mobile no is already in use!");
				response.setStatus(StatusResponse.Failed);
				return response;
			}

			response = loginService.saveUser(request);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong!");
			response.setStatus(StatusResponse.Failed);
		}
		return response;
	}
	
	@PostMapping("/getRoles")
	public @ResponseBody ResponseDto getRoles() {
		ResponseDto response = new ResponseDto();
		List<String> roles = new ArrayList<String>();
		try {
			roles=loginService.findAllRoles();
			if(roles.isEmpty()) {
				response.setMessage("Data not Found");
				response.setStatus(StatusResponse.Data_Not_Found);
			}else {
				response.setData(roles);
				response.setMessage("Data Found");
				response.setStatus(StatusResponse.Success);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong!");
			response.setStatus(StatusResponse.Failed);
		}
		return response;
	}

//	@PostMapping("/resetPassword")
//	public @ResponseBody ResponseVo resetPassword(@RequestBody ResetPasswordRequestVo request) {
//		ResponseVo response = new ResponseVo();
//		try {
//			if (request.getEmailOrUsername() == null || request.getEmailOrUsername().equals("")) {
//				response.setMessage("EmailOrUsername is mendetory field !");
//				response.setStatus(StatusResponse.failed);
//				return response;
//			}
//			if (request.getOtp() == null || request.getOtp().equals("")) {
//				response.setMessage("Otp is mendetory field !");
//				response.setStatus(StatusResponse.failed);
//				return response;
//			}
//			if (request.getPassword() == null || request.getPassword().equals("")) {
//				response.setMessage("Password is mendetory field !!");
//				response.setStatus(StatusResponse.failed);
//				return response;
//			}
//
//			response = loginService.resetPassword(request);
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.setMessage("Something went wrong!");
//			response.setStatus(StatusResponse.failed);
//			return response;
//		}
//		return response;
//	}

}
