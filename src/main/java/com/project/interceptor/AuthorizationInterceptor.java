package com.project.interceptor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.project.entity.Login;

/**
 * Enforces authentication and role based authorization for every mapped
 * request. Without this guard the application exposed all administrator,
 * doctor and receptionist endpoints to any unauthenticated caller.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	private static final Set<String> ADMIN_PATHS = new HashSet<String>(Arrays.asList(
			"/searchEmployeeView.html", "/searchEmployeeByName.html", "/searchEmployeeById.html",
			"/searchEmployeeByMobileNo.html", "/searchEmployeeByAadharNo.html", "/allEmployeesView.html",
			"/viewEmployee.html", "/addEmployeeView.html", "/addEmployee.html", "/editEmployeeView.html",
			"/editEmployee.html", "/deleteEmployee.html", "/editPersonalDetailsView.html"));

	private static final Set<String> DOCTOR_PATHS = new HashSet<String>(Arrays.asList(
			"/opdQueueD.html", "/viewDopdPatient1.html", "/viewDopdPatient2.html",
			"/patientObservePrescribe.html", "/addDopdPatientCase.html", "/patientHistoryList.html",
			"/patientHistory.html", "/deleteDopd.html"));

	private static final Set<String> RECEPTIONIST_PATHS = new HashSet<String>(Arrays.asList(
			"/addPatientView.html", "/addPatient.html", "/editPatientView.html", "/editPatient.html",
			"/opdQueueView.html", "/prescriptionQueueView.html", "/printPrescription.html",
			"/prescriptionPrintDone.html", "/addOpd.html", "/deleteOpd.html"));

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getRequestURI().substring(request.getContextPath().length());

		HttpSession session = request.getSession(false);
		Login user = (session == null) ? null : (Login) session.getAttribute("userInfo");

		if (user == null || user.getRole() == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

		String role = user.getRole();
		String required = null;
		if (ADMIN_PATHS.contains(path)) {
			required = "administrator";
		} else if (DOCTOR_PATHS.contains(path)) {
			required = "doctor";
		} else if (RECEPTIONIST_PATHS.contains(path)) {
			required = "receptionist";
		}

		if (required != null && !required.equals(role)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return true;
	}
}
