<%@include file="../shared/header.jsp" %>
<table style="width:100%;table-layout:fixed">
    <tr>
        <td></td>
        <td align="center"><h3>Viewing all enquiries</h3></td>
        <td align="right"><a href="${SITE_URL}/admin/dashboard" class="btn btn-info">Back to Dashboard</a></td>
    </tr>
</table>
<table class="table table-striped table-condensed">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Course</th>
        <th>Faculty</th>
        <th>Message</th>
        <th>Received on</th>
        <th>Action</th>
    </tr>
    <c:forEach var="enq" items="${allEnquiries}">
        <tr class="">
            <td>${enq.enquiryId}</td>
            <td>${enq.enquiryFirstName} ${enq.enquiryLastName}</td>
            <td>${enq.enquiryEmail}</td>
            <td>${enq.enquiryGender}</td>
            <td>${enq.courseId.courseName}</td>
            <td>${enq.facultyId.facultyName}</td>
            <td>${enq.enquiryMessage}</td>
            <td>${enq.enquiryAddedDate}</td>
            <td>Set Colour Code | Reply</td>
        </tr>
    </c:forEach>
</table>
<%@include file="../shared/footer.jsp" %>