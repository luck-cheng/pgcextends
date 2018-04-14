var appid = -1;
var port = chrome.runtime.connect({name: 'myport'});
var XToken = 'XToken';
/*消息监听器*/
port.onMessage.addListener(
    function (msg) {
        if (msg.from === "back") {
            switch (msg.code) {
            /**
             * 任务状态
             * 2000 开始任务
             */
                case 2000:
                    doTask();
                    break;
                case 101:
                    appid = msg.info;
                    break;
                case 300:
                    window.location.href="https://mp.toutiao.com/profile_v2/content-analysis/statistic/video";
                    break;
                case 400:
                    setTimeout("taskVideo()",5000);
                    XToken = msg.info;
                    break;
                case 10000:
                    window.location.href="https://mp.toutiao.com/profile_v2/content-analysis/statistic/overview";
                    break;
            }
        }
    }
);
/*发送消息交互的方法*/
function postMsg(code, info) {
    if (info) {
        port.postMessage({"from": "content", "code": code, "info": info});
    } else {
        port.postMessage({"from": "content", "code": code});
    }
}
/*抓取分析overview数据*/
function taskOverview() {
    var url = window.location.href;
    if(url === 'https://mp.toutiao.com/profile_v2/content-analysis/statistic/overview'){
        var articleNum = $(".pgc-dashboard div.pgc-dashboard-column:eq(0) div.pgc-dashboard-primary").text();
        var recommendNum = $(".pgc-dashboard div.pgc-dashboard-column:eq(1) div.pgc-dashboard-primary").text();
        var readNum = $(".pgc-dashboard div.pgc-dashboard-column:eq(2) div.pgc-dashboard-primary").text();
        var fansNum = $(".pgc-dashboard div.pgc-dashboard-column:eq(3) div.pgc-dashboard-primary").text();
        var commentNum = $(".pgc-dashboard div.pgc-dashboard-column:eq(4) div.pgc-dashboard-primary").text();

        localStorage.setItem('articleNum', articleNum);
        localStorage.setItem('recommendNum', recommendNum);
        localStorage.setItem('readNum', readNum);
        localStorage.setItem('fansNum', fansNum);
        localStorage.setItem('commentNum', commentNum);

        postMsg(300);
        console.log("OverView finish now...")

    }else{
        postMsg(500);
        self.location="https://mp.toutiao.com/profile_v2/content-analysis/statistic/overview";
    }

}
/*抓取视频分析页面数据*/
function taskVideo() {
    var yPlay = $(".pgc-dashboard div.pgc-dashboard-column:eq(0) div.pgc-dashboard-primary").text();
    var yFansPlay = $(".pgc-dashboard div.pgc-dashboard-column:eq(1) div.pgc-dashboard-primary").text();
    var allPlay = $(".pgc-dashboard div.pgc-dashboard-column:eq(2) div.pgc-dashboard-primary").text();
    var allPlayMin = $(".pgc-dashboard div.pgc-dashboard-column:eq(3) div.pgc-dashboard-primary").text();

    var tbodyTouTr = $("table tbody tr").length;//获取tr数量

    var trVars = [];
    for(var i = 0; i < tbodyTouTr; i++){
        var tdArr = $("table tbody tr").eq(i).find("td");
        var tdVars = [];
        for(var j = 0; j < tdArr.length; j++){
            if(j !== 8){
                var tdVar = tdArr.eq(j).text();
                // console.log(tdVar);
                tdVars.push(tdVar);
            }else {
                var tdVar = tdArr.eq(j).find("a").attr('href');
                // console.log(tdVar);
                tdVars.push(tdVar);
            }
        }
        // console.log(tdVars)
        trVars.push(tdVars);
    }
    var stringVideo = JSON.stringify(trVars).toString();
    console.log(stringVideo);

    var articleNum = localStorage.getItem('articleNum');
    localStorage.removeItem('articleNum');
    var recommendNum = localStorage.getItem('recommendNum');
    localStorage.removeItem('recommendNum');
    var readNum = localStorage.getItem('readNum');
    localStorage.removeItem('readNum');
    var fansNum = localStorage.getItem('fansNum');
    localStorage.removeItem('fansNum');
    var commentNum = localStorage.getItem('commentNum');
    localStorage.removeItem('commentNum');


    /*上传api*/
    $.ajax({
        headers : {'XToken' : XToken},
        url : "http://127.0.0.1:7000/TouTiao",
        type : "POST",
        dataType : "JSON",
        data : {
            articleNum : articleNum,
            recommendNum : recommendNum,
            readNum : readNum,
            fansNum : fansNum,
            commentNum : commentNum,
            yPlayNum : yPlay,
            yFansPlayNum : yFansPlay,
            allPlayNum : allPlay,
            allPlayMinNum : allPlayMin,
            videoParam : stringVideo
        },
        success : function (json) {
            console.log(json);
            if(json.code == 200){
                localStorage.clear();
                postMsg(2000, 'task sus')
            }
        }
    })
}
/*任务执行方法*/
function doTask() {
    // taskVideo()
    taskOverview()
}
/*视频分析页面检测状态*/
var url = window.location.href
if(url === 'https://mp.toutiao.com/profile_v2/content-analysis/statistic/video'){
    postMsg(400)
}

// init content
$.get('http://127.0.0.1:7000/temp').then(function () {
    postMsg(100);
}, function () {
    postMsg(200);
});

