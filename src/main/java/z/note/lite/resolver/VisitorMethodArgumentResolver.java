package z.note.lite.resolver;

import is.tagomor.woothee.Classifier;
import is.tagomor.woothee.crawler.Crawlers;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import z.note.lite.util.IpUtils;
import z.note.lite.vo.Visitor;

public class VisitorMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Visitor.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String referer = webRequest.getHeader("referer");
        String userAgent = webRequest.getHeader("user-agent");
        String acceptLanguage = webRequest.getHeader("accept-language");
        boolean crawler = Classifier.isCrawler(userAgent);
        return Visitor.builder()
                .ip(IpUtils.getIp())
                .referer(referer)
                .userAgent(userAgent)
                .acceptLanguage(acceptLanguage)
                .crawler(crawler)
                .locale(LocaleContextHolder.getLocale())
                .build();
    }
}
