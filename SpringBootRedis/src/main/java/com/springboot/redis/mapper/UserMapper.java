package com.springboot.redis.mapper;


import com.springboot.redis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;


@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Insert("insert into users(name) values(#{name})")
    int addUser(@Param("name")String name);

    @Select("select * from users where name =#{name}")
    @Cacheable(key ="#p0")
    User find(@Param("name") String name);

//    @CachePut(key = "#p0")
//    @Update("update user set name=#{name} where id=#{id}")
//    void updataById(@Param("id")String id,@Param("name")String name);
//
//    //如果指定为 true，则方法调用后将立即清空所有缓存
//    @CacheEvict(key ="#p0",allEntries=true)
//    @Delete("delete from user where id=#{id}")
//    void deleteById(@Param("id")String id);

}