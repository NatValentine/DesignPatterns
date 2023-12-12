package com.designPatterns.creationalPatterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static ConfigManager instance = new ConfigManager();
    private Map<String, Object> settings = new HashMap<>();

    private  ConfigManager() {}

    public static ConfigManager getInstance() {
        return instance;
    }

    public void set(String key, Object value) {
        this.settings.put(key, value);
    }

    public Object get(String key) {
        return this.settings.get(key);
    }
}
