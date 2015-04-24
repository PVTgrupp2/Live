$(document).ready(function(){
	$('#fblogin').click(function(){
		var anv = $.fblogin({fbId: '392795464233014'});
		
		anv.done(function(data){
			console.log(data);
			window.location.href = "#mypage";
		});
	});
	
	$('#fblogout').click(function(){
		FB.logout(function(response){
			window.location.href = "index.html";
		});
	});
});


function checkLogin(){
	FB.getLoginStatus(function(response) {
	  if (response.status === 'connected') {
	    // the user is logged in and has authenticated your
	    // app, and response.authResponse supplies
	    // the user's ID, a valid access token, a signed
	    // request, and the time the access token 
	    // and signed request each expire
	    var uid = response.authResponse.userID;
	    var accessToken = response.authResponse.accessToken;
	    window.location.href="#mypage";
	  } else if (response.status === 'not_authorized') {
	    // the user is logged in to Facebook, 
	    // but has not authenticated your app
	    window.location.href="#login";
	  } else {
	    // the user isn't logged in to Facebook.
	    window.location.href="#login";
	  }
	});
}
