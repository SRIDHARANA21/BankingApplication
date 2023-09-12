package com.BankApplication.BankApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Service.Userservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class Usercontroller {
@Autowired
Userservice service;
@PostMapping
public ResponseEntity<ResponseStructure<User>> saveuser( @Valid @RequestBody User u, @Valid @RequestParam int bid	)
{
	return service.saveuser(u, bid);
}
@GetMapping
public ResponseEntity<ResponseStructure<User>> finduser(@Valid @RequestParam int id)
{
	return service.finduser(id);
}
@DeleteMapping
public ResponseEntity<ResponseStructure<User>> deleteuser(@Valid @RequestParam int uid,@Valid @RequestParam int bid)
{
	return service.deleteuser(uid, bid);
}
@GetMapping("/updateuser")
public ResponseEntity<ResponseStructure<User>> updateuser(@Valid @RequestBody User upd,@Valid @RequestParam int id)
{
	return service.updateuser(upd, id);
}
@PostMapping("/login")
public ResponseEntity<ResponseStructure<User>> userlogin(@RequestParam String uname,@RequestParam String upassword)
{
	return service.loginUser(uname, upassword);
}

}
