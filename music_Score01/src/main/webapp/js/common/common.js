function commonAjax(url,param){
	var result="";
	$.ajax({
		url:url+"?"+param,
		type:"post",
		async: false,
		dataType:"json",
		success:function(data){
			result = data;
		},
		error:function(e){
		}
	});
	return result;
}