



navigator.geolocation.getCurrentPosition(function(position){
	console.log(position);
	var lat = position.coords.latitude;
	var lng = position.coords.longitude;
	
	$.ajax({
		method: 'GET',
		url: 'http://maps.googleapis.com/maps/api/geocode/json',
		data:{
			latlng:lat + "," + lng
		},

		success: function(adresse) {
			console.log(adresse);
			console.log(adresse.results[0].formatted_address);
			
			
			$('input[name ="ad"]').val(adresse.results[0].formatted_address);

	}
	})
});


class Address {
	constructor (address) {
	this.address = address;
	}
};



$('#form-adresse').bind('submit', ajouterAddress);



function ajouterAddress(){	
var newAddress = new Address (
		$('input[name ="ad"]').val()
		);

$.ajax({
	method: 'GET',
	url: 'http://maps.googleapis.com/maps/api/geocode/json',
	data:{
		address: newAddress.address
	},

	success: function(adresse) {
		console.log(adresse.results[0].geometry.location);
				
			
			
			var latlng = new google.maps.LatLng(adresse.results[0].geometry.location);
			var service = new google.maps.places.PlacesService(document.querySelector('#map'));	
			

		service.textSearch({
			location: latlng,
			radius: '500',
			query: ['coiffeur']
		}, function(place, status) {
			console.log(place);
		});
}
})


return false;
};