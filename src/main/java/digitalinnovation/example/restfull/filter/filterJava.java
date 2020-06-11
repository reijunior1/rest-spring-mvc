package digitalinnovation.example.restfull.filter;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class filterJava implements Filter {
    private Logger logger = (Logger) LoggerFactory.getLogger(filterJava.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Chegou no portão do castelo");
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
        logger.info("Saiu do portão do castelo");
    }
}
