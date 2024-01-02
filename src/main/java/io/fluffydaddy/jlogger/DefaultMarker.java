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

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultMarker implements Marker {
    @Override
    public void log(Level level, String msg) {
        switch (level) {
            case INFO:
                info(msg);
                break;
            case WARN:
                warn(msg);
                break;
            case DEBUG:
                debug(msg);
                break;
            case TRACE:
                trace(msg);
                break;
            case ERROR:
                error(msg);
                break;
            case FATAL:
                fatal(msg);
                break;
        }
    }
    
    @Override
    public void info(String msg) {
        System.out.println(format(Level.INFO, msg));
    }
    
    @Override
    public void warn(String msg) {
        System.out.println(format(Level.WARN, msg));
    }
    
    @Override
    public void debug(String msg) {
        System.out.println(format(Level.DEBUG, msg));
    }
    
    @Override
    public void trace(String msg) {
        System.out.println(format(Level.TRACE, msg));
    }
    
    @Override
    public void error(String msg) {
        System.err.println(format(Level.ERROR, msg));
    }
    
    @Override
    public void fatal(String msg) {
        System.err.println(format(Level.FATAL, msg));
    }
    
    private static String format(Level level, String msg) {
        return String.format("[%s %s]: %s", getTime(), level, msg);
    }
    
    @SuppressWarnings("SimpleDateFormat")
    private static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
