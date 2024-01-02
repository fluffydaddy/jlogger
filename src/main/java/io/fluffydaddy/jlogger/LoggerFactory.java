/*
 * Copyright © 2024 fluffydaddy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fluffydaddy.jlogger;

import java.util.HashMap;

public class LoggerFactory {
    private static final HashMap<String, Logger> LOGS;
    private static final HashMap<Class, Logger> DEFS;
    
    private static Logger DEFAULT_LOGGER;
    private static Logger RESERVE_LOGGER;
    
    static {
        LOGS = new HashMap<>();
        DEFS = new HashMap<>();
        
        setConfig(ThreadLogger.class, new ThreadLogger());
        setConfig(DefaultLogger.class, new DefaultLogger());
        
        useConfig(DefaultLogger.class);
    }
    
    public static Logger reserved() {
        if (RESERVE_LOGGER == null) {
            RESERVE_LOGGER = new DefaultLogger();
        }
        
        return RESERVE_LOGGER;
    }
    
    public static <T extends Logger> void setConfig(T loggingAdapter) {
        setConfig(loggingAdapter.getClass(), loggingAdapter);
    }
    
    public static <T extends Logger> void setConfig(Class<? extends T> clazz, T loggingConfig) {
        DEFS.put(clazz, loggingConfig);
    }
    
    public static void useConfig(Logger definedLoggerNotExist) {
        DEFAULT_LOGGER = definedLoggerNotExist;
    }
    
    public static void useConfig(Class<? extends Logger> clazz) {
        useConfig(DEFS.get(clazz));
    }
    
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz, DEFAULT_LOGGER.getClass());
    }
    
    public static Logger getLogger(String name) {
        return getLogger(name, DEFAULT_LOGGER.getClass());
    }
    
    public static Logger getLogger(Class<?> cls, Class<? extends Logger> ex) {
        return getLogger(cls.getSimpleName(), ex);
    }
    
    public static Logger getLogger(String name, Class<? extends Logger> ex) {
        Logger logger;
        
        if (!LOGS.containsKey(name)) {
            Marker marker = new DefaultMarker();
            
            if (DEFS.containsKey(ex))
                logger = DEFS.get(ex).createFrom(marker);
            else
                logger = DEFAULT_LOGGER.createFrom(marker);
            
            LOGS.put(name, logger);
        } else {
            logger = LOGS.get(name);
        }
        
        return logger;
    }
}
