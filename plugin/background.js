var locationNow = 'overview'
var msgPort = null;
var appstate = 0;
var clickState = 0;
var appid = -1;
/**
 * invoke by popup
 */
function setStorage(XToken) {
    sessionStorage.setItem('XToken', XToken);
}
function getStorage() {
    return sessionStorage.getItem('XToken');
}
function getClickState() {
    return clickState;
}
function popAction(code) {
    var defferd = $.Deferred();
    switch (code) {
    /**
     * 1000 查询插件业务状态
     * 2000 执行任务
     */
        case 1000:
            defferd.resolve(appstate);
            break;
        case 1001:
            postMsg(600);
            defferd.resolve(appstate);
            break;
        case 2000:
            if (appstate === 1) {
                console.log('content task start');
                clickState = 1;
                postMsg(code)
            }
            defferd.resolve(appstate);
            break;
    }
    return defferd.promise();
}

function postMsg(code, info) {
    if (info) {
        msgPort.postMessage({"from": "back", "code": code, "info": info});
    } else {
        msgPort.postMessage({"from": "back", "code": code});
    }

    if(!code && !info){
        msgPort.postMessage({"from": "back", "code": 2000})
    }
}

/**
 * invoke by content
 */
chrome.runtime.onConnect.addListener(
    function (port) {
        if (port.name == "myport") {
            msgPort = port;
            port.onMessage.addListener(function (msg) {
                console.log(msg);
                if (msg.from == 'content') {
                    switch (msg.code) {
                    /**
                     * 100 初始化成功
                     * 200 初始化失败
                     * 2000 任务执行成功
                     */
                        case 100:
                            console.log('content init end');
                            appstate = 1;
                            appid = parseInt(10000 * Math.random());
                            postMsg(101, appid);
                            break;
                        case 200:
                            appstate = -1;
                            console.log('content init fail');
                            break;
                        case 300:
                            console.log('overview finish...background start...')
                            locationNow = 'video'
                            postMsg(300);
                            break;
                        case 400:
                            if(locationNow == 'video'){
                                postMsg(400, sessionStorage.getItem('XToken'));
                            }
                            break;
                        case 500:
                            postMsg()
                            break;
                        case 2000:
                            appstate = 1;
                            console.log('content task end');
                            console.log('content task info -> ' + msg.info);
                            postMsg(10000)
                            setInterval(function () {
                                postMsg(2000)
                            }, 1800000);
                            console.log("该时段抓取完毕，正在等待下次任务。。。");
                            break;
                    }
                }
            });
        }
    }
);


