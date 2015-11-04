// 
// Copyright 2011 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.opensource.org/licenses/ecl2.php
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.domain.ext;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

// REFERENCE: https://www.hibernate.org/273.html
@SuppressWarnings("unchecked")
public class StringValuedEnumType <T extends Enum & StringValuedEnum> 
        implements EnhancedUserType, ParameterizedType{
    
    /**
     * Enum class for this particular user type.
     */
    private Class<T> enumClass;

    /**
     * Value to use if null.
     */
    private String defaultValue;
    
    /** Creates a new instance of ActiveStateEnumType */
    public StringValuedEnumType() {
    }
    
 	public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty("enum");
        try {
            enumClass = (Class<T>) Class.forName(enumClassName).asSubclass(Enum.class).
                    asSubclass(StringValuedEnum.class); //Validates the class but does not eliminate the cast
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe);
        }

        setDefaultValue(parameters.getProperty("defaultValue"));
    }

    public String getDefaultValue() {
        return defaultValue;
    }
    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    /**
     * The class returned by <tt>nullSafeGet()</tt>.
     * @return Class
     */
    public Class returnedClass() {
        return enumClass;
    }

    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }
    
    public boolean isMutable() {
        return false;
    }

    /**
     * Retrieve an instance of the mapped class from a JDBC resultset. Implementors
     * should handle possibility of null values.
     *
     * @param rs a JDBC result set
     * @param names the column names
     * @param owner the containing entity
     * @return Object
     * @throws HibernateException
     * @throws SQLException
     */
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {
        String value = rs.getString( names[0] );
        if (value==null || value.trim().length() == 0) {
            value = getDefaultValue();
            if (value==null){ //no default value
                return null;
            } 
        }
        String name = StringValuedEnumReflect.getNameFromValue(enumClass, value);
        Object res = rs.wasNull() ? null : 
        	((name == null || name.trim().length() == 0) ? null : Enum.valueOf(enumClass, name));
        
        return res;
    }
 
    /**
     * Write an instance of the mapped class to a prepared statement. Implementors
     * should handle possibility of null values. A multi-column type should be written
     * to parameters starting from <tt>index</tt>.
     *
     * @param st a JDBC prepared statement
     * @param value the object to write
     * @param index statement parameter index
     * @throws HibernateException
     * @throws SQLException
     */   
    public void nullSafeSet(PreparedStatement st, Object value, int index)
    throws HibernateException, SQLException {
        if (value==null) {
//            st.setNull(index, Types.VARCHAR);
            st.setString( index, "" );
        } else {
            st.setString( index, ((T) value).getValue() );
        }
    }
    
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }
    
    public Serializable disassemble(Object value) throws HibernateException {
        return (Enum) value;
    }
        
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return x==y;
    }
    
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    public String objectToSQLString(Object value) {
        return '\'' + ((T) value).getValue() + '\'';
    }
    
    public String toXMLString(Object value) {
        return ((T) value).getValue();
    }

    public Object fromXMLString(String xmlValue) {
        String name = StringValuedEnumReflect.getNameFromValue(enumClass, xmlValue);
        return Enum.valueOf(enumClass, name);
    }
        
}
