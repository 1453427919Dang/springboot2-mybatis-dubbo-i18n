package com.bowen.top.stzb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bowen.top.stzb.doman.User;
import com.bowen.top.stzb.doman.UserExample;

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	long countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Fri Dec 14 10:54:59 CST 2018
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

}
