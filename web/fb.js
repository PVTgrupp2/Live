$(document).ready(function(){
	
    $('.fblogin').click(function(){
        console.log("Login?!!=!");
        checkLogin();

	/*var anv = $.fblogin({fbId: '799390323443595'});
		
		anv.done(function(data){
			console.log(data);
	       	$('#utloggad').hide();
          $('#inloggad').show(); 
          //KNAPPID FÖR ALLA SIDOR
            $('#logoutp1').show();
            $('#logoutp2').show();
            $('#logoutp3').show();
            $('#logoutp4').show();
            $('#logoutp5').show();
            $('#logoutp6').show();
          $('#loginp1').hide();
          $('#loginp2').hide();
          $('#loginp3').hide();
          $('#loginp4').hide();
          $('#loginp5').hide();
          $('#loginp6').hide();
            checkLogin();
		});*/
	});

	$('.fblogout').click(function(){
        console.log("Klick class");
        checkLogin();
		/*FB.logout(function(response){
			// window.location.href = "index.html";
               $('#utloggad').show();
              $('#inloggad').hide();
              //KNAPPID FÖR ALLA SIDOR
               $('#logoutp1').hide();
               $('#logoutp2').hide();
               $('#logoutp3').hide();
               $('#logoutp4').hide();
               $('#logoutp5').hide();
               $('#logoutp6').hide();
              $('#loginp1').show();
              $('#loginp2').show();
              $('#loginp3').show();
              $('#loginp4').show();
              $('#loginp5').show();
              $('#loginp6').show();

            checkLogin();
		}); */
	});

    

});

 function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      kötta();
      uid = response.authResponse.userID;
      accessToken = response.authResponse.accessToken;
      $('#utloggad').hide();
        $('#inloggad').show();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      $('#utloggad').show();
            $('#inloggad').hide();
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      $('#utloggad').show();
         $('#inloggad').hide();
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '799390323443595',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.2' // use version 2.2
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function kötta() {
    console.log('Welcome!  Fetching your information.... ');
    });
  }


var uid = '';
var accessToken;

        function loadToTaste(){
            var totasteurl = 'https://pvt-grupp2.herokuapp.com/totaste/' + uid;
            $('#mytastelist').load(totasteurl, function(){                        
                $('#mytastelist').listview().listview('refresh');                    
                $('#mytastelist').hide();                
                $('#mytestedlist').show();
            });
        }
        function loadTested(){
            var testedurl = 'https://pvt-grupp2.herokuapp.com/bedom/' + uid;
            $('#mytestedlist').load(testedurl, function(){                        
                $('#mytestedlist').listview().listview('refresh');
                $('#mytastelist').hide();
                $('#mytestedlist').show();
            });
        }
    

  /*  function checkLogin(){
        console.log("checkLogin");
        FB.getLoginStatus(function(response) {
          if (response.status === 'connected') {
            // the user is logged in and has authenticated your
            // app, and response.authResponse supplies
            // the user's ID, a valid access token, a signed
            // request, and the time the access token 
            // and signed request each expire
            uid = response.authResponse.userID;
            accessToken = response.authResponse.accessToken;
            console.log("Inloggad");
            loadToTaste();
            loadTested();
            $('#utloggad').hide();
            $('#inloggad').show();
            $('.fblogout').html(/*'<li><a href="#" class="fblogout"><button class="ui-btn ui-btn-inline">Logga ut</button></a></li>');
                //KNAPPID FÖR ALLA SIDOR
                $('#logoutp1').show();
                $('#logoutp2').show();
                $('#logoutp3').show();
                $('#logoutp4').show();
                $('#logoutp5').show();
                $('#logoutp6').show();
                $('#loginp1').hide();
                $('#loginp2').hide();
                $('#loginp3').hide();
                $('#loginp4').hide();
                $('#loginp5').hide();
                $('#loginp6').hide();
          } else if (response.status === 'not_authorized') {
            // the user is logged in to Facebook, 
            // but has not authenticated your app
            console.log("Offline");
            $('#utloggad').show();
            $('#inloggad').hide();
                //KNAPPID FÖR ALLA SIDOR
                $('#logoutp1').hide();
                $('#logoutp2').hide();
                $('#logoutp3').hide();
                $('#logoutp4').hide();
                $('#logoutp5').hide();
                $('#logoutp6').hide();
                $('#loginp1').show();
                $('#loginp2').show();
                $('#loginp3').show();
                $('#loginp4').show();
                $('#loginp5').show();
                $('#loginp6').show();
          } else {
            // the user isn't logged in to Facebook.
            console.log("Offline");
            $('#utloggad').show();
            $('#inloggad').hide();
                //KNAPPID FÖR ALLA SIDOR
                $('#logoutp1').hide();
                $('#logoutp2').hide();
                $('#logoutp3').hide();
                $('#logoutp4').hide();
                $('#logoutp5').hide();
                $('#logoutp6').hide();
                $('#loginp1').show();
                $('#loginp2').show();
                $('#loginp3').show();
                $('#loginp4').show();
                $('#loginp5').show();
                $('#loginp6').show();


          }
        });
    }
*/

