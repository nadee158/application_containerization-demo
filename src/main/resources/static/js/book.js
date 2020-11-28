$(document).ready(function(){
	getBooks();
});

function saveBook(){
	var book = {id:$('#id').val(), name:$('#bookName').val(), isbn:$('#isbn').val(), description:$('#description').val()};
	$.ajax({
		type : "POST",
		url : "/books",
		contentType: "application/json",
		data : JSON.stringify(book),
		success : function(data) {
			getBooks();
		}
	});
}

function getBooks(){
	$.ajax({
		type : "GET",
		url : "/books",
		contentType: "application/json",
		success : function(data) {
			var string = ""
			if(data){
				data.forEach(function(book) {
					string = string + "<tr>"
					string = string + "<td>" + book.name + "</td>";
					string = string + "<td>" + book.isbn + "</td>";
					string = string + "<td>" + book.description + "</td>";
					string = string + "<\tr>"
				});
			}
			$("#tableAppend").html(string);
		}
	});
}

