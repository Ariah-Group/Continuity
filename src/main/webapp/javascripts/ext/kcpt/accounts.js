/*
 * Ext JS Library 2.2.1
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.onReady(function(){

    // create the Data Store
    var store = new Ext.data.JsonStore({
    	totalProperty: 'accounts-size',
    	root: 'accounts',
        idProperty: 'userId',
        fields: ['name', 'emailregular', 'workPhone', 'securityType', 'accessStatus'],
        url:  'plan/getAccounts',
        baseParams: {institutionId:11}
    });
    
    // create paging
    var pagingBar = new Ext.PagingToolbar({
        pageSize: 8,
        store: store,
        displayInfo: false
    });

    // create the grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "Name", width: 120, dataIndex: 'name', sortable: true},
            {header: "Email", width: 120, dataIndex: 'emailregular', sortable: true},
            {header: "Phone", width: 120, dataIndex: 'workPhone', sortable: true},
            {header: "Role", width: 120, dataIndex: 'securityType', sortable: true},
            {header: "Access", width: 120, dataIndex: 'accessStatus', sortable: true}
        ],
        el:'AccountGrid',
		sm: new Ext.grid.RowSelectionModel({singleSelect: true}),
		viewConfig: {forceFit: true},
        height:240,
        title:'Accounts',
        loadMask: true,
        bbar: pagingBar
    });

    // render it
    grid.render();
    
	grid.getSelectionModel().on('rowselect', function(sm, rowIdx, r) {
		Ext.get("AccountFirstNameID").set({value: r.data.name});
		Ext.get("AccountEMailID").set({value: r.data.emailregular});
	});
	
    // get institution select element
    var instSelect = Ext.get("InstitutionSelect");

    // change baseparam before loading
    store.on('beforeload', function() {
        store.baseParams = {
           institutionId: instSelect.getValue(true)
        };
     });

    // create event handling for institution select change
    instSelect.on('change', function(e) {
        store.load({params:{start:0, limit:8}});
    });

    // trigger the data store load
    store.load({params:{start:0, limit:8}});
    
});
