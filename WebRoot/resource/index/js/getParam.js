/*
*get url param @LHH1021
*/
var getParam = function(name){
    var search = document.location.search;
    var pattern = new RegExp("[?&]"+name+"\=([^&]+)", "g");
    var matcher = pattern.exec(search);
    var items = null;
    if(null != matcher){
            try{
                    items = decodeURIComponent(decodeURIComponent(matcher[1]));
            }catch(e){
                    try{
                            items = decodeURIComponent(matcher[1]);
                    }catch(e){
                            items = matcher[1];
                    }
            }
    }
    return items;
};