/**
 * Copyright (C) 2010 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bayern.steinbrecher.jcommander.internal;

import bayern.steinbrecher.jcommander.converters.BooleanConverter;
import bayern.steinbrecher.jcommander.converters.DoubleConverter;
import bayern.steinbrecher.jcommander.converters.FileConverter;
import bayern.steinbrecher.jcommander.converters.FloatConverter;
import bayern.steinbrecher.jcommander.converters.ISO8601DateConverter;
import bayern.steinbrecher.jcommander.converters.IntegerConverter;
import bayern.steinbrecher.jcommander.converters.LongConverter;
import bayern.steinbrecher.jcommander.converters.StringConverter;
import bayern.steinbrecher.jcommander.converters.URIConverter;
import bayern.steinbrecher.jcommander.converters.URLConverter;
import bayern.steinbrecher.jcommander.IStringConverter;
import bayern.steinbrecher.jcommander.IStringConverterFactory;
import bayern.steinbrecher.jcommander.converters.BigDecimalConverter;
import bayern.steinbrecher.jcommander.converters.PathConverter;

import java.io.File;
import java.lang.NoClassDefFoundError;
import java.math.BigDecimal;
import java.util.Date;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;

public class DefaultConverterFactory implements IStringConverterFactory {
  /**
   * A map of converters per class.
   */
  private static Map<Class, Class<? extends IStringConverter<?>>> classConverters;

  static {
    classConverters = Maps.newHashMap();
    classConverters.put(String.class, StringConverter.class);
    classConverters.put(Integer.class, IntegerConverter.class);
    classConverters.put(int.class, IntegerConverter.class);
    classConverters.put(Long.class, LongConverter.class);
    classConverters.put(long.class, LongConverter.class);
    classConverters.put(Float.class, FloatConverter.class);
    classConverters.put(float.class, FloatConverter.class);
    classConverters.put(Double.class, DoubleConverter.class);
    classConverters.put(double.class, DoubleConverter.class);
    classConverters.put(Boolean.class, BooleanConverter.class);
    classConverters.put(boolean.class, BooleanConverter.class);
    classConverters.put(File.class, FileConverter.class);
    classConverters.put(BigDecimal.class, BigDecimalConverter.class);
    classConverters.put(Date.class, ISO8601DateConverter.class);
    classConverters.put(URI.class, URIConverter.class);
    classConverters.put(URL.class, URLConverter.class);

    try {
      classConverters.put(Path.class, PathConverter.class);
    } catch (NoClassDefFoundError ex) {
      // skip if class is not present (e.g. on Android)
    }
  }

  public Class<? extends IStringConverter<?>> getConverter(Class forType) {
    return classConverters.get(forType);
  }

}
