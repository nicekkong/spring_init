<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="/WEB-INF/view/include/header.jsp"%>

<!-- Main content -->
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <form role="form" method="post">
                <input type='hidden' name='bno' value="${board.bno}">
                <input type="hidden" name="page" value="${cri.page}">
                <input type="hidden" name="perPageNum" value="${cri.perPageNum}">
            </form>


            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">LIST ALL PAGE</h3>
                </div>
                <div class="box-body">

                    <table class="table table-bordered">
                        <tr>
                            <th style="width: 10px">NO.</th>
                            <th>TITLE</th>
                            <th>WRITER</th>
                            <th>REGDATE</th>
                            <th style="width: 40px">VIEWCNT</th>
                        </tr>

                        <c:forEach items="${boardList}" var="boardList">
                            <tr>
                                <td>${boardList.bno}</td>
                                <td><a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardList.bno}">
                                    ${boardList.title}
                                </a></td>
                                <td>${boardList.writer}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardList.regDate}" />
                                </td>
                                <td><span class="badge bg-red">${boardList.viewCnt}</span></td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                <%--   1. 단순 href URL 처리 방식
                    <div class="text-center">
                        <ul class="pagination">

                            <c:if test="${pageMaker.prev}">
                                <li><a href="/board/listPage?page=${pageMaker.startPage - 1}">&laquo;</a></li>
                            </c:if>

                            <c:forEach begin="${pageMaker.startPage }"
                                       end="${pageMaker.endPage }" var="idx">
                                <li
                                        <c:out value="${(pageMaker.cri.page/pageMaker.cri.perPageNum) +1== idx?'class =active':''}"/>>
                                    <a href="/board/listPage?page=${idx}">${idx}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                <li><a
                                        href="/board/listPage?page=${pageMaker.endPage +1}">&raquo;</a></li>
                            </c:if>
                        </ul>
                    </div>
                --%>
                <%--   1. 단순 href URL 처리 방식 --%>
                <div class="text-center">
                    <ul class="pagination">
                        <c:if test="${pageMaker.prev}">
                            <li><a href="/board/listPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a></li>
                        </c:if>

                        <c:forEach begin="${pageMaker.startPage }"
                                   end="${pageMaker.endPage}" var="idx">
                            <script type="application/javascript">
                                console.log(${pageMaker.cri.page} + " / " + ${idx});
                            </script>
                            <li
                                    <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                                <a href="/board/listPage${pageMaker.makeQuery(idx)}">${idx}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                            <li><a href="/board/listPage${pageMaker.makeQuery(pageMaker.endPage +1)}">&raquo;</a></li>
                        </c:if>
                    </ul>
                </div>
                <%-- /--%>
                <!-- /.box-footer-->
            </div>
        </div>
        <!--/.col (left) -->

    </div>
    <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>

    var result = '${msg}';

    if(result == 'SUCCESS'){
        alert("처리가 완료되었습니다.");

        //location.href = "/board/listPage?page=${page}&perPageNum=${perPageNum}";
    }
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>