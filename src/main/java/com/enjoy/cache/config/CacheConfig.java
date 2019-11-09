package com.enjoy.cache.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{
	
	
		    //key的生成，springcache的内容，跟具体实现缓存器无关
//		  @Bean
//		  public KeyGenerator keyGenerator() {
//		      return new KeyGenerator() {
//		          @Override
//		          public Object generate(Object target, Method method, Object... params) {
//		
//		              StringBuilder sb = new StringBuilder();
//		              sb.append(target.getClass().getSimpleName());
//		              sb.append(method.getName());
//		              for (Object obj : params) {
//		                  sb.append(obj.toString());
//		              }
//		              return sb.toString();
//		          }
//		      };
//		  }
	
	  
		 //@Bean
//		 public CacheManager cacheManager() {
//		     //jdk里，内存管理器
//		     SimpleCacheManager cacheManager = new SimpleCacheManager();
//		     //—这里传入实现类1的对象名
//		     ConcurrentMapCache cmCache = new ConcurrentMapCache("CodRegionService02");
//		     List<ConcurrentMapCache> list = Collections.singletonList(cmCache);
//		     cacheManager.setCaches(list);
//		     return cacheManager;
//		 }
		 
		 
		    @Bean
		    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		    	//-redis缓存器的配置
		       return RedisCacheManager.builder(connectionFactory).cacheDefaults
		        		        (
		                           RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(2000))
		                        ).transactionAware().build();
		       
		    }
		 
		 
		 @Bean
		 public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		     RedisTemplate<String, Object> template = new RedisTemplate<>();
		     template.setConnectionFactory(factory);

		     //使用jdk的序列化
		      template.setValueSerializer(new JdkSerializationRedisSerializer());
		     //使用StringRedisSerializer来序列化和反序列化redis的key值
		     //template.setKeySerializer(new StringRedisSerializer());
		     template.afterPropertiesSet();
		     return template;
		 }
	    
	    

}
