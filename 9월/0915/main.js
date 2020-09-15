$(document).ready(function() {
	var myModal = $("#modal");
	$("#login_id").click(function() {
    	myModal.show(); // 모달창 보여주기
	});
	
	$("#close_button").click(function() {
    	myModal.hide(); // 모달창 감추기
	});
	
	$("#join_btn").click(function() {
		var flag = true;
		$("input[type='text']").each(function() {
			if(!($(this).val())) {
				flag = false;
			}
		})
		if(!flag) {
			alert("모든 항목이 입력되지 않았습니다.");
			return;
		}
		
		var id = $("userId_id").val();
		
		$.ajax({
				url:"userlist.xml",  
   				dataType:'xml',
	 			success:function(response) {
	 				$(response).find("user").each(function() {
						if(id == $(this).find("id").text()) alert("중복된 아이디가 있습니다.");
					});
	 			}
	 	});
	})
})