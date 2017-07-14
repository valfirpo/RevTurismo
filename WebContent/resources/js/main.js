$(document).ready(function(){});

function sellCar(id)
{
	console.log(id);
	if (confirm("Are you sure you want to SELL this Car?") == true) 
	{
	    window.open("sellCar?carId="+id,"_self");
	}
}

function buyCar(id, price, cash)
{
	if(cash >= price)
	{
		if (confirm("Are you sure you want to BUY this Car?") == true) 
		{
		    window.open("buyCar?carId="+id,"_self");
		}
	}
	else
	{
		alert("Not enough cash!");
	}
	 
}

