<%@include file="../shared/header.jsp" %>
<h3 align="center">Send an enquiry message</h3>
<c:if test="${param.success!=null}">
    <div style="color:green">
        Enquiry successfully sent!
    </div>
</c:if>
<form method="post" action="${SITE_URL}/enquiry/save">
    <div class="form-group">
        <label>First Name:</label>
        <input type="text" name="firstName" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Last Name:</label>
        <input type="text" name="lastName" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Gender:</label>
        <select name="gender" class="form-control">
            <option value="">----- Select a gender -----</option>
            <option value="M">Male</option>
            <option value="F">Female</option>
        </select>
    </div>
    <div class="form-group">
        <label>Course:</label>
        <select name="courseId" class="form-control">
            <option value="">----- Select a course -----</option>
            <c:forEach var="c" items="${courses}">
                <option value="${c.courseId}">${c.courseName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Faculty:</label>
        <select name="facultyId" class="form-control">
            <option value="">----- Select a faculty -----</option>
            <c:forEach var="f" items="${faculties}">
                <option value="${f.facultyId}">${f.facultyName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Message:</label>
        <textarea name="message" required="required" class="form-control"></textarea>
    </div>
    <div class="form-group">
        <label>Status:</label>
        <label><input type="checkbox" name="status"/>Active</label>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">
        <span class="glyphicon glyphicon-send"></span> Send
    </button>
    <button type="reset" class="btn btn-danger">
        <span class="glyphicon glyphicon-erase"></span> Reset Form
    </button>
</form>
<%@include file="../shared/footer.jsp" %>