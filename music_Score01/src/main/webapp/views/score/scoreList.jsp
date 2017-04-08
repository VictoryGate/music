<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Client Side Pagination in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../../css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../css/icon.css">
	<link rel="stylesheet" type="text/css" href="../../css/demo.css">
	<script type="text/javascript" src="../../js/jQuery/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/EasyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../js/score/score.js"></script>
</head>
<body>
	
	<div>
	
		<div id="tb" style="padding:2px 5px;margin-left: 10%">
			曲谱名: <input class="easyui-textbox" style="width:150px">&nbsp;&nbsp;&nbsp;&nbsp;
			创建人: <input class="easyui-textbox" style="width:150px;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;
			用户: <input class="easyui-textbox" style="width:150px;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;
			创建时间: <input class="easyui-datebox" style="width:150px;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;
			
			<p></p>
			<div style="margin-left: 35%">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" class="easyui-linkbutton" iconCls="icon-cut">重置</a>
			</div>
		</div>
		<div style="margin:20px 0;"></div>
		
		<table id="dg" title="曲谱列表" style="width:100%;height:380px;margin-bottom: 30px" data-options="
					rownumbers:true,
					singleSelect:true,
					autoRowHeight:true,
					pagination:true,
					pageSize:20">
			<thead>
				<tr>
					<th field="staveName" width="10%" align="center">曲谱名</th>
					<th field="creater" width="10%" align="center">创建人</th>
					<th field="userName" width="10%" align="center">创建用户</th>
					<th field="staveType" width="10%" align="center">曲谱类别</th>
					<th field="creatTime" width="10%" align="center">创建时间</th>
					<th field="lastUpdateTime" width="10%" align="center">最后修改时间</th>
					<th field="remark" width="25%" align="center">备注</th>
					<th field="note" width="15%" align="center" formatter="imgFormatter">编辑</th>
				</tr>
			</thead>
		</table>
	</div>
	
</body>
</html>