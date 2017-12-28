package com.example.demo.controller;


import org.springframework.web.multipart.MultipartFile;


public class FileForm {

	private Integer id;
	/**enctype multipartfileにすると、MultiPartFileで受け取れる。*/
	private MultipartFile file;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
