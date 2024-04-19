/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2008, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * --------------
 * WeekTests.java
 * --------------
 * (C) Copyright 2002-2008, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 05-Apr-2002 : Version 1 (DG);
 * 26-Jun-2002 : Removed unnecessary imports (DG);
 * 17-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 13-Mar-2003 : Added serialization test (DG);
 * 21-Oct-2003 : Added hashCode test (DG);
 * 06-Apr-2006 : Added testBug1448828() method (DG);
 * 01-Jun-2006 : Added testBug1498805() method (DG);
 * 11-Jul-2007 : Fixed bad time zone assumption (DG);
 * 28-Aug-2007 : Added test for constructor problem (DG);
 * 19-Dec-2007 : Set default locale for tests that are sensitive
 *               to the locale (DG);
 *
 */

 package org.jfree.data.time.junit;

 import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.ObjectInput;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutput;
 import java.io.ObjectOutputStream;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;
 import java.util.Locale;
 import java.util.TimeZone;
 
 import junit.framework.Test;
 import junit.framework.TestCase;
 import junit.framework.TestSuite;
 
 import org.jfree.data.time.Week;
 import org.jfree.data.time.Year;
 
 
 import java.util.Date;
 import java.util.TimeZone;
 import java.util.Locale;
 import junit.framework.TestCase;
 
 import java.util.Date;
 import java.util.TimeZone;
 import junit.framework.TestCase;
 
 public class WeekTests extends TestCase {
 
     // Test with valid input
     public void testWeekConstructorValidInput() {
         Date time = new Date();
         TimeZone zone = TimeZone.getDefault();
         Week week = new Week(time, zone);
         assertNotNull(week);
     }
 
     // Test with null time
     public void testWeekConstructorNullTime() {
         Date time = null;
         TimeZone zone = TimeZone.getDefault();
         try {
             new Week(time, zone);
             fail("Expected an IllegalArgumentException to be thrown");
         } catch (IllegalArgumentException e) {
             // Test passed
         }
     }
 
     // Test with null zone
     public void testWeekConstructorNullZone() {
         Date time = new Date();
         TimeZone zone = null;
         try {
             new Week(time, zone);
             fail("Expected an IllegalArgumentException to be thrown");
         } catch (IllegalArgumentException e) {
             // Test passed
         }
     }
 
     // Test with boundary case
     public void testWeekConstructorBoundaryCase() {
         Date time = new Date(Long.MAX_VALUE);
         TimeZone zone = TimeZone.getDefault();
         Week week = new Week(time, zone);
         assertNotNull(week);
     }
 
     // Test with edge case
     public void testWeekConstructorEdgeCase() {
         Date time = new Date(Long.MIN_VALUE);
         TimeZone zone = TimeZone.getDefault();
         Week week = new Week(time, zone);
         assertNotNull(week);
     }
 }