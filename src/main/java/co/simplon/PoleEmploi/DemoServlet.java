package co.simplon.PoleEmploi;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(DemoServlet.class);
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet DemoServlet");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(
				"Hello from HelloServlet !\n" + "got:\n" + request);
	}

	private static String arrayToString(String[] strs) {
		String res = "";
		for (String str : strs) {
			res += str + "\n";
		}
		return res;
	}

	private static String getParams(HttpServletRequest request) {
		StringBuilder res = new StringBuilder();
		for (Map.Entry<String, String[]> kv : request.getParameterMap()
				.entrySet()) {
			res.append(kv.getKey() + ":" + arrayToString(kv.getValue()));
		}
		return res.toString();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doPost DemoServlet");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(
				"Hello from HelloServlet !\n" + "got:\n" + request
						+ "\n parameters:\n" + getParams(request));

		for (Enumeration<String> e = request.getParameterNames(); e
				.hasMoreElements();) {

			String name = (String) e.nextElement();
			String[] values = request.getParameterValues(name);

			for (int i = 0; i < values.length; i++) {
				response.getWriter().println(name + ":" + values[i] + "<br/>");
			}
		}

	}

	@Override
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(
				"Delete from HelloServlet !\n" + "got:\n" + request
						+ "\n parameters:\n" + getParams(request));

		for (Enumeration<String> e = request.getParameterNames(); e
				.hasMoreElements();) {

			String name = (String) e.nextElement();
			String[] values = request.getParameterValues(name);

			for (int i = 0; i < values.length; i++) {
				response.getWriter().println(name + ":" + values[i] + "<br/>");
			}
		}

	}
}