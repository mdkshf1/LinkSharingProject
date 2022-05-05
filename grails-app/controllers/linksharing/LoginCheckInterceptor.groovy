package linksharing


class LoginCheckInterceptor {

    public LoginCheckInterceptor()
    {
        match controller:"Login" , action : 'logoutAction'
        match controller: "user", action: "index"
        match controller: "Util", action: "index"
    }

    boolean before() { true }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
