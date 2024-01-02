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

import io.fluffydaddy.jutils.Array;
import io.fluffydaddy.jutils.Unit;

import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class SimpleLogger implements Logger {
    @Override
    abstract public void log(Level level, String tag, Object o);
    
    @Override
    abstract public void log(Level level, String tag, CharSequence msg);
    
    @Override
    abstract public void log(Level level, String tag, String fmt, Object... args);
    
    @Override
    abstract public void log(Level level, String tag, String msg, Throwable t);
    
    protected final Array<LoggingAdapter> applyAdapters;
    
    public SimpleLogger() {
        applyAdapters = new Array<>();
    }
    
    @Override
    public void observe(LoggingAdapter observer) {
        if (applyAdapters.remove(observer)) {
            observer.onDestroy(this);
        }
        
        applyAdapters.add(observer);
        
        observer.onJoined(this);
    }
    
    @Override
    public void info(String tag, Object o) {
        log(Level.INFO, tag, o);
        receive(o);
    }
    
    @Override
    public void info(String tag, CharSequence msg) {
        log(Level.INFO, tag, msg);
        receive(msg);
    }
    
    @Override
    public void info(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.INFO, tag, msg);
        receive(msg);
    }
    
    @Override
    public void info(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.INFO, tag, result);
        receive(result);
    }
    
    @Override
    public void warn(String tag, Object o) {
        log(Level.WARN, tag, o);
        receive(o);
    }
    
    @Override
    public void warn(String tag, CharSequence msg) {
        log(Level.WARN, tag, msg);
        receive(msg);
    }
    
    @Override
    public void warn(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.WARN, tag, msg);
        receive(msg);
    }
    
    @Override
    public void warn(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.WARN, tag, result);
        receive(result);
    }
    
    @Override
    public void debug(String tag, Object o) {
        log(Level.DEBUG, tag, o);
        receive(o);
    }
    
    @Override
    public void debug(String tag, CharSequence msg) {
        log(Level.DEBUG, tag, msg);
        receive(msg);
    }
    
    @Override
    public void debug(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.DEBUG, tag, msg);
        receive(msg);
    }
    
    @Override
    public void debug(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.DEBUG, tag, result);
        receive(result);
    }
    
    @Override
    public void trace(String tag, Object o) {
        log(Level.TRACE, tag, o);
        receive(o);
    }
    
    @Override
    public void trace(String tag, CharSequence msg) {
        log(Level.TRACE, tag, msg);
        receive(msg);
    }
    
    @Override
    public void trace(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.TRACE, tag, msg);
        receive(msg);
    }
    
    @Override
    public void trace(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.TRACE, tag, result);
        receive(result);
    }
    
    @Override
    public void error(String tag, Object o) {
        log(Level.ERROR, tag, o);
        receive(o);
    }
    
    @Override
    public void error(String tag, CharSequence msg) {
        log(Level.ERROR, tag, msg);
        receive(msg);
    }
    
    @Override
    public void error(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.ERROR, tag, msg);
        receive(msg);
    }
    
    @Override
    public void error(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.ERROR, tag, result);
        receive(result);
    }
    
    @Override
    public void fatal(String tag, Object o) {
        log(Level.FATAL, tag, o);
        receive(o);
    }
    
    @Override
    public void fatal(String tag, CharSequence msg) {
        log(Level.FATAL, tag, msg);
        receive(msg);
    }
    
    @Override
    public void fatal(String tag, String fmt, Object... args) {
        String msg = String.format(fmt, args);
        log(Level.FATAL, tag, msg);
        receive(msg);
    }
    
    @Override
    public void fatal(String tag, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        final String result = buf.toString();
        
        log(Level.FATAL, tag, result);
        receive(result);
    }
    
    private void receive(Object o) {
        applyAdapters.forEach((Unit<LoggingAdapter>) it -> it.onReceive(o));
    }
    
    @Override
    public boolean isEnabled(Level level) {
        switch (level) {
            case INFO:
                return isInfoEnabled();
            case WARN:
                return isWarnEnabled();
            case DEBUG:
                return isDebugEnabled();
            case TRACE:
                return isTraceEnabled();
            case ERROR:
                return isErrorEnabled();
            case FATAL:
                return isFatalEnabled();
        }
        return false;
    }
}
