package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao {

	private String baseSql;

	public Student get(String no) throws Exception{

	}

	private List<Student> postFilter(ResultSet rSet, School school) throws Exception{

	}

	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception{

	}

	public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception{

	}

	public List<Student> filter(School school, boolean isAttend) throws Exception{

	}

	public boolean save(Student student) throws Exception{

	}

	private String baseSql = "select * from student where school_cd=? ";

	private List<Student> postFilter(ResultSet rSet,School school) throws Exception{
		List<Student> list = new ArrayList<>();
		try {
			while(rSet.next()){
				Student student = new Student();
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getString("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getString("is_attend"));
				student.setSchool(school);

				list.add(student);
			}
		} catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Student>filter(School school, int entYear, String classNum, boolean isAttend)throws Exception{
		List<Student> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparekdStatement statemant = null;
		ResultSet rSet = null;
		String condition = "and ent_year=? and class_num=?";
		String order = " order by no asc";

		String conditionIsAttend="";
		if (isAttend){
			conditionIsAttend = "and is_attend=true";
		}

		try{
			statement = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
			statement.setString(1. school.getCd());
			statement.setInt(2, entYear);
			statement.setString(3, classNum);
			rSet = statement.executeQuery();
		}
	}

}