package org.share0u.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface SQLImpl {

	void executeSQL(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception;

}