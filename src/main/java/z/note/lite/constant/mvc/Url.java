package z.note.lite.constant.mvc;

public interface Url {

    interface Api {

        String PATTERN = "/api/**";

        String FILTER_PATTERN = "/api/*";

        String LOGIN = "/api/login";

        String CAPTCHA = "/api/captcha";

    }

    interface Admin {

        String PATTERN = "/admin/**";

        String LOGIN = "/admin/login";

    }

    interface Portal {

        String PATTERN = Root.PATTERN;

    }

    interface Root {
        String PATTERN = "/**";

        String FILTER_PATTERN = "/*";
    }

}
