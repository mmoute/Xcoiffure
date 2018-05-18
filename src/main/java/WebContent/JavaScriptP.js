



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











/*Ajouter un commentaire Réduire*/





  /*

//Fonction de callback en cas d’erreur
function erreurPosition(error) {
  var info = "Erreur lors de la géolocalisation : ";
  switch(error.code) {
  case error.TIMEOUT:
  	info += "Timeout !";
  break;
  case error.PERMISSION_DENIED:
	info += "Vous n’avez pas donné la permission";
  break;
  case error.POSITION_UNAVAILABLE:
  	info += "La position n’a pu être déterminée";
  break;
  case error.UNKNOWN_ERROR:
  	info += "Erreur inconnue";
  break;
  }
document.getElementById("infoposition").innerHTML = info;


//On attribue la valeur de la latitude et de la longitude dans les champs correspondants
$("#lat").val(position.coords.latitude); 
$("#lng").val(position.coords.longitude);

//Position par défaut (Châtelet à Paris)
var centerpos = new google.maps.LatLng(48.579400,7.7519);

//Options relatives à la carte
var optionsGmaps = {
  center:centerpos,
  mapTypeId: google.maps.MapTypeId.ROADMAP,
  zoom: 15
};
//ROADMAP peut être remplacé par SATELLITE, HYBRID ou TERRAIN
//Zoom : 0 = terre entière, 19 = au niveau de la rue

//Initialisation de la carte pour l'élément portant l'id "map"
var map = new google.maps.Map(document.getElementById("map"), optionsGmaps);

//.. et la variable qui va stocker les coordonnées
var latlng;

}




*/