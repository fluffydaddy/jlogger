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

public class DefaultLogger extends SimpleLogger {
    protected final Marker marker;
    
    @Override
    public void log(Level level, String tag, Object o) {
        if (isEnabled(level))
            marker.log(level, format(tag, o));
    }
    
    @Override
    public void log(Level level, String tag, CharSequence msg) {
        if (isEnabled(level))
            marker.log(level, format(tag, msg));
    }
    
    @Override
    public void log(Level level, String tag, String fmt, Object... args) {
        if (isEnabled(level)) {
            String msg = String.format(fmt, args);
            marker.log(level, format(tag, msg));
        }
    }
    
    @Override
    public void log(Level level, String tag, String msg, Throwable t) {
        if (isEnabled(level))
            marker.log(level, format(tag, msg, t));
    }
    
    @Override
    public Logger createFrom(Marker marker) {
        return new DefaultLogger(marker);
    }
    
    protected DefaultLogger(Marker marker) {
        this.marker = marker;
    }
    
    public DefaultLogger() {
        this(new DefaultMarker());
    }
    
    @Override
    public boolean isInfoEnabled() {
        return true;
    }
    
    @Override
    public boolean isWarnEnabled() {
        return true;
    }
    
    @Override
    public boolean isDebugEnabled() {
        return true;
    }
    
    @Override
    public boolean isTraceEnabled() {
        return true;
    }
    
    @Override
    public boolean isErrorEnabled() {
        return true;
    }
    
    @Override
    public boolean isFatalEnabled() {
        return true;
    }
    
    protected String format(String name, Object o) {
        return String.format("[%s] %s", name, o);
    }
    
    protected String format(String name, CharSequence msg) {
        return String.format("[%s] %s", name, msg);
    }
    
    protected String format(String name, String msg, Throwable t) {
        final StringBuilder buf = new StringBuilder();
        
        buf.append(msg);
        
        if (t != null) {
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final java.io.StringWriter sw = new java.io.StringWriter();
            final java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
        }
        
        return buf.toString();
    }
}
