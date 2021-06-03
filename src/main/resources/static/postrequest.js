$(document).ready(
	function() {

		// SUBMIT FORM
		$("#addSchu").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			var temp = 0;
			var tempp = 0;
           	var nhom = $("#nhom").val();
           	var siso = $("#siso").val();
           	if(!isNaN(nhom)) temp++;
           	if(!isNaN(siso)) tempp++;
           	if(temp==1 && tempp==1) ajaxPost();
           	if(temp==0){
           		$("#nhom").focus();
           		alert('Tên nhóm phải là số!');
           	}
           	if(tempp==0){
           		$("#siso").focus();
           		alert('Sĩ số phải là số!');
           	}
			
		});

		function ajaxPost() {

			// PREPARE FORM DATA
			var formData = {
				subject_id : $("#subject_id").val(),
				semestern: $("#idky").val(),
				names : $("#names").val(),
				lecturers_id: $("#lecturers_id").val(),
				namel: $("#namel").val(),
				nhom: $("#nhom").val(),
				tth: $("#tth").val(),
				stc: $("#stc").val(),
				malop: $("#malop").val(),
				siso: $("#siso").val(),
				thu: $("#thu").val(),
				tietbd: $("#tietbd").val(),
				sotiet: $("#sotiet").val(),
				namer: $("#namer").val()
			}

			// DO POST
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "addSchule",
				data : JSON.stringify(formData),
				dataType : 'json',
				success : function(result) {
					if (result.status == "success") {
						alert("success!");
					} else {
						alert("Error!")
					}
					console.log(result);
				},
				error : function(e) {
					alert("Thêm thành công!")
				}
			});

		}

	})