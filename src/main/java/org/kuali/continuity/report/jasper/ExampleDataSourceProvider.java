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
package org.kuali.continuity.report.jasper;

import java.util.ArrayList;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.kuali.continuity.domain.report.Person;

/**
 * Data source provider implementation that
 * provides a bean collection data source
 * containing instances of Person class.
 */
public class ExampleDataSourceProvider extends 
        JRAbstractBeanDataSourceProvider {

public ExampleDataSourceProvider() {
    super(Person.class);
}

public JRDataSource create(JasperReport report)
        throws JRException {
        
    ArrayList collection = new ArrayList();
    collection.add(new Person("Teodor", "Danciu"));
    collection.add(new Person("Peter", "Severin"));
    return new JRBeanCollectionDataSource(collection);
}

public void dispose(JRDataSource dataSource) 
        throws JRException {
    // nothing to dispose
}

}

