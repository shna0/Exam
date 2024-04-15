package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;

public class SchoolDao extends Dao {
	public School get(String school_cd) throws Exception{
		School school = new School();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select * from school where no=?");
			statement.setString(1, school_cd);
			ResultSet rSet = statement.executeQuery();
			if(rSet.next()){
				school.setName(rSet.getString("name"));

			}
		} catch (Exception e){
			throw e;
		} finally{
			if(statement != null){
				try{
					statement.close();
				}catch(SQLException sqle) {
					throw sqle;
				}
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException sqle) {
					throw sqle;
				}
			}
		}
		return school;
	}
}