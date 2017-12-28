package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.demo.controller.File;

@Repository
public class BaseballRepository {

	@Autowired 
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<File> fileRowMapper = (rs, i) -> {
		File file = new File();
		file.setId(rs.getInt("id"));
		file.setFileName(rs.getString("file_name"));
		file.setBlobFile(rs.getBytes("file"));
		return file;
	};


	public void save(File file) {
		String sql = "insert into file(file_name, file) values(:fileName, :blobFile)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(file);		
		template.update(sql, param);
	}

	//FIND
	public File findById(Integer id) {
		String sql = "select id, file_name, file from file where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
      return template.queryForObject(sql, param, fileRowMapper);
	}
	
}
