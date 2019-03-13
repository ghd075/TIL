<%@tag import="com.edu.emp.JobDAO"%>
<%@tag import="com.edu.emp.JobDTO"%>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<select name="job_id">
		<%
			List<JobDTO> datas = JobDAO.getInstance().selectAll();
			for(int i = 0; i < datas.size(); i++){
				JobDTO job = datas.get(i);
		%>
			<option value="<%=job.getJob_id()%>"><%=job.getJob_title()%>
		<% } %>	
</select>