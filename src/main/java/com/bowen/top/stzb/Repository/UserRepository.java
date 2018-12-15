package com.bowen.top.stzb.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.bowen.top.stzb.doman.User;

/**
 * {@link User}
 * {@link Repository}
 */
@Repository
public class UserRepository {
	/**
	 * 内存形式存储  防止高并发
	 */
	private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();  
	
	private final static AtomicInteger idGenerater = new AtomicInteger();
	/**
	 * 保存用户对象
	 * @param user {@link User}
	 * @return
	 */
	public User save(User user) {
		//从1开始递增
		Integer id = idGenerater.incrementAndGet();
		user.setId(id);
		return repository.put(id, user)==null?user:null;
	}
	
	/**
	 * 获取所有
	 * @return
	 */
	public Collection<User> getAll(){
		return repository.values();
	}
}
