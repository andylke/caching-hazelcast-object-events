package io.github.andylke.caching.hazelcast.message;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration(proxyBeanMethods = false)
class MessageCacheConfiguration {

  @Autowired HazelcastCacheManager cacheManager;

  @Autowired MessageCacheListener messageCacheListener;

  @PostConstruct
  public void configure() {
    cacheManager
        .getHazelcastInstance()
        .getMap("messages")
        .addEntryListener(messageCacheListener, true);
  }
}
