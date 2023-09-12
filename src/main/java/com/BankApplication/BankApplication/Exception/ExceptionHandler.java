package com.BankApplication.BankApplication.Exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.BankApplication.BankApplication.Config.ResponseStructure;

import jakarta.validation.ConstraintViolation;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstrainViolationexception(
			jakarta.validation.ConstraintViolationException ex) {
		ResponseStructure<Object> structure = new ResponseStructure<>();
		Map<String, String> hashmap = new HashMap<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessage("Add proper details");
		structure.setStaus(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode staus, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		HashMap<String, String> hashmap = new HashMap<>();
		for (ObjectError error : list) {

			String message = error.getDefaultMessage();
			String fieldname = ((FieldError) error).getField();
			hashmap.put(fieldname, message);
		}
		return new ResponseEntity<Object>(hashmap, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<ResponseStructure<String>> UsernotFound(UserNotFound u) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(u.getmessage());
		structure.setData("User not found with the  given id");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);


	}
	public ResponseEntity<ResponseStructure<String>> ManagernotFound(ManagerNotFound m) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(m.getmessage());
		structure.setData("Manager  not found with the  given id");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	public ResponseEntity<ResponseStructure<String>>  AccountnotFound(AccountNotFound acc) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(acc.getmessage());
		structure.setData("Acccount  not found");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	public ResponseEntity<ResponseStructure<String>> banknotFound(BankNotFound ba) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ba.getMessage());
		structure.setData("bank  not found with the id");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	public ResponseEntity<ResponseStructure<String>> userpasswordnotFound(UserPasswordNotFound userpass) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(userpass.getMessage());
		structure.setData("please Enter the crt User Password");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	public ResponseEntity<ResponseStructure<String>> ManagerpasswordnotFound(ManagerPasswordNotFound managerpass) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(managerpass.getMessage());
		structure.setData("Please Enter the crt Manager Password");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<String>> ManagerLoginByname(ManagerNameNotFound managername) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(managername.getMessage());
		structure.setData("THere is no   Manager in this name please enter the crt name ");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<String>> UserLoginByname(UserNameNotFound username) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(username.getMessage());
		structure.setData("There is no  User in this name please enter the crt name ");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<String>> Userloginfortranscation(TranscationTypeNotFound trans) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(trans.getMessage());
		structure.setData("There is no  transcation type in this id please eneter another one ");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<String>> Useraccounttype(AccountTypeNotFound acctype) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(acctype.getMessage());
		structure.setData("There is no account type for this given id please enter the another one ");
		structure.setStaus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
