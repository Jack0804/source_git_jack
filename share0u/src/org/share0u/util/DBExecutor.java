package org.share0u.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBExecutor {
	private static Logger logger=LogManager.getLogger(DBExecutor.class);
	private static DataSource ds;

	static{
		try{
			ds=DBCPSource.setupDataSource();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	private SQLImpl impl;
	public DBExecutor(SQLImpl impl) {
		this.impl=impl;
	}

	public final void execute(){  


		try{
			makeConnection();
			impl.executeSQL(con,pstmt,rs);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			logger.debug("Finally....");
			closeAll();
		}
	}

	private void makeConnection() throws Exception{
		logger.debug("Connection established..");
		con = ds.getConnection();
		logger.debug(con);
	}

	private void closeAll(){
		logger.debug("CLOSE...................");
		if(rs != null){
			logger.debug("rs close......");
			try {rs.close();} catch (Exception e) {}
		}
		if(pstmt != null){
			logger.debug("pstmt close......");
			try {pstmt.close();} catch (Exception e) {}
		}
		if( con != null){
			logger.debug("con close....");
			try {con.close();} catch (Exception e) {}
		}


	}


}