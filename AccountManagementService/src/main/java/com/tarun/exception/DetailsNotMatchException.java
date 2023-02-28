package com.tarun.exception;

public class DetailsNotMatchException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public DetailsNotMatchException()
	{
		super("Details not match with the details on server !!");
	}
	public DetailsNotMatchException(String message)
	{
		super(message);
	}
}
