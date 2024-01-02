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

public final class Log {
    private final String tag;
    private final Level level;
    
    private final Logger _logging;
    
    public Log(String tag, Level logLevel) {
        this.tag = tag;
        this.level = logLevel;
        
        _logging = LoggerFactory.reserved();
    }
    
    public Log(String tag) {
        this(tag, Level.DEBUG);
    }
    
    public void log(CharSequence msg) {
        _logging.log(level, tag, msg);
    }
    
    public void log(Object o) {
        _logging.log(level, tag, o);
    }
    
    public void log(String fmt, Object... args) {
        _logging.log(level, tag, fmt, args);
    }
    
    public void log(Throwable ex) {
        _logging.log(level, tag, ex);
    }
    
    public void log(String msg, Throwable ex) {
        _logging.log(level, tag, msg, ex);
    }
    
    public void info(CharSequence msg) {
        _logging.info(tag, msg);
    }
    
    public void info(Object o) {
        _logging.info(tag, o);
    }
    
    public void info(String fmt, Object... args) {
        _logging.info(tag, fmt, args);
    }
    
    public void info(Throwable ex) {
        _logging.info(tag, ex);
    }
    
    public void info(String msg, Throwable ex) {
        _logging.info(tag, msg, ex);
    }
    
    public void warn(CharSequence msg) {
        _logging.warn(tag, msg);
    }
    
    public void warn(Object o) {
        _logging.warn(tag, o);
    }
    
    public void warn(String fmt, Object... args) {
        _logging.warn(tag, fmt, args);
    }
    
    public void warn(Throwable ex) {
        _logging.warn(tag, ex);
    }
    
    public void warn(String msg, Throwable ex) {
        _logging.warn(tag, msg, ex);
    }
    
    public void debug(CharSequence msg) {
        _logging.debug(tag, msg);
    }
    
    public void debug(Object o) {
        _logging.debug(tag, o);
    }
    
    public void debug(String fmt, Object... args) {
        _logging.debug(tag, fmt, args);
    }
    
    public void debug(Throwable ex) {
        _logging.debug(tag, ex);
    }
    
    public void debug(String msg, Throwable ex) {
        _logging.debug(tag, msg, ex);
    }
    
    public void trace(CharSequence msg) {
        _logging.trace(tag, msg);
    }
    
    public void trace(Object o) {
        _logging.trace(tag, o);
    }
    
    public void trace(String fmt, Object... args) {
        _logging.trace(tag, fmt, args);
    }
    
    public void trace(Throwable ex) {
        _logging.trace(tag, ex);
    }
    
    public void trace(String msg, Throwable ex) {
        _logging.trace(tag, msg, ex);
    }
    
    public void error(CharSequence msg) {
        _logging.error(tag, msg);
    }
    
    public void error(Object o) {
        _logging.error(tag, o);
    }
    
    public void error(String fmt, Object... args) {
        _logging.error(tag, fmt, args);
    }
    
    public void error(Throwable ex) {
        _logging.error(tag, ex);
    }
    
    public void error(String msg, Throwable ex) {
        _logging.error(tag, msg, ex);
    }
    
    public void fatal(CharSequence msg) {
        _logging.fatal(tag, msg);
    }
    
    public void fatal(Object o) {
        _logging.fatal(tag, o);
    }
    
    public void fatal(String fmt, Object... args) {
        _logging.fatal(tag, fmt, args);
    }
    
    public void fatal(Throwable ex) {
        _logging.fatal(tag, ex);
    }
    
    public void fatal(String msg, Throwable ex) {
        _logging.fatal(tag, msg, ex);
    }
}
