import enums.Visibility

class ApplicationInterceptor {

    public ApplicationInterceptor()
    {
        match controller:"Login" , action : 'loginHandler'
        match controller:"Login" , action : 'logoutAction'
        match controller: "user", action: "index"
        match controller: "Util", action: "index"
    }
    boolean before() {
      /*  def users = User.findByUserName(params.username)
        User user = users[0]
        if (user.topics == null)
        {
            flash.error = "User does not have any topics"
            redirect(controller: "User",action: "loginHandler")
        }
        else {
            //to check every topic??
        }
        //if (user.su)*/
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
