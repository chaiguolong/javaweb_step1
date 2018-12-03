var  highlightcolor='#d5f4fe';
var  clickcolor='#51b2f6';
function  changeto(){
    source=event.srcElement;
    if  (source.tagName=="TR"||source.tagName=="TABLE")
        return;
    while(source.tagName!="TD")
        source=source.parentElement;
    source=source.parentElement;
    cs  =  source.children;
    //alert(cs.length);
    if  (cs[1].style.backgroundColor!=highlightcolor && source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
        for(i=0;i<cs.length;i++){
            cs[i].style.backgroundColor=highlightcolor;
        }
}

function  changeback(){
    if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
        return
    if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
    //source.style.backgroundColor=originalcolor
        for(i=0;i<cs.length;i++){
            cs[i].style.backgroundColor="";
        }
}

function  clickto(){
    source=event.srcElement;
    if  (source.tagName=="TR"||source.tagName=="TABLE")
        return;
    while(source.tagName!="TD")
        source=source.parentElement;
    source=source.parentElement;
    cs  =  source.children;
    //alert(cs.length);
    if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
        for(i=0;i<cs.length;i++){
            cs[i].style.backgroundColor=clickcolor;
        }
    else
        for(i=0;i<cs.length;i++){
            cs[i].style.backgroundColor="";
        }
}
function JumpPage(actionName,newPage,maxPage)
{
    var form = document.forms[0];
    if(newPage<=maxPage && newPage>0 ){     
        document.getElementById(actionName+"_list_pageInfo_pageIndex").value = newPage; 
    }else{
        document.getElementById(actionName+"_list_pageInfo_pageIndex").value = maxPage; 
    }
    form.submit();
}
function JumpPageOther(actionName,newPage,maxPage)
{
    var form = document.forms[0];
    if(newPage<=maxPage && newPage>0 ){     
        document.getElementById(actionName+"list_pageInfo_pageIndex").value = newPage; 
    }else{
        document.getElementById(actionName+"list_pageInfo_pageIndex").value = maxPage; 
    }
    form.submit();
}
function SelectAll()
{
    var checkval = document.getElementsByName("selectall")[0].checked;
    var _chks = document.getElementsByName("ids");
    for (var i = 0; i < _chks.length; i++) {
       if(_chks[i].type=="checkbox"){
           if(_chks[i].disabled==false){
            _chks[i].checked=checkval;
           }
       }
    }
}
function DeleteSelect(namespace,actionName,id){
    if(window.confirm("请确认删除？")){
        var _chks = document.getElementsByName("ids");
        for (var i = 0; i < _chks.length; i++) {
           if(_chks[i].value==id){
               _chks[i].checked=true;
           }
           else{
               _chks[i].checked=false;
           }
        }
        document.forms[0].action = namespace + "/" + actionName +"_delete.jspx";
        document.forms[0].submit();
    }
}
function DeleteAll(namespace,actionName){
    if(window.confirm("请确认删除？")){
        var isSubmit = false;
        var _chks = document.getElementsByName("ids");
        for (var i = 0; i < _chks.length; i++) {
           if(_chks[i].checked==true){
               isSubmit = true;
               break;
           }
        }
        if(isSubmit==true){
            document.forms[0].action = namespace + "/" + actionName +"_delete.jspx";
            document.forms[0].submit();
        }
    }
}