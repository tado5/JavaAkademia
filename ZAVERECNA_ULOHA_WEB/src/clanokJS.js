var $frm = $("#frmArt");

//Pridanie funkcionality pre kliknutie na tlacidlo "Ulož článok"
$frm.submit(function (event) { //tu potrebujem aj objekt s udalosťou, aby som
    event.preventDefault(); //zrušiť pôvodné spracovanie udalosti
    skontrolujAOdosli();
});

function skontrolujAOdosli() {
//1. Uloží údaje z formulára do objektu
    var data = {};
    $frm.serializeArray().map(
        function (item) {
            var itemValueTrimmed = item.value.trim();
            if (itemValueTrimmed) {//ak je hodnota neprázdny reťazec
                data[item.name] = itemValueTrimmed;
            }
        }
    );

    console.log("skontrolujAOdosli> Údaje po uložení z formulára do objektu:");
    console.log(JSON.stringify(data));

//3.Kontrola, či boli zadané povinné polia
    if (!data.title) { //toto len pre istotu
        alert("Názov článku musí byť zadaný a musí obsahovať čitateľné znaky");
        return;
    }
    if (!data.content) { //toto je dôležité, keďže na textarea sa nedá použiť pattern. Odchytí, keď používateľ do prvku content
//zadal iba biele znaky
        alert("Obsah článku musí byť zadaný a musí obsahovať čitateľné znaky.");
        return;
    }


    data.content = " <div> " + data.content + " </div>";


    switch (data.LIKE) {
        case "1" :
            data.content += "<p> Mam rad Vysoke Tatry</p>";
            break;
        case "0" :
            data.content += "<p> Nemam rad Vysoke tatry </p>";
            break;

    }

    delete data.LIKE;

    data.content = " <div> " + data.content + " </div>";

    switch (data.cas) {
        case "1" :
            data.content += "<p>Chodim tam ras za rok</p>";
            break;
        case "2" :
            data.content += "<p> Chodim tam menej ako 5x rocne</p>";
            break;
        case "3" :
            data.content += "<p> Chodim tam menej ako 15x rocne </p>";
            break;
        case "4" :
            data.content += "<p> Vecsinu casu travim v nasich horach </p>";
            break;
    }


    delete data.cas;





    data.content += "<p>Na strake by som zmenil: ";
    if (data.NIC == "on") {
        data.content += " NIC";
    }
        if (data.VSETKO == "on") {
        data.content += " VSETKO ";
    }
    if (data.OBSAH == "on") {
        data.content += " OBSAH";
    }
    if (data.OBRAZKY == "on") {
        data.content += " OBRAZKY";
    }
    data.content += "</p>";



    data.content += "<p> paci sa mi : ";
    
        if (data.ano == "on") {
        data.content += " STRANKA SA MI PACI ";
    }
    if (data.nie == "on") {
        data.content += " STRANKA SA MI NEPACI";
    }
    if (data.najkrajsia == "on") {
        data.content += " TVOJA STRANKA JE NAJKRAJSIA";
    }
    if (data.celeZle == "on") {
        data.content += "  CELE ZLE :D";
    }
    data.content += "</p>";
    


   

    console.log("prepareAndSendArticle> Povinné údaje úspešne skontrolované:");

//4. odoslanie údajov
    if (window.confirm("Skutočne si želáte článok odoslať?")) {
        $.ajax({
            type: "POST",
            url: "http://wt.kpi.fei.tuke.sk/api/article",
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            data: JSON.stringify(data),
            success: function (response) {
                if (response.id) {
                    console.log(response.id);
                    window.alert("Článok úspešne uložený s id=" + response.id + ".");
                    window.open('http://hron.fei.tuke.sk/~korecko/WebTechAkademia/wtKpiBlogBrowser/article.html?id' + response.id, '_blank');
                    $frm.trigger('reset');
                }
            },
            error: function (jxhr) {
                window.alert("Spracovanie neúspešné. Údaje neboli zapísané. Kód chyby:" + status + "\n" + jxhr.statusText + "\n" + jxhr.responseText);
            }
        });

    }
}
