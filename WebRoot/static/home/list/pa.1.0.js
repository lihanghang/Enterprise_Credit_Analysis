function got_url(url) {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;
    document.body.appendChild(script);
}
var unloadData = [];
var paReadyCallbackStack = [];
var PinganAna = {
    fire:function(code) {
        unloadData.push(code);
    },
    ready:function(callback){
        paReadyCallbackStack.push(callback);
    }
}
var sendScript = document.createElement('script');
sendScript.src = '//pa.pacra.cn/data?action=get_js_release_url';
sendScript.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(sendScript);
