package gamz.projects.pharmacyfair.configuration.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = CacheConfig.class)
public class CacheConfigTest {

    @Autowired
    private ConcurrentMapCacheManager cacheManager;

    @Test
    public void testCacheManager() {
        String key = "testKey";
        Object value = new Object();
        Cache cache = cacheManager.getCache("settings");
        assertNotNull(cache);

        cache.put(key, value);
        assertEquals(value, cache.get(key).get());
    }

    @Test
    public void testClearCache() {
        String key = "testKey";
        Object value = new Object();

        Cache cache = cacheManager.getCache("settings");
        assertNotNull(cache);

        cache.put(key, value);
        assertNotNull(cache.get(key));

        cache.clear();

        assertNull(cache.get(key));
    }
}