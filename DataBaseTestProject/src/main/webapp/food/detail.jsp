<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*"%>
<%
    String fno = request.getParameter("fno");
    FoodDAO2 dao = FoodDAO2.newInstance();
    FoodVO vo = dao.foodDetailData(Integer.parseInt(fno));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Detail</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container { margin-top: 50px; }
.row { margin: 0px auto; width: 850px; }
p { overflow: hidden; white-space: nowrap; text-overflow: ellipsis; }
</style>
</head>
<body>
<div class="container">
  <div class="row">
    <table class="table">
      <tr>
        <td width="30%" class="text-center" rowspan="8">
          <img src="<%=vo.getPoster() %>" style="width:250px;height:200px">
        </td>
        <td colspan="2">
          <h3>
            <%=vo.getName() %>
            &nbsp;<span style="color:orange"><%=vo.getScore() %></span>
          </h3>
        </td>
      </tr>
      <tr>
        <th width="15%" class="text-center">주소</th>
        <td width="55%"><%=vo.getAddress() %></td>
      </tr>
      <tr>
        <th class="text-center">전화</th>
        <td><%=vo.getPhone() %></td>
      </tr>
      <tr>
        <th class="text-center">음식종류</th>
        <td><%=vo.getType() %></td>
      </tr>
      <tr>
        <th class="text-center">영업시간</th>
        <td><%=vo.getTime() %></td>
      </tr>
      <tr>
        <th class="text-center">주차</th>
        <td><%=vo.getParking() %></td>
      </tr>
      <tr>
        <th class="text-center">가격대</th>
        <td><%=vo.getPrice() %></td>
      </tr>
      <tr>
        <th class="text-center">테마</th>
        <td><%=vo.getTheme() %></td>
      </tr>
    </table>

    <table class="table">
      <tr>
        <td><%=vo.getContent() %></td>
      </tr>
      <tr>
        <td class="text-right">
          <button class="btn btn-sm btn-primary" onclick="javascript:history.back()">목록</button>
        </td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
