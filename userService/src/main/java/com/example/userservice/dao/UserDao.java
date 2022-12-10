package com.example.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.userservice.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

//    @Select("select * from tbl_book where id = #{id}")
//    Book getById(Integer id);
}
