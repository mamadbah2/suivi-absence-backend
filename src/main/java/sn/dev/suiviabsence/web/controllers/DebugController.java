package sn.dev.suiviabsence.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/debug")
public class DebugController {

    @RequestMapping(value = "/echo", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public Map<String, Object> echo(HttpServletRequest request, @RequestBody(required = false) String body) {
        Map<String, Object> result = new HashMap<>();
        
        result.put("method", request.getMethod());
        result.put("uri", request.getRequestURI());
        result.put("contentType", request.getContentType());
        
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        result.put("headers", headers);
        
        if (body != null && !body.isEmpty()) {
            result.put("body", body);
        }
        
        return result;
    }
}