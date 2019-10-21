package com.g7go.springbootstartercachedemo.demo.service.impl;

import com.g7go.springbootstartercachedemo.demo.pojo.User;
import com.g7go.springbootstartercachedemo.demo.service.UserService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Cacheable:触发缓存写入
 * CacheEvict:触发缓存清除
 * CachePut:更新缓存(不会影响到方法的运行)
 * Caching:重新组合要应用于方法的多个缓存操作
 * CacheConfig:设置类级别上共享的一些常见缓存设置(当我们需要缓存的地方越来越多，你可以使用@CacheConfig(cacheNames = {"myCache"})注解来统一指定value的值，这时可省略value，如果你在你的方法依旧写上了value，那么依然以方法的value值为准)
 *
 * @author lwc
 */
@Service
@CacheConfig(cacheNames = "CacheConfigName")
public class UserServiceImpl implements UserService {

    /**
     * Cacheable[] cacheable() default {}; //声明多个@Cacheable
     * CachePut[] put() default {};        //声明多个@CachePut
     * CacheEvict[] evict() default {};    //声明多个@CacheEvict
     * 插入用户
     */
    @Caching(
            put = {
                    @CachePut(value = "valueName", key = "#user.id"),
                    @CachePut(value = "valueName", key = "#user.name"),
                    @CachePut(value = "valueName", key = "#user.address")
            }
    )
    @Override
    public User saveUser(User user) {
        System.out.println("插入用户...");
        return user;
    }

    /**
     * --@Cacheable注解会先查询是否已经有缓存，有会使用缓存，没有则会执行方法并缓存
     * 命名空间:@Cacheable的value会替换@CacheConfig的cacheNames(两者必须有一个)
     * --key是[命名空间]::[@Cacheable的key或者KeyGenerator生成的key](@Cacheable的key优先级高,KeyGenerator不配置走默认KeyGenerator SimpleKey [])
     */
    @Override
    @Cacheable(value = {"valueName", "valueName2"}, key = "'keyName1'")
    public User findUser() {
        System.out.println("执行方法...");
        return new User("id1", "张三", "沧州", "123456", 22);
    }

    /**
     * --@CachePut注解的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，
     * 和 @Cacheable 不同的是，它每次都会触发真实方法的调用
     * 简单来说就是用户更新缓存数据。但需要注意的是该注解的value 和 key 必须与要更新的缓存相同，也就是与@Cacheable 相同
     * 默认先执行数据库更新再执行缓存更新
     * 注意返回值必须是要修改后的数据
     */
    @Override
    @CachePut(value = "valueName", key = "'keyName1'")
    public User updateUser() {
        System.out.println("更新用户...");
        return new User("id1", "李四", "北京", "123456", 22);
    }

    /**
     * --@CachEvict 的作用 主要针对方法配置，能够根据一定的条件对缓存进行清空
     * 触发缓存清除
     * 默认先执行数据库删除再执行缓存删除
     */
    @Override
    @CacheEvict(value = "valueName", allEntries = true)
    public void clearUser() {
        System.out.println("清除缓存...");
    }
}