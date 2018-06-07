Date.prototype.addDays = function(days) {
		this.setDate(this.getDate() + days);
	}
	
	Date.prototype.getLocaleDay = function() {
		var jours = [
			"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
		]
		
		return jours[this.getDay()];
	}
	
	Date.prototype.getLocaleMonth = function() {
		var mois = [
			"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
		];
		
		return mois[this.getMonth()];
	}
	
	Date.prototype.daysInMonth = function() {
		return new Date(this.getFullYear(), this.getMonth() + 1, 0).getDate();
	}
	
	Date.prototype.toString = function() {
		return this.getLocaleDay() + " " + this.getDate() + " " + this.getLocaleMonth() + " " + this.getFullYear();
	}
	
	
	
	class Calendar {
		constructor(date) {
			this.dateDuJour = (date === undefined) ? new Date() : date;
		}
		
		
		draw() {
			var that = this;
			var myPrev = $('<div />');
			var myNext = $('<div />');
			
			
			var myTable = $('<table class="table table-stripped" />');
			var myThead = $('<thead />');
			var myTheadRow = $('<tr />');
			var myTbody = $('<tbody />');
			
			for (let i = 0; i < 7; i++) {
				var myTh = $("<th />");
				
				myTh.text(this.dateDuJour.getLocaleDay() + " " + this.dateDuJour.getDate() + " " + this.dateDuJour.getLocaleMonth());
				myThead.append(myTh);
				
				this.dateDuJour.addDays(1);
			}
			
			for (let h = 8; h <= 20; h++) {
				for (let m = 0; m <= 30; m = m + 30) {
					var myRow = $("<tr />");
					
					this.dateDuJour.addDays(-7);
					
					for (let i = 0; i < 7; i++) {
						var myCellule = $('<td />');
						var myInput = $('<input type="radio" name="horaire" value="" />');
						var myLabel = $('<label />');
						
						myLabel.text(h + "h" + ((m == 0) ? "00" : "30"));
	
						myCellule.append(myInput);
						myCellule.append(myLabel);
						myRow.append(myCellule);
						
						this.dateDuJour.addDays(1);
					}
					
					myTbody.append(myRow);
				}
			}
			
			//On revient à la date initiale ...
			this.dateDuJour.addDays(-7);
			
			
			$('.calendar').children().remove();
			myTable.append(myThead);
			myThead.append(myTheadRow);
			myTable.append(myTbody);
			$('.calendar').append(myTable);
			

			myPrev.text("<");
			myNext.text(">");

			$('.calendar').prepend(myNext);
			$('.calendar').prepend(myPrev);
			
			myPrev.bind('click', function() {
				that.dateDuJour.addDays(-7);
				that.draw();
			});
			
			myNext.bind('click', function() {
				that.dateDuJour.addDays(7);
				that.draw();
			});
		}
	}


var cal = new Calendar();
	cal.draw();