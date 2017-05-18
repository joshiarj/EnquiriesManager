<%@include file="../shared/header.jsp" %>
<head>
    <style type="text/css">
        .dash-btn{text-align:center; width:330px; line-height:125px}
    </style>
</head>
<h2 align="center">Admin Dashboard</h2>
<table class="table" style="width:100%;table-layout:fixed;vertical-align:middle">
    <tr>
        <td align="center">
            <a href="${SITE_URL}/admin/viewallenquiries" class="dash-btn btn btn-primary"
               style="">Total enquiries: ${totalEnquiries}</a>
        </td>
        <td align="center">
            <a href="${SITE_URL}/admin/todaysenquiries" class="dash-btn btn btn-primary"
               style="">Today's enquiries:${todaysTotalEnquiries}</a>
        </td>
        <td align="center">
            <div class="dash-btn btn btn-primary">
                Total possible income: Rs.${possibleIncome}
            </div>
        </td>
    </tr>
</table>
<%@include file="../shared/footer.jsp" %>