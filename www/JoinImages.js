module.exports = {
	
	// internals
	CLASS: 'JoinImages',
	JOIN_METHOD: 'joinImagesFromData',	
	
	join: function (successCallback, errorCallback, optionsLink) {									
	    var args = [optionsLink];
		cordova.exec(successCallback, errorCallback, this.CLASS, this.JOIN_METHOD, args);
	}	
};