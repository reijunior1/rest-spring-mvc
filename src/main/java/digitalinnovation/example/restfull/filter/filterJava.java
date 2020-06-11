package digitalinnovation.example.restfull.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterJava implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> headersNames = req.getHeaderNames();
        Map<String, String> mapHeaders = Collections.list(headersNames)
                .stream()
                .collect(Collectors.toMap(it -> it, req::getHeader));
        if (mapHeaders.get("autorization") != null && mapHeaders.get("autorization").equals("admin")) {
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendError(403);
        }
    }
}
