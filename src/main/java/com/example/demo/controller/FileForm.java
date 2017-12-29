package com.example.demo.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileForm {

	private Integer id;
	/** enctype multipartfileにすると、MultiPartFileで受け取れる。 */
	private List<MultipartFile> file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

}
