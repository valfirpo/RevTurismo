$(document).ready(function(){});

function enterChallenge(id, fee, cash)
{
	if(cash > fee)
	{
		if (confirm("Are you sure you want to ENTER this challenge?") == true) 
		{
		    window.open("enterChallenge?challengeId="+id,"_self");
		}
	}
	else
	{
		alert("Not enough cash!");
	}
}

function startChallenge(id, reward)
{
	/*if (confirm("Are you sure you want to ENTER this challenge?") == true) 
	{
	    window.open("startChallenge?challengeId="+id,"_self");
	}*/
}

function sellCar(id)
{
	
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

