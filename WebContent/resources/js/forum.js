/**
 * 
 */
$(document).ready(function(){
	$(".f-btn").click(function(){
		
		$("#newPost").toggleClass("hide")
		var btn = $(".f-btn");
		if(btn.html() == "Create")
		{
			$(".f-btn").html("Close");
		}else
		{
			$(".f-btn").html("Create");
		}
		
	});
	
	
});