package com.juno.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juno.shop.dto.Qna;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class QnaDao {
	
	private JdbcTemplate tmp;
	
	@Autowired
	public QnaDao(ComboPooledDataSource ds) {
		tmp = new JdbcTemplate();
		tmp.setDataSource(ds);
	}

	public Qna getQna(int qseq) {
		return tmp.query("SELECT * FROM QNA WHERE QSEQ = ? ORDER BY QSEQ DESC", new RowMapper<Qna>() {
			@Override
			public Qna mapRow(ResultSet rs, int rowNum) throws SQLException {
				Qna q = new Qna();
				q.setQseq(rs.getInt("qseq"));
				q.setSubject(rs.getString("subject"));
				q.setContent(rs.getString("content"));
				q.setReply(rs.getString("reply"));
				q.setId(rs.getString("id"));
				q.setRep(rs.getString("rep"));
				q.setIndate(rs.getTimestamp("indate"));
				return q;
			}
		}, qseq).get(0);
	}

	public List<Qna> listQna(String id) {
		return tmp.query("SELECT * FROM QNA WHERE ID = ? ORDER BY QSEQ DESC", new RowMapper<Qna>() {
			@Override
			public Qna mapRow(ResultSet rs, int rowNum) throws SQLException {
				Qna q = new Qna();
				q.setQseq(rs.getInt("qseq"));
				q.setSubject(rs.getString("subject"));
				q.setContent(rs.getString("content"));
				q.setReply(rs.getString("reply"));
				q.setId(rs.getString("id"));
				q.setRep(rs.getString("rep"));
				q.setIndate(rs.getTimestamp("indate"));
				return q;
			}
		}, id);
	}

	public void insertQna(Qna q) {
		tmp.update(
			"INSERT INTO QNA(QSEQ, SUBJECT, CONTENT, ID) VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?)"
				, q.getSubject()
				, q.getContent()
				, q.getId()
		);
	}
}
