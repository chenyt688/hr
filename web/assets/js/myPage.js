rownumber = 8;              //表格要显示的数据行数
function upPage() {
    var nowpage = $("#nowpage").val();          //当前页数
    var allInfoAcount =$("#allInfoAcount").val();       //所有要显示的数据总条数
    var pageAccout = Math.ceil(allInfoAcount/rownumber);    //数据页面数
    if(parseInt(nowpage) >1){
        $("#nowpage").val(parseInt(nowpage)-1);
        var aimpage = $("#nowpage").val();
        changeTableInfo(aimpage,pageAccout);
    }
}
function nextPage() {
    var nowpage = $("#nowpage").val();          //当前页数
    var allInfoAcount =$("#allInfoAcount").val();       //所有要显示的数据总条数
    var pageAccout = Math.ceil(allInfoAcount/rownumber);    //数据页面数
    if(parseInt(nowpage)<parseInt(pageAccout)){
        $("#nowpage").val(parseInt(nowpage)+1);
        var aimpage = $("#nowpage").val();
        changeTableInfo(aimpage,pageAccout);
    }
}
function goPage() {
    var nowpage = $("#nowpage").val();          //当前页数
    var allInfoAcount =$("#allInfoAcount").val();       //所有要显示的数据总条数
    var pageAccout = Math.ceil(allInfoAcount/rownumber);    //数据页面数
    var inputpageCount = $("#inputpageCount").val();
    if(parseInt(inputpageCount)<=parseInt(pageAccout)){
        $("#nowpage").val(parseInt(inputpageCount));
        var aimpage = $("#nowpage").val();
        changeTableInfo(aimpage,pageAccout)

    }
}
function changeTableInfo(aimpage,pageAccout){              //改变表格数据
    var startindex =0;
    var endindex =0;
    if(parseInt(aimpage) == parseInt(pageAccout)){          //获取数据起始行和结束行
        endindex = $("#allInfoAcount").val();
        startindex = (parseInt(aimpage)-1)*rownumber ;
    }else {
        endindex = parseInt(aimpage)*rownumber -1;
        startindex = endindex - rownumber + 1;
    }
    var talentListGson = ${talentListGson};
    var temp = 1;
    for(var k = 1;k <= rownumber;k++){
        $("table").find("tr").eq(k).show();
    }
    for (var key in talentListGson) {
        if(parseInt(key) >= startindex){
            var talentname = talentListGson[key].name;
            var talentIdCard = talentListGson[key].id_card;
            $("table").find("tr").eq(temp).children().eq(0).text(parseInt(key) + 1);
            $("table").find("tr").eq(temp).children().eq(1).text(talentListGson[key].t_code);
            $("table").find("tr").eq(temp).children().eq(2).text(talentname);
            if(talentListGson[key].sexual == 0){
                $("table").find("tr").eq(temp).children().eq(3).text('男');
            }else{
                $("table").find("tr").eq(temp).children().eq(3).text('女');
            }
            if(talentListGson[key].status == 0){
                $("table").find("tr").eq(temp).children().eq(4).text('在职');
            }else if(talentListGson[key] == 1){
                $("table").find("tr").eq(temp).children().eq(4).text('离职');
            }else{
                $("table").find("tr").eq(temp).children().eq(4).text('退休');
            }
            $("table").find("tr").eq(temp).children().eq(5).text(talentIdCard);
            if(parseInt(key) > endindex){
                break;
            }
            temp++;
        }
    }
    if(endindex -startindex + 1 <rownumber){
        var tempIndex = rownumber -1-(endindex - startindex);
        for(var j = 0;j <= tempIndex;j++){
            $("table").find("tr").eq(temp).hide();
            temp = temp+1;
        }
    }
}