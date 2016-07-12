
function vypis(udaje){
    $("#weather").html(Mustache.render(tmplPoc,udaje));
    console.log(udaje);
}
$.getJSON( "http://api.openweathermap.org/data/2.5/weather",
    {q:"Vysoke Tatry ",units:'metric',APPID:"8641355d0bdfa52a49f4e9a42560adf0"},
    vypis);
var tmplPoc = "Teplota: {{main.temp}} °C<br> Tlak: {{main.pressure}} <br> Vlhkost: {{main.humidity}}%<br> Oblačnosť: {{clouds.all}}%";




