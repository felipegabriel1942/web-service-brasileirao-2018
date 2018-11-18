package br.com.brasileirao.exceptions;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int code;

	public DAOException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
