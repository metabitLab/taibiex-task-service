package com.taibiex.taskservice.common.constant;

import com.taibiex.taskservice.entity.PoolCreated;
import com.taibiex.taskservice.service.PoolCreatedService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PoolMapSingleton {

    @Resource
    private PoolCreatedService poolCreatedService;

    private static PoolMapSingleton instance;

    private Map<String, PoolCreated> sharedMap;

    public PoolMapSingleton() {
        this.sharedMap = new ConcurrentHashMap<>();
    }

    public static synchronized PoolMapSingleton getInstance() {
        if (instance == null) {
            instance = new PoolMapSingleton();
        }
        return instance;
    }

    public static void put(String key, PoolCreated value) {
        PoolMapSingleton.getInstance().sharedMap.put(key, value);
    }

    public static PoolCreated get(String key) {
        return PoolMapSingleton.getInstance().sharedMap.get(key);
    }

    public static boolean containsKey(String key) {
        return PoolMapSingleton.getInstance().sharedMap.containsKey(key);
    }

    public static void remove(String key) {
        PoolMapSingleton.getInstance().sharedMap.remove(key);
    }

    public static void clear() {
        PoolMapSingleton.getInstance().sharedMap.clear();
    }

    public static Map<String, PoolCreated> getSharedMap() {
        return PoolMapSingleton.getInstance().sharedMap;
    }

    @PostConstruct
    private void initShareMap() {
        List<PoolCreated> nodePoolEvents = poolCreatedService.findAll();
        nodePoolEvents.forEach(nodePoolEvent -> getSharedMap().put(nodePoolEvent.getPool(), nodePoolEvent));
    }
}
