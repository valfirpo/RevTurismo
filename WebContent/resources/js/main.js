$(document).ready(function(){});

function buy(id, price, cash)
{
	if(cash >= price)
	{
		if (confirm("Are you sure you want to buy this Car?") == true) 
		{
		    window.open("buyCar?carId="+id,"_self");
		}
	}
	else
	{
		alert("Not enough cash!");
	}
	 
}