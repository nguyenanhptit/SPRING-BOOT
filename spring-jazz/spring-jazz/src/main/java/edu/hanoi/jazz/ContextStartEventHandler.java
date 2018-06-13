package edu.hanoi.jazz;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import com.mysql.cj.jdbc.DatabaseMetaData;



public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent>{
	
	private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);

	@Autowired  DataSource dataSource;
	
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		// TODO Auto-generated method stub
		LOGGER.info("context start application" + dataSource);
//		try {
//			createTable("HN_GROUP", "create table HN_GROUP(id bigint primary "
//					+ " key generated always as identity (start with 1, increment by 1)," + " name varchar(100))");
//
//		} catch (Exception e) {
//			LOGGER.error(e, e);
//		}
	}

//	private void createTable(String name, String script) throws SQLException {
//		DatabaseMetaData dbmd = (DatabaseMetaData) dataSource.getConnection().getMetaData();
//		ResultSet rs = dbmd.getTables(null, null, name, null);
//		if (rs.next()) {
//			LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
//			return;
//		}
//		dataSource.getConnection().createStatement().executeUpdate(script);
//
//	}

}
