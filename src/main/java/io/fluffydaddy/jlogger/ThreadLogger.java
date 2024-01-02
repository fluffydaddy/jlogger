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

import java.io.PrintWriter;
import java.io.StringWriter;

public class ThreadLogger extends DefaultLogger {
    protected ThreadLogger(Marker marker) {
        super(marker);
    }
    
    public ThreadLogger() {
        this(new ThreadMarker());
    }
    
    @Override
    protected String format(String name, Object o) {
        return String.format("[%s]: %s", name, o);
    }
    
    @Override
    protected String format(String name, CharSequence msg) {
        return String.format("[%s]: %s", name, msg);
    }
    
    @Override
    protected String format(String name, String msg, Throwable t) {
        if (t != null) {
            StringBuilder buf = new StringBuilder();
            buf.append(" <");
            buf.append(t);
            buf.append(">");
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw);
            
            return buf.toString();
        }
        
        return msg;
    }
}
