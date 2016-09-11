<%--
  Auth : nicekkong@gmail.com
  Date : 2016. 9. 7. 오전 12:27
  Desc : 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h2>Ajax Test Page</h2>
    <div>
        <div>
            REPLYER <input type="text" name="replyer" id="newPeplyWriter"/>
        </div>
        <div>
            REPLY TEXT <input type="text" name="replyText" id="newReplyText"/>
        </div>
        <button id="replyAddBtn">ADD REPLY</button>
    </div>
    <ul id="replies"></ul>
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>

    var bno = 141;


    function getAllList() {

        $.getJSON("/replies/all/" + bno, function (data) {
            console.log(data.length);
//        for(reply in data) {
//            console.log(reply.replyText);
//            console.log(reply.replyer);
//        }
//        for(var i=0 ; i < data.length ; i++) {
//            console.log(data[i].replyText + " by " + data[i].replyer);
//        }

            var str = "";
            jQuery(data).each(
                    function () {
                        str += "<li data-rno'" + this.rno + "' class='replyLi'>"
                                + this.rno + " : " + this.replyText + "</li>";

                    }
            );
            jQuery("#replies").html(str)
        });

        jQuery(document).ready(function () {

        });
    }

    console.log("2222222");
</script>
</body>
<script>

    console.log("3333333");
</script>
</html>