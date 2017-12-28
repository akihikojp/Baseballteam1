package com.example.demo.controller;

//drop table file;

//CREATE TABLE file(
//		  id serial primary key,
//		  file_name text,
//		  file bytea
//		)


public class File {

	private Integer id;
	private String fileName;
	private byte[] blobFile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getBlobFile() {
		return blobFile;
	}

	public void setBlobFile(byte[] blobFile) {
		this.blobFile = blobFile;
	}

}
