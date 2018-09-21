function addlabel() {
    var pointArray = [
        new BMap.Point(121.716076,23.703799),
        new BMap.Point(112.121885,14.570616),
        new BMap.Point(123.776573,25.695422)];
    var optsArray = [{},{},{}];
    var labelArray = [];
    var contentArray = [
        "台湾是中国的！",
        "南海是中国的！",
        "钓鱼岛是中国的！"];
    for(var i = 0;i < pointArray.length; i++) {
        optsArray[i].position = pointArray[i];
        labelArray[i] = new BMap.Label(contentArray[i],optsArray[i]);
        labelArray[i].setStyle({
            color : "red",
            fontSize : "12px",
            height : "20px",
            lineHeight : "20px",
            fontFamily:"微软雅黑"
        });
        map.addOverlay(labelArray[i]);
        labelArray[i].disableMassClear();//设置这个覆盖物禁止移除
    }
}