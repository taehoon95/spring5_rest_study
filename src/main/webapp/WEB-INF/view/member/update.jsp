<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
<script type="text/javascript">
$(function(){
	var contextPath = "<%= request.getContextPath()%>";
	
	var id = ${id};
	$.get(contextPath + "/api/members/"+id,
		function(json) {
		$('#email').val(json.id);
		$('#name').val(json.name);
		$('#email').val(json.email);
		$('#registerDateTime').val(moment(json.registerDateTime).format('YYYY-MM-DD'));
		});
	$('#cancel').on("click", function(e){
		e.preventDefault();
		window.location.href = contextPath + "/read?id="+id;
	});
	$('#modify').on("click",function(e){
		e.preventDefault();
		var data = {id : $('#id').val(),
							email: $('#email').val(),
							name: $('#name').val(),
							password: $('#password').val(),
							registerDateTime:null};
		
		alert("data > " + data.id);
		$.ajax({
			url: contextPath + "api/members/"+id,
			type: 'PATCH',
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			cache : false,
			data : JSON.stringify(data),
			success : function(data){
				alert(data);
				window.location.href = contextPath+"/memberlist";
			},
			error:function(data, status, er){
				alert("code : " + request.status + "\n" + "message : "+request.responseText+"\n"+"error:"+error);
				window.location.href = contextPath+"/memberlist";
			}
		})
	});
});
</script>
<title>회원 정보</title>
</head>
<body>
${id }
	<form:form>
		<p><label>아이디 : <input id="id" type="number" value="${id }" readonly="readonly"></label></p>
		<p><label>이메일 : <input id="email" type="email"></label></p>
		<p><label>이름 : <input id="name" type="text"></label></p>
		<p><label>비밀번호 : <input id="password" type="password"></label></p>
		<p><label>가입일 : <input id="registerDateTime" type="date"></label></p>
		<button id="modify">수정</button>
		<button id="cancel">취소</button>
	</form:form>
</body>
</html>