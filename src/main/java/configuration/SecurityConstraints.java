package configuration;

abstract class SecurityConstraints {
    public static final String SECRET = "Claciun felicit!";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_STRING = "Authorization";
    public static final String USER_STRING = "User";
    static final String LOGIN_URL = "/login";
    static final String REGISTER_STUDENT_URL = "/user/student";
    static final String REGISTER_COMPANY_URL = "/user/company";
    static final String FILTERS_NAMES_URL = "/internship/filterName";
    static final String FILTER_INTERNSHIPS_URL = "/internship/filter";
}
