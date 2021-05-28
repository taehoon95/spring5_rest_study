<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		var contextPath = "<%= request.getContextPath()%>";
		var id = ${id};
		$.get(contextPath+"/api/members/"+id,
			function(json) {
				var	sCont = "";
						sCont += "<tr>";
						sCont += "<td id='id'>" + json.id + "</td>";
						sCont += "<td>" + json.name + "</td>";
						sCont += "<td>" + json.email + "</td>";
						sCont += "<td>" + json.registerDateTime + "</td>";
						sCont += "</tr>";
				$("#load:last-child").append(sCont);
				
				$('#list').on("click",function(){
					window.location.href = contextPath+"/memberlist";
				})
				
				$('#remove').on("click", function(){
					var data = {id : $('#id').text()};
					alert("data > " + data.id + " : " +$('#id').text());
					$.ajax({
						url: contextPath + "/api/members/"+data.id,
						type: 'Delete',
						success: function(res){
							alert(res);
							window.location.href = contextPath + "/memberlist";
						},
						error:function(request, status, error){
							alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							window.location.href = contextPath+"/memberlist";
						}
					});
				});
				
				$('#modify').on("click", function() {
					window.location.href = contextPath+"/update?id="+$('#id').text();
				});

		});
	});
</script>
<title>회원 정보</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>					
				<th>이메일</th>					
				<th>이름</th>					
				<th>가입일</th>					
			</tr>
		</thead>
		<tbody id="load"></tbody>
	</table>
	<button id="remove">삭제</button>
	<button id="modify">수정</button>
	<button id="list">목록</button>
</body>
</html>