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

public interface Logger {
    void observe(LoggingAdapter observer);
    
    void log(Level level, String tag, Object o);
    
    void log(Level level, String tag, CharSequence msg);
    
    void log(Level level, String tag, String fmt, Object... args);
    
    void log(Level level, String tag, String msg, Throwable t);
    
    void info(String tag, Object o);
    
    void info(String tag, CharSequence msg);
    
    void info(String tag, String fmt, Object... args);
    
    void info(String tag, String msg, Throwable t);
    
    void warn(String tag, Object o);
    
    void warn(String tag, CharSequence msg);
    
    void warn(String tag, String fmt, Object... args);
    
    void warn(String tag, String msg, Throwable t);
    
    void debug(String tag, Object o);
    
    void debug(String tag, CharSequence msg);
    
    void debug(String tag, String fmt, Object... args);
    
    void debug(String tag, String msg, Throwable t);
    
    void trace(String tag, Object o);
    
    void trace(String tag, CharSequence msg);
    
    void trace(String tag, String fmt, Object... args);
    
    void trace(String tag, String msg, Throwable t);
    
    void error(String tag, Object o);
    
    void error(String tag, CharSequence msg);
    
    void error(String tag, String fmt, Object... args);
    
    void error(String tag, String msg, Throwable t);
    
    void fatal(String tag, Object o);
    
    void fatal(String tag, CharSequence msg);
    
    void fatal(String tag, String fmt, Object... args);
    
    void fatal(String tag, String msg, Throwable t);
    
    Logger createFrom(Marker marker);
    
    boolean isEnabled(Level level);
    
    boolean isInfoEnabled();
    
    boolean isWarnEnabled();
    
    boolean isDebugEnabled();
    
    boolean isTraceEnabled();
    
    boolean isErrorEnabled();
    
    boolean isFatalEnabled();
}
