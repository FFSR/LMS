var App = angular.module('myApp',["ngTable","ngMessages"]);


//Basae URL and Port for Application

var getUrl = window.location;
var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
console.log(baseUrl+ "/");
App.value('url', baseUrl + "/");
