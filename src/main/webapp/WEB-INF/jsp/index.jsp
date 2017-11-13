<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">用户管理</div>
<div data-options="region:'west',split:true" title="菜单" style="width:12%;">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="用户管理" style="padding:10px;">
            <li>用户列表</li>
        </div>
        <div title="角色管理" data-options="selected:true" style="padding:10px;">
            content2
        </div>
        <div title="权限管理" style="padding:10px">
            content3
        </div>
    </div>
</div>
</div>
<div data-options="region:'center',title:'详情'">
    <div id="magazineGrid" style="width: 100%">
    </div>

</div>
</body>
<script language="JavaScript">
    $('#magazineGrid').datagrid({
        height: 340,
        url: 'getAllByUsername',
        method: 'POST',
//        queryParams: { 'id': id },
        idField: '产品ID',
        striped: true,
        fitColumns: true,
        singleSelect: false,
        rownumbers: true,
        pagination: true,
        nowrap: false,
        pageSize: 10,
        pageList: [10, 20, 50, 100, 150, 200],
        showFooter: true,
        columns: [[
            { field: 'ck', checkbox: true },
            { field: 'username', title: '用户名', width: 20, align: 'left' },
            { field: 'password', title: '密码', width: 20, align: 'left' },
            { field: 'enable', title: '是否启用',width:20}

//            { field: '数量', title: '数量', width: 80, align: 'left',
//                editor: {
//                    type: 'numberbox',
//                    options: {
//                        min: 0,
//                        precision: 0
//                    }
//                }
//            }
        ]],
        onBeforeLoad: function (param) {
//            var username = $("#username").val();
            param.username = "username";
        },
        onLoadSuccess: function (data) {

        },
        onLoadError: function () {

        },
        onClickCell: function (rowIndex, field, value) {

        }
    });
</script>
</html>