//------------------------------//
//		Tredjeparts plugin		//
//------------------------------//

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        // CommonJS
        factory(require('jquery'));
    } else {
        // Browser globals
        factory(jQuery);
    }
}(function ($) {
    $.extend({
        /**
         * fblogin
         * @property {object}  options      - settings for fblogin plugin.
         * 
         * Required:
         * options.fbId         {string}    - the Facebook app id
         *
         * Optional:
         * options.permissions  {string}    - a comma seperated list of FB permissions. See http://bit.ly/1plqJSs
         * options.fields       {string}    - a comma seperated list of field ids. See http://bit.ly/1plrevO 
         * options.success      {function}  - callback that will be triggered when data is successfully returned from FB.
         * options.error        {function}  - callback that will be triggered by any errors.
         */
        fblogin: function (options) {
            
            /**
             * Private Props
             * @property {object}  __               - add private module functions here.
             * @property {object}  isSdkLoaded      - a flag for when the FB SDK has loaded.
             * @property {object}  isFbInitiated    - a flag for when FB.init has been called.
             * @property {object}  $dfd             - stores an instance of jquery Deferred.
             */
            var __,           
                isSdkLoaded,      
                isFbInitiated,
                $dfd;

            options = options || {};
            isSdkLoaded = false;
            isFbInitiated = false;
            $dfd = $.Deferred();

            // PRIVATE FUNCTIONS
            __ = {  
                init: function () {
                    // FB ID is required
                    if (!options.fbId) {
                            throw new Error('Required option "fbId" is missing!');
                    }

                    options.permissions = options.permissions || '';
                    options.fields = options.fields || '';
                    options.success = options.success || function(){};
                    options.error = options.error || function(){};

                    __.listenForFbAsync();
                },
                listenForFbAsync: function () {
                    if (window.fbAsyncInit) {
                        var notMyFunction = window.fbAsyncInit;
                    }
                    // listen for FB SDK load
                    window.fbAsyncInit = function() {
                        __.initFB();
                        isSdkLoaded = true;
                        if (notMyFunction) { notMyFunction(); }
                    };

                    if (isSdkLoaded || window.FB) {
                        window.fbAsyncInit();
                        return;
                    }
                },
                initFB: function () {
                    if (!isFbInitiated) {
                        window.FB.init({
                            appId      : options.fbId,
                            cookie     : true,
                            xfbml      : true,
                            version    : 'v2.0'
                        });

                        isFbInitiated = true;
                    }
                    
                    $dfd.notify({status: 'init.fblogin'});
                },
                loginToFB: function () {
                    window.FB.login(function(response) {
                        if (response.authResponse) {

                            $dfd.notify({
                                status: 'authenticate.fblogin',
                                data: response
                            });

                        } else {
                            // mimic facebook sdk error format
                            $dfd.reject({
                                error: {
                                    message: 'User cancelled login or did not fully authorize.'
                                }
                            });
                        }
                    }, {
                        scope: options.permissions, 
                        return_scopes: true
                    });
                },
                getFbFields: function (accessToken) {
                    FB.api('/me', {fields: options.fields}, function(response) {
                        if (response && !response.error) {
                            $dfd.resolve(response);
                        } 
                        else {
                            $dfd.reject(response);
                        }
                    });
                }
            };

            // This monitors the FB login progresssion
            // 1. Init FB
            // 2. FB.login
            // 3. Get user data
            $dfd.progress(function (response) {
                if( response.status === 'init.fblogin' ) {
                    __.loginToFB();
                } else if( response.status === 'authenticate.fblogin' ) {
                     __.getFbFields(response.data.authResponse.accessToken);
                } else {
                    dfd.reject();
                }
            });

            // point callbacks at deffereds
            $dfd.done(options.success);
            $dfd.fail(options.error);

            // here we go!
            __.init();

            return $dfd;
        }
    });
}));