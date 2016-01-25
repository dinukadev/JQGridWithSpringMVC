<!DOCTYPE html>
<html>
	<head>
		<title>JQGrid Example</title>

			
				<link href="resources/css/jquery-ui.css" rel="stylesheet">
				<link href="resources/css/jquery-ui.theme.css" rel="stylesheet">
				<link href="resources/css/jquery-ui.structure.min.css" rel="stylesheet">
				<link rel="stylesheet" href="resources/css/ui.jqgrid.css">
				
	</head>
	
<body>

<div>
	
		 <table id="list">
                <tr>
                        <td />
                </tr>
        </table>
        <div id="pager"></div>
        <div style="margin-top:10px;">
        <input type="button" id="showSelected" value="Show Selected"/>
        </div>
	
	
</div>

		<script src="resources/js/jquery-1.11.1.min.js"></script>
		<script src="resources/js/jquery-ui.min.js"></script>
		<script src="resources/js/i18n/grid.locale-en.js"></script>
		<script src="resources/js/jquery.jqGrid.min.js"></script>
		
		
<script type="text/javascript">

	$(document).ready(function(){
		$("#list").jqGrid({
                url : "loadData",
                datatype : "json",
                mtype : 'POST',
                colNames : [ 'Name','Alias','Super Power'],
                colModel : [ {
                        name : 'name',
                        index : 'name',
                        width : 150
                }, {
                        name : 'alias',
                        index : 'alias',
                        width : 150,
                        editable : false
                }, {
                        name : 'power',
                        index : 'power',
                        width : 550,
                        editable : false
                }],
                pager : '#pager',
                rowNum : 10,
                height: 'auto',
                rowList : [ 10 ],
                sortname : 'invid',
                sortorder : 'desc',
                viewrecords : true,
                gridview : true,
                multiselect: true,
          		multiboxonly: false,
                caption : 'Super Heroes',
                jsonReader : {
                        repeatitems : false,
                }
        });
        jQuery("#list").jqGrid('navGrid', '#pager', {
                edit : false,
                add : false,
                del : false,
                search : false
        });
        
        
        $('#showSelected').on('click',function(){
        	
        	var selRowArr = jQuery("#list").getGridParam('selarrrow');
        	var selectedAppIds = [];
        	for(var i=0;i<selRowArr.length;i++){
        		var celValue =  $('#list').jqGrid('getCell', selRowArr[i], 'alias');
        		selectedAppIds.push(celValue);
        	}
        	alert(selectedAppIds);
        	$('#list').trigger( 'reloadGrid' );
        	
			
        });
	
	});
</script>

</body>
</html>