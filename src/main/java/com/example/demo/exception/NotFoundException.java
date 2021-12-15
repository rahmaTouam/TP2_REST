package com.example.demo.exception;

@ResponseStatus(404)
public class NotFoundException extends RunTimeException {

	public NotFoundException()
	{
		super();
	}
	
	public NotFoundException(String message)
	{
		super(message);
	}
}
