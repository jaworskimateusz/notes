$(document).ready(function() {
	
	$.ajax({
	      type: "GET",
		  dataType: "jsonp",
		  cache: false,
		  url: "https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN",
		  success: function(data) {
			  /*
			  for (var i = 0; i < 7; i++) {
		          $(".cards").append("<img src='" + data.data[i].images.low_resolution.url + "'></img>");
			  }
			  */
		    }
		  });
	
	$.ajax({
		  type: "GET",
		  dataType: "jsonp",
		  url: "https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN",
		  success: function(data) {
			$('.fullname').text(data.data.full_name);
			//$('.username').text(data.data.username);
		    $('.profile_picture').append("<img class='rounded-circle card-img-top' src='" + data.data.profile_picture + "'/>");
		  }
		});	
	
});
