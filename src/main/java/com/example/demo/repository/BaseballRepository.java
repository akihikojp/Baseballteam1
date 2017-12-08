package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.BaseballTeam;

@Repository
public class BaseballRepository {

	@Autowired 
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<BaseballTeam> teamRowMapper = (rs, i) -> {
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};

	/**全件検索*/
	public List<BaseballTeam> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history from baseball_teams";
		return template.query(sql, teamRowMapper);
	}
	/** IDで検索*/
	public BaseballTeam findById(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history from baseball_teams WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, teamRowMapper);
	}
	
	public void save(BaseballTeam ajaxBaseballTeam){
		SqlParameterSource param = new BeanPropertySqlParameterSource(ajaxBaseballTeam);
		
		String sql = "insert into baseball_teams (league_name, team_name, headquarters, inauguration, history) "
				   + "values (:leagueName, :teamName, :headquarters, :inauguration, :history)";
		
		template.update(sql, param);
	}
}
