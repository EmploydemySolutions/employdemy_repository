package com.vonage.core.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jcr.Session;
import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

/**
 * Servlet class
 *
 * @author Vonage
 *
 */
@Component(service = { Servlet.class }, property = { "description= page list",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/vonage/pagelist",
        "sling.servlet.extension=" + "csv" })
public class PageListByTag extends SlingSafeMethodsServlet {

    /**
     * CSV Content Type for output in servlet.
     */
    public static final String CSV_CONTENT_TYPE = "text/csv";

    /**
     * Download attachment for output in servlet.
     */
    public static final String DOWNLOAD_RESPONSE_HEADER = "Content-Disposition";

    /**
     * CSV File Name for output in servlet.
     */
    public static final String FEEDS_RESPONSE_HEADER = "attachment; filename=\"feeds.csv\"";

    /**
    *
    */
    private static final long serialVersionUID = -345088444809262084L;
    /**
     * log variable
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageListByTag.class);

    @Override
    protected final void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws IOException {
        final ResourceResolver resourceResolver = request.getResourceResolver();
        QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
        Session session = resourceResolver.adaptTo(Session.class);
        Map<String, String> predicateMapPage = new HashMap<>();
        predicateMapPage.put("path", "/content/vonage/language-masters/en");
        predicateMapPage.put("type", "cq:Page");
        predicateMapPage.put("property", "jcr:content/@cq:tags");
        predicateMapPage.put("property.1_value", "vonage:product/communications-apis/sms");
        predicateMapPage.put("property.2_value", "vonage:product/communications-apis/voice");
        predicateMapPage.put("p.limit", "-1");
        Query queryPg = queryBuilder.createQuery(PredicateGroup.create(predicateMapPage), session);
        SearchResult resultPage = queryPg.getResult();
        List<Hit> listPage = resultPage.getHits();
        // for (Hit hitPage : listPage) {
        //     try {
        //         String pagePath = hitPage.getPath();
        //         Resource jcrResource = resourceResolver.getResource(pagePath + "/jcr:content");
        //         Resource imgResource = resourceResolver.getResource(pagePath + "/jcr:content/image");
        //         if (imgResource != null) {
        //             ValueMap prop = imgResource.getValueMap();
        //             if (prop.get("fileReference", String.class) != null) {
        //                 response.getWriter().print(prop.get("fileReference", String.class));
        //             }
        //         }
        //         if (jcrResource != null) {
        //             ValueMap prop = jcrResource.getValueMap();
        //             response.getWriter().print(prop.get("pageTitle", String.class));
        //             response.getWriter().print(prop.get("disableIndexForSEO"));
        //             response.getWriter().print(prop.get("jcr:description", String.class));
        //         }
        //         response.setContentType("text/plain");
        //         response.setCharacterEncoding("UTF-8");
        //         response.getWriter().print(pagePath.toString());
        //     } catch (RepositoryException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        // }
        response.setContentType(CSV_CONTENT_TYPE);
        response.setHeader("Content-Disposition", "attachment; filename=\"userDirectory.csv\"");
        try {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = "xxxx, yyyy, zzzz, aaaa, bbbb, ccccc, dddd, eeee, ffff, gggg\n";
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        }
}
