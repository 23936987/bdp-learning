package com.bdp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyCacheConfig extends CachingConfigurerSupport {
    @Override
    public CacheManager cacheManager() {
      /*  // 引入配置
        J2CacheConfig config = J2CacheConfig.initFromConfig("/j2cache.properties");
        // 生成 J2CacheBuilder
        J2CacheBuilder j2CacheBuilder = J2CacheBuilder.init(config);
        // 构建适配器
        J2CacheSpringCacheManageAdapter j2CacheSpringCacheManageAdapter = new J2CacheSpringCacheManageAdapter(j2CacheBuilder, true);

        return j2CacheSpringCacheManageAdapter;
    */

      return super.cacheManager();
    }
}
