<%@include file="../shared/header.jsp" %>
<table style="width:100%;table-layout:fixed">
    <tr>
        <td></td>
        <td align="center"><h3>Viewing Today's Enquiries</h3></td>
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
    <c:forEach var="todEnq" items="${todaysEnquiries}">
        <tr class="">
            <td>${todEnq.enquiryId}</td>
            <td>${todEnq.enquiryFirstName} ${todEnq.enquiryLastName}</td>
            <td>${todEnq.enquiryEmail}</td>
            <td>${todEnq.enquiryGender}</td>
            <td>${todEnq.courseId.courseName}</td>
            <td>${todEnq.facultyId.facultyName}</td>
            <td>${todEnq.enquiryMessage}</td>
            <td>${todEnq.enquiryAddedDate}</td>
            <td>Set Colour Code | Reply</td>
        </tr>
    </c:forEach>
</table>
<%@include file="../shared/footer.jsp" %>